package com.sikepvp.core;

import com.sikepvp.core.command.RegionCmd;
import com.sikepvp.core.listener.JoinListener;
import com.sikepvp.core.listener.LocationCheck;
import com.sikepvp.core.ui.MainScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    JoinListener joinListener;
    LocationCheck locationCheck;
    RegionCmd regiondCMD;

    ConsoleCommandSender console = getServer().getConsoleSender();

    public void onEnable() {
        registerEvents();
        registerCommands();

        MainScoreboard mainBoard = new MainScoreboard(this, true);

        console.sendMessage("Core plugin working and ready");
    }

    public void onDisable() {

    }

    public Core getInstance() {
        return this;
    }

    private void registerCommands() {
        regiondCMD = new RegionCmd(this);
    }
    private void registerEvents() {
        joinListener = new JoinListener(this);
        locationCheck = new LocationCheck(this);
    }


}
