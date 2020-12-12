package com.mnir.marineplus.client.model;

import com.mnir.marineplus.entities.SeaBassEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.CodModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SeaBassModel <T extends SeaBassEntity> extends EntityModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer tailFin;

    public SeaBassModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 17.5F, -5.0F);
        head.setTextureOffset(13, 4).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(13, 0).addBox(-1.0F, 0.5F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 17.5F, 4.0F);
        body.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -9.0F, 2.0F, 3.0F, 9.0F, 0.0F, false);
        body.setTextureOffset(10, 13).addBox(-1.0F, -2.5F, -9.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(0, 12).addBox(-1.0F, 1.5F, -10.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(6, 5).addBox(0.0F, -4.5F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(10, 10).addBox(0.0F, 2.5F, -3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 10).addBox(0.0F, 1.5F, -4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(6, 4).addBox(0.0F, 3.5F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 11).addBox(0.0F, 2.5F, -9.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 4).addBox(0.0F, -3.5F, -8.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(0, 3).addBox(0.0F, -2.5F, -4.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(10, 11).addBox(0.0F, -3.5F, -4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

        tailFin = new ModelRenderer(this);
        tailFin.setRotationPoint(0.0F, 17.5F, 4.0F);
        tailFin.setTextureOffset(0, 0).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);
        tailFin.setTextureOffset(6, 0).addBox(0.0F, -2.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        tailFin.setTextureOffset(4, 6).addBox(0.0F, -3.5F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tailFin.setTextureOffset(0, 0).addBox(0.0F, -2.5F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        tailFin.setTextureOffset(6, 2).addBox(0.0F, 0.5F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        tailFin.setTextureOffset(0, 6).addBox(0.0F, 2.5F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tailFin.setTextureOffset(6, 6).addBox(0.0F, 1.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1f;
        if (!entityIn.isInWater())
        {
            f = 1.5F;
        }

        this.tailFin.rotateAngleY = -f * 0.25F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        tailFin.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
