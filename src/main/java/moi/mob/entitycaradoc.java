package moi.mob;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class entitycaradoc extends EntityTameable{//EntityMob {

	public entitycaradoc(World world) {
		super(world);
		
		this.setSize(0.6F, 1.8F);
        
		this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntitySkeleton.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntitySkeleton.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, entityminion.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntitySpider.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityIronGolem.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, entityminion.class, 7.0F, 1.0F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityVillager.class, 5.0F, 0.02F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 5.0F, 0.02F));
        this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
        
        
      //  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
       // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, 5, true));
       // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 4, true));
       // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 3, true));
       // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, entityminion.class, 2, true));
       // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 1, true));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setTamed(false);
       
		
	}
	
	public boolean isAIEnabled(){
		return true;
	}
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
		
	//	if (this.isTamed()){
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0F);
	//	}
	//	if (!this.isTamed()){
		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0F);}
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	}
	
	public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        int i = this.isTamed() ? 8 : 2;
        return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
    }
	
	
	@Override
	 public boolean interact(EntityPlayer player)
	    {
	        ItemStack itemstack = player.inventory.getCurrentItem();
	       

	        if (itemstack != null && itemstack.getItem() == Items.bread){
	        //	player.playSound("armormod:cakeok", 1, 1);
	            if (itemstack.stackSize-- == 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bread));
	            }
	            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.cooked_porkchop,1)))
	            {
	            //	player.playSound("armormod:cake", 1, 1);
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.cooked_porkchop,1), false);
	            }}
	        
	        if (itemstack != null && itemstack.getItem() == Items.cooked_porkchop){
		        
	            if (itemstack.stackSize-- == 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.cooked_porkchop));
	            }
	            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.cooked_beef,3)))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.cooked_beef,3), false);
	            }}
	        
	        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.dragon_egg)){
	        
	            if (itemstack.stackSize-- == 0)
	            {
	            	player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Item.getItemFromBlock(Blocks.dragon_egg)));
	               
	            }
	           if (!player.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.emerald_block),64)))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Item.getItemFromBlock(Blocks.emerald_block),64), false);
	                
	            }}
	        
	        if (itemstack == null && this.func_152114_e(player)  && !this.worldObj.isRemote)
            {
            	this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
                if (this.isSitting()){
	                player.addChatComponentMessage(new ChatComponentText("Caradoc vous informe qu'il vous suit"));
	                }
	                else
	                player.addChatComponentMessage(new ChatComponentText("Caradoc vous informe qu'il ne vous suit plus"));
                
            }
	         
	        if (this.isTamed())
	        {
	            if (itemstack != null)
	            {
	                if (itemstack.getItem() == Items.apple && (this.getMaxHealth() > this.getHealth()))
	                {
	           //         ItemFood itemfood = (ItemFood)itemstack.getItem();

	         //           if (this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
	               //     {
	                        if (!player.capabilities.isCreativeMode)
	                        {
	                            --itemstack.stackSize;
	                        }

	                        this.heal(2.0F);

	                        if (itemstack.stackSize <= 0)
	                        {
	                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
	                        }

	                        return true;
	                    }
	             //   }
	                
	            

	           
	            if (this.func_152114_e(player)  && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
	            {
	            	this.aiSit.setSitting(!this.isSitting());
	                this.isJumping = false;
	                this.setPathToEntity((PathEntity)null);
	                this.setTarget((Entity)null);
	                this.setAttackTarget((EntityLivingBase)null);
	                if (this.isSitting()){
	                player.addChatComponentMessage(new ChatComponentText("Caradoc vous informe qu'il vous suit"));
	                }
	                else
	                player.addChatComponentMessage(new ChatComponentText("Caradoc vous informe qu'il ne vous suit plus"));
	            }
	            }
	        }
	        else if (itemstack != null && itemstack.getItem() == Items.diamond)
	        {
	            if (!player.capabilities.isCreativeMode)
	            {
	                --itemstack.stackSize;
	            }

	            if (itemstack.stackSize <= 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
	            }

	            if (!this.worldObj.isRemote)
	            {
	                if (this.rand.nextInt(3) == 0)
	                {
	                    this.setTamed(true);
	                    this.setPathToEntity((PathEntity)null);
	                    this.setAttackTarget((EntityLivingBase)null);
	                    this.aiSit.setSitting(true);
	                    this.setHealth(50.0F);
	                    this.func_152115_b(player.getUniqueID().toString());
	                    this.playTameEffect(true);
	                    this.worldObj.setEntityState(this, (byte)7);
	                    player.addChatComponentMessage(new ChatComponentText("Caradoc vous informe qu'il est a vos ordres"));
	                }
	                else
	                {
	                    this.playTameEffect(false);
	                    this.worldObj.setEntityState(this, (byte)6);
	                }
	            }

	            return true;
	        }
	        
	        
	        
	        if (itemstack != null && itemstack.getItem() == Items.carrot){
	        {
	            if (itemstack.stackSize-- == 0)
	            {
	                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.carrot));
	            }
	            if (!player.inventory.addItemStackToInventory(new ItemStack(Items.potionitem,1,8228)))
	            {
	                player.dropPlayerItemWithRandomChoice(new ItemStack(Items.potionitem,1,8228), false);
	            }}

	            return true;
	        }
	        
	        else
	       {
	            return super.interact(player);
	       }
	        
	        
	    }

	
	
	
	@Override
	protected String getDeathSound()
    {
		this.playSound("armormod:mob.caradoc.death", 1.0F, 1.0F);
		return null;
    }
	
	  /**
     * Returns the sound this mob makes while it's alive.
     */
	@Override
    protected String getLivingSound()
    {
         this.playSound("armormod:mob.caradoc.say", 1.0F, 1.0F);
		return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound()
    {
		
		this.playSound("armormod:mob.caradoc.hurt", 1.0F, 1.0F);
		return null;
    }
	
	//bruit de pa
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("armormod:mob.caradoc.step", 0.15F, 1.0F);
    }
	
		
	@Override
	 protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	
	        int j = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);
	        int k;

	        for (k = 0; k < j; ++k)
	        {
	            this.dropItem(Items.wooden_sword, 1);
	        }

	        j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

	        for (k = 0; k < j; ++k)
	        {
	            this.dropItem(Items.porkchop,1);
	        }
	    }
/*	@Override
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
	    }*/

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return new entitycaradoc(this.worldObj);
	}




	

}
