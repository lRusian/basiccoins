/*
  # LRUSIAN PLUGIN CREATED AT 22/01/2022 (00h:30m AGT) END (00h:55m AGT)
  # PLUGIN CREATED FOR ALL COMMUNITY FREE CODES FOR ALL
  # CONTACT BY DISCORD: lRussian#8326
 */

package com.pepsidev.lrusian.basiccoins.listener;

import com.pepsidev.lrusian.basiccoins.BasicCoins;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        BasicCoins.get().getMySQLManager().addPlayerToDatabase(player.getUniqueId());
    }

}
