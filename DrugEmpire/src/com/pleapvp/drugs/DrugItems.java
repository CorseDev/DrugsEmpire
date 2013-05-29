package com.pleapvp.drugs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class DrugItems extends JavaPlugin implements Listener {
	@EventHandler
	public void preCraft(PlayerPickupItemEvent event) {
		if (event.getItem().getItemStack().getType() == Material.WHEAT) {
			ItemStack deliveryItem = event.getItem().getItemStack();
			ItemMeta itemMeta = event.getItem().getItemStack().getItemMeta();
			itemMeta.setDisplayName(ChatColor.GREEN + "§lMarijuana");
			deliveryItem.setItemMeta(itemMeta);
		}
	}
}
