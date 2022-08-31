package constantctf.constantctf.Tasks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class ChunkErrorTask extends BukkitRunnable {

    private Block block;
    private Material material;

    public ChunkErrorTask(Block block, Material mat) {
        this.block = block;
        this.material = mat;
    }

    @Override
    public void run() {
        block.setType(material);
    }
}
