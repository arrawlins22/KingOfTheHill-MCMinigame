package constantctf.constantctf.Events.RankManagingEvents;

import constantctf.constantctf.CustomItems.RankItems.MundoRankItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class NoBlockBreakingEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        e.setCancelled(true);
        if(player.getInventory().contains(MundoRankItem.MundoRankItem, 1)) {
            e.setCancelled(false);
        }
    }
}
