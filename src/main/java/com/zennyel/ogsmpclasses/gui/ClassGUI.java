package com.zennyel.ogsmpclasses.gui;

import com.zennyel.ogsmpclasses.loader.ConfigLoader;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ClassGUI extends AbstractGUI{
    private ConfigLoader configLoader;

    public ClassGUI(JavaPlugin instance, FileConfiguration menuConfiguration) {
        super(instance);
        this.configLoader = new ConfigLoader(menuConfiguration);
        this.setInventory(Bukkit.createInventory(null, 9*3, configLoader.getString("Class_Menu.Title")));
    }

    public void addItems() {
        for (int i = 0; i < getInventory().getSize(); i++) {
            Item(Material.LIGHT_GRAY_STAINED_GLASS_PANE, " ", " ", i);
        }
        getInventory().setItem(10, configLoader.getItemStack("Class_Menu.Druid"));
        getInventory().setItem(12, configLoader.getItemStack("Class_Menu.Rogue"));
        getInventory().setItem(14, configLoader.getItemStack("Class_Menu.Cleric"));
        getInventory().setItem(16, configLoader.getItemStack("Class_Menu.Shogun"));
    }


}