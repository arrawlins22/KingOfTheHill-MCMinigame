package constantctf.constantctf.CustomItems.Chests;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class MilitaryChest {

    public static ItemStack[] createCommonChest() {
        ArrayList<ItemStack> contents = new ArrayList<>();
        int num = (int) (Math.random() * 100);
        if (num < 100) {
            int rand = (int) (Math.random() * 100);
            if(rand < 25) {
                contents.add(new ItemStack(Material.LEATHER_BOOTS, 1));
            } else if (rand < 50) {
                contents.add(new ItemStack(Material.LEATHER_LEGGINGS, 1));
            } else if (rand < 75) {
                contents.add(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
            } else {
                contents.add(new ItemStack(Material.LEATHER_HELMET, 1));
            }
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.WOODEN_SWORD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.WOODEN_AXE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 80) {
            contents.add(new ItemStack(Material.SPECTRAL_ARROW, 10));
        }
        num = (int) (Math.random() * 100);
        if (num < 20) {
            contents.add(new ItemStack(Material.BOW, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 60) {
            contents.add(new ItemStack(Material.SPYGLASS, 1));
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
                contents.add(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
            } else if (rand < 50) {
                contents.add(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
            } else if (rand < 75) {
                contents.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
            } else {
                contents.add(new ItemStack(Material.CHAINMAIL_HELMET, 1));
            }
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.STONE_SWORD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 70) {
            contents.add(new ItemStack(Material.STONE_AXE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 80) {
            contents.add(new ItemStack(Material.SPECTRAL_ARROW, 10));
        }
        num = (int) (Math.random() * 100);
        if (num < 40) {
            contents.add(new ItemStack(Material.SHIELD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 30) {
            contents.add(new ItemStack(Material.SPYGLASS, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 60) {
            contents.add(new ItemStack(Material.BOW, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 5) {
            contents.add(new ItemStack(Material.IRON_SWORD, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 5) {
            contents.add(new ItemStack(Material.IRON_AXE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 5) {
            contents.add(new ItemStack(Material.IRON_HELMET, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 5) {
            contents.add(new ItemStack(Material.IRON_CHESTPLATE, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 5) {
            contents.add(new ItemStack(Material.IRON_LEGGINGS, 1));
        }
        num = (int) (Math.random() * 100);
        if (num < 5) {
            contents.add(new ItemStack(Material.IRON_BOOTS, 1));
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
