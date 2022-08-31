package constantctf.constantctf.Events;

import constantctf.constantctf.ConstantCTF;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class LeaderBoardEvents  implements Listener {
    public Map<String,Integer> playerkills;
    public LeaderBoardEvents() {
        playerkills = new HashMap<>();
    }
    @EventHandler
    public void onKillConfirm(EntityPickupItemEvent e) {
        if(e.getEntity() instanceof Player && e.getItem().getItemStack().equals(new ItemStack(Material.NETHER_STAR, 1))) {
            Player p = (Player) e.getEntity();
            PersistentDataContainer data = p.getPersistentDataContainer();
            int kills = 1;
            if(data.has(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER)) {
                kills = data.get(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER);
                kills++;
            }
            data.set(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER, kills);
        }
    }

    @EventHandler
    public void onLogOff(PlayerQuitEvent e) {
        int kills = 0;
        PersistentDataContainer data = e.getPlayer().getPersistentDataContainer();
        if(data.has(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER)) {
            kills = data.get(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER);
        }
        playerkills.put(e.getPlayer().getName(), kills);
    }

    @EventHandler
    public void onKillReset(EntityPickupItemEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getItem().getItemStack().getType().equals(Material.DRIED_KELP)) {
                PersistentDataContainer data = e.getEntity().getPersistentDataContainer();
                data.set(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER, 0);
            }
        }
    }

}
