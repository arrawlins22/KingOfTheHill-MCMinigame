package constantctf.constantctf.Events.RankManagingEvents;

import constantctf.constantctf.CustomItems.Accessories.*;
import constantctf.constantctf.CustomItems.RankItems.BaseRankItem;
import constantctf.constantctf.CustomItems.RankItems.MundoRankItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class ImportantItemDropEvent implements Listener {

    @EventHandler
    public void onImportantItemDropEvent(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItemDrop().getItemStack();
        if(item.equals(BridgeBuilderItem.BridgeBuilder)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(CloudInABottleItem.CloudInABottleItem)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(RenewablePearlItem.RenewablePearl)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(DeeDomeItem.DeeDome)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(StickyIckyItem.StickyIcky)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(WallItem.Wall)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(RegenerationFlowerItem.RegenerationFlower)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(ResistanceShellItem.ResistanceShell)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(StrengthStickItem.StrengthStick)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.getType().equals(Material.COMPASS)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You will need this item");
        }
        if(item.getType().equals(Material.NETHER_STAR)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "No Droppy Droppy");
        }
        if(item.equals(RocketJumpItem.RocketJump)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
        if(item.equals(ChunkErrorItem.ChunkError)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "That item can't be dropped");
        }
    }

}
