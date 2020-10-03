package com.mnir.marineplus.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class CookedTunaItem extends Item
{
    public CookedTunaItem()
    {
        super(new Item.Properties().group(ItemGroup.FOOD).
                food(new Food.Builder().
                        hunger(6).
                        saturation(9.6F).
                        setAlwaysEdible().
                        meat().build()));
    }
}
