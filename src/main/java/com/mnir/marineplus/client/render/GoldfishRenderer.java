package com.mnir.marineplus.client.render;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.client.model.GoldfishModel;
import com.mnir.marineplus.entities.GoldfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GoldfishRenderer extends MobRenderer<GoldfishEntity, GoldfishModel<GoldfishEntity>>
{
    protected static final ResourceLocation TEXTURE = new ResourceLocation(MarinePlusMod.MODID,
            "textures/entity/goldfish.png");

    public GoldfishRenderer(EntityRendererManager rendererManagerIn)
    {
        super(rendererManagerIn, new GoldfishModel<>(), 0.35F);
    }

    @Override
    public ResourceLocation getEntityTexture(GoldfishEntity entity) { return TEXTURE; }
}
