package me.mikewhilecoding.minecraft_health_sync;

import me.mikewhilecoding.minecraft_health_sync.handlers.DamageHandler;
import me.mikewhilecoding.minecraft_health_sync.handlers.PlayerHandler;
import me.mikewhilecoding.minecraft_health_sync.storage.SyncPlayers;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class MinecraftHealthSync extends JavaPlugin {

    private SyncPlayers syncPlayers;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("MinecraftHealthSync has been enabled!");

        // Initialize storage
        this.syncPlayers = new SyncPlayers(new ArrayList<>());

        // Register event handlers
        new DamageHandler(this, syncPlayers);
        new PlayerHandler(this, syncPlayers);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.syncPlayers.clearPlayers();
        Bukkit.getLogger().info("MinecraftHealthSync has been disabled!");
    }
}
