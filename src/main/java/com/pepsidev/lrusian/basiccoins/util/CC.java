/*
  # LRUSIAN PLUGIN CREATED AT 22/01/2022 (00h:30m AGT) END (00h:55m AGT)
  # PLUGIN CREATED FOR ALL COMMUNITY FREE CODES FOR ALL
  # CONTACT BY DISCORD: lRussian#8326
 */

package com.pepsidev.lrusian.basiccoins.util;

import net.md_5.bungee.api.ChatColor;
import java.util.List;
import java.util.stream.Collectors;

public class CC {

    public static String translate(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(CC::translate).collect(Collectors.toList());
    }



}
