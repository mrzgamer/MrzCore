package me.dev.klarcky.main.playervip;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class Bigorna implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cSem permissão");
			return true;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("mrzcore.bigorna")) {
			p.sendMessage("§cSem permissão para usar este comando!");
			return true;
		}
		Inventory AnvilInput = Bukkit.createInventory(p, InventoryType.ANVIL);
		p.openInventory(AnvilInput);
		p.sendMessage("§bVoce abriu a bigorna");
		return false;
	}

}
