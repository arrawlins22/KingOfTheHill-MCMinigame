package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.CustomItems.Accessories.ChunkErrorItem;
import constantctf.constantctf.CustomItems.Accessories.StickyIckyItem;
import constantctf.constantctf.Tasks.ChunkErrorTask;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class ChunckErrorEvent implements Listener {

    private ArrayList<Block> Blocks = new ArrayList<>();
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

        if(Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(ChunkErrorItem.ChunkError)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(checkBBCooldown(player)) {
                    setBBCooldown(player);
                    Block block = e.getPlayer().getTargetBlockExact(100, FluidCollisionMode.NEVER);
                    Location location = block.getLocation();
                    Chunk chunk = location.getChunk();
                    for(int x = 0; x < 16; x++) {
                        for(int y = 0; y < 256; y++) {
                            for(int z = 0; z < 16; z++) {
                                Blocks.add(chunk.getBlock(x,y,z));
                            }
                        }
                    }
                    for(int i = 0; i < Blocks.size(); i++) {
                        Material mat = Blocks.get(i).getType();
                        Blocks.get(i).setType(Material.AIR);
                        if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                            new ChunkErrorTask(Blocks.get(i), mat).runTaskLater(ConstantCTF.getPlugin(), 200L);
                        } else {
                            return;
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

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(ChunkErrorItem.ChunkError)) {
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
