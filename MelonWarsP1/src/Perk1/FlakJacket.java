package Perk1;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import GUI.ClassCustomizer;

public class FlakJacket implements Listener {

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
			  
		  if (event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§7Flak Jacket"))){
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	
			  	ItemStack D = new ItemStack(Material.DIAMOND);
				  ItemMeta DM = D.getItemMeta();
			  	
				  DM.setDisplayName("§bPerk 1");
				  ArrayList<String> lD = new ArrayList();
				  lD.add("§fFlack Jacket Perk!");
				  DM.setLore(lD);
				  D.setItemMeta(DM);
				  
				  p.getInventory().setItem(9, D);
				  
				  p.closeInventory();
		  	}
		  }
	}

}
