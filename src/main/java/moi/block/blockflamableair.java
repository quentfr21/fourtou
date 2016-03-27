package moi.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class blockflamableair extends Block{
	
	public blockflamableair(Material material,String name) {
		super(material);
		this.setBlockName(name);
		this.setBlockTextureName("stone");
		//this.setBlockTextureName("armormod:" + name);
		this.setHardness(2.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        return null;
	    }
	 
	 public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_)
	    {
	        return true;
	    }
	
	 public int quantityDropped(Random p_149745_1_)
	    {
	        return 1;
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
