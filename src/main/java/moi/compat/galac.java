package moi.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import moi.item.thermalprotect;
import moi.recipe.reg;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class galac {

	public static Item protect = new thermalprotect("testprotect");
	public static void init(){
		
		
		GameRegistry.registerItem(protect, "essai");
		
		GameRegistry.addShapedRecipe(new ItemStack(protect, 1, 0), new Object[] { "XY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'),new ItemStack(AsteroidsItems.thermalPadding,1,0) });
		GameRegistry.addShapedRecipe(new ItemStack(protect, 1, 1), new Object[] { "XY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'),new ItemStack(AsteroidsItems.thermalPadding,1,1) });
		GameRegistry.addShapedRecipe(new ItemStack(protect, 1, 2), new Object[] { "XY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'),new ItemStack(AsteroidsItems.thermalPadding,1,2) });
		GameRegistry.addShapedRecipe(new ItemStack(protect, 1, 3), new Object[] { "XY", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'),new ItemStack(AsteroidsItems.thermalPadding,1,3) });
	}
}
