
	package moi.mob.render;

	import moi.mob.entityperceval;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


	public class renderperceval extends RenderLiving{

		private static final ResourceLocation mobTextures = new ResourceLocation("armormod:textures/entity/perceval.png");
		private static final ResourceLocation mobTextures1 = new ResourceLocation("armormod:textures/entity/percevaltamed.png");
		
		public renderperceval(ModelBase par1ModelBase, float par2) {
			super(par1ModelBase, par2);
			
		}
		
		protected ResourceLocation getEntityTexture(entityperceval entity){
			if (entity.isTamed()){
				
				return mobTextures1;
			}
			
			return mobTextures;
		}
		
		protected ResourceLocation getEntityTexture(Entity entity){
			return this.getEntityTexture((entityperceval)entity);
		}

	}


