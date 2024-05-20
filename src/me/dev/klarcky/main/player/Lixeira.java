package me.dev.klarcky.main.player;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Lixeira implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cSem permissão");
			return true;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("mrzcore.lixeira")) {
			p.sendMessage("§cSem permissão para usar este comando!");
			return true;
		}
		Inventory lixo = Bukkit.createInventory(null, 18, "§4Lixeira");
		p.openInventory(lixo);
		p.sendMessage("§bVoce abriu A lixeira!");
		return false;
	}
}
