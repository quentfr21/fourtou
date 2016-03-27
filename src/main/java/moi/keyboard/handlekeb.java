package moi.keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import moi.recipe.reg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

public class handlekeb {
	
	public static boolean boostpressed;
	public static boolean botboostpressed;
	
	public static int mode = 0;
	public static int nv = 0;
	
	
	
	
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
	    ItemStack casque = player.getCurrentArmor(3);
		ItemStack torse = player.getCurrentArmor(2);
		ItemStack fut = player.getCurrentArmor(1);
		ItemStack bot = player.getCurrentArmor(0);
		
			if(Keyb.flight.getIsKeyPressed()){
			if (torse !=null){
				if (torse.getItem() == reg.torse){
				if (mode == 0){
					mode = 1;
					player.addChatComponentMessage(new ChatComponentText("vol active"));
					//player.playSound("armormod:on", 1, 1);
				} 
				else if (mode == 1){
					mode = 0;
					player.addChatComponentMessage(new ChatComponentText("vol desactive"));
					//player.playSound("armormod:off", 1, 1);
				}
				}
				}
			}
			
			if(Keyb.nv.getIsKeyPressed()){
				if (casque !=null){
					if (casque.getItem() == reg.casque){
					if (nv == 0){
						nv = 1;
						player.addChatComponentMessage(new ChatComponentText("vision de nuit active"));
					} 
					else if (nv == 1){
						nv = 0;
						player.addChatComponentMessage(new ChatComponentText("vision de nuit desactive"));
					
					}
					}
					}
				}
			
	}
	
	@SubscribeEvent
	public void tick(PlayerTickEvent e){
		
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
	    ItemStack casque = player.getCurrentArmor(3);
		ItemStack torse = player.getCurrentArmor(2);
		ItemStack fut = player.getCurrentArmor(1);
		ItemStack bot = player.getCurrentArmor(0);
		
		if (torse !=null){
			if (torse.getItem() == reg.torse){
		
		if (Keyb.boost.getIsKeyPressed() && mode == 1){
			e.player.capabilities.setFlySpeed(0.25F);
			boostpressed = true;
		}
		else{
			boostpressed = false;
			e.player.capabilities.setFlySpeed(0.05F);}
	
	

}}
		
		if (bot !=null){
			if (bot.getItem() == reg.bot){
		
		if (Keyb.boost.getIsKeyPressed() && !player.capabilities.isFlying){
			botboostpressed = true;
			//e.player.addPotionEffect(new PotionEffect(Potion.jump.id,1,8));
		
		}else{botboostpressed = false;}}
	
	}
}}
