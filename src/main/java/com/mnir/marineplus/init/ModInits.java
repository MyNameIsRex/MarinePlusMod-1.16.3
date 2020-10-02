package com.mnir.marineplus.init;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.blocks.PlatinumBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModInits
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MarinePlusMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MarinePlusMod.MODID);

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MarinePlusMod.LOGGER.debug("Marine Plus Blocks Registered!");

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MarinePlusMod.LOGGER.debug("Marine Plus Items Registered! ");
    }

    //Items

    //Blocks
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", PlatinumBlock::new);

    //Block Item
    public static final RegistryObject<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("platinum_block", () ->
            new BlockItem(PLATINUM_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(16)));
}
