package moi.proxy;


import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import moi.craftlistenner.craftlistenner;
import moi.keyboard.Keyb;
import moi.keyboard.handlekeb;
import moi.mob.entitycaradoc;
import moi.mob.entityminion;
import moi.mob.entityperceval;
import moi.mob.model.Modelcaradoc;
import moi.mob.model.Modelminion;
import moi.mob.model.Modelperceval;
import moi.mob.render.rendercaradoc;
import moi.mob.render.renderminion;
import moi.mob.render.renderperceval;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	


	
	 @Override
	    public void preInit(FMLPreInitializationEvent e) {
	        super.preInit(e);
	        
	        Keyb.init();
	        FMLCommonHandler.instance().bus().register(new handlekeb());
	    }

	
	@Override
	public void init(FMLInitializationEvent e) {
			super.init(e);
		
		RenderingRegistry.registerEntityRenderingHandler(entityminion.class,new renderminion(new Modelminion(), 0));
		RenderingRegistry.registerEntityRenderingHandler(entityperceval.class,new renderperceval(new Modelperceval(), 0));
		RenderingRegistry.registerEntityRenderingHandler(entitycaradoc.class,new rendercaradoc(new Modelcaradoc(), 0));
		
		 }
	
	 @Override
	    public void postInit(FMLPostInitializationEvent e) {
	        super.postInit(e);
	    }
	

}
