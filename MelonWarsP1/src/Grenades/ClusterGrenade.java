package Grenades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import Guns.Rifle;
import MelonWars.Main;

public class ClusterGrenade implements Listener {

	//Grenade Throw.
	
		private HashMap<String, Snowball> shooters = new HashMap();
		
		private static ArrayList<String> cooldown = new ArrayList();
		@EventHandler
		   public void onPlayerInteract(PlayerInteractEvent e) {
			   Action a = e.getAction();
			   if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
				   return;
			   
			   if (e.getItem().getType() == Material.MELON_SEEDS) {
				 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §eCluster Grenade")) {
					   
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
		          ClusterGrenade.cooldown.remove(p.getName());
		        }
		      }, 100L);  
		    
		    
		      final Item droppedItem = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 0.0D), 
		        new ItemStack(Material.MELON_SEEDS));
		      droppedItem.setPickupDelay(1000000000);
		      droppedItem.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
		      droppedItem.setCustomName("§aMelon §eCluster Grenade");
		      
		      final Item droppedItem1 = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(1.0D, 0.5D, 0.0D), 
				        new ItemStack(Material.MELON_SEEDS));
				      droppedItem1.setPickupDelay(1000000000);
				      droppedItem1.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
				      droppedItem1.setCustomName("§aMelon §eCluster Grenade");
				      
				      final Item droppedItem11 = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 1.0D), 
						        new ItemStack(Material.MELON_SEEDS));
						      droppedItem11.setPickupDelay(1000000000);
						      droppedItem11.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
						      droppedItem11.setCustomName("§aMelon §eCluster Grenade");
						      final Item droppedItem111 = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 0.0D), 
								        new ItemStack(Material.MELON_SEEDS));
								      droppedItem111.setPickupDelay(1000000000);
								      droppedItem111.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
								      droppedItem111.setCustomName("§aMelon §eCluster Grenade");
								      final Item droppedItem1111 = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, -0.5D, 0.0D), 
										        new ItemStack(Material.MELON_SEEDS));
										      droppedItem1111.setPickupDelay(1000000000);
										      droppedItem1111.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
										      droppedItem1111.setCustomName("§aMelon §eCluster Grenade");
				if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §eCluster Grenade"))
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
		          
		          loc.getWorld().createExplosion(droppedItem.getLocation().getX(), droppedItem.getLocation().getY(), droppedItem.getLocation().getZ(), 3.0F, false, false);
		          loc.getWorld().createExplosion(droppedItem1.getLocation().getX(), droppedItem1.getLocation().getY(), droppedItem1.getLocation().getZ(), 3.0F, false, false);
		          loc.getWorld().createExplosion(droppedItem11.getLocation().getX(), droppedItem11.getLocation().getY(), droppedItem11.getLocation().getZ(), 3.0F, false, false);
		          loc.getWorld().createExplosion(droppedItem111.getLocation().getX(), droppedItem111.getLocation().getY(), droppedItem111.getLocation().getZ(), 3.0F, false, false);
		          loc.getWorld().createExplosion(droppedItem1111.getLocation().getX(), droppedItem1111.getLocation().getY(), droppedItem1111.getLocation().getZ(), 3.0F, false, false);
		        }
		      }, 45L);

		      
		      BukkitScheduler scheduler2 = Bukkit.getServer().getScheduler();
		      
		      scheduler2.scheduleSyncDelayedTask(Main.pl, new Runnable()
		      {
		        public void run()
		        {
		          droppedItem11.remove();
		        }
		      }, 45L);
		    }
		    }
		  }
		
		
		//Giving Api:

				public static void givePClusterGrenade(Player p)
				  {
				    PlayerInventory inv = p.getInventory();
				    
				    ItemStack R = new ItemStack(Material.MELON_SEEDS);
				    ItemMeta RM = R.getItemMeta();
				    
				    RM.setDisplayName("§aMelon §eCluster Grenade");
				    ArrayList<String> lore = new ArrayList();
				    lore.add("Right click to launch grenade.");
				    RM.setLore(lore);
				    R.setItemMeta(RM);
				    
					p.getInventory().remove(Material.MELON_SEEDS);
				    
				      inv.addItem(new ItemStack[] { R });
				      
				    }
				  
			
}
