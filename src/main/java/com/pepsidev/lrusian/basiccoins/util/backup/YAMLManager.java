/*
  # LRUSIAN PLUGIN CREATED AT 22/01/2022 (00h:30m AGT) END (00h:55m AGT)
  # PLUGIN CREATED FOR ALL COMMUNITY FREE CODES FOR ALL
  # CONTACT BY DISCORD: lRussian#8326
 */

package com.pepsidev.lrusian.basiccoins.util.backup;

import java.util.Set;
import java.util.UUID;

import com.pepsidev.lrusian.basiccoins.BasicCoins;
import org.bukkit.configuration.file.FileConfiguration;

public class YAMLManager extends DatabaseManager {
	
	private FileConfiguration pFile;

	public YAMLManager(BasicCoins pl) {
		super(pl);
		pFile = plugin.getPlayerDataFile();
	}

	@Override
	public boolean createCratesTable() {
		if(!pFile.contains("balances")) {
			pFile.set("balances.967fa9bc-4e1b-4a38-8f51-49c44edd3919", 99999);
		}
		plugin.savePlayerDataFile();
		return true;
	}

	@Override
	public void addPlayerToDatabase(UUID playerUUID) {
		String uuidStr = playerUUID.toString();
		Set<String> players = pFile.getConfigurationSection("balances").getKeys(false);
		if(!players.contains(uuidStr)) {
			pFile.set("balances." + uuidStr + "", 0);
		}
		plugin.savePlayerDataFile();
	}

	@Override
	public int getCoins(UUID playerUUID) {
		String uuidStr = playerUUID.toString();
		for(String uuidStrings : pFile.getConfigurationSection("balances").getKeys(false)) {
			if(uuidStr.equals(uuidStrings)) {
				return pFile.getInt("balances." + uuidStr + "");
			}
		}
		return 0;
	}

	@Override
	public int setCoins(int cratesToday, UUID playerUUID) {
		String uuidStr = playerUUID.toString();
		pFile.set("balances." + uuidStr + "", cratesToday);
		plugin.savePlayerDataFile();
		return cratesToday;
	}

	@Override
	public void resetCoinsTotal() {
		for(String uuidStrings : pFile.getConfigurationSection("balances").getKeys(false)) {
			pFile.set("balances." + uuidStrings + "", 0);
		}
		plugin.savePlayerDataFile();
	}


}
