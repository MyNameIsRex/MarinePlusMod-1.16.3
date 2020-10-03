package com.mnir.marineplus.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class RawTunaItem extends Item
{
    public RawTunaItem()
    {
        super(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()
                .hunger(2)
                .saturation(0.2F)
                .setAlwaysEdible()
                .meat()
                .build())));
    }
}
