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
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Dye;

import Grenades.ClassicGrenade;
import Grenades.ClusterGrenade;

public class PerkSelector implements Listener {

	static void PerkSelector(Player player) {
		  Inventory inv = Bukkit.createInventory(null, 54, "§5Perk Selector");
		  	  
		  //Perk 1
		  
		  ItemStack FC = new ItemStack(Material.WATCH);
		  ItemMeta FCM = FC.getItemMeta();
		  
		  ItemStack FJ = new ItemStack(Material.LEATHER_CHESTPLATE);
		  LeatherArmorMeta FJM = (LeatherArmorMeta) FJ.getItemMeta();
		  
		  ItemStack DC = new ItemStack(Material.TNT);
		  ItemMeta DCM = DC.getItemMeta();
		  
		  ItemStack S = new ItemStack(Material.POTION, 1, (short) 8201);
		  ItemMeta SM = S.getItemMeta();
		  
		  FCM.setDisplayName("§eFaster Cooldown");
		  ArrayList<String> lFC = new ArrayList();
		  lFC.add("§fClick To Select §eFaster Cooldown§f.");
		  lFC.add("§fRecieve 30% Less Time For Shooting Cooldown.");
		  FCM.setLore(lFC);
		  FC.setItemMeta(FCM);
		  
		  FJM.setDisplayName("§7Flak Jacket");
		  FJM.setColor(Color.GRAY);
		  ArrayList<String> lFJ = new ArrayList();
		  lFJ.add("§fClick To Select §7Flak Jacket§f.");
		  lFJ.add("§fRecieve 30% Less Explosive Damage.");
		  FJM.setLore(lFJ);
		  FJ.setItemMeta(FJM);
	
		  DCM.setDisplayName("§4Danger Close");
		  ArrayList<String> lDC = new ArrayList();
		  lDC.add("§fClick To Select §4Danger Close§f.");
		  lDC.add("§fRecieve 40% More Explosive Range.");
		  DCM.setLore(lDC);
		  DC.setItemMeta(DCM);
		  
		  SM.setDisplayName("§5Strength");
		  ArrayList<String> lS = new ArrayList();
		  lS.add("§fClick To Select §5Strength§f.");
		  lS.add("§fRecieve Permanent Strength For Fighting With Sword.");
		  SM.setLore(lS);
		  S.setItemMeta(SM);
		  
		  //Perk 2
		  
		  
		  
		  //Perk 3
		  
		  
		  
		  
		  ItemStack P1 = new ItemStack(Material.DIAMOND);
		  ItemMeta P1M = P1.getItemMeta();
		  
		  ItemStack P2 = new ItemStack(Material.REDSTONE);
		  ItemMeta P2M = P2.getItemMeta();
		  
		  ItemStack P3 = new ItemStack(Material.GOLD_INGOT);
		  ItemMeta P3M = P3.getItemMeta();

		  Dye BP = new Dye(Material.STAINED_GLASS_PANE);
		  BP.setColor(DyeColor.BROWN);
		  ItemStack BPC = BP.toItemStack();
		  
		  Dye RP = new Dye(Material.STAINED_GLASS_PANE);
		  RP.setColor(DyeColor.ORANGE);
		  ItemStack RPC = RP.toItemStack();
		  
		  Dye YP = new Dye(Material.STAINED_GLASS_PANE);
		  YP.setColor(DyeColor.BLUE);
		  ItemStack YPC = YP.toItemStack();

		  P1M.setDisplayName("§bPerk 1");
		  ArrayList<String> lP1 = new ArrayList();
		  lP1.add("§fSelect Perk One Below.");
		  P1M.setLore(lP1);
		  P1.setItemMeta(P1M);
		  
		  P2M.setDisplayName("§cPerk 2");
		  ArrayList<String> lP2 = new ArrayList();
		  lP2.add("§fSelect Perk Two Below.");
		  P2M.setLore(lP2);
		  P2.setItemMeta(P2M);
		  
		  P3M.setDisplayName("§ePerk 3");
		  ArrayList<String> lP3 = new ArrayList();
		  lP3.add("§fSelect Perk Three Below.");
		  P3M.setLore(lP3);
		  P3.setItemMeta(P3M);
		  
		  inv.setItem(0, BPC);
		  inv.setItem(1, P1);
		  inv.setItem(2, BPC);
		  inv.setItem(3, RPC);
		  inv.setItem(4, P2);
		  inv.setItem(5, RPC);
		  inv.setItem(6, YPC);
		  inv.setItem(7, P3);
		  inv.setItem(8, YPC);
		  inv.setItem(9, BPC);
		  inv.setItem(10, BPC);
		  inv.setItem(11, BPC);
		  inv.setItem(12, RPC);
		  inv.setItem(13, RPC);
		  inv.setItem(14, RPC);
		  inv.setItem(15, YPC);
		  inv.setItem(16, YPC);
		  inv.setItem(17, YPC);
		  inv.setItem(18, BPC);
		  inv.setItem(19, FC);
		  inv.setItem(20, BPC);
		  inv.setItem(21, RPC);
		  
		  inv.setItem(23, RPC);
		  inv.setItem(24, YPC);
		  
		  inv.setItem(26, YPC);
		  inv.setItem(27, BPC);
		  inv.setItem(28, FJ);
		  inv.setItem(29, BPC);
		  inv.setItem(30, RPC);
		  
		  inv.setItem(32, RPC);
		  inv.setItem(33, YPC);
		  
		  inv.setItem(35, YPC);
		  inv.setItem(36, BPC);
		  inv.setItem(37, DC);
		  inv.setItem(38, BPC);
		  inv.setItem(39, RPC);
		  
		  inv.setItem(41, RPC);
		  inv.setItem(42, YPC);
		  
		  inv.setItem(44, YPC);
		  inv.setItem(45, BPC);
		  inv.setItem(46, S);
		  inv.setItem(47, BPC);
		  inv.setItem(48, RPC);
		  
		  inv.setItem(50, RPC);
		  inv.setItem(51, YPC);
		  
		  inv.setItem(53, YPC);
		  player.openInventory(inv);
	}
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
			  
		  if (event.getCurrentItem().getType() == Material.DIAMOND) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§bPerk 1"))){
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
		  	}
		  }
		  
		  InventoryAction a1 = event.getAction();
		     if (a1 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.REDSTONE) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§cPerk 2"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  }
		  }
		  InventoryAction a2 = event.getAction();
		     if (a2 == InventoryAction.UNKNOWN || event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR)
		    	 return;
		  
		  if (event.getCurrentItem().getType() == Material.GOLD_INGOT) {
			  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§ePerk 3"))){
				  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  }
		  }
	}
	
}
