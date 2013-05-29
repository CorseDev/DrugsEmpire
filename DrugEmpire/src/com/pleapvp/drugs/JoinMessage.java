package com.pleapvp.drugs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinMessage extends JavaPlugin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);

		event.setJoinMessage(player.getName()
				+ user.getPrefix().replaceAll("&", "§") + ChatColor.GRAY
				+ " joined the game.");
	}
}
