package io.github.russia9.boatdeny;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.command.SendCommandEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.serializer.TextSerializers;

@Plugin(
        id = "boatdeny",
        name = "BoatDeny",
        version = "0.0.1",
        description = "Plugin to disable commands in boats and minecarts",
        authors = "Russia9")
public class BoatDeny {
    @Listener
    public void onCommandSend(SendCommandEvent event) {
        Object src = event.getSource();
        if (src instanceof Player) {
            Player player = (Player) src;
            if(player.getVehicle().isPresent() && !player.hasPermission("boatdeny.bypass")) {
                player.sendMessage(TextSerializers.FORMATTING_CODE.deserialize("&cНельзя выполнять команды во время езды!"));
                event.setCancelled(true);
            }
        }
    }
}
