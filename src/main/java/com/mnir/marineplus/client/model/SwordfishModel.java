package com.mnir.marineplus.client.model;

import com.mnir.marineplus.entities.SwordfishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.CodModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SwordfishModel <T extends SwordfishEntity> extends EntityModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer tailFin;

    public SwordfishModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(-14.0F, 17.5F, 0.0F);
        setRotationAngle(head, 0.0F, -1.5708F, 0.0F);
        head.setTextureOffset(0, 8).addBox(-20.0F, -0.5F, -14.0F, 12.0F, 1.0F, 0.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 17.5F, 0.0F);
        setRotationAngle(body, 0.0F, -1.5708F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-8.0F, -1.5F, -1.0F, 16.0F, 3.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 5).addBox(-6.0F, 1.5F, -1.0F, 9.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 9).addBox(-5.0F, -2.5F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(16, 16).addBox(-4.0F, -4.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(12, 15).addBox(-4.0F, 2.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(8, 14).addBox(2.0F, 1.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(14, 9).addBox(-3.0F, 3.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-2.0F, 5.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(16, 15).addBox(3.0F, 3.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(8, 16).addBox(-3.0F, -5.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(0, 17).addBox(-2.0F, -6.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        tailFin = new ModelRenderer(this);
        tailFin.setRotationPoint(0.0F, 17.5F, 8.0F);
        setRotationAngle(tailFin, 0.0F, -1.5708F, 0.0F);
        tailFin.setTextureOffset(4, 14).addBox(1.0F, -3.5F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(16, 13).addBox(2.0F, -4.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(6, 12).addBox(3.0F, -5.5F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(0, 12).addBox(3.0F, 3.5F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(16, 11).addBox(2.0F, 2.5F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(0, 14).addBox(0.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
        tailFin.setTextureOffset(12, 12).addBox(1.0F, 0.5F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }

        this.tailFin.rotateAngleY = -f * 0.25F * MathHelper.sin(0.6F * ageInTicks) - 1.5708F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tailFin.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
