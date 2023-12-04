package me.mikewhilecoding.minecraft_health_sync.handlers;

import me.mikewhilecoding.minecraft_health_sync.MinecraftHealthSync;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageHandler implements Listener {

    public DamageHandler(MinecraftHealthSync plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Bukkit.getLogger().info("Entity has been damaged!" + event.getEntity().getName());
    }

}
