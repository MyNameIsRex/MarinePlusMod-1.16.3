package com.mnir.marineplus.client.model;

import com.mnir.marineplus.entities.SwordfishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SwordfishModel <T extends SwordfishEntity> extends EntityModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer tailFin;

    public SwordfishModel()
    {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 8).addBox(-20.0F, -7.0F, 0.0F, 12.0F, 1.0F, 0.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(8.0F, 17.5F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-16.0F, -1.5F, -1.0F, 16.0F, 3.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 5).addBox(-14.0F, 1.5F, -1.0F, 9.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 9).addBox(-13.0F, -2.5F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(16, 16).addBox(-12.0F, -4.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(12, 15).addBox(-12.0F, 2.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(8, 14).addBox(-6.0F, 1.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(14, 9).addBox(-11.0F, 3.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-10.0F, 5.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(16, 15).addBox(-5.0F, 3.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(8, 16).addBox(-11.0F, -5.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(0, 17).addBox(-10.0F, -6.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        tailFin = new ModelRenderer(this);
        tailFin.setRotationPoint(0.0F, 24.0F, 0.0F);
        tailFin.setTextureOffset(4, 14).addBox(9.0F, -10.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(16, 13).addBox(10.0F, -11.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(6, 12).addBox(11.0F, -12.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(0, 12).addBox(11.0F, -3.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(16, 11).addBox(10.0F, -4.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(0, 14).addBox(8.0F, -8.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(12, 12).addBox(9.0F, -6.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1.0F;
        if (!entityIn.isInWater())
        {
            f = 1.5F;
        }
        this.tailFin.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tailFin.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
