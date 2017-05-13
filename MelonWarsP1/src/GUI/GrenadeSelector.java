package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import Grenades.ClassicGrenade;
import Grenades.ClusterGrenade;
import Grenades.IncendiaryGrenade;
import Guns.MachineGun;
import Guns.Rifle;
import Guns.Sniper;

public class GrenadeSelector implements Listener {

	static void GrenadeSelector(Player player) {
		  Inventory inv = Bukkit.createInventory(null, 9, "§cGrenade Selector");
		  	  
		  ItemStack G = new ItemStack(Material.MELON_SEEDS);
		  ItemMeta GM = G.getItemMeta();
		  
		  ItemStack CG = new ItemStack(Material.MELON_SEEDS);
		  ItemMeta CGM = CG.getItemMeta();
		  
		  ItemStack IG = new ItemStack(Material.MELON_SEEDS);
		  ItemMeta IGM = IG.getItemMeta();

		  GM.setDisplayName("§aMelon §8Grenade");
		  ArrayList<String> lG = new ArrayList();
		  lG.add("§fClick To Select §aMelon §8Grenade§f.");
		  GM.setLore(lG);
		  G.setItemMeta(GM);
		  
		  CGM.setDisplayName("§aMelon §eCluster Grenade");
		  ArrayList<String> lC = new ArrayList();
		  lC.add("§fClick To Select §aMelon §eCluster Grenade§f.");
		  CGM.setLore(lC);
		  CG.setItemMeta(CGM);
		  
		  IGM.setDisplayName("§aMelon §4Incendiary Grenade");
		  ArrayList<String> lI = new ArrayList();
		  lI.add("§fClick To Select §aMelon §4Incendiary Grenade§f.");
		  IGM.setLore(lI);
		  IG.setItemMeta(IGM);
		  
		  inv.setItem(0, G);
		  inv.setItem(1, CG);
		  inv.setItem(2, IG);
		
		  player.openInventory(inv);
	}
	 @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		  if(ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("§cGrenade Selector")) 
			  return;
		  Player p = (Player) event.getWhoClicked();
			  
			  if(p.getGameMode() == GameMode.ADVENTURE){
					event.setCancelled(true);
		  }
			  
			
	     InventoryAction ag = event.getAction();
	     if (ag == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
	    	 return;
			  
		  if (event.getCurrentItem().getType() == Material.MELON_SEEDS) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aMelon §8Grenade"))){
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	p.closeInventory();
				   ClassicGrenade.givePGrenade(p);
			  p.sendMessage("§bYou have recieved a §aMelon §8Grenade§b!");
		  	}
		  }
		  
		  InventoryAction ac = event.getAction();
		     if (ac == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.MELON_SEEDS) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aMelon §eCluster Grenade"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  	ClusterGrenade.givePClusterGrenade(p);
				  p.sendMessage("§bYou have recieved a §aMelon §eCluster Grenade§b!");
			  }
		  }
		  
		  InventoryAction ai = event.getAction();
		     if (ai == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.MELON_SEEDS) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aMelon §4Incendiary Grenade"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  	IncendiaryGrenade.givePIncendiaryGrenade(p);
				  p.sendMessage("§bYou have recieved a §aMelon §4Incendiary Grenade§b!");
			  }
		  }  
	}
}
