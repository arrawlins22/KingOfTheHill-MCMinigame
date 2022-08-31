package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.CustomItems.Accessories.RenewablePearlItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class RenewablePearlEvent implements Listener {

    private HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 15;

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
    public void onPearl(PlayerInteractEvent e) {

        if(e.getPlayer().getEquipment().getItemInMainHand().equals(RenewablePearlItem.RenewablePearl)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(checkBBCooldown(e.getPlayer())) {
                    setBBCooldown(e.getPlayer());
                    e.getPlayer().getInventory().addItem(RenewablePearlItem.RenewablePearl);
                } else {
                    e.setCancelled(true);
                }
            }
        }

    }

    @EventHandler
    public void onToss(ProjectileLaunchEvent e) {
        if(e.getEntity() instanceof EnderPearl) {
            e.getEntity().setVelocity(e.getEntity().getVelocity().multiply(2));
        }
    }

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(RenewablePearlItem.RenewablePearl)) {
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
