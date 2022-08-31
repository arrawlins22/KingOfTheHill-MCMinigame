package constantctf.constantctf.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class HandleDeathEvent implements Listener {

    ItemStack[] empty = new ItemStack[41];
    SaveLocationOnDC sldc;

    public HandleDeathEvent(SaveLocationOnDC sldc) {
        this.sldc = sldc;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        sldc.removeSavedItems(e.getEntity().getUniqueId());
        sldc.removeSavedLocation(e.getEntity().getUniqueId());
        e.getDrops().clear();
        e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.NETHER_STAR, 1));
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        e.setRespawnLocation(new Location(e.getPlayer().getWorld(), 1094, 100, 882, 0, 0));
    }

}
