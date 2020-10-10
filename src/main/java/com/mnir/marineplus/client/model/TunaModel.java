package com.mnir.marineplus.client.model;

import com.mnir.marineplus.entities.TunaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class TunaModel <T extends TunaEntity> extends EntityModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer backFin;

    public TunaModel()
    {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 19.0F, -6.0F);
        head.setTextureOffset(0, 28).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-1.0F, -6.0F, -6.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
        body.setTextureOffset(13, 0).addBox(-1.0F, -7.0F, -6.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(16, 7).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(0, 3).addBox(0.0F, -3.0F, -4.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(26, 0).addBox(0.0F, -3.0F, -5.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 3).addBox(0.0F, -9.0F, -5.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(0.0F, -8.0F, -4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(26, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(26, 0).addBox(0.0F, -8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

        backFin = new ModelRenderer(this);
        backFin.setRotationPoint(0.0F, 19.0F, 3.0F);
        backFin.setTextureOffset(6, 9).addBox(0.0F, -3.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        backFin.setTextureOffset(6, 9).addBox(0.0F, -4.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        backFin.setTextureOffset(10, 9).addBox(0.0F, -4.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        backFin.setTextureOffset(0, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);
        backFin.setTextureOffset(6, 9).addBox(0.0F, 1.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        backFin.setTextureOffset(6, 9).addBox(0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        backFin.setTextureOffset(10, 9).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch)
    {
        float f = 1.0F;
        if (!entityIn.isInWater())
        {
            f = 1.5F;
        }

        this.backFin.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        backFin.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
