package Grenades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import MelonWars.Main;
import net.minecraft.server.v1_11_R1.Explosion;

public class ClassicGrenade implements Listener {

	//Grenade Throw.
	
	private HashMap<String, Snowball> shooters = new HashMap();
	
	private static ArrayList<String> cooldown = new ArrayList();
	
	@EventHandler
	   public void onPlayerInteract(PlayerInteractEvent e) {
		   Action a = e.getAction();
		   if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			   return;
		   
		   if (e.getItem().getType() == Material.MELON_SEEDS) {
			 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §8Grenade")) {
				   
				  final Player p = e.getPlayer();
				 if (cooldown.contains(p.getName()))
			      {
			        return;
			      }
			      cooldown.add(p.getName());
			      BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
			      
			      scheduler.scheduleSyncDelayedTask(Main.pl, new Runnable()
			      {
			        public void run()
			        {
			          ClassicGrenade.cooldown.remove(p.getName());
			        }
			      }, 65L);    
			    
			      final Item droppedItem = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 0.0D), 
			        new ItemStack(Material.MELON_SEEDS));
			      droppedItem.setPickupDelay(1000000000);
			      droppedItem.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
			      droppedItem.setCustomName("§aMelon §8Grenade");
			      
			      if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §8Grenade"))
				    {					      
		e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount()-1);
				    }
			    	  
			    	  
			      BukkitScheduler scheduler1 = Bukkit.getServer().getScheduler();
			      
			      scheduler1.scheduleSyncDelayedTask(Main.pl, new Runnable()
			      {
			        public void run()
			        {
			          Location loc = p.getLocation();
			          
			          loc.getWorld().createExplosion(droppedItem.getLocation().getX(), droppedItem.getLocation().getY(), droppedItem.getLocation().getZ(), 5.0F, false, false);
			          
			        }
			      }, 45L);

			      
			      BukkitScheduler scheduler2 = Bukkit.getServer().getScheduler();
			      
			      scheduler2.scheduleSyncDelayedTask(Main.pl, new Runnable()
			      {
			        public void run()
			        {
			          droppedItem.remove();
			        }
			      }, 45L);
			      }
		   }
			  }
	
	//Giving Api:

		public static void givePGrenade(Player p)
		  {
		    PlayerInventory inv = p.getInventory();
		    
		    ItemStack R = new ItemStack(Material.MELON_SEEDS, 2);
		    ItemMeta RM = R.getItemMeta();
		    
		    RM.setDisplayName("§aMelon §8Grenade");
		    ArrayList<String> lore = new ArrayList();
		    lore.add("Right click to launch grenade.");
		    RM.setLore(lore);
		    R.setItemMeta(RM);
		    
			p.getInventory().remove(Material.MELON_SEEDS);
		    
		      inv.addItem(new ItemStack[] { R });
		      
		    }	  
	
		@EventHandler
		  public void onEntityDamage(EntityDamageByEntityEvent e)
		  {
			
			Entity p = e.getDamager();
			
			if (e.getDamager().getLocation().) {
		      e.setDamage(16.0D);
		      p.sendMessage("Debug");
			}
	}
}
