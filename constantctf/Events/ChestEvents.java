package constantctf.constantctf.Events;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.CustomItems.Chests.FoodChest;
import constantctf.constantctf.CustomItems.Chests.MilitaryChest;
import constantctf.constantctf.CustomItems.Chests.MiscChest;
import constantctf.constantctf.Tasks.ChangeBlockTask;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public class ChestEvents implements Listener {

    @EventHandler
    public void onLoot(InventoryOpenEvent e) {

        Inventory inventory = e.getInventory();
        Location blockLocation = e.getInventory().getLocation();
        blockLocation.add(0,-1,0);
            //Military
            if (blockLocation.getBlock().getType().compareTo(Material.GREEN_WOOL) == 0) {
                e.getInventory().addItem(MilitaryChest.createCommonChest());
            }
            if (blockLocation.getBlock().getType().compareTo(Material.RED_WOOL) == 0) {
                e.getInventory().addItem(MilitaryChest.createUncommonChest());
            }
            if (blockLocation.getBlock().getType().compareTo(Material.BROWN_WOOL) == 0) {
                e.getInventory().addItem(MilitaryChest.createRareChest());
            }
            //Food
            if (blockLocation.getBlock().getType().compareTo(Material.CYAN_WOOL) == 0 || blockLocation.getBlock().getType().compareTo(Material.LIGHT_BLUE_WOOL) == 0) {
                e.getInventory().addItem(FoodChest.createCommonChest());
            }
            if (blockLocation.getBlock().getType().compareTo(Material.PURPLE_WOOL) == 0) {
                e.getInventory().addItem(FoodChest.createUncommonChest());
            }
            if (blockLocation.getBlock().getType().compareTo(Material.BLUE_WOOL) == 0) {
                e.getInventory().addItem(FoodChest.createRareChest());
            }
            //Misc
            if (blockLocation.getBlock().getType().compareTo(Material.GRAY_WOOL) == 0) {
                e.getInventory().addItem(MiscChest.createCommonChest());
            }
            if (blockLocation.getBlock().getType().compareTo(Material.LIGHT_GRAY_WOOL) == 0) {
                e.getInventory().addItem(MiscChest.createUncommonChest());
            }
            if (blockLocation.getBlock().getType().compareTo(Material.WHITE_WOOL) == 0) {
                e.getInventory().addItem(MiscChest.createRareChest());
            }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Location location = e.getInventory().getLocation();
        location.add(0,-1,0);
        Material mat = location.getBlock().getType();

        if(mat.compareTo(Material.GREEN_WOOL) == 0 || mat.compareTo(Material.CYAN_WOOL) == 0|| mat.compareTo(Material.LIGHT_BLUE_WOOL) == 0) {
            e.getInventory().getLocation().getBlock().setType(Material.AIR);
            new ChangeBlockTask(ConstantCTF.getPlugin(), e.getInventory().getLocation(), Material.CHEST).runTaskLater(ConstantCTF.getPlugin(), 180L*20);
        }
        if(mat.compareTo(Material.RED_WOOL) == 0 || mat.compareTo(Material.PURPLE_WOOL) == 0 || mat.compareTo(Material.GRAY_WOOL) == 0) {
            e.getInventory().getLocation().getBlock().setType(Material.AIR);
            new ChangeBlockTask(ConstantCTF.getPlugin(), e.getInventory().getLocation(), Material.CHEST).runTaskLater(ConstantCTF.getPlugin(), 360L*20);
        }
        if(mat.compareTo(Material.BROWN_WOOL) == 0) {
            e.getInventory().getLocation().getBlock().setType(Material.AIR);
            new ChangeBlockTask(ConstantCTF.getPlugin(), e.getInventory().getLocation(), Material.CHEST).runTaskLater(ConstantCTF.getPlugin(), 720L*20);
        }
    }
}
