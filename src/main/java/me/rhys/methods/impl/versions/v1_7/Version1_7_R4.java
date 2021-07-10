package me.rhys.methods.impl.versions.v1_7;

import me.rhys.methods.api.abstraction.MethodAbstraction;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Version1_7_R4 extends MethodAbstraction {

    @Override
    public Material getType(Player player, double x, double y, double z) {
        return CraftMagicNumbers.getMaterial(((CraftWorld) player.getWorld()).getHandle()
                .getType((int) x, (int) y, (int) z));
    }

    @Override
    public Entity getEntityFromID(World world, int entityID) {
        net.minecraft.server.v1_7_R4.Entity entity = ((CraftWorld) world).getHandle().getEntity(entityID);
        return entity != null ? entity.getBukkitEntity() : null;
    }

    @Override
    public boolean isDead(Player player) {
        return ((CraftPlayer) player).getHandle().dead;
    }

    @Override
    public boolean isSpectator(Player player) {
        return false;
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

                effects.add(new PotionEffect(this.getById(handle.getEffectId()), handle.getDuration(),
                        handle.getAmplifier(), handle.isAmbient()));
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
        PacketPlayOutBlockChange packetPlayOutBlockChange = new PacketPlayOutBlockChange((int) x, (int) y, (int) z,
                ((CraftWorld) player.getWorld()).getHandle());
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutBlockChange);
    }

    PotionEffectType getById(int id) {
        switch (id) {
            case 1: {
                return PotionEffectType.SPEED;
            }

            case 2: {
                return PotionEffectType.SLOW;
            }

            case 3: {
                return PotionEffectType.FAST_DIGGING;
            }

            case 4: {
                return PotionEffectType.SLOW_DIGGING;
            }

            case 5: {
                return PotionEffectType.INCREASE_DAMAGE;
            }

            case 6: {
                return PotionEffectType.HEAL;
            }

            case 7: {
                return PotionEffectType.HARM;
            }

            case 8: {
                return PotionEffectType.JUMP;
            }

            case 9: {
                return PotionEffectType.CONFUSION;
            }

            case 10: {
                return PotionEffectType.REGENERATION;
            }

            case 11: {
                return PotionEffectType.DAMAGE_RESISTANCE;
            }

            case 12: {
                return PotionEffectType.FIRE_RESISTANCE;
            }

            case 13: {
                return PotionEffectType.WATER_BREATHING;
            }

            case 14: {
                return PotionEffectType.INVISIBILITY;
            }

            case 15: {
                return PotionEffectType.BLINDNESS;
            }

            case 16: {
                return PotionEffectType.NIGHT_VISION;
            }

            case 17: {
                return PotionEffectType.HUNGER;
            }

            case 18: {
                return PotionEffectType.WEAKNESS;
            }

            case 19: {
                return PotionEffectType.POISON;
            }

            case 20: {
                return PotionEffectType.WITHER;
            }

            case 21: {
                return PotionEffectType.HEALTH_BOOST;
            }

            case 22: {
                return PotionEffectType.ABSORPTION;
            }

            case 23: {
                return PotionEffectType.SATURATION;
            }
        }

        return null;
    }
}
