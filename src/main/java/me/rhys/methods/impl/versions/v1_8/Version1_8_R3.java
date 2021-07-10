package me.rhys.methods.impl.versions.v1_8;

import me.rhys.methods.api.abstraction.MethodAbstraction;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftMagicNumbers;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Version1_8_R3 extends MethodAbstraction {

    @Override
    public Material getType(Player player, double x, double y, double z) {
        BlockPosition blockPosition = new BlockPosition(x, y, z);
        return CraftMagicNumbers.getMaterial(((CraftWorld) player.getWorld()).getHandle()
                .getType(blockPosition).getBlock());
    }

    @Override
    public Entity getEntityFromID(World world, int entityID) {
        net.minecraft.server.v1_8_R3.Entity entity = ((CraftWorld) world).getHandle().a(entityID);
        return entity != null ? entity.getBukkitEntity() : null;
    }

    @Override
    public boolean isDead(Player player) {
        return ((CraftPlayer) player).getHandle().dead;
    }

    @Override
    public boolean isSpectator(Player player) {
        return ((CraftPlayer) player).getHandle().isSpectator();
    }

    @Override
    public boolean isSleeping(Player player) {
        return ((CraftPlayer) player).getHandle().sleeping;
    }

    @Override
    public float getFallDistance(Player player) {
        return ((CraftPlayer) player).getHandle().fallDistance;
    }

    @Override
    public List<PotionEffect> getActivePotionEffects(Player player) {
        List<PotionEffect> effects = new ArrayList();

        for (Object obj : ((CraftPlayer) player).getHandle().effects.values()) {
            if (obj instanceof MobEffect) {
                MobEffect handle = (MobEffect) obj;
                effects.add(new PotionEffect(PotionEffectType.getById(handle.getEffectId()), handle.getDuration(),
                        handle.getAmplifier(), handle.isAmbient(), handle.isShowParticles()));
            }
        }

        return effects;
    }

    @Override
    public boolean isChunkLoaded(Player player, int x, int z) {
        WorldServer worldServer = ((CraftWorld) player.getWorld()).getHandle();
        return worldServer.getChunkIfLoaded(x >> 4, z >> 4) != null;
    }

    @Override
    public Block getBlockIfChunkLocation(Player player, Block block) {
        WorldServer worldServer = ((CraftWorld) block.getWorld()).getHandle();
        int x = block.getX();
        int z = block.getZ();
        return worldServer.getChunkIfLoaded(x >> 4, z >> 4) != null ? block : null;
    }

    @Override
    public void sendKeepAlive(Player player, int time) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutKeepAlive(time));
    }

    @Override
    public void sendTransaction(Player player, short action, int windowID, boolean accepted) {
        ((CraftPlayer) player).getHandle().playerConnection
                .sendPacket(new PacketPlayOutTransaction(windowID, action, accepted));
    }

    @Override
    public void sendBlockUpdate(Player player, double x, double y, double z) {
        PacketPlayOutBlockChange packetPlayOutBlockChange =
                new PacketPlayOutBlockChange((((CraftWorld) player.getWorld()).getHandle()),
                        new BlockPosition(x, y, z));
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutBlockChange);
    }
}
