package sg.me.saiyen.infinityban.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import sg.me.saiyen.infinityban.Main;


public class ReloadPluginCommand implements CommandExecutor {
    private final Main main;
    public ReloadPluginCommand(Main main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings[0].equalsIgnoreCase("reload")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (player.hasPermission("infinityban.op")) {
                    main.reloadConfig();
                    player.sendMessage(Main.onColor("&eInfinityBan &areloaded"));
                }else{
                    player.sendMessage(Main.onColor(main.getConfig().getString("nopermission")));
                }
            } else if (commandSender instanceof ConsoleCommandSender) {
                main.reloadConfig();
            }
        }
        return true;
    }
}
