package com.mnir.marineplus;

import com.mnir.marineplus.entities.GoldfishEntity;
import com.mnir.marineplus.entities.SwordfishEntity;
import com.mnir.marineplus.entities.TunaEntity;
import com.mnir.marineplus.init.ModInits;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("marineplus")
public class MarinePlusMod
{
    public static final String MODID = "marineplus";
    public static final Logger LOGGER = LogManager.getLogger();

    public MarinePlusMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ModInits.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() ->
        {
            GlobalEntityTypeAttributes.put(ModInits.TUNA.get(), TunaEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModInits.SWORDFISH.get(), SwordfishEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModInits.GOLDFISH.get(), GoldfishEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {}
}
