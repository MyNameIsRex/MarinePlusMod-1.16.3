package com.mnir.marineplus.util;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.client.render.SwordfishRenderer;
import com.mnir.marineplus.client.render.TunaRenderer;
import com.mnir.marineplus.init.ModInits;
import com.mnir.marineplus.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MarinePlusMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModInits.TUNA.get(), TunaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModInits.SWORDFISH.get(),
                SwordfishRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
    {
        ModSpawnEggItem.initSpawnEggs();
    }
}
