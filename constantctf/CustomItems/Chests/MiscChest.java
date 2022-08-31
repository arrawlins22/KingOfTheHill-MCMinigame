package constantctf.constantctf.CustomItems.Chests;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class MiscChest {

    public static Inventory CommonChest;
    public static Inventory UncommonChest;
    public static Inventory RareChest;

    public static ItemStack[] createCommonChest() {
        ArrayList<ItemStack> contents = new ArrayList<>();
        int num;
        contents.add(pot(0));
        num = (int) (Math.random() * 100);
        if (num < 50) {
            contents.add(pot(1));
        }
        num = (int) (Math.random() * 100);
        if (num < 50) {
            contents.add(pot(1));
        }
        num = (int) (Math.random() * 100);
        if (num < 20) {
            contents.add(pot(2));
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

    public static ItemStack pot(int amp) {

        Material mat = Material.POTION;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add(ChatColor.WHITE + "pot");
        //Meta
        itemMeta.setDisplayName(ChatColor.GOLD + "pot");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);
        PotionMeta potionmeta = (PotionMeta) item.getItemMeta();
        PotionEffect speed = new PotionEffect(PotionEffectType.HEAL, 4, amp);
        potionmeta.addCustomEffect(speed, true);
        item.setItemMeta(potionmeta);

        return item;
    }
}
