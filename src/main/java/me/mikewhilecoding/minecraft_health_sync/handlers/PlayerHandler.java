package me.mikewhilecoding.minecraft_health_sync.handlers;

import me.mikewhilecoding.minecraft_health_sync.MinecraftHealthSync;
import me.mikewhilecoding.minecraft_health_sync.storage.SyncPlayers;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerHandler implements Listener {

    private SyncPlayers syncPlayers;

    public PlayerHandler(MinecraftHealthSync plugin, SyncPlayers syncPlayers) {
        this.syncPlayers = syncPlayers;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        syncPlayers.addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        syncPlayers.removePlayer(event.getPlayer());
    }

}
