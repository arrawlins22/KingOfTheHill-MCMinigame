package constantctf.constantctf.CustomItems.Accessories;
import constantctf.constantctf.ConstantCTF;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class BridgeBuilderItem {

    public static ItemStack BridgeBuilder;

    public static void init() {
        createBridgeBuilder();
    }

    public static void createBridgeBuilder() {
        Material mat = Material.CYAN_GLAZED_TERRACOTTA;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aOh this is how I get over there");
        itemLore.add("§bLeft Click to Use");
        //Meta
        itemMeta.setDisplayName("§bBridge Builder");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK,  1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        BridgeBuilder = item;
        //recipe
        NamespacedKey key = new NamespacedKey(ConstantCTF.getPlugin(ConstantCTF.class), "BridgeBuilderItem");
        ShapedRecipe itemRecipe = new ShapedRecipe(key, BridgeBuilder);
        itemRecipe.shape ("WWW",
                          "WWW",
                          "WWW");
        itemRecipe.setIngredient('W', Material.OAK_PLANKS);

        Bukkit.addRecipe(itemRecipe);

    }

}