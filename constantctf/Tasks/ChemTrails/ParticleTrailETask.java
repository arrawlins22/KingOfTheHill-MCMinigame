package constantctf.constantctf.Tasks.ChemTrails;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class ParticleTrailETask extends BukkitRunnable {

    private final Player player;

    public ParticleTrailETask(Player p) {
        this.player = p;
    }

    @Override
    public void run() {
        Random r = new Random();
        for(int i = 0; i < 5; i++) {
            player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation().add(r.nextDouble()*.5, r.nextDouble()*.5,r.nextDouble()*.5),0);
        }
        for(int i = 0; i < 5; i++) {
            player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation().add(r.nextDouble()*.5, r.nextDouble()*.5,(r.nextDouble()*.5)*-1),0);
        }
    }
}
