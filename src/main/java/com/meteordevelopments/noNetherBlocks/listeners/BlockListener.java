package com.meteordevelopments.noNetherBlocks.listeners;

import com.bgsoftware.superiorskyblock.api.SuperiorSkyblockAPI;
import com.bgsoftware.superiorskyblock.api.island.Island;
import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import com.meteordevelopments.noNetherBlocks.NoNetherBlocks;
import com.meteordevelopments.noNetherBlocks.utils.ColorUtility;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class BlockListener implements Listener {

    NoNetherBlocks plugin = NoNetherBlocks.getPlugin();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        SuperiorPlayer splayer = SuperiorSkyblockAPI.getPlayer(player);
        List<String> restrictedBlocks = plugin.getConfig().getStringList("nether-restricted-blocks");
        Material placedBlocks = event.getBlock().getType();
        if (restrictedBlocks.contains(placedBlocks.toString().toUpperCase())) {
            if (splayer != null) {
                Island island = splayer.getIsland();
                if (splayer.isInsideIsland() && island != null) {
                    if (!island.isNetherEnabled()) {
                        event.setCancelled(true);
                        player.sendMessage(ColorUtility.translate(plugin.getConfig().getString("not-unlocked-message")));
                    }
                }
            }

        }
    }
}
