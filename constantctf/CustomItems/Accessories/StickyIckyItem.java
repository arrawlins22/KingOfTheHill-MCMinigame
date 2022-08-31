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

public class StickyIckyItem {

    public static ItemStack StickyIcky;

    public static void init() {
        createStickyIcky();
    }

    public static void createStickyIcky() {
        Material mat = Material.COBWEB;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aHit em wit it");
        itemLore.add("§bRight Click to Use");
        //Meta
        itemMeta.setDisplayName("§bSticky Icky");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        StickyIcky = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "StickyIcky");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, StickyIcky);
        itemRecipe.shape("WWW",
                         "WWW",
                         "WWW");
        itemRecipe.setIngredient('W', Material.STRING);

        Bukkit.addRecipe(itemRecipe);

    }
}
