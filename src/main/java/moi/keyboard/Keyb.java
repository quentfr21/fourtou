package moi.keyboard;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class Keyb {
	
	// public static KeyBinding bot;
	    public static KeyBinding flight;
	    public static KeyBinding boost;
		public static KeyBinding nv;

	    public static void init() {
	        
	   //     bot = new KeyBinding("key.bot", Keyboard.KEY_LCONTROL, "key.categories.modmoi");
	        
	       flight = new KeyBinding("key.flight", Keyboard.KEY_F, "key.categories.modmoi");
	       
	       boost = new KeyBinding("key.boost", Keyboard.KEY_LCONTROL, "key.categories.modmoi");
	       
	       nv = new KeyBinding("key.nvision", Keyboard.KEY_N, "key.categories.modmoi");

	        // Register both KeyBindings to the ClientRegistry
	        ClientRegistry.registerKeyBinding(flight);
	    //    ClientRegistry.registerKeyBinding(bot);
	        ClientRegistry.registerKeyBinding(boost);
	        ClientRegistry.registerKeyBinding(nv);
	    }
	   
}
