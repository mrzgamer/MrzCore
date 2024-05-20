package me.dev.klarcky.main.staff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameMode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cComando permitido apenas em jogo");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("mrzcore.gamemode")) {
			p.sendMessage("§cApenas Admins podem usar este comando");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§cUse /gamemode <0> <1> <3> ");
			return true;
		}
		try {
			int opcao = Integer.parseInt(args[0]);

			switch (opcao) {

			case 0:
				p.setGameMode(org.bukkit.GameMode.SURVIVAL);
				p.sendMessage("§bVoce esta no modo sobrevivencia!");
				break;

			case 1:
				p.setGameMode(org.bukkit.GameMode.CREATIVE);
				p.sendMessage("§bVoce esta no modo criativo!");
				break;

			case 3:
				p.setGameMode(org.bukkit.GameMode.SPECTATOR);
				p.sendMessage("§bVoce esta no modo espectador!");
				break;

			default:
				p.sendMessage("§bOpção Invalida use /gamemode <0> <1> <3> /gm <0> <1> <3> ");
				break;

			}
		} catch (NumberFormatException e) {
			p.sendMessage("§cUse /gamemode <0> <1> <3> ");
		}
		return false;
	}
}
