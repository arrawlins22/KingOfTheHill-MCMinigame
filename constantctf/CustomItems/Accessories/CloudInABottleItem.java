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

public class CloudInABottleItem {

    public static ItemStack CloudInABottleItem;

    public static void init() {
        createCloudInABottle();
    }

    public static void createCloudInABottle() {
        Material mat = Material.GRAY_GLAZED_TERRACOTTA;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aTwo extra big, extra jumps");
        itemLore.add("§bDouble tap space to use");
        //Meta
        itemMeta.setDisplayName("§bCloud in a Bottle");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK,  1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        CloudInABottleItem = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "CloudInABottleItem");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, CloudInABottleItem);
        itemRecipe.shape ("WWW",
                          "WWW",
                          "WWW");
        itemRecipe.setIngredient('W', Material.BIRCH_PLANKS);

        Bukkit.addRecipe(itemRecipe);

    }
}
