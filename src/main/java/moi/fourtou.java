package moi;


import moi.compat.galac;
import moi.compat.solarexp;
import moi.proxy.CommonProxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = fourtou.modid, name = "armure de ouf", version = "1.4")

public class fourtou {
	@SidedProxy(clientSide="moi.proxy.ClientProxy", serverSide="moi.proxy.ServerProxy")
	public static CommonProxy proxy;


	
	public static final String modid = "foutou";

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		
		
		proxy.preInit(e);

	}
	

	@EventHandler
	public void init(FMLInitializationEvent e) {
		
		

		proxy.init(e);
	

	}

	

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
		proxy.postInit(e);
		

	}
	@Mod.EventHandler
	   public void afterModsLoaded(FMLPostInitializationEvent evt)
	   {
  
	    if (Loader.isModLoaded("SolarExpansion")) {
	     try
      {
	      solarexp.addnewrecipe();
	      }
      catch (Exception e) {}
	    }
	   
	if (Loader.isModLoaded("GalacticraftMars")) {
	     try
     {
	      galac.init();
	      }
     catch (Exception e) {}
	    }
	   }
	
	

}
