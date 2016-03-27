package moi.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.ColorizerGrass;

public class blockstair extends BlockStairs{

	public blockstair(Block block, int i,String name,int opacity,float light) {
		super(block,i);
		
		//this.setBlockTextureName("armormod:" + name);
		this.setBlockName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1F);
        this.setResistance(3.0F);
        this.setLightOpacity(opacity);
		this.setLightLevel(light);
	}

	 
	

}
