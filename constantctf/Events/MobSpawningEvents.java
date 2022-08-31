package constantctf.constantctf.Events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MobSpawningEvents implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {

        ItemStack bow = new ItemStack(Material.BOW,1);
        bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 5);
            if(e.getEntity() instanceof Skeleton) {
                e.getEntity().getEquipment().setItemInMainHand(bow);
                e.getEntity().getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET, 1));
            }
            if(e.getEntity() instanceof Zombie) {
                e.getEntity().getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET, 1));
                e.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000000, 3));
            }
            if(e.getEntity() instanceof  Creeper) {
                e.setCancelled(true);
            }
            if(e.getEntity() instanceof Spider) {
                e.setCancelled(true);
            }
            if(e.getEntity() instanceof Enderman) {
                e.setCancelled(true);
            }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if(e.getEntity() instanceof Wolf) {
            return;
        }
        if(e.getEntity() instanceof Skeleton) {
            e.getDrops().clear();
        }
        if(e.getEntity() instanceof Zombie) {
           e.getDrops().clear();
        }
    }


}
