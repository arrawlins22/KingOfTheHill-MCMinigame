package constantctf.constantctf.Events;
import constantctf.constantctf.Tasks.ChemTrails.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class NoFallDamageEvent  implements Listener {

    private ChemTrailSelectionEvent ChemTrails;

    public NoFallDamageEvent(ChemTrailSelectionEvent ctse) {
        ChemTrails = ctse;
    }

    @EventHandler
    public void onFallDmg(EntityDamageEvent e) {
        if(e.getCause().compareTo(EntityDamageEvent.DamageCause.FALL) == 0) {
            e.setCancelled(true);
        }
        if(e.getEntity() instanceof LivingEntity) {
            if(e.getEntity().getLocation().getBlockX() < 1110 && e.getEntity().getLocation().getBlockX() > 1080) {
                if(e.getEntity().getLocation().getBlockY() < 110 && e.getEntity().getLocation().getBlockX() > 95) {
                    if(e.getEntity().getLocation().getBlockZ() < 890 && e.getEntity().getLocation().getBlockZ() > 860) {
                        e.setCancelled(true);
                        ((LivingEntity) e.getEntity()).setHealth(20);
                    }
                }
            }
        }
    }
    @EventHandler
    public void ParticleTrailsInSpawn(PlayerMoveEvent e) {
        if(e.getPlayer().getLocation().getBlockX() < 1110 && e.getPlayer().getLocation().getBlockX() > 1080) {
            if (e.getPlayer().getLocation().getBlockY() < 110 && e.getPlayer().getLocation().getBlockX() > 95) {
                if (e.getPlayer().getLocation().getBlockZ() < 890 && e.getPlayer().getLocation().getBlockZ() > 860) {
                    runParticleEffect(e.getPlayer());
                }
            }
        }
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
