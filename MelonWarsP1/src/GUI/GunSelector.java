package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import Guns.MachineGun;
import Guns.Rifle;
import Guns.Sniper;

public class GunSelector implements Listener {

	static void GunSelector(Player player) {
		  Inventory inv = Bukkit.createInventory(null, 9, "§bGun Selector");
		  	  
		  ItemStack R = new ItemStack(Material.IRON_BARDING);
		  ItemMeta RM = R.getItemMeta();
		  
		  ItemStack G = new ItemStack(Material.GOLD_BARDING);
		  ItemMeta GM = G.getItemMeta();
		  
		  ItemStack D = new ItemStack(Material.DIAMOND_BARDING);
		  ItemMeta DM = D.getItemMeta();
		  
		  RM.setDisplayName("§aMelon §7Rifle");
		  ArrayList<String> lR = new ArrayList();
		  lR.add("§fClick To Select §aMelon §7Rifle§f.");
		  RM.setLore(lR);
		  R.setItemMeta(RM);
		  
		  GM.setDisplayName("§aMelon §6Machine Gun");
		  ArrayList<String> lG = new ArrayList();
		  lG.add("§fClick To Select §aMelon §6Machine Gun§f.");
		  GM.setLore(lG);
		  G.setItemMeta(GM);
		  
		  DM.setDisplayName("§aMelon §dSniper");
		  ArrayList<String> lD = new ArrayList();
		  lD.add("§fClick To Select §aMelon §dSniper§f.");
		  DM.setLore(lD);
		  D.setItemMeta(DM);
		  
		  inv.setItem(0, R);
		  inv.setItem(1, G);
		  inv.setItem(2, D);
		  
		  player.openInventory(inv);
	}
	 @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		  if(ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("§bGun Selector")) 
			  return;
		  Player p = (Player) event.getWhoClicked();
			  
			  if(p.getGameMode() == GameMode.ADVENTURE){
					event.setCancelled(true);

		  }
		  
			  InventoryAction a = event.getAction();
			     if (a == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
			    	 return;
			
		  if (event.getCurrentItem().getType() == Material.IRON_BARDING) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aMelon §7Rifle"))){
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	p.closeInventory();
			  Rifle.givePRifle(p);
			  p.sendMessage("§bYou have recieved a §aMelon §7Rifle§b!");
		  	}
		  }
		  
		  InventoryAction a2 = event.getAction();
		     if (a2 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.GOLD_BARDING) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aMelon §6Machine Gun"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  MachineGun.givePRifle(p);
				  p.sendMessage("§bYou have recieved a §aMelon §6Machine Gun§b!");
			  }
		  }
		  
		  InventoryAction a3 = event.getAction();
		     if (a3 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.DIAMOND_BARDING) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aMelon §dSniper"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				  	p.closeInventory();
				  Sniper.givePRifle(p);
				  p.sendMessage("§bYou have recieved a §aMelon §dSniper§b!");
				  }
			  }
		  
		  
	}
}