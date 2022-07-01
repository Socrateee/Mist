package net.socrate.mist.events;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.socrate.mist.Mist;
import net.socrate.mist.commands.FogCommand;

@Mod.EventBusSubscriber(modid = Mist.MOD_ID)

public class ModEvent {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {

        FogCommand.commandFog(event.getDispatcher());

    }
}
