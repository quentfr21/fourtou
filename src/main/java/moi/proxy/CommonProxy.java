package moi.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moi.config.conf;
import moi.craftlistenner.craftlistenner;
import moi.mob.entitymobregistry;
import moi.recipe.reg;


public class CommonProxy {
	

    public void preInit(FMLPreInitializationEvent e) {
    	
    	conf.configs(e);
    	reg.regblock();
    	reg.regitem();
		reg.ajoutrecette();
		
		FMLCommonHandler.instance().bus().register(new craftlistenner());
		
    }

    public void init(FMLInitializationEvent e) {
    	
    	entitymobregistry.registerEntity();
    	 
    	reg.ajouteach();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}