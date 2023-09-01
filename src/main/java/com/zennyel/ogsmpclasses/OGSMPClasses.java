package com.zennyel.ogsmpclasses;

import com.zennyel.ogsmpclasses.manager.ClassManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class OGSMPClasses extends JavaPlugin {

    private long startTime;

    private ClassManager cache;

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public void init(){
        startTime = System.currentTimeMillis();
        getLogger().info("Start loading...");
        this.cache = new ClassManager(this);






        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
        getLogger().info("Loading completed, took " + loadTime + "ms!");
    }

    public void shutdown(){

    }

    public void registerCommands(){

    }

    public void registerEvents(){}




}
