package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Dye;

import GUI.GearSelector;

public class ClassCustomizer implements Listener {

	private void ClassCustomizer(Player player) {
		  Inventory inv = Bukkit.createInventory(null, 9, "§aClass Customizer");
		  
		  ItemStack G = new ItemStack(Material.LEATHER_CHESTPLATE);
		  LeatherArmorMeta GM = (LeatherArmorMeta) G.getItemMeta();
		  
		  ItemStack GU = new ItemStack(Material.DIAMOND_BARDING);
		  ItemMeta GUM = GU.getItemMeta();
		  
		  ItemStack GR = new ItemStack(Material.MELON_SEEDS);
		  ItemMeta GRM = GR.getItemMeta();
		  
		  ItemStack P = new ItemStack(Material.EMERALD);
		  ItemMeta PM = P.getItemMeta();
		  
		  ItemStack KS = new ItemStack(Material.CHEST);
		  ItemMeta KSM = KS.getItemMeta();
		  
		  GM.setColor(Color.LIME);
		  GM.getItemFlags().clear();
		  GM.setDisplayName("§bGear Selector");
		  ArrayList<String> lR = new ArrayList();
		  lR.add("§fClick To Select §aGreen§f/§cRed §fGear.");
		  GM.setLore(lR);
		  G.setItemMeta(GM);
		  
		  GUM.setDisplayName("§dGun Selector");
		  ArrayList<String> lGU = new ArrayList();
		  lGU.add("§fClick To Select Your Gun Of Choice.");
		  GUM.setLore(lGU);
		  GU.setItemMeta(GUM);
		  
		  GRM.setDisplayName("§eGrenade Selector");
		  ArrayList<String> lGR = new ArrayList();
		  lGR.add("§fClick To Select Your Grenade Of Choice.");
		  GRM.setLore(lGR);
		  GR.setItemMeta(GRM);
		  
		  PM.setDisplayName("§aPerk Selector");
		  ArrayList<String> lP = new ArrayList();
		  lP.add("§fClick To Select Your Perks.");
		  PM.setLore(lP);
		  P.setItemMeta(PM);
		  
		  KSM.setDisplayName("§cKill Streak Selector");
		  ArrayList<String> lKS = new ArrayList();
		  lKS.add("§fClick To Select Your Kill Streaks.");
		  KSM.setLore(lKS);
		  KS.setItemMeta(KSM);
		  
		  inv.setItem(0, G);
		  inv.setItem(2, GU);
		  inv.setItem(4, GR);
		  inv.setItem(6, P);
		  inv.setItem(8, KS);
		  
		  player.openInventory(inv);
	}
	 @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		  if(ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("§aClass Customizer")) 
			  return;
		  Player p = (Player) event.getWhoClicked();
			  
			  if(p.getGameMode() == GameMode.ADVENTURE){
					event.setCancelled(true);

		  }
		  
			  InventoryAction a = event.getAction();
			     if (a == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
			    	 return;
			
		  if (event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§bGear Selector"))){
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	p.closeInventory();
			  	GearSelector.GearSelector(p);
		  	}
		  }
		  
		  InventoryAction a2 = event.getAction();
		     if (a2 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.DIAMOND_BARDING) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§dGun Selector"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  	GunSelector.GunSelector(p);
			  	}
			  }
		  
		  InventoryAction a3 = event.getAction();
		     if (a3 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.MELON_SEEDS) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§eGrenade Selector"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  	GrenadeSelector.GrenadeSelector(p);
			  	}
			  }
		  
		  if (event.getCurrentItem().getType() == Material.EMERALD) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aPerk Selector"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  	PerkSelector.PerkSelector(p);
			  	}
			  }
	}
	
	 @EventHandler
	    public boolean onPlayerTeleport(PlayerJoinEvent event) {
	        Player p = event.getPlayer();

		p.getInventory().clear();
		PlayerInventory inv = p.getInventory();
		ItemStack C = new ItemStack(Material.WATCH);
	    ItemMeta CM = C.getItemMeta();
	    
	    CM.setDisplayName("§aClass Customizer");
	    ArrayList<String> lore = new ArrayList();
	    lore.add("Customize Your Class");
	    CM.setLore(lore);
	    C.setItemMeta(CM);
	    
	    inv.addItem(new ItemStack[] { C });
	    
			return false;
	 }
	 
	 @EventHandler
	   public boolean onPlayerInteract(PlayerInteractEvent e) {
		 
		 Player p = e.getPlayer();
		 
		  Action a = e.getAction();
		   if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			   return true;
		 
		   if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
		 if((p.getLocation().getY() < 102)) {
	    		if((p.getLocation().getZ() < 110)) {
	    			   if (e.getItem().getType() == Material.WATCH) {
	    					 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aClass Customizer")) {
	    		
		 p.sendMessage("§cYou Must Be In Your Teams Base To Select Gear!");
		 return false;
	    			   }
	    		}
	    		}
		 }
	   }
		   
		   Action a3 = e.getAction();
		   if (a3 == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			   return false;
		 
		 if (!p.getWorld().getName().equalsIgnoreCase("Hub")) {
		   if (e.getItem().getType() == Material.WATCH) {
	  			 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aClass Customizer")) {
	  			 ClassCustomizer(e.getPlayer());
	  			 }
	  		   }
	  		}
		   
		 if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
		 if((p.getLocation().getY() < 103)) {
		  		if((p.getLocation().getZ() > -257)) {
		  		   if (e.getItem().getType() == Material.WATCH) {
		  			 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aClass Customizer")) {
		  			p.sendMessage("§cYou Must Be In Your Teams Base To Select Gear!");	
		  		   }
		  		}
		 }
		  	}
		  
		   Action a1 = e.getAction();
		   if (a1 == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			   return false;
		   
		   if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
		   if(p.getLocation().getY() > 102) {
  			 if(p.getLocation().getZ() > 110) {
		   if (e.getItem().getType() == Material.WATCH) {
			 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aClass Customizer")) {
			 ClassCustomizer(e.getPlayer());
			 
		   }
  			 }
		   }
		   }
		}
		   if(p.getLocation().getY() > 103) {
  			 if(p.getLocation().getZ() < -257) {
  				 if (e.getItem().getType() == Material.WATCH) {
  					 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aClass Customizer")) {
  						ClassCustomizer(e.getPlayer());
  					 }
  				 }
  			 }
		   }
		 }
		 return false;
	 }
}
