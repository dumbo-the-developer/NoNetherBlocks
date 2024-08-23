package com.meteordevelopments.noNetherBlocks;

import com.meteordevelopments.noNetherBlocks.listeners.BlockListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoNetherBlocks extends JavaPlugin {
    @Getter
    public static NoNetherBlocks plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        saveConfig();
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

}
