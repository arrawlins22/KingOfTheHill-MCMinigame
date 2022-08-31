package constantctf.constantctf;

import constantctf.constantctf.Commands.HubCommand;
import constantctf.constantctf.Commands.LeaderBoardCommand;
import constantctf.constantctf.Commands.OpManCommand;
import constantctf.constantctf.CustomItems.Accessories.*;
import constantctf.constantctf.CustomItems.RankItems.BaseRankItem;
import constantctf.constantctf.CustomItems.RankItems.MundoRankItem;
import constantctf.constantctf.Events.*;
import constantctf.constantctf.Events.AccesoryEvents.*;
import constantctf.constantctf.Events.KillStreakEvents.KillStreakItemEvents;
import constantctf.constantctf.Events.KillStreakEvents.NetherStarBuffs;
import constantctf.constantctf.Events.RankManagingEvents.ImportantItemDropEvent;
import constantctf.constantctf.Events.RankManagingEvents.NoBlockBreakingEvent;
import constantctf.constantctf.Events.RankManagingEvents.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class ConstantCTF extends JavaPlugin {

    private static Plugin plugin;
    SaveLocationOnDC sldc;
    LeaderBoardEvents lbe;
    ChemTrailSelectionEvent ctse;

    @Override
    public void onEnable() {
        plugin = this;
        sldc = new SaveLocationOnDC();
        lbe = new LeaderBoardEvents();
        ctse = new ChemTrailSelectionEvent();
        eventInit();
        itemInit();
        this.saveDefaultConfig();
        commandInit();

    }

    @Override
    public void onDisable() {
        Bukkit.getServer().broadcastMessage("LOL");
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public void eventInit() {
        getServer().getPluginManager().registerEvents(new CloudInABottleEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new NoBlockBreakingEvent(), this);
        getServer().getPluginManager().registerEvents(new ImportantItemDropEvent(), this);
        getServer().getPluginManager().registerEvents(new LobbyTorchBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new RenewablePearlEvent(), this);
        getServer().getPluginManager().registerEvents(new NoFallDamageEvent(ctse), this);
        getServer().getPluginManager().registerEvents(new ChestEvents(), this);
        getServer().getPluginManager().registerEvents(new BridgeBuilderEvent(), this);
        getServer().getPluginManager().registerEvents(new DeeDomeEvent(), this);
        getServer().getPluginManager().registerEvents(new StickyIckyEvent(), this);
        getServer().getPluginManager().registerEvents(new WallEvent(), this);
        getServer().getPluginManager().registerEvents(new HandleDeathEvent(sldc), this);
        getServer().getPluginManager().registerEvents(new WolfCaptureEvents(ctse), this);
        getServer().getPluginManager().registerEvents(new NetherStarBuffs(), this);
        getServer().getPluginManager().registerEvents(new KillStreakItemEvents(), this);
        getServer().getPluginManager().registerEvents(new WallEvent(), this);
        getServer().getPluginManager().registerEvents(new CombatAccesoryEvents(), this);
        getServer().getPluginManager().registerEvents(new MobSpawningEvents(), this);
        getServer().getPluginManager().registerEvents(new WorldFallingEvent(), this);
        getServer().getPluginManager().registerEvents(new RocketJumpEvent(), this);
        getServer().getPluginManager().registerEvents(new ChunckErrorEvent(), this);
        getServer().getPluginManager().registerEvents(lbe, this);
        getServer().getPluginManager().registerEvents(sldc, this);
        getServer().getPluginManager().registerEvents(ctse, this);
    }
    public void itemInit() {
        BridgeBuilderItem.init();
        CloudInABottleItem.init();
        RenewablePearlItem.init();
        RocketJumpItem.init();
        BaseRankItem.init();
        MundoRankItem.init();
        DeeDomeItem.init();
        StickyIckyItem.init();
        WallItem.init();
        RegenerationFlowerItem.init();
        StrengthStickItem.init();
        ResistanceShellItem.init();
        ChunkErrorItem.init();
    }
    public void commandInit() {
        this.getCommand("hub").setExecutor(new HubCommand(sldc));
        this.getCommand("stone").setExecutor(new OpManCommand());
        this.getCommand("leaderboard").setExecutor(new LeaderBoardCommand(lbe));
    }

    public SaveLocationOnDC getSldc() {
        return sldc;
    }
    public LeaderBoardEvents getLbe() {
        return lbe;
    }
}
