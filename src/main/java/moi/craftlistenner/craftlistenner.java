package moi.craftlistenner;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moi.config.conf;
import moi.keyboard.Keyb;
import moi.recipe.reg;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class craftlistenner {


	
	@SubscribeEvent
	public void crafting(ItemCraftedEvent e)
	{
	if(e.crafting.getItem() == reg.casque)
	{
	e.player.addStat(reg.helmet, 1);
	//e.player.playSound("armord:casque",1,1);
	}
	if(e.crafting.getItem() == reg.torse)
	{
	e.player.addStat(reg.chestplate, 1);
	}
	if(e.crafting.getItem() == reg.fut)
	{
	e.player.addStat(reg.leggins, 1);
	}
	if(e.crafting.getItem() == reg.bot)
	{
	e.player.addStat(reg.boot, 1);
	}
	if(e.crafting.getItem() == reg.pioche)
	{
	e.player.addStat(reg.pickaxe, 1);
	}
	
	}
	

	
	@SubscribeEvent
	public void pickup(ItemPickupEvent e)
	{
	if(e.pickedUp.getEntityItem().getItem() == reg.casque)
	{
	e.player.addStat(reg.helmet, 1);
	//e.player.playSound("armord:casque",1,1);
	}
	if(e.pickedUp.getEntityItem().getItem() == reg.torse)
	{
	e.player.addStat(reg.chestplate, 1);
	}
	if(e.pickedUp.getEntityItem().getItem() == reg.fut)
	{
	e.player.addStat(reg.leggins, 1);
	}
	if(e.pickedUp.getEntityItem().getItem() == reg.bot)
	{
	e.player.addStat(reg.boot, 1);
	}
	if(e.pickedUp.getEntityItem().getItem() == reg.pioche)
	{
	e.player.addStat(reg.pickaxe, 1);
	}
	
	}
	
	@SubscribeEvent
	public void dimchange(PlayerChangedDimensionEvent e)
	{
		if (e.toDim == 0){
		e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans l'Overworld"));}
		
		if (e.toDim == -1){
			e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans le Nether"));}
			
	 	if (e.toDim == 1){
			e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans le End"));}
			
	 	if (e.toDim == 7){
			e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans la Twilight Forest"));}
		
	 	if (e.toDim == 15){
			e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans votre super boite"));}
		
	 	if (e.toDim == 17){
			e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans le monde de M3DO"));}
		
		if (e.toDim !=0 && e.toDim != -1 && e.toDim != 1 && e.toDim !=7 && e.toDim != 15 && e.toDim != 17)
			e.player.addChatComponentMessage(new ChatComponentText("Bienvenue dans la dimension numero " + e.toDim));
			
		
	}
	
	@SubscribeEvent
	public void login(PlayerLoggedInEvent e){
		
	
		
	if (conf.mess == true){
		
	String username = e.player.getDisplayName();
	if(username == "jejoul"){
		e.player.addChatMessage(new ChatComponentText("Bienvenue monsieur, craft bien espece de je sais pas koi :-)"));
		//e.player.playSound("armormod:gg",1,1);
	}
	if(username == "remi"){
		e.player.addChatMessage(new ChatComponentText("coucou le noob, craft bien :-)"));
	}
	if(username == "Acehilm"){
		e.player.addChatMessage(new ChatComponentText("whouaa aa a aa a  :-)"));
	}
	
		
	}
	}
}
