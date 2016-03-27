package moi.compat;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import solarexpansion.init.SEGameObjects;
import cpw.mods.fml.common.registry.GameRegistry;

public class solarexp {
	
	public static void addnewrecipe(){
		
		
		 GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SEGameObjects.SolarCoreHardened), new Object[] { " A ", "ABA", " A ", 
		      Character.valueOf('A'), "gemDiamond", 
		      Character.valueOf('B'), SEGameObjects.SolarCoreLeadstone }));
		 
		 GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SEGameObjects.SolarCoreRedstone), new Object[] { " A ", "ABA", " A ", 
		      Character.valueOf('A'), "gemQuartz", 
		      Character.valueOf('B'), SEGameObjects.SolarCoreHardened }));
		 
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SEGameObjects.SolarCoreResonant), new Object[] { " A ", "ABA", " A ", 
		      Character.valueOf('A'), "gemEmerald", 
		      Character.valueOf('B'), SEGameObjects.SolarCoreRedstone }));
		    
		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SEGameObjects.SolarCoreLeadstone), new Object[] { " A ", "ABA", " A ", 
		        Character.valueOf('A'), "blockIron", 
		        Character.valueOf('B'), "ingotIron" }));
		    

		    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(SEGameObjects.PhotovoltaicCell), new Object[] { "AAA", "BBB", "CCC", 
		      Character.valueOf('A'), "paneGlass", 
		      Character.valueOf('B'), "shardLapis", 
		      Character.valueOf('C'), "nuggetGold" }));
		
		   
		    		
		    		  ItemStack steel = new ItemStack(SEGameObjects.SteelIngot,1);
		    		  
		    GameRegistry.addSmelting(Items.iron_ingot, steel, 0.5f);
		    
	}

}
