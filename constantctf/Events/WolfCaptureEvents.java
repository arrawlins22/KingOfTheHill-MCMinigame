package constantctf.constantctf.Events;

import constantctf.constantctf.Tasks.ChemTrails.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class WolfCaptureEvents implements Listener {
    private ChemTrailSelectionEvent ChemTrails;
    public boolean isCaptureReady;
    public boolean isWolfAlive;
    public Location pointHere;
    public Player playerConPerro;
    public Wolf wolf;
    private HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 180;

    public WolfCaptureEvents(ChemTrailSelectionEvent ctse) {
        isCaptureReady = false;
        isWolfAlive = false;
        ChemTrails = ctse;
    }

    //Watches For Wolf Death
    @EventHandler
    public void onWolfDeath(EntityDeathEvent e) {
        if(e.getEntity() instanceof Wolf) {
            playerConPerro = null;
            isWolfAlive = false;
            e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.NETHER_STAR, 1));
        }
    }

    //Creates Wolf when Capture Happens
    @EventHandler
    public void onWolfCapture(BlockBreakEvent e) {
        if(e.getBlock().getType().equals(Material.DEEPSLATE_DIAMOND_ORE)) {
            playerConPerro = e.getPlayer();
            isWolfAlive = true;
            isCaptureReady = false;
            e.getPlayer().getLocation();
            wolf = (Wolf) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.WOLF);
            wolf.setOwner(e.getPlayer());
            e.getBlock().setType(Material.SMOOTH_STONE);
            Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + " Has a pet Wolf.");
            Bukkit.broadcastMessage("Follow the Compass and eliminate the furry.");
            e.setCancelled(true);
        }
    }

    //updates compass
    //initiates new capture point if needed
    //updates location to point to if player held
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if(!isCaptureReady && !isWolfAlive) {
            setNewCaptureSpot(e.getPlayer());
        }
        if(e.getPlayer().equals(playerConPerro)) {

            runParticleEffect(e.getPlayer());

            if(playerConPerro.getLocation().getBlockX() - wolf.getLocation().getBlockX() < -25 || playerConPerro.getLocation().getBlockZ() - wolf.getLocation().getBlockZ() > 25) {
                wolf.teleport(playerConPerro);
            }

            pointHere = wolf.getLocation();
            if(checkBBCooldown(playerConPerro)) {
                setBBCooldown(playerConPerro);
                e.getPlayer().getWorld().dropItem(wolf.getLocation(), new ItemStack(Material.NETHER_STAR, 1));
                e.getPlayer().sendMessage("your dog shit on the floor");
            }
        }
        e.getPlayer().setCompassTarget(pointHere);
    }

    public void setNewCaptureSpot(Player player) {
        Location block = new Location(player.getWorld(),1147, 182, 866);
        block.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
        pointHere = block;
        isCaptureReady = true;
        Bukkit.broadcastMessage("Follow the Compass to the new Capture Point");
    }

    public boolean checkBBCooldown(Player player) {
        if(cooldown.containsKey(player.getUniqueId())) {
            long secondsLeft = (cooldown.get(player.getUniqueId())/1000) + cooldowntime - (System.currentTimeMillis() /1000);
            if(secondsLeft > 0) {
                return false;
            }
        }
        return true;
    }
    public void setBBCooldown(Player player) {
        cooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }

    private void runParticleEffect(Player p) {
        int choice = ChemTrails.getTrailSelected(p);
        if(choice == 0) {
            new ParticleTrailATask(p).run();
        }
        if(choice == 1) {
            new ParticleTrailHTask(p).run();
        }
        if(choice == 2) {
            new ParticleTrailCTask(p).run();
        }
        if(choice == 3) {
            new ParticleTrailGTask(p).run();
        }
        if(choice == 4) {
            new ParticleTrailFTask(p).run();
        }
        if(choice == 5) {
            new ParticleTrailDTask(p).run();
        }
        if(choice == 6) {
            new ParticleTrailETask(p).run();
        }
        if(choice == 7) {
            new ParticleTrailBTask(p).run();
        }
        if(choice == 8) {
            new ParticleTrailITask(p).run();
        }
    }
}
