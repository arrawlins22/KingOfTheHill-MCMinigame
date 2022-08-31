package constantctf.constantctf.Events.KillStreakEvents;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class KillStreakItemEvents implements Listener {

    PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 200, 4);

    @EventHandler
    public void onSpeedBuff(PlayerInteractEvent e) {
        if(Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().getType().equals(Material.SUGAR)) {
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                e.getPlayer().getEquipment().setItemInMainHand(new ItemStack(Material.SUGAR, e.getPlayer().getEquipment().getItemInMainHand().getAmount() - 1));
                e.getPlayer().addPotionEffect(speed);
            }
        }
    }
}