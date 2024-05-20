package me.dev.klarcky.main.staff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cSem permissão");
			return false;
		}
		Player p = (Player)sender;
		if(!p.hasPermission("mrzcore.good")) {
			p.sendMessage("§cApenas Staffs podem usar este comando.!");
			return true;
		}
		if(!p.isInvulnerable() == true) {
			p.setInvulnerable(true);
			p.sendMessage("§bModo invencivel ligado");
		}else {
			p.sendMessage("§bModo invencivel desligado");
			p.setInvulnerable(false);
		}
		return false;
	}

}