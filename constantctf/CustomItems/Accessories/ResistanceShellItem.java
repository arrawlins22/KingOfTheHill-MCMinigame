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

public class ResistanceShellItem {
    public static ItemStack ResistanceShell;

    public static void init() {
        createResistanceShellItem();
    }

    public static void createResistanceShellItem() {
        Material mat = Material.TURTLE_EGG;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aWow Austin, Creative Game Design");
        itemLore.add("§bAlways Active");
        //Meta
        itemMeta.setDisplayName("§bResistance Shell");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        ResistanceShell = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "ResistanceShell");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, ResistanceShell);
        itemRecipe.shape("WWW",
                         "WWW",
                         "WWW");
        itemRecipe.setIngredient('W', Material.TURTLE_EGG);

        Bukkit.addRecipe(itemRecipe);

    }
}
