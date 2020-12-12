package com.mnir.marineplus.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PlatinumBlock extends Block
{
    public PlatinumBlock()
    {
        super(AbstractBlock.Properties.create(Material.IRON).
                hardnessAndResistance(5.0F, 6.0F).
                harvestLevel(3).
                harvestTool(ToolType.PICKAXE).
                sound(SoundType.METAL));
    }
}
