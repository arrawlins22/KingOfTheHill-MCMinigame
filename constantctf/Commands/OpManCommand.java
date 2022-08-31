package constantctf.constantctf.Commands;

import constantctf.constantctf.CustomItems.RankItems.MundoRankItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpManCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(((Player) sender).isOp()) {
                player.getInventory().addItem(MundoRankItem.MundoRankItem);
            } else {
                sender.sendMessage("you too much of a bitch for that");
            }
        }
        return true;
    }
}