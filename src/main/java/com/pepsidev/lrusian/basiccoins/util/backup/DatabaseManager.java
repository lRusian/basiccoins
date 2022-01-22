/*
  # LRUSIAN PLUGIN CREATED AT 22/01/2022 (00h:30m AGT) END (00h:55m AGT)
  # PLUGIN CREATED FOR ALL COMMUNITY FREE CODES FOR ALL
  # CONTACT BY DISCORD: lRussian#8326
 */

package com.pepsidev.lrusian.basiccoins.util.backup;

import java.util.UUID;

import com.pepsidev.lrusian.basiccoins.BasicCoins;

public abstract class DatabaseManager {
	
	protected BasicCoins plugin;

	public DatabaseManager(BasicCoins pl) {
		plugin = pl;
	}

	public abstract boolean createCratesTable();
	
	public abstract void addPlayerToDatabase(UUID playerUUID);
	public abstract int getCoins(UUID playerUUID);

	public abstract int setCoins(int coins, UUID playerUUID);

	public abstract void resetCoinsTotal();


}
