package MelonWars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		Main.pl.getConfig().set("spawn.world", p.getLocation().getWorld().getName());
		Main.pl.getConfig().set("spawn.x", p.getLocation().getX());
		Main.pl.getConfig().set("spawn.y", p.getLocation().getY());
		Main.pl.getConfig().set("spawn.z", p.getLocation().getZ());
		Main.pl.saveConfig();
		
		World w = Bukkit.getServer().getWorld(Main.pl.getConfig().getString("spawn.world"));
		double x = Main.pl.getConfig().getDouble("spawn.x");
		double y = Main.pl.getConfig().getDouble("spawn.y");
		double z = Main.pl.getConfig().getDouble("spawn.z");
		p.teleport(new Location(w, x, y, z));
		p.sendMessage("§a§l==========§c§l==========");
		p.sendMessage("");
		p.sendMessage("          §a§lWelcome To");
		p.sendMessage("          §c§lMelonWars!");
		p.sendMessage("");
		p.sendMessage("§c§l==========§a§l==========");
	}
	
}
