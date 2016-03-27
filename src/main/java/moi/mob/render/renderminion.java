package moi.mob.render;

import moi.mob.entityminion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class renderminion extends RenderLiving{

	private static final ResourceLocation mobTextures = new ResourceLocation("armormod:textures/entity/minion.png");
	
	public renderminion(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
	}
	
	protected ResourceLocation getEntityTexture(entityminion entity){
		
		return  mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((entityminion)entity);
	}

}
