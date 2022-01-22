/*
  # LRUSIAN PLUGIN CREATED AT 22/01/2022 (00h:30m AGT) END (00h:55m AGT)
  # PLUGIN CREATED FOR ALL COMMUNITY FREE CODES FOR ALL
  # CONTACT BY DISCORD: lRussian#8326
 */

package com.pepsidev.lrusian.basiccoins.command;

import com.google.common.primitives.Ints;
import com.pepsidev.lrusian.basiccoins.BasicCoins;
import com.pepsidev.lrusian.basiccoins.util.CC;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class CoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return false;
        Player p = (Player)sender;
        if(args.length == 0){
            int coins = BasicCoins.get().getDatabaseManager().getCoins(p.getUniqueId());

            for (String string : BasicCoins.get().getConfig().getStringList("COINS.VIEW")) {
                p.sendMessage(CC.translate(string
                        .replace("<player_balance>", String.valueOf(coins))
                        .replace("<player_name>", p.getName())));
            }
            return false;
        }

        if(args[0].equalsIgnoreCase("reset")){
            BasicCoins.get().getDatabaseManager().resetCoinsTotal();

            for (String msg : BasicCoins.get().getConfig().getStringList("COINS.RESET")) {
                p.sendMessage(CC.translate(msg
                        .replace("<player_name>", p.getName())
                ));
            }
        }

        if(args[0].equalsIgnoreCase("set")) {
            if (Bukkit.getPlayer(args[1]) == null) {
                sender.sendMessage(CC.translate("&cA player with that name was not found."));
                return true;
            }

            if (Ints.tryParse(args[2]) == null) {
                sender.sendMessage(CC.translate("&cThe number you entered is invalid."));
                return true;
            }

            Player target = Bukkit.getPlayer(args[1]);
            int amount = Ints.tryParse(args[2]);

            int coinstotal = BasicCoins.get().getDatabaseManager().getCoins(p.getUniqueId());

            int coins_target = BasicCoins.get().getDatabaseManager().setCoins(amount, target.getUniqueId());

            for (String msg : BasicCoins.get().getConfig().getStringList("COINS.SET.PLAYER")) {
                p.sendMessage(CC.translate(msg
                        .replace("<target_name>", target.getName())
                        .replace("<amount>", String.valueOf(amount))
                        .replace("<target_balance>", String.valueOf(coinstotal))
                        .replace("<target_setbalance>", String.valueOf(coins_target))
                        .replace("<player_name>", p.getName())
                ));
            }

        }


        if(args[0].equalsIgnoreCase("give")){
            if (Bukkit.getPlayer(args[1]) == null) {
                sender.sendMessage(CC.translate("&cA player with that name was not found."));
                return true;
            }

            if (Ints.tryParse(args[2]) == null) {
                sender.sendMessage(CC.translate("&cThe number you entered is invalid."));
                return true;
            }

            Player target = Bukkit.getPlayer(args[1]);
            int amount = Ints.tryParse(args[2]);

            int coinstotal = BasicCoins.get().getDatabaseManager().getCoins(p.getUniqueId());


                int coins_target = BasicCoins.get().getDatabaseManager().setCoins(coinstotal + amount, target.getUniqueId());

                for (String msg : BasicCoins.get().getConfig().getStringList("COINS.GIVE.PLAYER")) {
                    p.sendMessage(CC.translate(msg
                            .replace("<target_name>", target.getName())
                            .replace("<amount>", String.valueOf(amount))
                            .replace("<target_balance>", String.valueOf(coinstotal))
                            .replace("<target_setbalance>", String.valueOf(coins_target))
                            .replace("<player_name>", p.getName())
                    ));
                }

        }

        if(args[0].equalsIgnoreCase("remove")){

            if (Bukkit.getPlayer(args[1]) == null) {
                sender.sendMessage(CC.translate("&cA player with that name was not found."));
                return true;
            }

            Player target = Bukkit.getPlayer(args[1]);

            int coinstotal = BasicCoins.get().getDatabaseManager().getCoins(p.getUniqueId());

            BasicCoins.get().getDatabaseManager().setCoins(0, target.getUniqueId());

            for (String msg : BasicCoins.get().getConfig().getStringList("COINS.REMOVE.PLAYER")) {
                p.sendMessage(CC.translate(msg
                        .replace("<target_name>", target.getName())
                        .replace("<target_balance>", String.valueOf(coinstotal))
                        .replace("<player_name>", p.getName())
                ));
            }
        }
        return false;
    }

}