package constantctf.constantctf.Tasks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class StickyIckyTask extends BukkitRunnable {
    Plugin plugin;
    Material material;
    Block block;

    public StickyIckyTask(Plugin plugin, Block block, Material mat) {
        this.plugin = plugin;
        this.block = block;
        this.material = mat;
    }

    @Override
    public void run() {
        block.setType(material);
    }

}
