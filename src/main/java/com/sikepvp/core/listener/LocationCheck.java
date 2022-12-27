package com.sikepvp.core.listener;

import com.sikepvp.core.Core;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class LocationCheck implements Listener {

    public static HashMap<String, Location> regionList = new HashMap<>();
    public static HashMap<Player, String> currentRegion = new HashMap<>();

    Core core;
    public LocationCheck(Core core) {
        this.core = core;

        core.getServer().getPluginManager().registerEvents(this, core);
    }

    private static void checkRegions(Player player) {
        for(Map.Entry<String, Location> entry : regionList.entrySet()) {
            String regionName = entry.getKey();
            Location regionLoc = entry.getValue();

            if(regionLoc.distanceSquared(player.getLocation()) < 10000) {
                currentRegion.put(player, regionName);
            } else {
                currentRegion.remove(player);
            }
        }
    }

    public static String getRegion(Player player) {
        if(currentRegion.containsKey(player)) {
            return currentRegion.get(player);
        } else {
            return null;
        }
    }

    public static boolean isInRegion(Player player) {
        checkRegions(player);
        if(currentRegion.containsKey(player)) {
            return true;
        } else {
            return false;
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
    }

}
