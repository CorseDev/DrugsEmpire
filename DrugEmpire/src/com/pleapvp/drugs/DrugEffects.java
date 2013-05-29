package com.pleapvp.drugs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrugEffects extends JavaPlugin implements Listener {
	@EventHandler
	public void EatDrug(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (player.getItemInHand().getType() == Material.WHEAT) {
				if (player.hasPotionEffect(PotionEffectType.CONFUSION)) {
					player.sendMessage(ChatColor.GRAY
							+ "Dude, you're already high. Let's wait it out man.");
				} else {
					int amount = player.getItemInHand().getAmount();
					player.getItemInHand().setAmount(amount - 1);
					if (amount == 1) {
						player.setItemInHand(null);
					}
				}
				player.addPotionEffect(new PotionEffect(
						PotionEffectType.HUNGER, 100, 4));
				player.addPotionEffect(new PotionEffect(
						PotionEffectType.CONFUSION, 400, 4));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
						400, 4));
				player.sendMessage(ChatColor.GRAY
						+ "Just a little hit... woah, man... woah.");
			}
		}
	}

}