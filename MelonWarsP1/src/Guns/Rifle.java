package Guns;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftSnowball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.Effect;

import MelonWars.Main;
import net.minecraft.server.v1_11_R1.PacketPlayOutEntityDestroy;

public class Rifle implements Listener {
	
	//Shooting The Rifle:
	
	private HashMap<String, Snowball> shooters = new HashMap();
	
	  static ArrayList<String> cooldown = new ArrayList();

	  @EventHandler
	   public void onPlayerInteract(PlayerInteractEvent e) {
		   Action a = e.getAction();
		   if (a == Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR)
			   return;
		   
		   if (e.getItem().getType() == Material.IRON_BARDING) {
			 if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMelon §7Rifle")) {
				   
	      final Player p = e.getPlayer();
	      if (cooldown.contains(p.getName()))
	      {
	        return;
	      }
	      cooldown.add(p.getName());
	      BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	      
	      scheduler.scheduleSyncDelayedTask(Main.pl, new Runnable()
	      {
	        public void run()
	        {
	          Rifle.cooldown.remove(p.getName());
	        }
	      }, 9L);
	      
	      Snowball s = (Snowball)e.getPlayer().launchProjectile(Snowball.class);
		    this.shooters.put(e.getPlayer().getName(), s);
		    s.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(2));
		    s.setCustomName("Rifle");
		    
		    for (Player player : Bukkit.getOnlinePlayers()) {
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftSnowball) s).getHandle().getId()));
            }
	      final Item droppedItem = p.getLocation().getWorld().dropItem(p.getEyeLocation().subtract(0.0D, 0.5D, 0.0D), 
	        new ItemStack(Material.MELON_BLOCK));
	      droppedItem.setPickupDelay(1000000000);
	      droppedItem.setVelocity(p.getEyeLocation().getDirection().normalize().multiply(3));
	      
	      BukkitScheduler scheduler2 = Bukkit.getServer().getScheduler();
	      
	      scheduler2.scheduleSyncDelayedTask(Main.pl, new Runnable()
	      {
	        public void run()
	        {
	          droppedItem.remove();
	        }
	      }, 68L);
	    }
		 }
	    	 
	  }

		 @EventHandler
	      public void onDrop(PlayerDropItemEvent event, Player p) {
	          if (event.getItemDrop().getItemStack().getType() == Material.MELON_BLOCK) {
	              event.getItemDrop().remove();
	          } 
	}
		 
		 //Snowball Damager:
		 
	@EventHandler
	  public void onEntityDamage(EntityDamageByEntityEvent e)
	  {
	    if (e.getDamager() instanceof Snowball) {
	    	if(e.getDamager().getCustomName().equalsIgnoreCase("Rifle")) {
	      e.setDamage(16.0D);
	      if (e.getEntity() instanceof Snowball) {
	      }
	      
	      if ((e.getEntity() instanceof Player)) {
	    	     Player player = (Player) e.getEntity();
	    	     player.getInventory().getHelmet().setDurability((short) 0);
	    	     player.getInventory().getChestplate().setDurability((short) 0);
	    	     player.getInventory().getLeggings().setDurability((short) 0);
	    	     player.getInventory().getBoots().setDurability((short) 0);
	      
	  Firework fw = (Firework) e.getEntity().getWorld().spawn(e.getEntity().getLocation(), Firework.class);
      
      FireworkMeta fwm = fw.getFireworkMeta();
      fwm.clearEffects();
      fwm.addEffect(FireworkEffect.builder().flicker(true).trail(false).with(Type.STAR).withColor(Color.LIME).withFade(Color.RED).build());
      
      Field f;
	try {
		f = fwm.getClass().getDeclaredField("power");
		  f.setAccessible(true);
	      f.set(fwm,  -2);	      
	} catch (NoSuchFieldException e1) {
		e1.printStackTrace();
	} catch (SecurityException e1) {
		e1.printStackTrace();
	} catch (IllegalArgumentException e1) {
		e1.printStackTrace();
	} catch (IllegalAccessException e1) {
		e1.printStackTrace();
	}

      fw.setFireworkMeta(fwm);
	      		}
	    	}
	    }
	  }
	
	//Giving Api:

	public static void givePRifle(Player p)
	  {
	    PlayerInventory inv = p.getInventory();
	    
	    ItemStack R = new ItemStack(Material.IRON_BARDING);
	    ItemMeta RM = R.getItemMeta();
	    
	    RM.setDisplayName("§aMelon §7Rifle");
	    ArrayList<String> lore = new ArrayList();
	    lore.add("Right click to shoot melons!");
	    RM.setLore(lore);
	    R.setItemMeta(RM);
	    
	    p.getInventory().remove(Material.GOLD_BARDING);
		p.getInventory().remove(Material.DIAMOND_BARDING);
		p.getInventory().remove(Material.IRON_BARDING);
	    
	      inv.addItem(new ItemStack[] { R });
	      
	    }
	  
}
