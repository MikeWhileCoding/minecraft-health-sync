package me.mikewhilecoding.minecraft_health_sync.handlers;

import me.mikewhilecoding.minecraft_health_sync.MinecraftHealthSync;
import me.mikewhilecoding.minecraft_health_sync.storage.SyncPlayers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class DamageHandler implements Listener {

    private SyncPlayers syncPlayers;
    public DamageHandler(MinecraftHealthSync plugin, SyncPlayers syncPlayers) {
        this.syncPlayers = syncPlayers;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Bukkit.getLogger().info("Entity has been damaged!" + event.getEntity().getName());

        for (Entity player : syncPlayers.getPlayers()) {
            if (event.getEntity() == player) {
                syncPlayers.damagePlayers(event.getEntity(), event.getDamage());
                Bukkit.getLogger().info("Entity " + event.getEntity().getName() + " is a synced player!");
            }
        }
    }

    @EventHandler
    public void onRegen(EntityRegainHealthEvent event) {
        Bukkit.getLogger().info("Entity has regained! " + event.getAmount() + " HP " + event.getEntity().getName());

        for (Entity player : syncPlayers.getPlayers()) {
            if (event.getEntity() == player) {
                syncPlayers.regenPlayers(event.getEntity(), event.getAmount());
                Bukkit.getLogger().info("Entity " + event.getEntity().getName() + " is a synced player!");
            }
        }
    }

}
