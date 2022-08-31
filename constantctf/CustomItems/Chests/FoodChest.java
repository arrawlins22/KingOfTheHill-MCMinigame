package constantctf.constantctf.CustomItems.Chests;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class FoodChest {

    public static Inventory UncommonChest;
    public static Inventory RareChest;

    public static ItemStack[] createCommonChest() {
        ArrayList<ItemStack> contents = new ArrayList<>();
        int num = (int) (Math.random() * 100);
        if (num < 100) {
            int rand = (int) (Math.random() * 100);
            if(rand < 25) {
                contents.add(new ItemStack(Material.BEEF, 1));
            } else if (rand < 50) {
                contents.add(new ItemStack(Material.PORKCHOP, 1));
            } else if (rand < 75) {
                contents.add(new ItemStack(Material.MUTTON, 1));
            } else {
                contents.add(new ItemStack(Material.RABBIT, 1));
            }

        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.BEEF, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.PORKCHOP, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.MUTTON, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.RABBIT, 1));
        }
        ItemStack[] it = contents.toArray(new ItemStack[0]);
        return it;
    }

    public static ItemStack[] createUncommonChest() {
        ArrayList<ItemStack> contents = new ArrayList<>();
        int num = (int) (Math.random() * 100);
        if (num < 100) {
            int rand = (int) (Math.random() * 100);
            if(rand < 25) {
                contents.add(new ItemStack(Material.COOKED_BEEF, 1));
            } else if (rand < 50) {
                contents.add(new ItemStack(Material.COOKED_CHICKEN, 1));
            } else if (rand < 75) {
                contents.add(new ItemStack(Material.COOKED_MUTTON, 1));
            } else {
                contents.add(new ItemStack(Material.COOKED_PORKCHOP, 1));
            }
        }
        num = (int) (Math.random() * 100);
        if (num < 40) {
            contents.add(new ItemStack(Material.COOKED_PORKCHOP, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 40) {
            contents.add(new ItemStack(Material.COOKED_MUTTON, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 40) {
            contents.add(new ItemStack(Material.COOKED_CHICKEN, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 40) {
            contents.add(new ItemStack(Material.COOKED_BEEF, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 10) {
            contents.add(new ItemStack(Material.GOLDEN_CARROT, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 10) {
            contents.add(new ItemStack(Material.GOLDEN_APPLE, 1));
        }
        ItemStack[] it = contents.toArray(new ItemStack[0]);
        return it;
    }

    public static ItemStack[] createRareChest() {
        ArrayList<ItemStack> contents = new ArrayList<>();
        int num = (int) (Math.random() * 100);
        if (num < 100) {
            int rand = (int) (Math.random() * 100);
            if(rand < 25) {
                contents.add(new ItemStack(Material.IRON_BOOTS, 1));
            } else if (rand < 50) {
                contents.add(new ItemStack(Material.IRON_LEGGINGS, 1));
            } else if (rand < 75) {
                contents.add(new ItemStack(Material.IRON_CHESTPLATE, 1));
            } else {
                contents.add(new ItemStack(Material.IRON_HELMET, 1));
            }
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.IRON_SWORD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.IRON_AXE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 80) {
            contents.add(new ItemStack(Material.SPECTRAL_ARROW, 10));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.BOW, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.CROSSBOW, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 40) {
            contents.add(new ItemStack(Material.SHIELD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 2) {
            contents.add(new ItemStack(Material.DIAMOND_SWORD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 2) {
            contents.add(new ItemStack(Material.DIAMOND_AXE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 2) {
            contents.add(new ItemStack(Material.DIAMOND_HELMET, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 2) {
            contents.add(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 2) {
            contents.add(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 2) {
            contents.add(new ItemStack(Material.DIAMOND_BOOTS, 1));
        }
        ItemStack[] it = contents.toArray(new ItemStack[0]);
        return it;
    }
}
