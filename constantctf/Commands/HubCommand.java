package constantctf.constantctf.Commands;

import constantctf.constantctf.Events.SaveLocationOnDC;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {

    SaveLocationOnDC sldc;

    public HubCommand(SaveLocationOnDC sldc) {
        this.sldc = sldc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(((Player) sender).getLocation().getY() > 50) {
                sldc.setSavedItems(player.getUniqueId(), (player).getInventory().getContents());
                sldc.setSavedLocation((player).getUniqueId(), (player).getLocation());
                player.getInventory().setContents(player.getEnderChest().getContents());
            }
            player.teleport(new Location(player.getWorld(), 1097, 100,879, 270, 0));
        }
        return true;
    }
}
