package com.mnir.marineplus.init;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.blocks.PlatinumBlock;
import com.mnir.marineplus.entities.GoldfishEntity;
import com.mnir.marineplus.entities.SeaBassEntity;
import com.mnir.marineplus.entities.SwordfishEntity;
import com.mnir.marineplus.entities.TunaEntity;
import com.mnir.marineplus.items.CookedTunaItem;
import com.mnir.marineplus.items.ModSpawnEggItem;
import com.mnir.marineplus.items.RawTunaItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModInits
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MarinePlusMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MarinePlusMod.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MarinePlusMod.MODID);

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MarinePlusMod.LOGGER.debug("Marine Plus Blocks Registered!");

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MarinePlusMod.LOGGER.debug("Marine Plus Items Registered! ");

        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MarinePlusMod.LOGGER.debug("Marine Plus Entities Registered! ");
    }

    //Entities
    public static final RegistryObject<EntityType<TunaEntity>> TUNA = ENTITIES.register("tuna", () ->
            EntityType.Builder.create(TunaEntity::new, EntityClassification.WATER_CREATURE).size(0.5F, 0.3F)
                    .build(new ResourceLocation(MarinePlusMod.MODID, "tuna").toString()));
    public static final RegistryObject<EntityType<SwordfishEntity>> SWORDFISH = ENTITIES.register("swordfish", () ->
            EntityType.Builder.create(SwordfishEntity::new, EntityClassification.WATER_CREATURE).size(0.5F,0.3F)
                    .build(new ResourceLocation(MarinePlusMod.MODID, "swordfish").toString()));
    public static final RegistryObject<EntityType<GoldfishEntity>> GOLDFISH = ENTITIES.register("goldfish", () ->
            EntityType.Builder.create(GoldfishEntity::new, EntityClassification.WATER_CREATURE).size(0.5F, 0.3F)
                    .build(new ResourceLocation(MarinePlusMod.MODID, "goldfish").toString()));
    public static final RegistryObject<EntityType<SeaBassEntity>> SEA_BASS = ENTITIES.register("sea_bass", () ->
            EntityType.Builder.create(SeaBassEntity::new, EntityClassification.WATER_CREATURE).size(0.5F, 0.3F)
                    .build(new ResourceLocation(MarinePlusMod.MODID, "sea_bass").toString()));

    //Spawn egg Items
    public static final RegistryObject<ModSpawnEggItem> TUNA_SPAWN_EGG = ITEMS.register("tuna_spawn_egg",
            () -> new ModSpawnEggItem(TUNA, 0x889CC1, 0xA3A9B2, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> SWORDFISH_SPAWN_EGG = ITEMS.register("swordfish_spawn_egg",
            () -> new ModSpawnEggItem(SWORDFISH, 0x155370, 0x9a9fa1,
                    new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> GOLDFISH_SPAWN_EGG = ITEMS.register("goldfish_spawn_egg",
            () -> new ModSpawnEggItem(GOLDFISH, 0xFF7819, 0xFFC519,
                    new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> SEA_BASS_SPAWN_EGG = ITEMS.register("sea_bass_spawn_egg",
            () -> new ModSpawnEggItem(SEA_BASS, 0xADADAD, 0x848484,
                    new Item.Properties().group(ItemGroup.MISC)));

    //Fish Items
    public static final RegistryObject<RawTunaItem> RAW_TUNA = ITEMS.register("raw_tuna",
            RawTunaItem::new);
    public static final RegistryObject<CookedTunaItem> COOKED_TUNA = ITEMS.register("cooked_tuna",
            CookedTunaItem::new);

    //Blocks
    public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", PlatinumBlock::new);

    //Block Item
    public static final RegistryObject<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("platinum_block", () ->
            new BlockItem(PLATINUM_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(16)));

}
