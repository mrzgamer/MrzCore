package me.dev.klarcky.main.playervip;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hat implements CommandExecutor {

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
		if (p.getInventory().getItemInMainHand().getType() == Material.AIR) {
			p.sendMessage("§cVoce precia de um item para usar como chapéu");
			return true;
		}

		ItemStack itemInHand = p.getInventory().getItemInMainHand();
		p.getInventory().setHelmet(itemInHand);
		p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
		;

		p.sendMessage("§bVoce definiu um novo chapéu");
		return false;
	}

}