package pl.ping;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/** Komenda /ping: każdy gracz sprawdza swój aktualny ping. */
public final class PingPlugin extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Ta komenda działa tylko w grze."));
            return true;
        }

        int ping = player.getPing();
        NamedTextColor color = ping < 80 ? NamedTextColor.GREEN
                : ping < 150 ? NamedTextColor.YELLOW
                : NamedTextColor.RED;

        player.sendMessage(Component.text("Twój ping: ", NamedTextColor.GRAY)
                .append(Component.text(ping + " ms", color)));
        return true;
    }
}
