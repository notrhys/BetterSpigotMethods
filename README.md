# BetterSpigotMethods
Faster spigot player methods

## What is this?

This API provides faster methods of getting specific information from the spigot API.

## Examples

Setting up the API:

```Java

    @Override
    public void onEnable() {
        // first we need to register the API
        new BetterMethods().register();

        // register our other stuffs
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
    }
```

Getting the block type without calling 'block.getType()'

```Java
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        // get the block below the player
        Block blockBelow = event.getTo().clone().add(0, -1, 0).getBlock();

        if (blockBelow != null) {
            // normally you would use blockBelow.getType() but to reduce the time we will use the BetterMethods API
            Material material = BetterMethodAPI.getType(event.getPlayer(), blockBelow);

            // debug
            event.getPlayer().sendMessage("Material: " + material.name());
        }
    }
```

## Method List

```Java
    // get the type of a specific block
    public static Material getType(Player player, Block block) {
        return getType(player, block.getX(), block.getY(), block.getZ());
    }

    // get the type of a block at a specific location
    public static Material getType(Player player, double x, double y, double z) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getType(player, x, y, z);
    }

    // get an entity from it's ID
    public static Entity getEntityFromID(World world, int entityID) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getEntityFromID(world, entityID);
    }

    // check if the player is dead
    public static boolean isDead(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isDead(player);
    }

    // check if the player is in spectator
    public static boolean isSpectator(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isSpectator(player);
    }

    // check if the player sleeping
    public static boolean isSleeping(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isSleeping(player);
    }

    // get the fall-distance of the player
    public static float getFallDistance(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getFallDistance(player);
    }

    // get the active potion effects of the player
    public static List<PotionEffect> getActivePotionEffects(Player player) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getActivePotionEffects(player);
    }

    // check if the chunk is loaded and X & Z
    public static boolean isChunkLoaded(Player player, int x, int z) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().isChunkLoaded(player, x, z);
    }

    // return the block if its chunk is loaded
    public static Block getBlockIfChunkLocation(Player player, Block block) {
        return BetterMethods.getInstance().getManager().getMethodAbstraction().getBlockIfChunkLocation(player, block);
    }
    
    // more more anti-cheat devs
    
    // send a keep-alive (C00) to the client
    public static void sendKeepAlive(Player player, int time) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendKeepAlive(player, time);
    }

    // send a transaction (C0F) the client
    public static void sendTransaction(Player player, short action, int windowID, boolean accepted) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendTransaction(player,action,
                windowID, accepted);
    }

    // send the client a block update at a specific x, y, z
    public static void sendBlockUpdate(Player player, double x, double y, double z) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendBlockUpdate(player, x, y, z);
    }

    // send the client a block update at a specific block
    public static void sendBlockUpdate(Player player, Block block) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendBlockUpdate(player, block.getX(),
                block.getY(), block.getZ());
    }

    // send the client a block update at a specific location
    public static void sendBlockUpdate(Player player, Location location) {
        BetterMethods.getInstance().getManager().getMethodAbstraction().sendBlockUpdate(player, location.getX(),
                location.getY(), location.getZ());
    }
```
