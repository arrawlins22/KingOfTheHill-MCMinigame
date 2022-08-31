package constantctf.constantctf.Events.KillStreakEvents;

import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import java.util.Objects;

public class NetherStarBuffs implements Listener {

    private final Inventory inv;


    public NetherStarBuffs() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 9, "Example");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.addItem(createGuiItem(Material.SUGAR, "Crack", "§bRight click for 10 seconds of speed 5", "§b Cost 1 star"));
        inv.addItem(createGuiItem(Material.DIAMOND_SWORD, "§bMy Thicc Sword", "§aBuy for a nice sword", "§bCost 5 Stars"));
        inv.addItem(createGuiItem(Material.DIAMOND_HELMET, "§bAustin's Helmet", "§aThe only helmet worthy of protecting the bowl cut", "§bCost 5 Stars"));
        inv.addItem(createGuiItem(Material.DIAMOND_CHESTPLATE, "§bThe Grinch's Chestplate", "§aOnly those with the smallest hearts can wear", "§bCost 5 Stars"));
        inv.addItem(createGuiItem(Material.DIAMOND_LEGGINGS, "§bJohn's Leggings", "§aWe all know why they're John's", "§bCost 5 Stars"));
        inv.addItem(createGuiItem(Material.DIAMOND_BOOTS, "§bJust some boots", "§aI mean not like you are gonna buy em", "§bCost 5 Stars"));
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
            if(p.getInventory().containsAtLeast(new ItemStack(Material.NETHER_STAR, 1), 1)) {
                p.getEquipment().setItemInMainHand(new ItemStack(Material.NETHER_STAR, p.getEquipment().getItemInMainHand().getAmount()-1));
                p.getInventory().addItem(new ItemStack(Material.SUGAR, 1));
            } else {
                p.sendMessage("you can't afford that");
            }
        }
        if(e.getRawSlot() == 1) {
            if(p.getInventory().containsAtLeast(new ItemStack(Material.NETHER_STAR, 1), 5)) {
                p.getEquipment().setItemInMainHand(new ItemStack(Material.NETHER_STAR, p.getEquipment().getItemInMainHand().getAmount()-5));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
            } else {
                p.sendMessage("you can't afford that");
            }
        }
        if(e.getRawSlot() == 2) {
            if(p.getInventory().containsAtLeast(new ItemStack(Material.NETHER_STAR, 1), 5)) {
                p.getEquipment().setItemInMainHand(new ItemStack(Material.NETHER_STAR, p.getEquipment().getItemInMainHand().getAmount()-5));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET, 1));
            } else {
                p.sendMessage("you can't afford that");
            }
        }
        if(e.getRawSlot() == 3) {
            if(p.getInventory().containsAtLeast(new ItemStack(Material.NETHER_STAR, 1), 5)) {
                p.getEquipment().setItemInMainHand(new ItemStack(Material.NETHER_STAR, p.getEquipment().getItemInMainHand().getAmount()-5));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
            } else {
                p.sendMessage("you can't afford that");
            }
        }
        if(e.getRawSlot() == 4) {
            if(p.getInventory().containsAtLeast(new ItemStack(Material.NETHER_STAR, 1), 5)) {
                p.getEquipment().setItemInMainHand(new ItemStack(Material.NETHER_STAR, p.getEquipment().getItemInMainHand().getAmount()-5));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
            } else {
                p.sendMessage("you can't afford that");
            }
        }
        if(e.getRawSlot() == 5) {
            if(p.getInventory().containsAtLeast(new ItemStack(Material.NETHER_STAR, 1), 5)) {
                p.getEquipment().setItemInMainHand(new ItemStack(Material.NETHER_STAR, p.getEquipment().getItemInMainHand().getAmount()-5));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS, 1));
            } else {
                p.sendMessage("you can't afford that");
            }
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
    public void openNetherStarInv(PlayerInteractEvent e) {
        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                e.getPlayer().openInventory(inv);
            }
        }

    }
}
