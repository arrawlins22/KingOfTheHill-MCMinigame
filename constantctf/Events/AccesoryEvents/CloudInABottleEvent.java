package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.CustomItems.Accessories.CloudInABottleItem;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class CloudInABottleEvent implements Listener {

    private ArrayList<UUID> pog = new ArrayList<>();

    private HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private long cooldowntime = 20;

    public boolean checkBBCooldown(Player player) {
        if(cooldown.containsKey(player.getUniqueId())) {
            long secondsLeft = (cooldown.get(player.getUniqueId())/1000) + cooldowntime - (System.currentTimeMillis() /1000);
            if(secondsLeft > 0) {
                player.sendMessage(ChatColor.RED + "Its on Cooldown for " + secondsLeft +" more seconds dummy");
                return false;
            }
        }
        return true;
    }
    public void setBBCooldown(Player player) {
        cooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }
    public boolean checkFirstJump(Player player) {
        if(pog.contains(player.getUniqueId())) {
            pog.remove(player.getUniqueId());
            return true;
        }
        return false;
    }
    public void setFirstJump(Player player) {
        pog.add(player.getUniqueId());
    }

    @EventHandler
    public void DoubleJump(PlayerToggleFlightEvent e){
        Player player = e.getPlayer();

        if(player.getInventory().contains(CloudInABottleItem.CloudInABottleItem, 1)) {
            if(player.getGameMode() != GameMode.CREATIVE) {
                if(checkBBCooldown(player)) {
                    if(checkFirstJump(player)) {
                        setBBCooldown(player);
                    } else {
                        setFirstJump(player);;
                    }
                    player.setVelocity(player.getLocation().getDirection().multiply(3).setY(1.5));
                    e.setCancelled(true);
                }
            }
        }
        if(player.getGameMode() == GameMode.CREATIVE) {
        } else {
            e.setCancelled(true);
            player.setFlying(false);
        }
    }

    @EventHandler
    public void FixDoubleJump(PlayerItemHeldEvent e) {
        if(e.getPlayer().getInventory().getItem(e.getNewSlot()).equals(CloudInABottleItem.CloudInABottleItem)) {
            e.getPlayer().setAllowFlight(true);
        }
    }

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(CloudInABottleItem.CloudInABottleItem)) {
            if(cooldown.containsKey(p.getUniqueId())) {
                long secondsLeft = (cooldown.get(p.getUniqueId())/1000) + cooldowntime - (System.currentTimeMillis() /1000);
                if(secondsLeft > 0) {
                    p.setLevel((int) secondsLeft);
                    return;
                }
                p.setLevel(0);
            }
        }
    }

}
