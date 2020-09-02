package sg.me.saiyen.infinityban;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.plugin.java.JavaPlugin;
import sg.me.saiyen.infinityban.commands.ReloadPluginCommand;
import sg.me.saiyen.infinityban.listeners.AnvilListener;
import sg.me.saiyen.infinityban.listeners.EnchantingTableListener;

public class Main extends JavaPlugin {

    private final ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
    EnchantmentStorageMeta meta = (EnchantmentStorageMeta)book.getItemMeta();

    public static String onColor(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public ItemStack getBook() {
        return book;
    }

    @Override
    public void onEnable() {
        loadConfig();
        meta.addStoredEnchant(Enchantment.ARROW_INFINITE, 1, true);
        book.setItemMeta(meta);
        getCommand("infinityban").setExecutor(new ReloadPluginCommand(this));
        getServer().getPluginManager().registerEvents(new AnvilListener(this), this);
        getServer().getPluginManager().registerEvents(new EnchantingTableListener(this), this);
        getLogger().info("InfinityBan ON");
    }

    @Override
    public void onDisable() {
        getLogger().info("InfinityBan OFF");
    }

}
