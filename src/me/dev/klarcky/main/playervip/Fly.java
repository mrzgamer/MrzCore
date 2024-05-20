package me.dev.klarcky.main.playervip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cSem permissão");
			return false;
		}
		Player p = (Player)sender;
		if(!p.hasPermission("mrzcore.fly")) {
			p.sendMessage("§cSem permissão para usar este comando!");
			return true;
		}
		if(!p.getAllowFlight() == true) {
			p.setAllowFlight(true);
			p.sendMessage("§bModo Fly ligado");
		}else {
			p.sendMessage("§bModo Fly desligado");
			p.setAllowFlight(false);
		}
		return false;
	}

}
