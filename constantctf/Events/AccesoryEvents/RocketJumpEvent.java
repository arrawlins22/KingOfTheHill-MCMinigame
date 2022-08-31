package constantctf.constantctf.Events.AccesoryEvents;

import constantctf.constantctf.CustomItems.Accessories.BridgeBuilderItem;
import constantctf.constantctf.CustomItems.Accessories.RocketJumpItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class RocketJumpEvent implements Listener {

    private HashMap<UUID,ItemStack> shirt = new HashMap<>();
    private final HashMap<UUID,Long> cooldown = new HashMap<UUID, Long>();
    private final long cooldowntime = 120;
    private ArrayList<UUID> pog = new ArrayList<>();
    private ItemStack wings = new ItemStack(Material.ELYTRA, 1);

    public boolean checkIfHeldRocket(Player player) {
        if(pog.contains(player.getUniqueId())) {
            pog.remove(player.getUniqueId());
            return true;
        }
        return false;
    }
    public void setHeldRocket(Player player) {
        pog.add(player.getUniqueId());
    }

    @EventHandler
    public void onRocketJump(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        if(e.getPlayer().getEquipment().getItemInMainHand().equals(RocketJumpItem.RocketJump)) {
            if(e.getPlayer().isGliding()) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if (checkBBCooldown(e.getPlayer())) {
                        setBBCooldown(e.getPlayer());
                        ItemStack save = e.getPlayer().getEquipment().getItemInOffHand();
                        e.getPlayer().getEquipment().setItemInOffHand(new ItemStack(Material.FIREWORK_ROCKET, 1));
                        e.getPlayer().getInventory().addItem(save);
                        e.getPlayer().chat("I kiss boys");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent e) {
        Player player = e.getPlayer();
        wings.addEnchantment(Enchantment.BINDING_CURSE, 1);
        if(player.getInventory().getItem(e.getNewSlot()).equals(RocketJumpItem.RocketJump)) {
           if(player.getEquipment().getChestplate() != null || !player.getEquipment().getChestplate().equals(wings)) {
               shirt.put(player.getUniqueId(), player.getEquipment().getChestplate());
           }
           player.getEquipment().setChestplate(wings);
           player.updateInventory();
           setHeldRocket(player);
        }
    }

    @EventHandler
    public void onMovement(PlayerMoveEvent e) {
        if(!Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(RocketJumpItem.RocketJump)) {
            if(checkIfHeldRocket(e.getPlayer())) {
                e.getPlayer().getEquipment().setChestplate(shirt.get(e.getPlayer().getUniqueId()));
            }
            e.getPlayer().updateInventory();
        }
    }


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

    @EventHandler
    public void showCooldown(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (Objects.requireNonNull(e.getPlayer().getEquipment()).getItemInMainHand().equals(RocketJumpItem.RocketJump)) {
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
