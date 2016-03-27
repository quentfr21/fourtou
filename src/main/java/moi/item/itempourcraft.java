package moi.item;

import java.util.List;

import moi.recipe.reg;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class itempourcraft extends Item {
	
	public itempourcraft(String name){
		super();
		
		this.setTextureName("armormod:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabCombat);
		
		
	}

   
}
