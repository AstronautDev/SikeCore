package com.sikepvp.core.listener;

import com.sikepvp.core.Core;
import com.sikepvp.core.ui.MainScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    Core core;
    public JoinListener(Core core) {
        this.core = core;
        core.getServer().getPluginManager().registerEvents(this, core);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        MainScoreboard.createBoard(p);
    }

}
