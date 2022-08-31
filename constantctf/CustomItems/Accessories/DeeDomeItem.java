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

public class DeeDomeItem {
    public static ItemStack DeeDome;

    public static void init() {
        createBridgeBuilder();
    }

    public static void createBridgeBuilder() {
        Material mat = Material.NETHER_BRICK;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aYou should let people in your bubble");
        itemLore.add("§bRight Click to use");
        //Meta
        itemMeta.setDisplayName("§bDee-Dome");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK,  1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        DeeDome = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "DeeDome");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, DeeDome);
        itemRecipe.shape ("WWW",
                          "WWW",
                          "WWW");
        itemRecipe.setIngredient('W', Material.NETHER_BRICK);

        Bukkit.addRecipe(itemRecipe);

    }
}
