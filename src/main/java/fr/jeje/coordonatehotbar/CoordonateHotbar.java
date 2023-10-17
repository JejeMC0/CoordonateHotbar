package fr.jeje.coordonatehotbar;

import fr.jeje.coordonatehotbar.Hotbar.Coord;
import fr.jeje.coordonatehotbar.Hotbar.ShowCoord;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;



/**
 * Main entry point of the plugin
 */
public class CoordonateHotbar extends JavaPlugin {
    @Override
    public void onDisable() {
        // Ecrit dans fichier JSON
        try {
            LocationMap.DumpToFile();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void onEnable() {
        // Loads from JSON file
        try {
            LocationMap.LoadFromFile();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        // Commands
        this.getCommand("coord").setExecutor(new Coord(this));
        this.getCommand("show-coord").setExecutor(new ShowCoord());
    }
}
