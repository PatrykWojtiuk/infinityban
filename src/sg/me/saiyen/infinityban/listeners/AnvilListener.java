package sg.me.saiyen.infinityban.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import sg.me.saiyen.infinityban.Main;

public class AnvilListener implements Listener {
    private final Main main;
    public AnvilListener(Main main){
        this.main = main;
    }
    @EventHandler
    public void onAnvilCraft(InventoryClickEvent event){
        if(event.getInventory().getType() == InventoryType.ANVIL){
            if(event.getInventory().getItem(1) !=null && event.getInventory().getItem(1).isSimilar(main.getBook())){
                Player player = (Player) event.getWhoClicked();
                if(event.getRawSlot() == 2){
                    event.setCancelled(true);
                    player.sendMessage(Main.onColor(main.getConfig().getString("message")));
                }
            }
        }
    }
}
