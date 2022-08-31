package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.CustomItems.Accessories.StickyIckyItem;
import constantctf.constantctf.Tasks.StickyIckyTask;
import org.bukkit.ChatColor;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class StickyIckyEvent implements Listener {

    private HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 60L;

    public boolean checkBBCooldown(Player player) {
        if(cooldown.containsKey(player.getUniqueId())) {
            long secondsLeft = (cooldown.get(player.getUniqueId())/1000) + cooldowntime - (System.currentTimeMillis() /1000);
            if(secondsLeft > 0) {
                player.sendMessage(ChatColor.RED + "Its on Cooldown for " + secondsLeft +" more seconds dummy");
                return false;
            }
        }
        return true;
    }
    public void setBBCooldown(Player player) {
        cooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }


    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if(e.getPlayer().getEquipment().getItemInMainHand().equals(StickyIckyItem.StickyIcky)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(checkBBCooldown(player)) {
                    setBBCooldown(player);
                    Block block = e.getPlayer().getTargetBlockExact(100, FluidCollisionMode.NEVER);
                    Location location = block.getLocation();
                    for (int x = -1; x < 2; x++) {
                        for (int z = -1; z < 2; z++) {
                            for (int y = 0; y < 2; y++) {
                                location.setX(block.getX() + x);
                                location.setY(block.getY() + y);
                                location.setZ(block.getZ() + z);
                                Material mat = location.getBlock().getType();
                                if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                    new StickyIckyTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 200L);
                                    location.getBlock().setType(Material.COBWEB);
                                }
                            }
                        }
                    }
                }
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(StickyIckyItem.StickyIcky)) {
            if(cooldown.containsKey(p.getUniqueId())) {
                long secondsLeft = (cooldown.get(p.getUniqueId())/1000) + cooldowntime - (System.currentTimeMillis() /1000);
                if(secondsLeft > 0) {
                    p.setLevel((int) secondsLeft);
                    return;
                }
                p.setLevel(0);
            }
        }
    }
}
