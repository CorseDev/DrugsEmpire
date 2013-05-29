package com.pleapvp.drugs;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new JoinMessage(), this);
		getServer().getPluginManager().registerEvents(new LeaveMessage(), this);
		// getServer().getPluginManager().registerEvents(new Nametag(), this);
		getServer().getPluginManager().registerEvents(new DrugItems(), this);
		getServer().getPluginManager().registerEvents(new DrugEffects(), this);
		getServer().getPluginManager().registerEvents(new DrugDetector(), this);
	}

	@Override
	public void onDisable() {

	}
}
