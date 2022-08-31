package constantctf.constantctf.Commands;

import constantctf.constantctf.ConstantCTF;
import constantctf.constantctf.Events.LeaderBoardEvents;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;


public class LeaderBoardCommand implements CommandExecutor {
    LeaderBoardEvents lbe;
    public Map<String,Integer> playerkills;
    public LeaderBoardCommand(LeaderBoardEvents lbe) {
        this.lbe = lbe;
        playerkills = lbe.playerkills;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        playerkills = lbe.playerkills;
        updateOnlinePlayers(sender);
        ArrayList<String> usedPlayers = new ArrayList<>();

        int top10 = 10;
        if(top10 > playerkills.size()) {
            top10 = playerkills.size();
        }
        for(int j = 0; j < top10; j++) {
            int saveK = 0;
            String saveP = ((Player) sender).getName();
            for (Map.Entry<String, Integer> entry : playerkills.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (value > saveK && !usedPlayers.contains(key)) {
                    saveK = value;
                    saveP = key;
                }
            }
            usedPlayers.add(saveP);
            sender.sendMessage(j+1 + ": " + saveP + " " + saveK +" Stars");
        }

        return true;
    }


    private void updateOnlinePlayers(CommandSender p) {
        Player[] players = p.getServer().getOnlinePlayers().toArray(new Player[0]);

        for(int i = 0; i < players.length; i++) {
            PersistentDataContainer data = players[i].getPersistentDataContainer();
            while(playerkills.containsKey(players[i].getName())) {
                playerkills.remove(players[i].getName());
            }
            if (data.has(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER)) {
                playerkills.put(players[i].getName(), data.get(new NamespacedKey(ConstantCTF.getPlugin(), "Kills"), PersistentDataType.INTEGER));
            } else {
                playerkills.put(players[i].getName(), 0);
            }
        }
    }
}
