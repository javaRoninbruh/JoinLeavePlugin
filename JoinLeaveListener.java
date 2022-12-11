package me.ronin.ronin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

public class JoinLeaveListener implements Listener {
    private static final String[] messages = {
            "Welcome to the server, %s!",
            "Greetings, %s! You have joined the server.",
            "Hey there, %s! Welcome to the server."
    };

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Generate a random index
        int index = new Random().nextInt(messages.length);

        // Get the message at the random index
        String message = messages[index];

        // Set the join message with the player's name
        event.setJoinMessage(ChatColor.GREEN + String.format(message, player.getName()));
    }
    private static final String[] messages1 = {
            "%s has left the server.",
            "%s has disconnected.",
            "%s has flown the coop."
    };

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        // Generate a random index
        int index = new Random().nextInt(messages1.length);

        // Get the message at the random index
        String message = messages1[index];

        // Set the leave message with the player's name
        event.setQuitMessage(ChatColor.RED + String.format(message, player.getName()));
    }
}