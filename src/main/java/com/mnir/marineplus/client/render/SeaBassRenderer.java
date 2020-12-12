package com.mnir.marineplus.client.render;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.client.model.SeaBassModel;
import com.mnir.marineplus.entities.SeaBassEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SeaBassRenderer extends MobRenderer<SeaBassEntity, SeaBassModel<SeaBassEntity>>
{
    protected static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(MarinePlusMod.MODID,
            "textures/entity/sea_bass.png");

    public SeaBassRenderer(EntityRendererManager rendererManager)
    {
        super(rendererManager, new SeaBassModel<>(), 0.35F);
    }

    @Override
    public ResourceLocation getEntityTexture(SeaBassEntity entity) { return TEXTURE_LOCATION; }
}
