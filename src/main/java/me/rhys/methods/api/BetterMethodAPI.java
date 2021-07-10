package me.rhys.methods.api;

import me.rhys.methods.BetterMethods;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public class BetterMethodAPI {

    public static Material getType(Player player, Block block) {
        return getType(player, block.getX(), block.getY(), block.getZ());
    }

    public static Material getType(Player player, double x, double y, double z) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getType(player, x, y, z);
    }

    public static Entity getEntityFromID(World world, int entityID) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getEntityFromID(world, entityID);
    }

    public static boolean isDead(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isDead(player);
    }

    public static boolean isSpectator(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isSpectator(player);
    }

    public static boolean isSleeping(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isSleeping(player);
    }

    public static float getFallDistance(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getFallDistance(player);
    }

    public static List<PotionEffect> getActivePotionEffects(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getActivePotionEffects(player);
    }

    public static boolean isChunkLoaded(Player player, int x, int z) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isChunkLoaded(player, x, z);
    }

    public static Block getBlockIfChunkLocation(Player player, Block block) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getBlockIfChunkLocation(player, block);
    }

    public static void sendKeepAlive(Player player, int time) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendKeepAlive(player, time);
    }

    public static void sendTransaction(Player player, short action, int windowID, boolean accepted) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendTransaction(player,action,
                windowID, accepted);
    }

    public static void sendBlockUpdate(Player player, double x, double y, double z) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendBlockUpdate(player, x, y, z);
    }

    public static void sendBlockUpdate(Player player, Block block) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendBlockUpdate(player, block.getX(),
                block.getY(), block.getZ());
    }

    public static void sendBlockUpdate(Player player, Location location) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendBlockUpdate(player, location.getX(),
                location.getY(), location.getZ());
    }
}
