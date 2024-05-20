package me.dev.klarcky.main;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.dev.klarcky.main.player.Lixeira;
import me.dev.klarcky.main.player.Tpa;
import me.dev.klarcky.main.playervip.Bigorna;
import me.dev.klarcky.main.playervip.Enderchest;
import me.dev.klarcky.main.playervip.Fly;
import me.dev.klarcky.main.playervip.Food;
import me.dev.klarcky.main.playervip.Hat;
import me.dev.klarcky.main.playervip.Table;
import me.dev.klarcky.main.staff.GameMode;
import me.dev.klarcky.main.staff.God;

public class Main extends JavaPlugin{
	
	public void onEnable() {
		ConsoleCommandSender m = Bukkit.getConsoleSender();
		m.sendMessage("§f[§cMrz§8Core§f]§bAtivo com sucesso!!!");
		m.sendMessage("§f[§cMrz§8Core§f]§bFeito por MuriloMoraz");
		registro();
		comandos();
	}
	
	private void registro() {
		// TODO Auto-generated method stub
		
	}

	private void comandos() {
		getCommand("bigorna").setExecutor(new Bigorna());
		getCommand("enderchest").setExecutor(new Enderchest());
		getCommand("food").setExecutor(new Food());
		getCommand("fly").setExecutor(new Fly());
		getCommand("hat").setExecutor(new Hat());
		getCommand("lixeira").setExecutor(new Lixeira());
		getCommand("mesa").setExecutor(new Table());
		getCommand("gm").setExecutor(new GameMode());
		getCommand("god").setExecutor(new God());
		getCommand("tpa").setExecutor(new Tpa());
		
	}

	public void onDisable() {
		ConsoleCommandSender m = Bukkit.getConsoleSender();
		m.sendMessage("§f[§cMrz§8Core§f]§bDesativado com sucesso");
		m.sendMessage("§f[§cMrz§8Core§f]§bFeito por MuriloMoraz");
		
	}
 

	
}
