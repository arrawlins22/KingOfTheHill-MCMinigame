package constantctf.constantctf.Events.RankManagingEvents;

import constantctf.constantctf.CustomItems.RankItems.BaseRankItem;
import constantctf.constantctf.CustomItems.RankItems.MundoRankItem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class PlayerJoinEvent implements Listener {

    ArrayList<String> BigBois = new ArrayList<String>();

    public ArrayList<String> getBigBois() {
        if(!BigBois.contains("Frost_Shadow_22")) {
            BigBois.add("Frost_Shadow_22");
        }
        if(!BigBois.contains("_HalfDollar")) {
            BigBois.add("_HalfDollar");
        }
        return BigBois;
    }
    public boolean isMundo(Player player) {
        if(getBigBois().contains(player.getDisplayName())) {
            return true;
        }
        return false;
    }

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.teleport(new Location(player.getWorld(), 1097.5, 100,879.5, 270, 0));
        player.getInventory().setContents(player.getEnderChest().getContents());
        player.setAllowFlight(true);

    }
}
