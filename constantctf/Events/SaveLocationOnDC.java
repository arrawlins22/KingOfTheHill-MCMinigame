package constantctf.constantctf.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SaveLocationOnDC implements Listener {

    private Map<UUID, Location> savedLocation = new HashMap<UUID, Location>();
    private Map<UUID, ItemStack[]> savedItems = new HashMap<UUID, ItemStack[]>();

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e){
        Player player = e.getPlayer();

        if(player.getLocation().getY() >= 20) {
            setSavedItems(player.getUniqueId(), player.getInventory().getContents());
            setSavedLocation(player.getUniqueId(), player.getLocation());
        }

    }

    @EventHandler
    public void onGameContinue(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if(e.getBlock().getDrops().contains(new ItemStack(Material.SOUL_TORCH, 1))) {
            e.setCancelled(true);
            if(savedLocation.containsKey(player.getUniqueId())) {
                player.teleport(savedLocation.get(player.getUniqueId()));
                player.getInventory().setContents(savedItems.get(player.getUniqueId()));
            } else {
                player.sendMessage("You do not have a run to continue!");
            }
            return;
        }

    }

    public Map<UUID, Location> getSavedLocations() {
        return savedLocation;
    }
    public Map<UUID, ItemStack[]> getSavedItems() {
        return savedItems;
    }
    public void setSavedLocation(UUID uuid, Location location) {
        savedLocation.put(uuid, location);
    }
    public void setSavedItems(UUID uuid, ItemStack[] contents) {
        savedItems.put(uuid, contents);
    }
    public void removeSavedLocation(UUID uuid) {
        savedLocation.remove(uuid);
    }
    public void removeSavedItems(UUID uuid) {
        savedItems.remove(uuid);
    }
}
