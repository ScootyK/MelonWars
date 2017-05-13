package Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RedGear implements Listener, CommandExecutor {

	public static void giveMArmor(Player p)
	  {
	    PlayerInventory inv = p.getInventory();
	    
	    p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 18000, 255));
	  

	    ItemStack A2 = new ItemStack(Material.MELON_BLOCK);
	    ItemMeta Am1 = A2.getItemMeta();
	   
	    Am1.setDisplayName("§aMelon §cHead");
	    ArrayList<String> lore1 = new ArrayList();
	    lore1.add("Best Melon Head In Town!");
	    Am1.setLore(lore1);
	    A2.setItemMeta(Am1);
	    
	    A2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10); 
	    if (!inv.contains(A2))
	      inv.addItem(new ItemStack[] { A2 });
	      
	      inv.remove(A2);
	      inv.addItem(new ItemStack[] { A2 });
	      inv.setHelmet(A2);
	    
	    ItemStack A = new ItemStack(Material.LEATHER_CHESTPLATE);
	    LeatherArmorMeta meta2 = (LeatherArmorMeta) A.getItemMeta();
     meta2.setDisplayName("§4Red §aMelon §cChestplate");
     meta2.setLore(Arrays.asList("Best Melon Chestplate In Town!"));
     meta2.setColor(Color.RED);
     A.setItemMeta(meta2);		   
	    A.setDurability((short)0);
	    
	    	 A.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
	    if (!inv.contains(A))
	    {
	      inv.addItem(new ItemStack[] { A });
	
	      inv.remove(A);
	      inv.addItem(new ItemStack[] { A });
	      inv.setChestplate(A);
	      
	      ItemStack A1 = new ItemStack(Material.LEATHER_LEGGINGS);
	      LeatherArmorMeta meta1 = (LeatherArmorMeta) A1.getItemMeta();
       meta1.setDisplayName("§4Red §aMelon §cLeggings");
       meta1.setLore(Arrays.asList("Best Melon Leggings In Town!"));
       meta1.setColor(Color.RED);
       A1.setItemMeta(meta1);		    
       A1.setDurability((short)0);
		    
		    	 A1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		    if (!inv.contains(A1))
		    {
		      inv.addItem(new ItemStack[] { A1 });		  
		      inv.remove(A1);
		      inv.setLeggings(A1);
		      
		      inv.addItem(new ItemStack[] { A1 });
		      
		      ItemStack A11 = new ItemStack(Material.LEATHER_BOOTS);
           LeatherArmorMeta meta = (LeatherArmorMeta) A11.getItemMeta();
           meta.setDisplayName("§4Red §aMelon §cBoots");
           meta.setLore(Arrays.asList("Best Melon Boots In Town!"));
           meta.setColor(Color.RED);
           A11.setItemMeta(meta);
			    
			    	 A11.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
			    if (!inv.contains(A11))
			    {
			      inv.addItem(new ItemStack[] { A11 });
			
			      inv.remove(A11);
			      inv.addItem(new ItemStack[] { A11 });
			      inv.setBoots(A11);
			      
			      inv.remove(A11);
			      inv.remove(A1);
			      inv.remove(A);
			      inv.remove(A2);
			      
			      ItemStack A1111 = new ItemStack(Material.WOOD_SWORD);
				    ItemMeta Am = A1111.getItemMeta();
				    
				    Am.setDisplayName("§aMelon §cSword");
				    ArrayList<String> lore = new ArrayList();
				    lore.add("The Sharpest Sword In Town!");
				    Am.setLore(lore);
				    A1111.setItemMeta(Am);
				    
				    	 A1111.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				    	 A1111.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				    if (!inv.contains(A1111))
				    {
				      inv.remove(A1111);
				      inv.addItem(new ItemStack[] { A1111 });
				      
				      ItemStack R = new ItemStack(Material.MELON_SEEDS, 2);
					    ItemMeta RM = R.getItemMeta();
					    
					    RM.setDisplayName("§aMelon §8Grenade");
					    ArrayList<String> lore6 = new ArrayList();
					    lore6.add("Right click to launch grenade.");
					    RM.setLore(lore6);
					    R.setItemMeta(RM);
					    
						p.getInventory().remove(Material.MELON_SEEDS);
					    
						inv.remove(R);
					      inv.addItem(new ItemStack[] { R });		    
	
	    }
	    p.sendMessage("§bYou have recieved a §aMelon §cGear§b!");
	    }
		    }
	    }
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String comandlabel, String[] args)
	  {
		Player p = (Player) sender;
	    if (cmd.getName().equalsIgnoreCase("redgear")) {
	      if ((sender instanceof Player)) {
	    	  if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
	    		  return false;
				 }
	    		 if(p.getLocation().getY() > 103) {
	    			 if(p.getLocation().getZ() < -257) {
	    	  
	      giveMArmor(p);
	    			 }
	    		 }
	     	}
	      }
	    if (p.getWorld().getName().equalsIgnoreCase("Hub")) { 
	    if((p.getLocation().getY() < 103)) {
  		if((p.getLocation().getZ() > -257)) {
  			p.sendMessage("You Must Be In §cRed §fBase For §cRed §fGear!");
  			return true;
  		}
  		}
		 }
			return true;
	  }
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		
		if (p.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase("§4Red §aMelon §cChestplate")) {
		giveMArmor(p);
		
		}
	}
}
