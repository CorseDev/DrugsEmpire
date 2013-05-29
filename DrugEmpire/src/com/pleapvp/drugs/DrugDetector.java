package com.pleapvp.drugs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class DrugDetector extends JavaPlugin implements Listener {
	private HashMap<String, Date> cooldowns = new HashMap<String, Date>();
	
	@EventHandler
	public void DrugDetect(PlayerInteractEntityEvent event) {

		Entity citizen = event.getRightClicked();
		Player cop = event.getPlayer();

		if (cop.hasPermission("drugdetector.check")) {
			if (citizen instanceof Player == true) {
				Player clicked = (Player) citizen;
				if (cop.getItemInHand().getType() == Material.STICK) {
					if(cooldowns.containsKey(cop.getName())&&cooldowns.get(cop.getName()).getTime()>new Date().getTime()) {
						cop.sendMessage(ChatColor.GOLD + "You must wait 10 seconds between using the DrugStick!");
					} else if (clicked.getInventory().contains(Material.WHEAT)
							|| clicked
									.hasPotionEffect(PotionEffectType.CONFUSION)) {
						Bukkit.getServer().broadcastMessage(
								ChatColor.RED + "BUSTED! " + ChatColor.GOLD
										+ clicked.getName()
										+ " was caught with " + ChatColor.GREEN
										+ " Marijuana" + ChatColor.GOLD
										+ " by " + cop.getName() + "!");
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"jail " + clicked.getName().toString()
										+ " jail 8m");
						clicked.getInventory().remove(Material.WHEAT);
						cooldowns.put(cop.getName(), new Date(new Date().getTime() + 10000));
					} else {
						Bukkit.getServer()
								.broadcastMessage(
										ChatColor.DARK_BLUE
												+ "CLEAN! "
												+ ChatColor.GOLD
												+ clicked.getName()
												+ " was checked for drugs, but didn't have any.");
						cooldowns.put(cop.getName(), new Date(new Date().getTime() + 10000));

						if (clicked.getInventory().contains(Material.COCOA)) {
							Bukkit.getServer().broadcastMessage(
									ChatColor.RED + "BUSTED! " + ChatColor.GOLD
											+ clicked.getName()
											+ " was caught with "
											+ ChatColor.RED + "Heroin"
											+ ChatColor.GOLD + " by "
											+ cop.getName() + "!");
							Bukkit.getServer().dispatchCommand(
									getServer().getConsoleSender(),
									"jail " + clicked.getName().toString()
											+ " jail 15m");
							cooldowns.put(cop.getName(), new Date(new Date().getTime() + 10000));
							clicked.getInventory().remove(Material.COCOA);
						} else {
							clicked.sendMessage(ChatColor.DARK_BLUE
									+ "CLEAN! "
									+ ChatColor.GOLD
									+ cop.getName()
									+ " checked you for drugs, but didn't find any.");
							Bukkit.getServer()
									.broadcastMessage(
											ChatColor.DARK_BLUE
													+ "CLEAN! "
													+ ChatColor.GOLD
													+ clicked.getName()
													+ " was checked for drugs, but didn't have any.");
							cooldowns.put(cop.getName(), new Date(new Date().getTime() + 10000));
						}
					}
				}
			}
		}
	}
}