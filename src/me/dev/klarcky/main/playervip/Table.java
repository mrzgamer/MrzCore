package me.dev.klarcky.main.playervip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Table implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cSem permissão");
			return true;
		}
		Player p= (Player)sender;
		
		if(!p.hasPermission("mrzcore.mesa")) {
			p.sendMessage("§cSem permissão para usar este comando!");
			return true;
		}
		p.openWorkbench(null, true);
		p.sendMessage("§cVoce abriu a bancada de trabalho");
		return false;
	}

}
