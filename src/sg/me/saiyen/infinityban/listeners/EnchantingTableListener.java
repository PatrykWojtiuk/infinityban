package sg.me.saiyen.infinityban.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import sg.me.saiyen.infinityban.Main;

import java.util.Map;

public class EnchantingTableListener implements Listener {
    private final Main main;
    public EnchantingTableListener(Main main){
        this.main = main;
    }
    @EventHandler
    public void onTable(EnchantItemEvent event){
        if(event.getItem().getType().equals(Material.BOW)){
            Player player = event.getEnchanter();
            for(Map.Entry<Enchantment, Integer> x : event.getEnchantsToAdd().entrySet()){
                Enchantment enchantment = x.getKey();
                if(enchantment.getName().equalsIgnoreCase("ARROW_INFINITE")){
                    player.sendMessage(Main.onColor(main.getConfig().getString("message")));
                    event.setCancelled(true);
                }
            }
        }
    }
}
