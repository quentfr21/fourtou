package moi.item;

import moi.keyboard.handlekeb;
import moi.recipe.reg;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class itemarmor extends ItemArmor{

	public String textureName;
	
	
	public itemarmor(String unlocalizedName, ArmorMaterial material,
			String textureName, int type) {
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName("armormod:" + textureName);

	}

	
	 public boolean getIsRepairable(ItemStack stack, ItemStack stack1){
		
		 if (stack1.getItem() == reg.reparation){
			
		 return true;
		 }
		 return false;
	 }
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		
		 return "armormod:textures/armor/armor" + (this.armorType == 2 ? "2" : "1") + ".png";
	
	}

	 
	
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {

		ItemStack casque = player.getCurrentArmor(3);
		ItemStack torse = player.getCurrentArmor(2);
		ItemStack fut = player.getCurrentArmor(1);
		ItemStack bot = player.getCurrentArmor(0);

	
			
		if (casque != null && casque.getItem() == reg.casque){
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20, 2));
		//player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 3));
		
		if (player.isPotionActive(Potion.wither) || player.isPotionActive(Potion.poison)){
			player.clearActivePotions();
		}
		
		if (handlekeb.nv == 1){
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, 3));
			}else{player.removePotionEffectClient(Potion.nightVision.id);}
		}
		
		if (torse != null && torse.getItem() == reg.torse){
		
		if (handlekeb.boostpressed && Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed() && handlekeb.mode == 1){
			
			player.motionY = 1.3;
		}
		if (handlekeb.boostpressed && Minecraft.getMinecraft().gameSettings.keyBindSneak.getIsKeyPressed() && handlekeb.mode == 1){
			
			player.motionY = -1.3;
		}
		
		
		}
		
		if (torse != null && torse.getItem() == reg.torse && handlekeb.mode == 1) {
			//player.fallDistance = 0.0F;
			player.capabilities.allowFlying = true;
		//	player.capabilities.isFlying = true;
			if (player.isBurning()){
				player.extinguish();}
			}
		
		else if (torse != null && torse.getItem() == reg.torse && handlekeb.mode == 0) {
			
			//player.fallDistance = 0.0F;
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
			if (player.isBurning()){
				player.extinguish();}
		
			}
			
		else if (torse == null)
		{
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
			player.fallDistance = 0.0F;
		
		}
		
		if (fut != null && fut.getItem() == reg.fut
				&& player.isSprinting()) {
			player.addPotionEffect(new PotionEffect(1, 1, 15));
		}
		
		 if (bot != null && bot.getItem() == reg.bot) {
			player.fallDistance = 0.0F;
			
			if(handlekeb.botboostpressed && handlekeb.mode == 0){
				player.addPotionEffect(new PotionEffect(Potion.jump.id,1,8));
				}
			else{player.removePotionEffectClient(Potion.jump.id);}
			
			
		 }
		 
		 
			 
		 }
	
		 
}
