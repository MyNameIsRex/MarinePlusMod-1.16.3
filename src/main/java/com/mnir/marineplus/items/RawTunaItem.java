package com.mnir.marineplus.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class RawTunaItem extends AbstractModFishItem
{
    public RawTunaItem()
    {
        super(new Item.Properties().food((new Food.Builder()
                .hunger(2)
                .saturation(0.2F)
                .build())));
    }
}
