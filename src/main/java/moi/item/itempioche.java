package moi.item;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;

import moi.recipe.reg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;


public class itempioche extends ItemPickaxe {
	
	int test = 0;
	
	


	public itempioche(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName("armormod:" + unlocalizedName);
		
	}
	
	 public boolean getIsRepairable(ItemStack stack, ItemStack stack1){
			
		 if (stack1.getItem() == Items.emerald){
			
		 return true;
		 }
		 return false;
	 }
	
	
	public Set<String> getToolClasses(ItemStack stack) {
	    return ImmutableSet.of("pickaxe", "spade", "axe");
	}
	
	
	public float func_150893_a(ItemStack stack, Block block) {
	    if (block.getMaterial() == Material.wood || block.getMaterial() == Material.vine || block.getMaterial() == Material.plants)
	        return this.efficiencyOnProperMaterial;
	    return effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : super.func_150893_a(stack, block);
	}
	
	public boolean func_150897_b(Block block) {
	    return effectiveAgainst.contains(block) ? true : super.func_150897_b(block);
	}
	
	private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
		    Blocks.planks, Blocks.cactus, Blocks.bookshelf, Blocks.log, Blocks.log2, 
		    Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin,Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
		    Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, 
		    Blocks.soul_sand, Blocks.mycelium, Blocks.leaves, Blocks.leaves2, Blocks.glowstone,Blocks.glass,Blocks.piston,Blocks.glass_pane,Blocks.sticky_piston,});
	
	
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		
		if (stack.getTagCompound() == null){
			stack.setTagCompound(new NBTTagCompound());
		stack.stackTagCompound.setInteger("mode",3);}
		
		if (stack.getTagCompound().getInteger("mode") == 3 && !world.isRemote && !player.isSneaking()){ 
			stack.stackTagCompound.setInteger("mode",1);
			world.playSoundEffect(player.posX, player.posY, player.posZ, "armormod:on", 1, 1);
			stack.addEnchantment(Enchantment.silkTouch, 1);
			player.addChatComponentMessage(new ChatComponentText("silktouch et Ore Dictionnaire active"));
						
		}
			
		else if (stack.getTagCompound().getInteger("mode") == 1 && !world.isRemote && !player.isSneaking())	{
			stack.stackTagCompound.setInteger("mode",2);
				
				
				if (stack.isItemEnchanted()){
				NBTTagList tl = stack.stackTagCompound.getTagList("ench", 10); 
				 for(int i=0;i<tl.tagCount();i++){
					 NBTTagCompound nbtl = (NBTTagCompound) tl.getCompoundTagAt(i);
					 if(nbtl.getShort("id") == Enchantment.silkTouch.effectId){
					 tl.removeTag(i);
					 player.addChatComponentMessage(new ChatComponentText("changement pour fortune 3"));
					 stack.addEnchantment(Enchantment.fortune, 3);
					
					}
					 }
				return stack;
				 }}
	
		else if (stack.getTagCompound().getInteger("mode") == 2 && !world.isRemote && !player.isSneaking())	{
			stack.stackTagCompound.setInteger("mode",3);
			
			
			if (stack.isItemEnchanted()){
			NBTTagList tl = stack.stackTagCompound.getTagList("ench", 10); 
			 for(int i=0;i<tl.tagCount();i++){
				 NBTTagCompound nbtl = (NBTTagCompound) tl.getCompoundTagAt(i);
				 if(nbtl.getShort("id") == Enchantment.fortune.effectId){
				 tl.removeTag(i);
				 player.addChatComponentMessage(new ChatComponentText("fortune desactive"));
				
				 world.playSoundEffect(player.posX, player.posY, player.posZ, "armormod:off", 1, 1);
				}
				 if(nbtl.getShort("id") == Enchantment.silkTouch.effectId){
					 tl.removeTag(i);
					 player.addChatComponentMessage(new ChatComponentText("silktouch desactiver"));
					
					// world.playSoundEffect(player.posX, player.posY, player.posZ, "armormod:off", 1, 1);
					}
				 }
			return stack;
			 }
			
			
			
			}
		
		
		return stack;
		}
	
	
	/**
	 * Get a List of itemstacks from an OD name.<br>
	 * It also makes sure that no items with damage 32767 are included, to prevent errors.
	 */
	public static List<ItemStack> getODItems(String oreName)
	{
		List<ItemStack> result = Lists.newArrayList();

		for (ItemStack stack : OreDictionary.getOres(oreName))
		{
			if (stack == null)
			{
				continue;
			}

			if (stack.getItemDamage() == OreDictionary.WILDCARD_VALUE)
			{
				List<ItemStack> list = Lists.newArrayList();

				ItemStack copy = stack.copy();
				copy.setItemDamage(0);

				list.add(copy.copy());

				String startName = copy.getUnlocalizedName();

				for (int i = 1; i <= 128; i++)
				{
					try
					{
						copy.setItemDamage(i);

						if (copy.getUnlocalizedName() == null || copy.getUnlocalizedName().equals(startName))
						{
							result.addAll(list);
							break;
						}
					}
					catch (Exception e)
					{
						System.out.println("Couldn't retrieve OD items for: " + oreName);
						System.out.println("Caused by: " + e.toString());

						result.addAll(list);
						break;
					}

					list.add(copy.copy());

					if (i == 128)
					{
						copy.setItemDamage(0);
						result.add(copy);
					}
				}
			}
			else
			{
				result.add(stack.copy());
			}
		}

		return result;
	}
	
	public static String getOreDictionaryName(ItemStack stack)
	{
		int[] oreIds = OreDictionary.getOreIDs(stack);

		if (oreIds.length == 0)
		{
			return "Unknown";
		}

		return OreDictionary.getOreName(oreIds[0]);
	}
	
	public static boolean isOre(Block block, int meta)
	{
		if (block == Blocks.lit_redstone_ore)
		{
			return true;
		}
		String oreDictName = getOreDictionaryName(new ItemStack(block, 1, meta));
		return oreDictName.startsWith("ore") || oreDictName.startsWith("denseore");
	}


	public float getDigSpeed(ItemStack itemstack, Block block, int metadata)
 {
		test = metadata;
        return func_150893_a(itemstack, block);
    }
	
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity)
    {
		
		
		if (stack.getTagCompound() != null){
		
		if (!world.isRemote && stack.getTagCompound().getInteger("mode") != 1 ){
		if (block == Blocks.diamond_ore || block == Blocks.coal_ore || block == Blocks.redstone_ore || block == Blocks.lapis_ore || block == Blocks.emerald_ore)
			
		{
			
			int random = new Random().nextInt(5)+1;
			world.spawnEntityInWorld(new EntityXPOrb(world,x + 0.5D,y + 0.5D,z + 0.5D,random));
		}
		}
		if ((double)block.getBlockHardness(world,x,y,z) != 0.0D)
        {
            stack.damageItem(1, entity);
        }
		
		
		if (!world.isRemote && stack.getTagCompound().getInteger("mode") == 1){
		int meta = test;
			if(isOre(block,meta)){
		ItemStack  atest = new ItemStack(block,1,meta);
		String oname = getOreDictionaryName(atest);
		List<ItemStack> a = getODItems(oname);
		if(!a.isEmpty()){
		world.setBlock(x, y, z, Blocks.air);
		world.spawnEntityInWorld(new EntityItem(world,x + 0.5D,y + 0.5D,z + 0.5D,a.get(0)));
		}
			}
			 }   
		}
		//stack.damageItem(1, entity);
		return true;
    }
	
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		
		list.add("clique droit pour changer de mode");
		
	}
	
		
}
