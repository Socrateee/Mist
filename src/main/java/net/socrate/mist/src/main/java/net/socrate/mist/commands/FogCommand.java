package net.socrate.mist.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class FogCommand {


    public static void commandFog(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(Commands.literal("fog").executes((command) -> {

            return execute(command);

        }));
    }

    private static int execute(CommandContext<CommandSourceStack> command) {

        if (command.getSource().getEntity() instanceof Player) {

            Player player = (Player) command.getSource().getEntity();
            player.sendMessage(new TextComponent("test"), player.getUUID());


        //    RenderSystem.setShaderFogStart(0);
          //  RenderSystem.setShaderFogEnd(10);



        }

        return Command.SINGLE_SUCCESS ;
    }



}


