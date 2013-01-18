package fr.noogotte.pvpheaddrop;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PvPListener implements Listener {

    private PvPHeadDrop plugin;

    public PvPListener(PvPHeadDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        if(!(new Random().nextInt(100) < plugin.getRate())) {
            return;
        }

        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        SkullMeta meta = (SkullMeta) stack.getItemMeta();
        Player killer = event.getEntity().getKiller();
        meta.setOwner(killer.getName());

        if (plugin.isRenameAllowed()) {
            meta.setDisplayName("Tête de " + killer.getName());
        }

        stack.setItemMeta(meta);
        event.getDrops().add(stack);
    }
}
