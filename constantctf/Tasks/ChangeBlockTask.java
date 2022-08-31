package constantctf.constantctf.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ChangeBlockTask extends BukkitRunnable {

   Plugin plugin;
   Material material;
   Location location;

    public ChangeBlockTask(Plugin plugin, Location loc, Material mat) {
        this.plugin = plugin;
        this.location = loc;
        this.material = mat;
    }

    @Override
    public void run() {
        location.getBlock().setType(material);
    }

}
