/*
  # LRUSIAN PLUGIN CREATED AT 22/01/2022 (00h:30m AGT) END (00h:55m AGT)
  # PLUGIN CREATED FOR ALL COMMUNITY FREE CODES FOR ALL
  # CONTACT BY DISCORD: Vuhp#6969
 */

package com.pepsidev.lrusian.basiccoins;

import com.pepsidev.lrusian.basiccoins.command.CoinsCommand;
import com.pepsidev.lrusian.basiccoins.listener.PlayerListener;
import com.pepsidev.lrusian.basiccoins.util.FileConfig;
import com.pepsidev.lrusian.basiccoins.util.backup.DatabaseManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

@Getter
public final class BasicCoins extends JavaPlugin {

    FileConfiguration playerDataFileConfig = new YamlConfiguration();
    File playerDataFile;
    FileConfig dataConfig;
    DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        createFiles();

        Bukkit.getConsoleSender().sendMessage("PLUGIN CREATED BY: LRUSIAN");
        Bukkit.getConsoleSender().sendMessage("DAY/TIME CREATED: 22/01/2022 at 00:30 end: 00:55");

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        this.getCommand("coins").setExecutor(new CoinsCommand());
    }

    @Override
    public void onDisable() {

    }

    public DatabaseManager getMySQLManager() {
        return databaseManager;
    }

    public FileConfiguration getPlayerDataFile() {
        return playerDataFileConfig;
    }

    public void savePlayerDataFile(){
        try {
            playerDataFileConfig.save(playerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("Failed to save base.yml!");
        }
    }

    private void createFiles() {
        this.dataConfig = new FileConfig(this, "data.yml");

        playerDataFile = new File(getDataFolder(), "data.yml");

        saveRes(playerDataFile, "data.yml");

        playerDataFileConfig = new YamlConfiguration();
        try {
            playerDataFileConfig.load(playerDataFile);
        }catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveRes(File file, String name) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource(name, false);
        }
    }

    public static BasicCoins get() {
        return BasicCoins.getPlugin(BasicCoins.class);
    }

}
