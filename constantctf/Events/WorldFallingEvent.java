package constantctf.constantctf.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.HashMap;
import java.util.UUID;

public class WorldFallingEvent implements Listener {


    private HashMap<UUID,Long> cooldown = new java.util.HashMap<UUID, Long>();
    private long cooldowntime = 120;
    PotionEffect speed = new PotionEffect(PotionEffectType.SLOW_FALLING, 20, 0);

    public boolean checkBBCooldown(Player player) {
        if(cooldown.containsKey(player.getUniqueId())) {
            long secondsLeft = (cooldown.get(player.getUniqueId())/1000) + cooldowntime - (System.currentTimeMillis() /1000);
            if(secondsLeft > 0) {
                return false;
            }
        }
        return true;
    }
    public void setBBCooldown(Player player) {
        cooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }

    @EventHandler
    public void onWorldFall(PlayerMoveEvent e) {

        if(e.getPlayer().getLocation().getBlockY() < 5 && checkBBCooldown(e.getPlayer())) {
            e.getPlayer().teleport(e.getPlayer().getLocation().add(0, 300, 0));
            e.getPlayer().sendMessage("If you fall again in the next 120 seconds you will die");
            e.getPlayer().addPotionEffect(speed);
            setBBCooldown(e.getPlayer());
        }

    }

    
}
