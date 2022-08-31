package constantctf.constantctf.Events.AccesoryEvents;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CombatAccesoryEvents implements Listener {

    PotionEffect Resistance;
    PotionEffect Strength;
    PotionEffect Regeneration;

    public CombatAccesoryEvents() {
        Resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1);
        Strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0);
        Regeneration = new PotionEffect(PotionEffectType.REGENERATION, 100, 1);
    }

    @EventHandler
    public void ResistanceShell(PlayerMoveEvent e) {
        if(e.getPlayer().getInventory().contains(Material.TURTLE_EGG)) {
            if(!e.getPlayer().hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                e.getPlayer().addPotionEffect(Resistance);
            }
        }
    }

    @EventHandler
    public void StrengthStick(PlayerMoveEvent e) {
        if(e.getPlayer().getInventory().contains(Material.BLAZE_ROD)) {
            if(!e.getPlayer().hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                e.getPlayer().addPotionEffect(Strength);
            }
        }
    }

    @EventHandler
    public void RegenerationFlower(PlayerMoveEvent e) {
        if(e.getPlayer().getInventory().contains(Material.RED_TULIP)) {
            if(!e.getPlayer().hasPotionEffect(PotionEffectType.REGENERATION)) {
                e.getPlayer().addPotionEffect(Regeneration);
            }
        }
    }
}
