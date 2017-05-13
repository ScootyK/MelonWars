package MelonWars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.ScoreboardManager;

import Commands.GreenGear;
import Commands.MachineGunCmd;
import Commands.RedGear;
import Commands.RifleCmd;
import Commands.SniperCommand;
import GUI.ClassCustomizer;
import GUI.GearSelector;
import GUI.GrenadeSelector;
import GUI.GunSelector;
import GUI.PerkSelector;
import Guns.MachineGun;
import Guns.Rifle;
import Guns.Sniper;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class Main extends JavaPlugin implements Listener {

	public static PluginManager pm = Bukkit.getPluginManager();
	private static Main instance;
	public static Main pl;
	public static Economy econ = null;
	public static EconomyResponse r;
	
	public void onEnable()
	  {
		if (!setupEconomy()){		
			getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
			
		}
		
		getLogger().info("Plugin has enabled!");
		
		this.getConfig().addDefault("kills", 0);
		this.getConfig().addDefault("deaths", 0);
		this.getConfig().options().copyDefaults(true);
		
		instance= this;
		pl = this;
		  getCommand("rifle").setExecutor(new RifleCmd());
		  getCommand("machinegun").setExecutor(new MachineGunCmd());
		  getCommand("greengear").setExecutor(new GreenGear());
		  getCommand("redgear").setExecutor(new RedGear());
		  getCommand("sniper").setExecutor(new SniperCommand());
		  
		  this.getServer().getPluginManager().registerEvents(this, this);
		  	  
		  loadListeners();
	}
	
	public void onDisable() {
		saveConfig();
	}
	
	public static Main getInstance() {
	return instance;
	}
	
	
	private void loadListeners () throws NullPointerException {
		
    pm.registerEvents(new Rifle(), this);
    pm.registerEvents(new MachineGun(), this);
    pm.registerEvents(new Sniper(), this);
    pm.registerEvents(new GreenGear(), this);
    pm.registerEvents(new JoinEvent(), this);
    pm.registerEvents(new RedGear(), this);
    pm.registerEvents(new ClassCustomizer(), this);
    pm.registerEvents(new GearSelector(), this);
    pm.registerEvents(new GunSelector(), this);
    pm.registerEvents(new PerkSelector(), this);
    pm.registerEvents(new GrenadeSelector(), this);
    pm.registerEvents(new Grenades.ClassicGrenade(), this);
    pm.registerEvents(new Grenades.ClusterGrenade(), this);
    pm.registerEvents(new Grenades.IncendiaryGrenade(), this);
    pm.registerEvents(new Perk1.FlakJacket(), this);
	
	}
	
	public boolean setupEconomy() {		
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;		
		}
		
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ !=null;
		
		
		
	}
	
	
	@EventHandler
	public void createHubBoard(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		String name = p.getName().toString();
		
		int kills = pl.getConfig().getInt("Players." + name + ".Kills");
		int deaths = pl.getConfig().getInt("Players." + name + ".Deaths");
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
		
		Objective obj = board.registerNewObjective("MelonWars", "Stats");
		
		obj.setDisplayName("§a§lMelon §c§lWars");
	    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	    obj.getScore("§e").setScore(9);
	    obj.getScore("§a§lMelon §2§lMoney: §a§l$" + econ.getBalance(name)).setScore(8);
	    obj.getScore("§e").setScore(7);
	    obj.getScore("§c§lKills: " + kills).setScore(6);
	    obj.getScore("§b§lDeaths: " + deaths).setScore(5);
	    obj.getScore("§e").setScore(4);
	    obj.getScore("§e").setScore(3);
	    obj.getScore("§e").setScore(2);
	    obj.getScore("§e").setScore(1);
	    
	    Bukkit.getPlayer(p.getName()).setScoreboard(obj.getScoreboard());
	    
	}
	
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		Player k = p.getKiller();
		
		p.setGameMode(GameMode.ADVENTURE);
		
		String name = p.getName().toString();
		
		int kills = pl.getConfig().getInt("Players." + name + ".Kills");
		int deaths = pl.getConfig().getInt("Players." + name + ".Deaths");
		
		String playername = p.getName().toString();
		
		if(!pl.getConfig().contains("Players." + playername)) {
			
			pl.getConfig().set("Players." + playername + ".Kills", 0);
			pl.getConfig().set("Players." + playername + ".Deaths", 0);
			
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
			
			Objective obj = board.registerNewObjective("MelonWars", "Stats");
			
			obj.setDisplayName("§a§lMelon §c§lWars");
		    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		    obj.getScore("§e").setScore(9);
		    obj.getScore("§a§lMelon §2§lMoney: §a§l$" + econ.getBalance(name)).setScore(8);
		    obj.getScore("§e").setScore(7);
		    obj.getScore("§c§lKills: " + kills).setScore(6);
		    obj.getScore("§b§lDeaths: " + deaths).setScore(5);
		    obj.getScore("§e").setScore(4);
		    obj.getScore("§e").setScore(3);
		    obj.getScore("§e").setScore(2);
		    obj.getScore("§e").setScore(1);
		    
		    Bukkit.getPlayer(p.getName()).setScoreboard(obj.getScoreboard());
			
			pl.saveConfig();
			
		}			
		
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		
		if(p.getKiller() instanceof Player) {
			
			Player k = p.getKiller();
			
			String pname = p.getName().toString();
			String kname = k.getName().toString();
			
			//Kill Player Scoreboard
			
			int kills = pl.getConfig().getInt("Players." + kname + ".Kills");
			int deaths = pl.getConfig().getInt("Players." + kname + ".Deaths");
			
			pl.getConfig().set("Players." + kname + ".Kills", kills + 1);
			pl.getConfig().set("Players." + pname + ".Deaths", deaths + 1);
			
			Bukkit.broadcastMessage("§c" + k.getName()+ " §fkilled §a" + p.getName() + ".");
			k.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+1 Kill!");
			
			r = econ.depositPlayer(k.getName(), 10.00);
			
			pl.saveConfig();
				
				pl.getConfig().set("Players." + k + ".Kills", 0);
				pl.getConfig().set("Players." + k + ".Deaths", 0);
				
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
				
				Objective obj = board.registerNewObjective("MelonWars", "Stats");
				
				obj.setDisplayName("§a§lMelon §c§lWars");
			    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			    obj.getScore("§e").setScore(9);
			    obj.getScore("§a§lMelon §2§lMoney: §a§l$" + econ.getBalance(k)).setScore(8);
			    obj.getScore("§e").setScore(7);
			    obj.getScore("§c§lKills: " + kills).setScore(6);
			    obj.getScore("§b§lDeaths: " + deaths).setScore(5);
			    obj.getScore("§e").setScore(4);
			    obj.getScore("§e").setScore(3);
			    obj.getScore("§e").setScore(2);
			    obj.getScore("§e").setScore(1);
			    
			    Bukkit.getPlayer(kname).setScoreboard(obj.getScoreboard());
			    
			    pl.saveConfig();
			    
			    //Death Player Scoreboard
			    
			    if (!(p.getKiller() instanceof Player)) {

			    int kills2 = pl.getConfig().getInt("Players." + pname + ".Kills");
				int deaths2 = pl.getConfig().getInt("Players." + pname + ".Deaths");
				
				pl.getConfig().set("Players." + pname + ".Deaths", deaths + 1);						
				
				pl.saveConfig();
					
					pl.getConfig().set("Players." + p + ".Kills", 0);
					pl.getConfig().set("Players." + p + ".Deaths", 0);					
					
					obj.setDisplayName("§a§lMelon §c§lWars");
				    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
				    obj.getScore("§e").setScore(9);
				    obj.getScore("§a§lMelon §2§lMoney: §a§l$" + econ.getBalance(p)).setScore(8);
				    obj.getScore("§e").setScore(7);
				    obj.getScore("§c§lKills: " + kills).setScore(6);
				    obj.getScore("§b§lDeaths: " + deaths).setScore(5);
				    obj.getScore("§e").setScore(4);
				    obj.getScore("§e").setScore(3);
				    obj.getScore("§e").setScore(2);
				    obj.getScore("§e").setScore(1);
				    
				    Bukkit.getPlayer(pname).setScoreboard(obj.getScoreboard());
				    
				    pl.saveConfig();
				
			    }
		}
	}
}
