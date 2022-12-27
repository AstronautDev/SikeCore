package com.sikepvp.core.ui;

import com.sikepvp.core.Core;
import com.sikepvp.mafia.utility.Cash;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MainScoreboard {

    private static String title;
    Core core;
    private static String pinSym = "⊙";

    public MainScoreboard(Core core, boolean update) {
        this.core = core;

        setTitle("SikePvP");
        if(update) {
            updateScoreboards();
        } else {
            return;
        }
    }

    public static void createBoard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("uiBoard", "dummy", title);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Date inputDate = new Date();
        LocalDate date = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String day = date.getDayOfWeek().toString();

        Score dateScore = obj.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + day);
        dateScore.setScore(15);
        Score playerScore = obj.getScore(ChatColor.DARK_AQUA + p.getName());
        playerScore.setScore(14);
        Score buffer1 = obj.getScore("");
        buffer1.setScore(13);
        Score locScore = obj.getScore(ChatColor.GREEN + pinSym + " CURRENT LOC");
        locScore.setScore(12);
        Score buffer2 = obj.getScore(" ");
        buffer2.setScore(11);
        Score infHeadScore = obj.getScore(ChatColor.BOLD + "Influence");
        infHeadScore.setScore(10);
        Score influenceScore = obj.getScore(ChatColor.LIGHT_PURPLE + "0000");
        influenceScore.setScore(9);
        Score buffer3 = obj.getScore("  ");
        buffer3.setScore(8);
        Score moneyHeadScore = obj.getScore(ChatColor.BOLD + "Money");
        moneyHeadScore.setScore(7);
        Score moneyScore;
        if(Cash.hasCash(p.getUniqueId())) {
            moneyScore = obj.getScore(ChatColor.RED + "$" + Cash.getCash(p.getUniqueId()));
        } else {
            moneyScore = obj.getScore(ChatColor.RED + "NO ACCOUNT");
        }
        moneyScore.setScore(6);
        Score buffer4 = obj.getScore("   ");
        buffer4.setScore(5);
        Score objHeadScore = obj.getScore(ChatColor.BOLD + "Objective");
        objHeadScore.setScore(4);
        Score objScore = obj.getScore(ChatColor.YELLOW + "Current Objective");
        objScore.setScore(3);
        Score buffer5 = obj.getScore("    ");
        buffer5.setScore(2);
        Score websiteScore = obj.getScore(ChatColor.YELLOW + "www.sikepvp.com");
        websiteScore.setScore(1);
        p.setScoreboard(board);
    }

    private void updateScoreboards() {
        new BukkitRunnable() {
            public void run () {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    createBoard(p);
                }
            }
        }.runTaskTimer(core, 60L, 20L);
    }

    public void setTitle(String boardTitle) {
        title = ChatColor.translateAlternateColorCodes('&', boardTitle);
    }

    public String getTitle() {
        return title;
    }

}
