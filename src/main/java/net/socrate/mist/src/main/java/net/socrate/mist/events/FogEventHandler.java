package net.socrate.mist.events;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.socrate.mist.Mist;

import java.awt.*;


@Mod.EventBusSubscriber(modid = Mist.MOD_ID)
public class FogEventHandler {

    @SubscribeEvent
    public static void onRenderFogColors(EntityViewRenderEvent.FogColors event) {

        if (event.getCamera().getEntity() instanceof Player) {

            Player player = (Player) event.getCamera().getEntity();

            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();

            double[] c = {Math.abs(10),Math.abs(100),Math.abs(10)} ;

            int r = 10;

            double cal = Math.sqrt( Math.pow(x-c[0], 2) + Math.pow(y-c[1], 2) + Math.pow(z-c[2], 2)  ) ;
            player.sendMessage(new TextComponent("rayon Color"+cal), player.getUUID() );




            if (r < cal ) {


                Color color = Color.decode("#A6EC06");
                float red = color.getRed();
                float green = color.getGreen();
                float blue = color.getBlue();

                final float[] fogColors = {red / 255F, green / 255F, blue / 255F};
                event.setRed(fogColors[0]);
                event.setGreen(fogColors[1]);
                event.setBlue(fogColors[2]);


            }
        }
    }


    @SubscribeEvent
    public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {

        if (event.getCamera().getEntity() instanceof Player) {

            Player player = (Player) event.getCamera().getEntity();

            double x = player.getX();
            double y = player.getY() ;
            double z = player.getZ();

            double[] c = {Math.abs(10),Math.abs(100),Math.abs(10)} ;

            int r = 10;
            double cal = Math.sqrt( Math.pow(x-c[0], 2) + Math.pow(y-c[1], 2) + Math.pow(z-c[2], 2)  ) ;
            player.sendMessage(new TextComponent("rayon Fog"+cal), player.getUUID() );



            if (r < cal ) {


                RenderSystem.setShaderFogStart(0);
                RenderSystem.setShaderFogEnd(30);

            }
        }


    }










}
