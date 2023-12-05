package me.mikewhilecoding.minecraft_health_sync.storage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;

import java.util.List;

public class SyncPlayers {
    private List<Entity> players;

    public SyncPlayers(List<Entity> players) {
        this.players = players;
    }

    public void addPlayer(Entity player) {
        players.add(player);
        Bukkit.getLogger().info("Added player " + player.getName() + " to the list of players to sync.");
    }

    public void removePlayer(Entity player) {
        players.remove(player);
        Bukkit.getLogger().info("Removed player " + player.getName() + " from the list of players to sync.");
    }

    public void clearPlayers() {
        players.clear();
        Bukkit.getLogger().info("Cleared the list of players to sync.");
    }

    public List<Entity> getPlayers() {
        return players;
    }

    public void damagePlayers(Entity entity, double damage) {
        Bukkit.getLogger().info("Damaging players by " + damage + " HP." + " damage origin: " + entity.getName());
        for (Entity player : players) {
            if (entity != player) {
                Damageable damageable = (Damageable) player;
                damageable.setHealth(damageable.getHealth() - damage);
                Bukkit.getLogger().info("Damaged player " + player.getName() + " by " + damage + " HP.");
            }
        }
    }

    public void regenPlayers(Entity entity, double regen) {
        Bukkit.getLogger().info("Regenerating players by " + regen + " HP." + " regen origin: " + entity.getName());
        for (Entity player : players) {
            if (entity != player) {
                Damageable damageable = (Damageable) player;
                if (damageable.getHealth() + regen > damageable.getMaxHealth()) {
                    regen = damageable.getMaxHealth() - damageable.getHealth();
                }
                damageable.setHealth(damageable.getHealth() + regen);
                Bukkit.getLogger().info("Regenerated player " + player.getName() + " by " + regen + " HP.");
            }
        }
    }

}
