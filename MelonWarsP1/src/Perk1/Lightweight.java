package Perk1;

public class Lightweight {

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
			  
		  if (event.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
		  if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(("§bLightweight"))){
			  	p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
			  	
			  	ItemStack L = new ItemStack(Material.DIAMOND);
				  ItemMeta LM = L.getItemMeta();
			  	
				  LM.setDisplayName("§bLightweight");
				  ArrayList<String> lL = new ArrayList();
				  lL.add("§fLightweight Perk!");
				  LM.setLore(lL);
				  L.setItemMeta(LM);
				  
				  p.getInventory().remove(Material.DIAMOND);
				  p.getInventory().setItem(9, L);
				  
				  p.closeInventory();
				  
			if (p.getInventory().contains(L)) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
				
				
				}	  
		  	}
		  }
	}
}
