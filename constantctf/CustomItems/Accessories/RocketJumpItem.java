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

public class RocketJumpItem {

    public static ItemStack RocketJump;

    public static void init() {
        createRocketJumpItem();
    }

    public static void createRocketJumpItem() {
        Material mat = Material.FIREWORK_STAR;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aI know its buggy as hell");
        itemLore.add("§bHold to equip to elytra, right click to get rocket");
        //Meta
        itemMeta.setDisplayName("§bRocket Jump");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        RocketJump = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "RocketJump");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, RocketJump);
        itemRecipe.shape("WWW",
                         "WWW",
                         "WWW");
        itemRecipe.setIngredient('W', Material.SPRUCE_PLANKS);

        Bukkit.addRecipe(itemRecipe);

    }
}
