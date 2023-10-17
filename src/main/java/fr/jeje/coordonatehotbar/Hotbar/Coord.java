package fr.jeje.coordonatehotbar.Hotbar;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import fr.jeje.coordonatehotbar.PlayerLocation;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandExecutor;

/**
 * Implementation of the command /coord
 */
public class Coord implements CommandExecutor {
    private JavaPlugin plugin;

    public Coord(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        // If the sender is not a player, returns incompletion
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        // Location of the player
        PlayerLocation l = new PlayerLocation(p.getLocation());

        // Broadcast location to everyone in the server, including the player's username
        plugin.getServer().broadcastMessage(String.format("%s est en %s", p.getName(), l.toString()));

        return true;
    }
}

