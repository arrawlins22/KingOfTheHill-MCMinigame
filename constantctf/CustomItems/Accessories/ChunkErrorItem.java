package constantctf.constantctf.CustomItems.Accessories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChunkErrorItem {
    public static ItemStack ChunkError;

    public static void init() {
        createChunkError();
    }

    public static void createChunkError() {
        Material mat = Material.YELLOW_GLAZED_TERRACOTTA;
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta itemMeta = item.hasItemMeta() ?
                item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(mat);
        //Lore
        List<String> itemLore = new ArrayList<>();
        itemLore.add("§aWow your game must have Bugged...");
        itemLore.add("§bRight Click to use");
        //Meta
        itemMeta.setDisplayName("§bChunk Error");
        itemMeta.setLore(itemLore);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.LUCK, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);

        ChunkError = item;
    }
}
