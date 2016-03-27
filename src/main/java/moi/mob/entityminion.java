package moi.mob;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class entityminion extends EntityAnimal {

	public entityminion(World world) {
		super(world);
		this.setSize(0.7F, 0.7F);
		
		this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, entitycaradoc.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(4, new EntityAITempt(this, 1.25D, Items.beef, false));
        this.tasks.addTask(5, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    
		
	}
	
	public boolean isAIEnabled(){
		return true;
	}
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.5D);
	}

	
	@Override
	 public boolean interact(EntityPlayer player)
	    {
	        ItemStack itemstack = player.inventory.getCurrentItem();
	       

	        if (itemstack != null && itemstack.getItem() == Items.wheat){
	        	player.playSound("armormod:cakeok", 1, 1);
	            if (itemstack.stackSize-- == 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.wheat));
	            }
	            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.cake,1)))
	            {
	            	//player.playSound("armormod:cake", 1, 1);
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.cake,1), false);
	            }}
	        
	        if (itemstack != null && itemstack.getItem() == Items.blaze_rod){
		        
	            if (itemstack.stackSize-- == 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.blaze_rod));
	            }
	            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.blaze_powder,7)))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.blaze_powder,7), false);
	            }}
	        
	        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.diamond_ore)){
	        
	            if (itemstack.stackSize-- == 0)
	            {
	            	player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Item.getItemFromBlock(Blocks.diamond_ore)));
	               
	            }
	           if (!player.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.diamond_block))))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)), false);
	                
	            }}
	         
	            
	        
	        
	        
	        if (itemstack != null && itemstack.getItem() == Items.bone){
	        {
	            if (itemstack.stackSize-- == 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bone));
	            }
	            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.cookie,4)))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.cookie,4), false);
	            }}

	            return true;
	        }
	        
	        else
	       {
	            return super.interact(player);
	       }
	        
	        
	    }
	
	@Override
	public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == Items.beef;
    }
	
	
	
	@Override
	protected String getDeathSound()
    {
		this.playSound("armormod:mob.minion.death", 1.0F, 1.0F);
		return null;
    }
	
	  /**
     * Returns the sound this mob makes while it's alive.
     */
	@Override
    protected String getLivingSound()
    {
		this.playSound("armormod:mob.minion.say", 1.0F, 1.0F);
		return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
		this.playSound("armormod:mob.minion.hurt", 1.0F, 1.0F);
		return null;
    }
	
	//bruit de pa
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("armormod:mob.minion.step", 0.15F, 1.0F);
    }
	
		
	@Override
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        int j = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);
	        int k;

	        for (k = 0; k < j; ++k)
	        {
	            this.dropItem(Items.bone, 1);
	        }

	        j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	            this.dropItem(Items.cooked_chicken,1);
	        }
	    }
	@Override
	 protected void dropRareDrop(int p_70600_1_)
	    {
	        switch (this.rand.nextInt(3))
	        {
	            case 0:
	                this.dropItem(Items.diamond, 1);
	                break;
	            case 1:
	                this.dropItem(Items.emerald, 1);
	                break;
	            case 2:
	                this.dropItem(Items.nether_star, 1);
	        }
	    }

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return new entityminion(this.worldObj);
	}




	

}
