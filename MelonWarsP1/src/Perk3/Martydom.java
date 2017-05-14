package Perk3;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import MelonWars.Main;
public class Martyrdom implements Listener {
	
	@EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		  if(ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("§5Perk Selector")) 
			  return;
		  Player p = (Player) event.getWhoClicked();
			  
			  if(p.getGameMode() == GameMode.ADVENTURE){
					event.setCancelled(true);
			  	
			  	}
			  
			  InventoryAction a = event.getAction();
			     if (a == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
			    	 return;
					  
				  if (event.getCurrentItem().getType() == Material.GOLD_INGOT) {
				  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§4Martyrdom"))){
					  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
					  	
					  	ItemStack G = new ItemStack(Material.GOLD_INGOT);
						  ItemMeta GM = G.getItemMeta();
					  	
						  GM.setDisplayName("§bMartyrdom");
						  ArrayList<String> lG = new ArrayList();
						  lG.add("§fMartyrdom Perk!");
						  GM.setLore(lG);
						  G.setItemMeta(GM);
						  
						  p.getInventory().setItem(9, G);
						  
						  p.closeInventory();
				  		}
				  }
				
	}		  
					@EventHandler	
					public void onPlayerDeath(PlayerDeathEvent e) {
						
					Player p = e.getEntity();
					
					final Item droppedItem = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 0.0D), 
					        new ItemStack(Material.MELON_SEEDS));
					      droppedItem.setPickupDelay(1000000000);
					      droppedItem.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
					      droppedItem.setCustomName("§aMelon §8Grenade");
					
						ItemStack M = new ItemStack(Material.GOLD_INGOT);
						  ItemMeta MM = M.getItemMeta();
					  	
						  MM.setDisplayName("§4Martyrdom");
						  ArrayList<String> lM = new ArrayList();
						  lM.add("§fMartyrdom Perk!");
						  MM.setLore(lM);
						  M.setItemMeta(MM);
						  
						  p.getInventory().remove(Material.GOLD_INGOT);
						  p.getInventory().setItem(9, M);
						  
						  p.closeInventory();
						  
					if (p.getInventory().contains(M)) {
						
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
