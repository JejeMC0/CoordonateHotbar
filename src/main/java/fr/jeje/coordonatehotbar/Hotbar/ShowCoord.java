package fr.jeje.coordonatehotbar.Hotbar;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.jeje.coordonatehotbar.PlayerLocation;
import  fr.jeje.coordonatehotbar.LocationMap;

/**
 * Implementation of the command /show-coord
 */
public class ShowCoord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        // If the sender is not a player, returns incompletion
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        // Get user's HashMap
        HashMap<String, PlayerLocation> coords = LocationMap.getLocation(p.getUniqueId().toString());

        // HashMap is empty: No coordonates have been saved
        if (coords.size() < 1) {
            // Sends message to sender only
            p.sendMessage("Aucune coordonnées sauvegardées");
            // Returns from command with success
            return true;
        }

        // Builds a string with all saved coordonates, seperated by a new line
        StringBuilder sb = new StringBuilder();

        for (String key : coords.keySet()) {
            sb.append(key + " ( " + coords.get(key).toString() + " )\n");
        }

        // Sends built string to sender only
        p.sendMessage(sb.toString());

        return true;
    }
}