package io.github.NegroBob.PainfulShearing;

import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class PainfulShearing extends JavaPlugin implements Listener {
	
	// Make generator a class field to avoid making a new Random object
	// every PlayerShearEntityEvent.. this will actually result in a 
	// more random number, too.
	Random generator = new Random();
	
	public void OnEnable(){		
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void OnDisable(){
		
	}
	
	@EventHandler
	public void onPlayerShear(PlayerShearEntityEvent event){
	
		// Add some debug to make sure this is firing.
		getLogger().info(event.getPlayer().getName() + " sheared!");
		
	    
	    	Player player = event.getPlayer();
	    	org.bukkit.Location spot = player.getLocation();
		 org.bukkit.entity.Entity sheared = event.getEntity();
	    
		  int chance = generator.nextInt(10) + 1;
		
		if (sheared instanceof Sheep) {
			player.playSound(spot, Sound.GHAST_SCREAM, 1.0f, 1.0f);
			player.sendMessage("That is a sheep");
						
		} else {
			player.sendMessage("That isn't a sheep");
			
		}
	}
}
