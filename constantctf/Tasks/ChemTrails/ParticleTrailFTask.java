package constantctf.constantctf.Tasks.ChemTrails;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class ParticleTrailFTask extends BukkitRunnable {

    private final Player player;

    public ParticleTrailFTask(Player p) {
        this.player = p;
    }

    @Override
    public void run() {
        Random r = new Random();
        for(int i = 0; i < 3; i++) {
            player.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, player.getLocation().add(r.nextDouble()*.5, r.nextDouble()*.5,r.nextDouble()*.5),0);
        }
        for(int i = 0; i < 3; i++) {
            player.getWorld().spawnParticle(Particle.GLOW_SQUID_INK, player.getLocation().add(r.nextDouble()*.5, r.nextDouble()*.5,(r.nextDouble()*.5)*-1),0);
        }
    }
}
