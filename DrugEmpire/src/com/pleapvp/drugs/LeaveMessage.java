package com.pleapvp.drugs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class LeaveMessage extends JavaPlugin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);

		event.setQuitMessage(player.getName()
				+ user.getPrefix().replaceAll("&", "§") + ChatColor.GRAY
				+ " left the game.");
	}
}
