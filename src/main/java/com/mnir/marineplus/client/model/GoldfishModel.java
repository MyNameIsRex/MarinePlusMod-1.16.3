package com.mnir.marineplus.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class GoldfishModel <T extends Entity> extends EntityModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leftTailFin;
    private final ModelRenderer rightTailFin;

    public GoldfishModel()
    {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 4).addBox(-1.0F, -10.0F, -8.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-1.0F, -11.0F, -7.0F, 2.0F, 4.0F, 9.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-1.0F, -10.0F, 2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 7).addBox(0.0F, -12.0F, -3.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(13, 5).addBox(0.0F, -7.0F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(0.0F, -8.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

        leftTailFin = new ModelRenderer(this);
        leftTailFin.setRotationPoint(0.0F, 15.0F, 4.0F);
        setRotationAngle(leftTailFin, 0.0F, 0.2182F, 0.0F);
        leftTailFin.setTextureOffset(13, 4).addBox(0.0F, 1.0F, 0.9397F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        leftTailFin.setTextureOffset(4, 15).addBox(0.0F, -3.0F, 1.9397F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        leftTailFin.setTextureOffset(13, 2).addBox(0.0F, -4.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        leftTailFin.setTextureOffset(13, 0).addBox(0.0F, -3.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        leftTailFin.setTextureOffset(12, 13).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        leftTailFin.setTextureOffset(13, 1).addBox(0.0F, 2.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        leftTailFin.setTextureOffset(2, 15).addBox(0.0F, 1.0F, 1.9397F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        leftTailFin.setTextureOffset(13, 3).addBox(0.0F, -2.0F, 0.9397F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        leftTailFin.setTextureOffset(4, 5).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

        rightTailFin = new ModelRenderer(this);
        rightTailFin.setRotationPoint(0.0F, 15.0F, 4.0F);
        setRotationAngle(rightTailFin, 0.0F, -0.2182F, 0.0F);
        rightTailFin.setTextureOffset(13, 4).addBox(0.0F, 1.0F, 0.9397F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        rightTailFin.setTextureOffset(4, 15).addBox(0.0F, -3.0F, 1.9397F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        rightTailFin.setTextureOffset(13, 2).addBox(0.0F, -4.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        rightTailFin.setTextureOffset(13, 0).addBox(0.0F, -3.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        rightTailFin.setTextureOffset(12, 13).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        rightTailFin.setTextureOffset(13, 1).addBox(0.0F, 2.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        rightTailFin.setTextureOffset(2, 15).addBox(0.0F, 1.0F, 1.9397F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        rightTailFin.setTextureOffset(13, 3).addBox(0.0F, -2.0F, 0.9397F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        rightTailFin.setTextureOffset(4, 5).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1.0F;
        if (!entityIn.isInWater())
        {
            f = 1.5F;
        }

        this.leftTailFin.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
        this.rightTailFin.rotateAngleY = f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        leftTailFin.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        rightTailFin.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
