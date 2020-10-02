package com.mnir.marineplus.client.render;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.client.model.TunaModel;
import com.mnir.marineplus.entities.TunaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TunaRenderer extends MobRenderer<TunaEntity, TunaModel<TunaEntity>>
{
    protected static final ResourceLocation TEXTURE = new ResourceLocation(MarinePlusMod.MODID,
            "textures/entity/tuna.png");

    public TunaRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new TunaModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(TunaEntity entity)
    {
        return TEXTURE;
    }
}
