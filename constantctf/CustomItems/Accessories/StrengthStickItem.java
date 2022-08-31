package constantctf.constantctf.CustomItems.Accessories;

import constantctf.constantctf.ConstantCTF;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class StrengthStickItem {
    public static ItemStack StrengthStick;

    public static void init() {
        createStrengthStickItem();
    }

    public static void createStrengthStickItem() {
        Material mat = Material.BLAZE_ROD;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aWow Austin, Creative Game Design");
        itemLore.add("§bAlways Active");
        //Meta
        itemMeta.setDisplayName("§bStrength Stick");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        StrengthStick = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "StrengthStick");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, StrengthStick);
        itemRecipe.shape("WWW",
                         "WWW",
                         "WWW");
        itemRecipe.setIngredient('W', Material.BLAZE_ROD);

        Bukkit.addRecipe(itemRecipe);

    }
}
