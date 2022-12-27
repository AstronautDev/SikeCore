package com.sikepvp.core.command;

import com.sikepvp.core.Core;
import com.sikepvp.core.listener.LocationCheck;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegionCmd implements CommandExecutor {

    Core core;
    public RegionCmd(Core core) {
        this.core = core;

        core.getCommand("region").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(cmd.getLabel().equalsIgnoreCase("region")) {
                if(args.length == 1) {
                    String regionName = args[0];
                    LocationCheck.regionList.put(regionName, p.getLocation());
                    p.sendMessage("Added region '" + regionName + "'" + " at location.");
                    return true;
                }
            }

        }

        return false;
    }
}
