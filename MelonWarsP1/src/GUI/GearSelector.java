package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
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
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Dye;

import Commands.GreenGear;
import Commands.RedGear;

public class GearSelector implements Listener {

	 static void GearSelector (HumanEntity whoClicked) {
		  Inventory inv = Bukkit.createInventory(null, 9, "§eGear Selector");
		  
		  ItemStack G = new ItemStack(Material.LEATHER_CHESTPLATE);
		  LeatherArmorMeta GM = (LeatherArmorMeta) G.getItemMeta();
		  
		  ItemStack R = new ItemStack(Material.LEATHER_CHESTPLATE);
		  LeatherArmorMeta RM = (LeatherArmorMeta) R.getItemMeta();
		  
		  GM.setDisplayName("§aGreen Gear");
		  GM.setColor(Color.LIME);
		  ArrayList<String> lG = new ArrayList();
		  lG.add("§fClick To Select §aGreen §fGear.");
		  GM.setLore(lG);
		  G.setItemMeta(GM);
		  
		  RM.setDisplayName("§cRed Gear");
		  RM.setColor(Color.RED);
		  ArrayList<String> lR = new ArrayList();
		  lR.add("§fClick To Select §cRed §fGear.");
		  RM.setLore(lR);
		  R.setItemMeta(RM);
		  
		  Dye GG = new Dye(Material.STAINED_GLASS_PANE);
		  GG.setColor(DyeColor.PURPLE);
		  ItemStack GGC = GG.toItemStack();
	  
		  Dye RG = new Dye(Material.STAINED_GLASS_PANE);
		  RG.setColor(DyeColor.ORANGE);
		  ItemStack RGC = RG.toItemStack();
		  
		  Dye WG = new Dye(Material.STAINED_GLASS_PANE);
		  WG.setColor(DyeColor.BLACK);
		  ItemStack WGC = WG.toItemStack();
		  
		  inv.setItem(0, G);
		  inv.setItem(1, GGC);
		  inv.setItem(2, GGC);
		  inv.setItem(3, GGC);
		  inv.setItem(4, WGC);
		  inv.setItem(5, RGC);
		  inv.setItem(6, RGC);
		  inv.setItem(7, RGC);
		  inv.setItem(8, R);
		  
		  whoClicked.openInventory(inv);
	  }
	 
	 @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		  if(ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("§eGear Selector")) 
			  return;
		  Player p = (Player) event.getWhoClicked();
			  
			  if(p.getGameMode() == GameMode.ADVENTURE){
					event.setCancelled(true);

		  }
		  
			  InventoryAction a = event.getAction();
			     if (a == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
			    	 return;
			  
		  if (event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§aGreen Gear"))) {
			 if (!p.getWorld().getName().equalsIgnoreCase("Hub")) {
					GreenGear.giveMArmor(p);
				  	p.closeInventory();
				 return;
			 }
			  if(p.getLocation().getY() > 102) {
	    			 if(p.getLocation().getZ() > 110) {
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	GreenGear.giveMArmor(p);
			  	p.closeInventory();
		  	}
			  }
		  }
		  }
		  InventoryAction a2 = event.getAction();
		     if (a2 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§cRed Gear"))) {
				  if (!p.getWorld().getName().equalsIgnoreCase("Hub")) {
						RedGear.giveMArmor(p);
					  	p.closeInventory();
					 return;
				 }
		  if((p.getLocation().getY() < 102)) {
	    		if((p.getLocation().getZ() < 110)) {
	    			return;
	    		}
			 }
			  }
		  }
		  InventoryAction a3 = event.getAction();
		     if (a3 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§cRed Gear"))) {
			  if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
			  if(p.getLocation().getY() > 103) {
	    			 if(p.getLocation().getZ() < -257) {
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	RedGear.giveMArmor(p);
			  	p.closeInventory();
	    			 }
		  	}
			  }
		  }
		  }
		  InventoryAction a4 = event.getAction();
		     if (a4 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§cRed Gear"))) {
				  if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
		    if((p.getLocation().getY() < 103)) {
		  		if((p.getLocation().getZ() > -257)) {
		  			p.sendMessage("You Must Be In §cRed §fBase To Select §cRed §fGear!");
		  			return;
		  		}
		    }
				 }
			  }
		  }
		    
		    
	}
}
