package moi.item;

import java.util.List;

import moi.config.conf;
import moi.recipe.reg;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class itemspeed extends Item {
	
	public static int volevite = 4;
	public static int saut = 6;
	
	public itemspeed(String name){
		super();
		
		this.setTextureName("armormod:" + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
		
	}
	
	
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
	
		
		if (!world.isRemote && !player.isSneaking())
		{
			int x = (int) player.posX;
			int y = (int) player.posY;
			int z = (int) player.posZ;
			int d = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360) + 0.50) & 3;
			
		//	System.out.println(d);
		
				if (d == 0 && world.getBlock(x-1,y,z+1) == Blocks.air){
					world.setBlock(x-1,y,z+1,reg.blockcass);
					stack.damageItem(1,player);
					return stack;
						}
				
				else if (d == 1 && world.getBlock(x-2,y,z) == Blocks.air){
					world.setBlock(x-2,y,z,reg.blockcass);
					stack.damageItem(1,player);
					return stack;
				//	stack.damageItem(1,player);
					}
				else if (d == 2 && world.getBlock(x-1,y,z-1) == Blocks.air){
					world.setBlock(x-1,y,z-1,reg.blockcass);
					stack.damageItem(1,player);
					return stack;
				//	stack.damageItem(1,player);
					}
				else if (d == 3 && world.getBlock(x,y,z) == Blocks.air){
					world.setBlock(x,y,z,reg.blockcass);
					stack.damageItem(1,player);
					return stack;
				//	stack.damageItem(1,player);
					}
			
		}
		//stack.damageItem(1,player);
		return stack;
	}
		
	  public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
			
	    	
	 		list.add("pose un block devant nos pied");
			
		}
	
	
}
