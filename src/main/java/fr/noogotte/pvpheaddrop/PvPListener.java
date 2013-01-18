package fr.noogotte.pvpheaddrop;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PvPListener implements Listener {

    private PvPHeadDrop plugin;

    public PvPListener(PvPHeadDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(PlayerDeathEvent event) {

        Random rand = new Random();
        boolean drop = rand.nextInt(100) + 1 < plugin.getRate();

        if(!drop) {
            return;
        }

        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        SkullMeta meta = (SkullMeta) stack.getItemMeta();
        Player death = (Player) event.getEntity();
        meta.setOwner(death.getName());
        stack.setItemMeta(meta);
        event.getDrops().add(stack);
    }
}
