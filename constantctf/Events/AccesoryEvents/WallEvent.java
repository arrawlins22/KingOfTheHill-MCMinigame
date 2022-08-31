package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.CustomItems.Accessories.WallItem;
import constantctf.constantctf.Tasks.StickyIckyTask;
import constantctf.constantctf.Tasks.WallTask;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class WallEvent implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 60L;

    public boolean checkBBCooldown(Player player) {
        if (cooldown.containsKey(player.getUniqueId())) {
            long secondsLeft = (cooldown.get(player.getUniqueId()) / 1000) + cooldowntime - (System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                player.sendMessage(ChatColor.RED + "Its on Cooldown for " + secondsLeft + " more seconds dummy");
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
        int n = 0;
        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(WallItem.Wall)) {
            if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                if (checkBBCooldown(player)) {
                    e.setCancelled(true);
                    setBBCooldown(player);
                    if (player.getFacing() == BlockFace.NORTH || player.getFacing() == BlockFace.SOUTH) {
                        if (player.getFacing() == BlockFace.NORTH) {
                            n = -1;
                        } else {
                            n = 1;
                        }
                        Block block =  e.getPlayer().getLocation().add(0,0,n*2).getBlock();
                        Location location = block.getLocation();
                        for (int x = -20; x < 20; x++) {
                            for (int z = 0; z < 1; z++) {
                                for (int y = -5; y < 15; y++) {
                                    location.setX(block.getX() + x);
                                    location.setY(block.getY() + y);
                                    location.setZ(block.getZ() + z);
                                    Material mat = location.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat) {
                                        new WallTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 200L);
                                    }
                                    location.getBlock().setType(Material.BLUE_ICE);
                                }
                            }
                        }
                    }
                    if (player.getFacing() == BlockFace.EAST || player.getFacing() == BlockFace.WEST) {
                        if (player.getFacing() == BlockFace.EAST) {
                            n = 1;
                        } else {
                            n = -1;
                        }
                        Block block =  e.getPlayer().getLocation().add(n*2,0, 0).getBlock();
                        Location location = block.getLocation();
                        for (int z = -20; z < 20; z++) {
                            for (int x = 0; x < 1; x++) {
                                for (int y = -5; y < 15; y++) {
                                    location.setX(block.getX() + x);
                                    location.setY(block.getY() + y);
                                    location.setZ(block.getZ() + z);
                                    Material mat = location.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat) {
                                        new WallTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 200L);
                                    }
                                    location.getBlock().setType(Material.BLUE_ICE);
                                }
                            }
                        }
                    }
                }
            }
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (checkBBCooldown(player)) {
                    e.setCancelled(true);
                    setBBCooldown(player);
                    if (player.getFacing() == BlockFace.NORTH || player.getFacing() == BlockFace.SOUTH) {
                        if (player.getFacing() == BlockFace.NORTH) {
                            n = -1;
                        } else {
                            n = 1;
                        }
                        Block block =  e.getPlayer().getLocation().add(0,0,n*25).getBlock();
                        Location location = block.getLocation();
                        for (int x = -20; x < 20; x++) {
                            for (int z = 0; z < 1; z++) {
                                for (int y = -5; y < 15; y++) {
                                    location.setX(block.getX() + x);
                                    location.setY(block.getY() + y);
                                    location.setZ(block.getZ() + z);
                                    Material mat = location.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat) {
                                        new WallTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 200L);
                                        location.getBlock().setType(Material.BLUE_ICE);
                                    }
                                }
                            }
                        }
                    }
                    if (player.getFacing() == BlockFace.EAST || player.getFacing() == BlockFace.WEST) {
                        if (player.getFacing() == BlockFace.EAST) {
                            n = 1;
                        } else {
                            n = -1;
                        }
                        Block block =  e.getPlayer().getLocation().add(n*25,0, 0).getBlock();
                        Location location = block.getLocation();
                        for (int z = -20; z < 20; z++) {
                            for (int x = 0; x < 1; x++) {
                                for (int y = -5; y < 15; y++) {
                                    location.setX(block.getX() + x);
                                    location.setY(block.getY() + y);
                                    location.setZ(block.getZ() + z);
                                    Material mat = location.getBlock().getType();
                                    if(mat != Material.GLASS && mat != Material.BLUE_ICE && Material.TINTED_GLASS != mat && Material.COBWEB != mat) {
                                        new WallTask(ConstantCTF.getPlugin(), location.getBlock(), mat).runTaskLater(ConstantCTF.getPlugin(), 200L);
                                        location.getBlock().setType(Material.BLUE_ICE);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(WallItem.Wall)) {
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

