package me.dev.klarcky.main.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Tpa implements CommandExecutor {

    private Map<Player, Player> teleportRequests = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando só pode ser executado por jogadores.");
            return true;
        }

        Player senderPlayer = (Player) sender;

        // Verifica se o jogador forneceu argumentos suficientes
        if (args.length != 1) {
            senderPlayer.sendMessage("§cUso: /tpa <jogador>");
            return true;
        }

        // Obtém o nome do jogador alvo
        String targetName = args[0];

        // Verifica se o jogador alvo está online
        Player targetPlayer = Bukkit.getPlayer(targetName);
        if (targetPlayer == null || !targetPlayer.isOnline()) {
            senderPlayer.sendMessage("§cO jogador alvo não está online ou não existe.");
            return true;
        }

        // Adiciona a solicitação de teleporte
        teleportRequests.put(targetPlayer, senderPlayer);

        TextComponent acceptText = new TextComponent("Clique aqui para aceitar");
        acceptText.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/aceitar"));
        targetPlayer.sendMessage("§aVocê recebeu uma solicitação de teleporte de " + senderPlayer.getName() +
                ". ");
        targetPlayer.spigot().sendMessage(acceptText);

        senderPlayer.sendMessage("§aSolicitação de teleporte enviada para " + targetPlayer.getName() + ".");

        return true;
    }

    public void acceptTeleportRequest(Player player) {
        Player sender = teleportRequests.get(player);
        if (sender != null) {
            player.teleport(sender);
            player.sendMessage("§aTeleporte aceito.");
            sender.sendMessage("§aO jogador " + player.getName() + " aceitou o teleporte.");
            teleportRequests.remove(player);
        } else {
            player.sendMessage("§cNão há solicitações de teleporte pendentes para você.");
        }
    }

    public void declineTeleportRequest(Player player) {
        Player sender = teleportRequests.get(player);
        if (sender != null) {
            player.sendMessage("§cVocê recusou a solicitação de teleporte de " + sender.getName() + ".");
            sender.sendMessage("§cO jogador " + player.getName() + " recusou o teleporte.");
            teleportRequests.remove(player);
        } else {
            player.sendMessage("§cNão há solicitações de teleporte pendentes para você.");
        }
    }
}