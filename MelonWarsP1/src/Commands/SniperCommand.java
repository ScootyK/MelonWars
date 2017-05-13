package Commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class SniperCommand implements CommandExecutor {

	public static void givePRifle(Player p)
	  {
	    PlayerInventory inv = p.getInventory();
	    
	    ItemStack R = new ItemStack(Material.DIAMOND_BARDING);
	    ItemMeta RM = R.getItemMeta();
	    
	    RM.setDisplayName("§aMelon §dSniper");
	    ArrayList<String> lore = new ArrayList();
	    lore.add("Right click to shoot melons!");
	    RM.setLore(lore);
	    R.setItemMeta(RM);
	    
	    inv.remove(R);
	      inv.addItem(new ItemStack[] { R });
	    }

	  
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		cmd.getName().equalsIgnoreCase("sniper");
		Player p = (Player) sender;
		
		if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
			return false;
		}
		if((p.getLocation().getY() > 103)) {
	  		if((p.getLocation().getZ() < -257)) {
	  		
		p.getInventory().remove(Material.GOLD_BARDING);
		p.getInventory().remove(Material.IRON_BARDING);
		
		 givePRifle(p);
		 p.sendMessage("§bYou have recieved a §aMelon §dSniper§b!");
			 }
		}
		if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
		 if(p.getLocation().getY() > 102) {
			 if(p.getLocation().getZ() > 110) {
				 return false;
				}
				 p.getInventory().remove(Material.GOLD_BARDING);
					p.getInventory().remove(Material.DIAMOND_BARDING);
					
					 givePRifle(p);
					  p.sendMessage("§bYou have recieved a §aMelon §dSniper§b!");
		}
}
		 if (p.getWorld().getName().equalsIgnoreCase("Hub")) {
		 if((p.getLocation().getY() < 103)) {
		  		if((p.getLocation().getZ() > -257)) {
		  			 if(p.getLocation().getY() < 102) {
		    			 if(p.getLocation().getZ() < 110) { 
		    				 return false;
		    				
		    			 }
		  			p.sendMessage("§cYou Must Be In Your Teams Base To Change Guns");
		  			return true;
		  		}
				 }
		  		}
		 }

		 
		return false;
		
		
	}
	
}
