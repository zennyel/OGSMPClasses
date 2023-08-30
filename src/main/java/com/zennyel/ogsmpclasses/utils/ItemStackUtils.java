package com.zennyel.ogsmpclasses.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackUtils {

    public static ItemStack createItemStack(Material material, String displayName, String description) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        List<String> lore = new ArrayList<>();
        lore.add(description);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createItemStack(Material material, String displayName, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getItemFromConfiguration(String configPath, FileConfiguration configuration) {
        if (!configuration.contains(configPath)) {
            return null;
        }

        String materialName = configuration.getString(configPath + ".material");
        Material material = Material.matchMaterial(materialName);

        if (material == null) {
            return null;
        }

        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        String displayName = ChatColor.translateAlternateColorCodes('&', configuration.getString(configPath + ".displayName"));itemMeta.setDisplayName(displayName);

        List<String> loreList = configuration.getStringList(configPath + ".lore");
        List<String> formattedLore = new ArrayList<>();

        for (String lore : loreList) {
            formattedLore.add(ChatColor.translateAlternateColorCodes('&', lore));
        }

        itemMeta.setLore(formattedLore);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}
