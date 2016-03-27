
package moi.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Modelminion extends ModelBase
{
  //fields
    ModelRenderer corp;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer bras1;
    ModelRenderer bras2;
  
  public Modelminion()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      corp = new ModelRenderer(this, 23, 0);
      corp.addBox(0F, 0F, 0F, 7, 11, 7);
      corp.setRotationPoint(-3F, 7F, -4F);
      corp.setTextureSize(64, 32);
      corp.mirror = true;
      setRotation(corp, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 10, 0);
      leg1.addBox(0F, 0F, 0F, 2, 6, 2);
      leg1.setRotationPoint(2F, 17F, -2F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 0);
      leg2.addBox(0F, 0F, 0F, 2, 6, 2);
      leg2.setRotationPoint(-1F, 17F, 0F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, -3.141593F, 0F);
      bras1 = new ModelRenderer(this, 4, 9);
      bras1.addBox(0F, 0F, 0F, 1, 6, 1);
      bras1.setRotationPoint(3F, 11F, -1F);
      bras1.setTextureSize(64, 32);
      bras1.mirror = true;
      setRotation(bras1, 0F, 0F, -0.6981317F);
      bras2 = new ModelRenderer(this, 0, 9);
      bras2.addBox(0F, 0F, 0F, 1, 6, 1);
      bras2.setRotationPoint(-3F, 11F, -1F);
      bras2.setTextureSize(64, 32);
      bras2.mirror = true;
      setRotation(bras2, 0F, 0F, 0.6981317F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    corp.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    bras1.render(f5);
    bras2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
/* this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;  
   this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  // this.leg1.rotateAngleY = 0.0F;
   //this.leg2.rotateAngleY = 0.0F;
  */  
    this.bras1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;  
    this.bras2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  /*  
    this.leg1.rotateAngleX = MathHelper.cos(f2 * 0.6662F) * 1.4F * f3;
    this.leg2.rotateAngleX = MathHelper.cos(f2 * 0.6662F + (float)Math.PI) * 1.4F * f3;*/
    
  /*  this.bras1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.bras2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.bras1.rotateAngleZ = 0.0F;
    this.bras2.rotateAngleZ = 0.0F;
    this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.leg1.rotateAngleY = 0.0F;
    this.leg2.rotateAngleY = 0.0F;*/
    
    
  }

}
