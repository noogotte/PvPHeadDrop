package fr.noogotte.pvpheaddrop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PvPHeadDrop extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PvPListener(this), this);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }

    public int getRate() {
        return getConfig().getInt("rate");
    }
}
