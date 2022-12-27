package com.sikepvp.core;

import com.sikepvp.core.listener.JoinListener;
import com.sikepvp.core.ui.MainScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    JoinListener joinListener;

    ConsoleCommandSender console = getServer().getConsoleSender();

    public void onEnable() {
        registerEvents();

        MainScoreboard mainBoard = new MainScoreboard(this, true);

        console.sendMessage("Core plugin working and ready");
    }

    public void onDisable() {

    }

    public Core getInstance() {
        return this;
    }

    private void registerEvents() {
        joinListener = new JoinListener(this);
    }


}
