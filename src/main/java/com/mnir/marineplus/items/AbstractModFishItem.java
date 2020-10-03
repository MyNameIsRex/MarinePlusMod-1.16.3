package com.mnir.marineplus.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class AbstractModFishItem extends Item
{
    public AbstractModFishItem(Properties properties)
    {
        super(new Item.Properties().
                group(ItemGroup.FOOD).
                food(new Food.Builder()
                        .setAlwaysEdible()
                        .build()));
    }
}
