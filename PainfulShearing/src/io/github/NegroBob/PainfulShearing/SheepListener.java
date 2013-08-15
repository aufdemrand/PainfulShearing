package io.github.NegroBob.PainfulShearing;

import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class SheepListener extends JavaPlugin implements Listener {
	
	public void OnEnable(){		
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void OnDisable(){
		
	}
	
	@EventHandler
	public void onPlayerShear(PlayerShearEntityEvent event){
		
		Player player = event.getPlayer();
	    org.bukkit.Location spot = player.getLocation();
	    org.bukkit.entity.Entity sheared = event.getEntity();
		Random generator = new Random();
		int chance = generator.nextInt(10) + 1;
		
		if(sheared instanceof Sheep){
			player.playSound(spot, Sound.GHAST_SCREAM, 1.0f, 1.0f);
			player.sendMessage("That is a sheep");
						
		}else{
			player.sendMessage("That isn't a sheep");
			
		}
	}
}
