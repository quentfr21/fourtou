package moi.mob.render;

import moi.mob.entitycaradoc;
import moi.mob.entityminion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class rendercaradoc extends RenderLiving{

	private static final ResourceLocation mobTextures = new ResourceLocation("armormod:textures/entity/caradoc.png");
	private static final ResourceLocation mobTextures1 = new ResourceLocation("armormod:textures/entity/caradoctamed.png");
	
	public rendercaradoc(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
	}
	
	protected ResourceLocation getEntityTexture(entitycaradoc entity){
		if (entity.isTamed()){
		return mobTextures1;}
		return mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((entitycaradoc)entity);
	}

}
