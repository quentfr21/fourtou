package moi.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class blockflamablestone extends Block {

	public blockflamablestone(Material material,String name) {
		super(material);
		this.setBlockName(name);
		this.setBlockTextureName("stone");
		this.setHardness(50F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	 public int quantityDropped(Random p_149745_1_)
	    {
	        return 0;
	    }
	 public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	    {
		 
		 return true;
	    }
	 public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	    {
		 return 20;
		 
	    }
	 public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	    {
		 return 3000;
		 
	    }
	 public int getMobilityFlag()
	    {
		 return 0;
		 
	    }

}
