package constantctf.constantctf.Events;

import constantctf.constantctf.CustomItems.Accessories.*;
import constantctf.constantctf.CustomItems.RankItems.MundoRankItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class LobbyTorchBreakEvent implements Listener {

    private Location gameSpawn[];

    public LobbyTorchBreakEvent() {
        this.gameSpawn = new Location[20];
        Location location0 = new Location(Bukkit.getWorlds().get(0), 568, 179, 443);
        Location location1 = new Location(Bukkit.getWorlds().get(0), 1584, 153, 513);
        Location location2 = new Location(Bukkit.getWorlds().get(0), 1211, 108, 414);
        Location location3 = new Location(Bukkit.getWorlds().get(0), 406, 117, 538);
        Location location4 = new Location(Bukkit.getWorlds().get(0), 417, 120, 881);
        Location location5 = new Location(Bukkit.getWorlds().get(0), 1371, 160, 450);
        Location location6 = new Location(Bukkit.getWorlds().get(0), 1589, 149, 425);
        Location location7 = new Location(Bukkit.getWorlds().get(0), 1584, 125, 647);
        Location location8 = new Location(Bukkit.getWorlds().get(0), 1557, 129, 1063);
        Location location9 = new Location(Bukkit.getWorlds().get(0), 1529, 200, 1265);
        Location location10 = new Location(Bukkit.getWorlds().get(0), 1488,150,1521);
        Location location11 = new Location(Bukkit.getWorlds().get(0), 1382,108,1566);
        Location location12 = new Location(Bukkit.getWorlds().get(0), 966,168,1556);
        Location location13 = new Location(Bukkit.getWorlds().get(0), 410,200,1386);
        Location location14 = new Location(Bukkit.getWorlds().get(0), 408,141,1187);
        Location location15 = new Location(Bukkit.getWorlds().get(0), 408,119,1105);
        Location location16 = new Location(Bukkit.getWorlds().get(0), 1078,173,456);
        Location location17 = new Location(Bukkit.getWorlds().get(0), 1190,107,428);
        Location location18 = new Location(Bukkit.getWorlds().get(0), 922,158,418);
        Location location19 = new Location(Bukkit.getWorlds().get(0), 500,152,973);
        gameSpawn[0] = location0;
        gameSpawn[1] = location1;
        gameSpawn[2] = location2;
        gameSpawn[3] = location3;
        gameSpawn[4] = location4;
        gameSpawn[5] = location5;
        gameSpawn[6] = location6;
        gameSpawn[7] = location7;
        gameSpawn[8] = location8;
        gameSpawn[9] = location9;
        gameSpawn[10] = location10;
        gameSpawn[11] = location11;
        gameSpawn[12] = location12;
        gameSpawn[13] = location13;
        gameSpawn[14] = location14;
        gameSpawn[15] = location15;
        gameSpawn[16] = location16;
        gameSpawn[17] = location17;
        gameSpawn[18] = location18;
        gameSpawn[19] = location19;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();

        //GAME START
        if(e.getBlock().getDrops().contains(new ItemStack(Material.REDSTONE_TORCH, 1))) {
            e.setCancelled(true);
            Location spawnHere = randomSpawnLocation();
            player.teleport(spawnHere);
            giveAccessories(player);
            player.getInventory().addItem(new ItemStack(Material.COMPASS, 1));
            player.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
            e.getPlayer().setWalkSpeed(0.2f);
            return;
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
            e.setCancelled(true);
        if(Objects.requireNonNull(e.getPlayer().getInventory().contains(MundoRankItem.MundoRankItem))) {
            e.setCancelled(false);
        }
    }

    public Location randomSpawnLocation() {
        double i = Math.random()*100;
        int j = (int) (i/5);
        return gameSpawn[j];
    }

    public void giveAccessories(Player player) {
        player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD, 1));
        int rand = (int) (Math.random() * 100);
        if (rand < 33) {
            player.getInventory().addItem(ResistanceShellItem.ResistanceShell);
        } else if (rand < 66) {
            player.getInventory().addItem(StrengthStickItem.StrengthStick);
        } else {
            player.getInventory().addItem(RegenerationFlowerItem.RegenerationFlower);
        }
        rand = (int) (Math.random() * 100);
        if (rand < 25) {
            player.getInventory().addItem(BridgeBuilderItem.BridgeBuilder);
        } else if (rand < 50) {
            player.getInventory().addItem(CloudInABottleItem.CloudInABottleItem);
        } else if (rand < 75) {
            player.getInventory().addItem(RocketJumpItem.RocketJump);
        } else {
            player.getInventory().addItem(RenewablePearlItem.RenewablePearl);
        }
        rand = (int) (Math.random() * 100);
        if (rand < 25) {
            player.getInventory().addItem(DeeDomeItem.DeeDome);
        } else if (rand < 50) {
            player.getInventory().addItem(StickyIckyItem.StickyIcky);
        } else if (rand < 75) {
            player.getInventory().addItem(WallItem.Wall);
        } else {
            player.getInventory().addItem(ChunkErrorItem.ChunkError);
        }
    }
}
