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

public class RenewablePearlItem {

    public static ItemStack RenewablePearl;

    public static void init() {
        createRenewablePearlItem();
    }

    public static void createRenewablePearlItem() {
        Material mat = Material.ENDER_PEARL;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aReduce, Reuse, Recycle");
        itemLore.add("§bRight Click to use");
        //Meta
        itemMeta.setDisplayName("§bRenewable Pearl");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        RenewablePearl = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "RenewablePearl");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, RenewablePearl);
        itemRecipe.shape("WWW",
                         "WWW",
                         "WWW");
        itemRecipe.setIngredient('W', Material.ACACIA_PLANKS);

        Bukkit.addRecipe(itemRecipe);

    }
}
