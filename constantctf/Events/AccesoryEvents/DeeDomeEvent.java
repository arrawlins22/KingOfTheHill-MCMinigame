package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.CustomItems.Accessories.DeeDomeItem;
import constantctf.constantctf.Tasks.DeeDomeRemovingTask;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class DeeDomeEvent implements Listener {

    private HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 120L;


    private final int radius = 15;


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
    public void buildDeeDome(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(DeeDomeItem.DeeDome)) {
            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if (checkBBCooldown(player)) {
                    e.setCancelled(true);
                    setBBCooldown(player);
                    Location OGSpot = player.getLocation();
                    Location location = player.getLocation();

                    double y = -15;
                    double z;
                    while(y <= 15) {
                        double x = (radius * radius) - (y * y);
                        if (x < 0) {
                            x = x * -1;
                        }
                        x = Math.sqrt(x);
                        while(x >= -15) {
                            z = (radius * radius) - ((x * x) + (y * y));
                            if (z < 0) {
                                z = z * -1;
                            }
                             z = Math.sqrt(z);
                            int fredZ = (int) z;
                            int fredX = (int) x;
                            int fredY = (int) y;
                            location.setX(OGSpot.getBlockX() + fredX);
                            location.setZ(OGSpot.getBlockZ() + fredZ);
                            location.setY(OGSpot.getBlockY() + fredY);
                            Material mat = location.getBlock().getType();
                            if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                location.getBlock().setType(Material.GLASS);
                                new DeeDomeRemovingTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 300L);
                                if (fredX != 0) {
                                    location.setX(OGSpot.getBlockX() - fredX);
                                    mat = location.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                        location.getBlock().setType(Material.GLASS);
                                        new DeeDomeRemovingTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 300L);
                                    }
                                }
                                location.setX(OGSpot.getBlockX() + fredX);
                                if (fredZ != 0) {
                                    location.setZ(OGSpot.getBlockZ() - fredZ);
                                    mat = location.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                        location.getBlock().setType(Material.GLASS);
                                        new DeeDomeRemovingTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 300L);
                                    }
                                    if (fredX != 0) {
                                        location.setX(OGSpot.getBlockX() - fredX);
                                        mat = location.getBlock().getType();
                                        if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                            location.getBlock().setType(Material.GLASS);
                                            new DeeDomeRemovingTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 300L);
                                        }
                                    }
                                }
                            }
                            x = x - .1;
                        }
                        y = y + .1;
                    }
                }
            }
        }
    }

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(DeeDomeItem.DeeDome)) {
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
