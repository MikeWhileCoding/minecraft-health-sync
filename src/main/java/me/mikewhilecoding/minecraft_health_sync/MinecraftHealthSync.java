package me.mikewhilecoding.minecraft_health_sync;

import me.mikewhilecoding.minecraft_health_sync.handlers.DamageHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftHealthSync extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("MinecraftHealthSync has been enabled!");

        // Register event handlers
        new DamageHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("MinecraftHealthSync has been disabled!");
    }
}
