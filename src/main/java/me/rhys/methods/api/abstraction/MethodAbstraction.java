package me.rhys.methods.api.abstraction;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public abstract class MethodAbstraction {
    public abstract Material getType(Player player, double x, double y, double z);
    public abstract Entity getEntityFromID(World world, int entityID);
    public abstract boolean isDead(Player player);
    public abstract boolean isSpectator(Player player);
    public abstract boolean isSleeping(Player player);
    public abstract float getFallDistance(Player player);
    public abstract List<PotionEffect> getActivePotionEffects(Player player);
    public abstract boolean isChunkLoaded(Player player, int x, int z);
    public abstract Block getBlockIfChunkLocation(Player player, Block block);
    public abstract void sendKeepAlive(Player player, int time);
    public abstract void sendTransaction(Player player, short action, int windowID, boolean accepted);
    public abstract void sendBlockUpdate(Player player, double x, double y, double z);
}
