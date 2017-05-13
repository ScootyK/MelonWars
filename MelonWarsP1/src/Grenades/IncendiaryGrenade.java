package Grenades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import MelonWars.Main;

public class IncendiaryGrenade implements Listener {

private HashMap<String, Snowball> shooters = new HashMap();
	
	private static ArrayList<String> cooldown = new ArrayList();
	
	@EventHandler
	   public void onPlayerInteract(PlayerInteractEvent e) {
		   Action a = e.getAction();
		   if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			   return;
		   
		   if (e.getItem().getType() == Material.MELON_SEEDS) {
			 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §4Incendiary §8Grenade")) {
				   
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
			          IncendiaryGrenade.cooldown.remove(p.getName());
			        }
			      }, 65L);    
			    
			      final Item droppedItem = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 0.0D), 
			        new ItemStack(Material.MELON_SEEDS));
			      droppedItem.setPickupDelay(1000000000);
			      droppedItem.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
			      droppedItem.setCustomName("§aMelon §4Incendiary §8Grenade");
			      
			      if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §4Incendiary §8Grenade"))
				    {					      
		e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount()-1);
				    }
			    	  
			      if (p.getItemInHand().getAmount() == 1) {
			          if ((e.getAction() != Action.RIGHT_CLICK_AIR)) {
			    		  return;
			    	  }
			    	  
			    	  ItemStack A = new ItemStack(Material.AIR);
			    	  p.setItemInHand(A);
			      }
			    	  
			      BukkitScheduler scheduler1 = Bukkit.getServer().getScheduler();
			      
			      scheduler1.scheduleSyncDelayedTask(Main.pl, new Runnable()
			      {
			        public void run()
			        {
			          Location loc = p.getLocation();
			          
			          loc.getWorld().createExplosion(droppedItem.getLocation().getX(), droppedItem.getLocation().getY(), droppedItem.getLocation().getZ(), 4.0F, true, false);
			          
			        }
			      }, 25L);

			      
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

		public static void givePIncendiaryGrenade(Player p)
		  {
		    PlayerInventory inv = p.getInventory();
		    
		    ItemStack R = new ItemStack(Material.MELON_SEEDS);
		    ItemMeta RM = R.getItemMeta();
		    
		    RM.setDisplayName("§aMelon §4Incendiary §8Grenade");
		    ArrayList<String> lore = new ArrayList();
		    lore.add("Right click to launch grenade.");
		    RM.setLore(lore);
		    R.setItemMeta(RM);
		    
			p.getInventory().remove(Material.MELON_SEEDS);
		    
		      inv.addItem(new ItemStack[] { R });
		      
		    }
		
		//Fire Damage:
		
		@EventHandler
		  public void onFireTickDamage(EntityDamageEvent e)
		  {
			
		    if (e.getCause().FIRE_TICK != null) {
		      e.setDamage(4.0D);
	    }
	}
		@EventHandler
		  public void onFireDamage(EntityDamageEvent e)
		  {
			
		    if (e.getCause().FIRE != null) {
		      e.setDamage(12.0D);
	    }
	}
}
