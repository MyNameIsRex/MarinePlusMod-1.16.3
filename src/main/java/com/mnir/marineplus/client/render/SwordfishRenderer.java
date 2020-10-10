package com.mnir.marineplus.client.render;

import com.mnir.marineplus.MarinePlusMod;
import com.mnir.marineplus.client.model.SwordfishModel;
import com.mnir.marineplus.entities.SwordfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SwordfishRenderer extends MobRenderer<SwordfishEntity, SwordfishModel<SwordfishEntity>>
{
    protected static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(MarinePlusMod.MODID,
            "textures/entity/swordfish.png");

    public SwordfishRenderer(EntityRendererManager rendererManager)
    {
        super(rendererManager, new SwordfishModel<>(), 0.35F);
    }

    @Override
    public ResourceLocation getEntityTexture(SwordfishEntity entity) { return TEXTURE_LOCATION; }
}
