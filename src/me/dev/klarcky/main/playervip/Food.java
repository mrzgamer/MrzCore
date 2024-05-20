package me.dev.klarcky.main.playervip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Food implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�cSem permiss�o");
			return true;
		}
		Player p =(Player)sender;
	
		if (!p.hasPermission("mrzcore.food")) {
			p.sendMessage("�cSem permiss�o para executar este comando!");
			return true;
		}
		if(p.getFoodLevel() <=20) {
			p.setFoodLevel(20);
			p.sendMessage("�bSua fome foi saciada!");
		}else {
			p.sendMessage("�cVoce n�o esta com fome!");
		}
		return false;
	}

}
