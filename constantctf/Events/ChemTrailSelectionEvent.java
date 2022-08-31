package constantctf.constantctf.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zoglin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChemTrailSelectionEvent implements Listener {

    private final Inventory inv;
    private Map<UUID, Integer> savedTrail = new HashMap<UUID, Integer>();

    public ChemTrailSelectionEvent() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 9, "Chem-Trails");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.addItem(createGuiItem(Material.ENCHANTED_BOOK, "Default Particles", "§bHa Loser"));
        inv.addItem(createGuiItem(Material.TOTEM_OF_UNDYING, "§bTotem Particles", "§aGreen Particles"));
        inv.addItem(createGuiItem(Material.SNOWBALL, "§bSnowflake Particles", "§aWhite Particles"));
        inv.addItem(createGuiItem(Material.INK_SAC, "§bSquid Particles", "§aBlack Particles"));
        inv.addItem(createGuiItem(Material.GLOW_INK_SAC, "§bGlow Squid Particles", "§aBlue-Green Particles"));
        inv.addItem(createGuiItem(Material.ROSE_BUSH, "§bHeart Particles", "§aRed Heart Particles"));
        inv.addItem(createGuiItem(Material.DRAGON_BREATH, "§bDragon's Breath Particles", "§aPurple Particles"));
        inv.addItem(createGuiItem(Material.CAMPFIRE, "§bFlame Particles", "§aOrange Fire Particles"));
        inv.addItem(createGuiItem(Material.SOUL_CAMPFIRE, "§bSoul Flame Particles", "§aBlue Fire Particles"));
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        if(e.getRawSlot() == 0) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 0);
        }
        if(e.getRawSlot() == 1) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 1);
        }
        if(e.getRawSlot() == 2) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 2);
        }
        if(e.getRawSlot() == 3) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 3);
        }
        if(e.getRawSlot() == 4) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 4);
        }
        if(e.getRawSlot() == 5) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 5);
        }
        if(e.getRawSlot() == 6) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 6);
        }
        if(e.getRawSlot() == 7) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 7);
        }
        if(e.getRawSlot() == 8) {
            savedTrail.put(e.getWhoClicked().getUniqueId(), 8);
        }
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
    //open inventory
    @EventHandler
    public void onRightClickEvent(PlayerInteractAtEntityEvent e) {
        if(e.getRightClicked() instanceof Zoglin) {
            e.getPlayer().openInventory(inv);
        }
    }

    public int getTrailSelected(Player p) {
        if(savedTrail.containsKey(p.getUniqueId())) {
            return savedTrail.get(p.getUniqueId());
        }
        return 0;
    }

}
