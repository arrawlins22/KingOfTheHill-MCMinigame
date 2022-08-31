package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.Tasks.BridgeRemovingTask;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class BridgeBuilderEvent implements Listener {

    private HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 30;
    PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 300, 2);

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
    public void BuildBridge(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(BridgeBuilderItem.BridgeBuilder)) {
            if(e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                if(checkBBCooldown(player)) {
                    e.setCancelled(true);
                    setBBCooldown(player);
                    Location loc = player.getLocation();
                    int n = 0;
                    if (player.getFacing() == BlockFace.NORTH || player.getFacing() == BlockFace.SOUTH) {
                        if (player.getFacing() == BlockFace.NORTH) {
                            n = -1;
                        } else {
                            n = 1;
                        }
                        loc.add(0, -2, n);
                        for (int i = 0; i < 25; i++) {
                            loc.add(0, 1, 0);
                            for (int j = 0; j < 5; j++) {
                                Material mat = loc.getBlock().getType();
                                if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat ) {
                                    new BridgeRemovingTask(ConstantCTF.getPlugin(), loc.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 250L);
                                    loc.getBlock().setType(Material.TINTED_GLASS);
                                }
                                for (int k = 0; k < 3; k++) {
                                    loc.add(0, 1, 0);
                                    mat = loc.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                        loc.getBlock().setType(Material.AIR);
                                        new BridgeRemovingTask(ConstantCTF.getPlugin(), loc.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 250L);
                                    }
                                }
                                loc.add(0, -3, n);
                            }
                        }
                    }
                    if (player.getFacing() == BlockFace.EAST || player.getFacing() == BlockFace.WEST) {
                        if (player.getFacing() == BlockFace.EAST) {
                            n = 1;
                        } else {
                            n = -1;
                        }
                        loc.add(n, -2, 0);
                        for (int i = 0; i < 25; i++) {
                            loc.add(0, 1, 0);
                            for (int j = 0; j < 4; j++) {
                                Material mat = loc.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                        loc.getBlock().setType(Material.TINTED_GLASS);
                                        new BridgeRemovingTask(ConstantCTF.getPlugin(), loc.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 250L);
                                    }
                                for (int k = 0; k < 3; k++) {
                                    loc.add(0, 1, 0);
                                    mat = loc.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                        loc.getBlock().setType(Material.AIR);
                                        new BridgeRemovingTask(ConstantCTF.getPlugin(), loc.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 250L);
                                    }
                                }
                                loc.add(n, -3, 0);
                            }
                        }
                    }
                    player.addPotionEffect(speed);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(BridgeBuilderItem.BridgeBuilder)) {
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
