package moi.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import moi.block.blockflamableair;
import moi.block.blockflamablestone;
import moi.block.blockstair;
import moi.config.conf;
import moi.item.itemarmor;
import moi.item.itempioche;
import moi.item.itempourcraft;
import moi.item.itemspeed;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class reg {
	
	public static ArmorMaterial armuremat = EnumHelper.addArmorMaterial("armuremat", conf.duraarmor, new int[] { 30, 30, 30, 30 }, 60);
	
	public static ToolMaterial toolmat= EnumHelper.addToolMaterial("toolmat", 3, conf.durapioche, 900000.0F, 10.0F, 50);

	public static Block blockcass = new blockflamablestone(Material.cloth, "flamablestone");
	public static Block blockair = new blockflamableair(Material.leaves,"flamableairstone");
	public static Block icestair = new blockstair(Blocks.ice,0,"icestairs",128,0);
	public static Block dirtstair = new blockstair(Blocks.dirt, 0, "dirtstairs",255,0);
	public static Block glassstair = new blockstair(Blocks.glass, 0, "glassstairs",0,0);
	public static Block goldstair = new blockstair(Blocks.gold_block, 0, "goldstairs",255,0);
	public static Block ironsstair = new blockstair(Blocks.iron_block, 0, "ironstairs",255,0);
	public static Block diamstair = new blockstair(Blocks.diamond_block, 0, "diamstairs",255,0);
	public static Block emeraldstair = new blockstair(Blocks.emerald_block, 0, "emeraldstairs",255,0);
	public static Block coalstair = new blockstair(Blocks.coal_block, 0, "coalstairs",255,0);
	public static Block redstonestair = new blockstair(Blocks.redstone_block, 0, "redstonestairs",255,0);
	public static Block lapisstair = new blockstair(Blocks.lapis_block, 0, "lapisstairs",255,0);
	public static Block glowstair = new blockstair(Blocks.glowstone, 0, "glowstairs",255,1.0F);
	
	
	public static Item casque = new itemarmor("casque", armuremat, "casque", 0);
	public static Item torse = new itemarmor("torse", armuremat, "torse", 1);
	public static Item fut = new itemarmor("fut", armuremat, "fut", 2);
	public static Item bot = new itemarmor("bot", armuremat, "bot", 3);
	
	public static Item pioche = new itempioche("pioche", toolmat);
	public static Item piochecore = new itempourcraft("piochecore");
	public static Item pick = new itempourcraft("pick");
	
	public static Item saut = new itempourcraft("saut");
	public static Item amorti = new itempourcraft("amorti");
	public static Item reparation = new itempourcraft("reparation");
	
	public static Item corecasque = new itempourcraft("corecasque");
	
	public static Item coretorse = new itempourcraft("coretorse");
	
	public static Item booster = new itemspeed("selecteurvitesse");
	public static ItemStack test = new ItemStack(Blocks.diamond_block);

	public static Achievement helmet;
	public static Achievement chestplate;
	public static Achievement leggins;
	public static Achievement boot;
	public static Achievement pickaxe;
	public static Achievement boost;
	public static Achievement vide;

	 public static AchievementPage Pageach;
	
	
	
	
	public static void ajoutrecette() {
		
		//stair
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.dirtstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.dirt }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.dirt,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.dirtstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.coalstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.coal_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.coal_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.coalstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.ironsstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.iron_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.iron_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.ironsstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.diamstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.diamond_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.diamond_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.diamstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.goldstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.gold_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.gold_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.goldstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.emeraldstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.emerald_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.emerald_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.emeraldstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.lapisstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.lapis_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.lapis_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.lapisstair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.redstonestair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.redstone_block }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.redstone_block,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.redstonestair }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.icestair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.ice}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.ice,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.icestair}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.glassstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.glass}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.glass,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.glassstair}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reg.glowstair,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), Blocks.glowstone}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.glowstone,6), new Object[] { "A  ", "AA ", "AAA", 
			      Character.valueOf('A'), reg.glowstair}));
		
		//pioche
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pioche), new Object[] { "CBC", " A ", " A ", 
		      Character.valueOf('A'), "stickWood", 
		      Character.valueOf('B'), piochecore,
		      Character.valueOf('C'),pick}));
		
		//piochecore
		GameRegistry.addRecipe(new ItemStack(piochecore), new Object[] { "ACA", "CBC", "ACA", 
		      Character.valueOf('A'), Items.leather, 
		      Character.valueOf('B'), Blocks.diamond_block,
		      Character.valueOf('C'), Items.gold_ingot});
		
		//pick
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pick), new Object[] { "ABC", 
				      Character.valueOf('A'), "blockQuartz", 
				      Character.valueOf('B'), "blockRedstone",
				      Character.valueOf('C'), "blockIron"}));
		
		//booster
		GameRegistry.addRecipe(new ItemStack(booster), new Object[] { "  A", " B ", "B  ", 
		      Character.valueOf('B'), Items.stick, 
		      Character.valueOf('A'), Items.diamond});
		    
		
		//reparation
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(reparation), new Object[] { "A A", "BCB", " C ", 
				Character.valueOf('C'), Items.gold_ingot, 
			      Character.valueOf('B'), Items.leather, 
			      Character.valueOf('A'), Items.diamond}));
		
		
		//casque
		GameRegistry.addShapedRecipe(new ItemStack(corecasque), new Object[] { "ABC", 
		      Character.valueOf('A'), new ItemStack(Items.potionitem,1,8262),
		      Character.valueOf('B'), new ItemStack(Items.potionitem,1,8269),
		      Character.valueOf('C'), Items.milk_bucket});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(casque), new Object[] { "BAB", "C C", 
		      Character.valueOf('A'), corecasque,
		      Character.valueOf('B'), Blocks.quartz_block,
		      Character.valueOf('C'), Blocks.end_stone}));
				
		
		
		//torse
		GameRegistry.addRecipe(new ItemStack(torse), new Object[] {"C C","BAB", "DDD", 
		      Character.valueOf('A'), coretorse,
		      Character.valueOf('B'), Blocks.end_stone,
		      Character.valueOf('C'), Blocks.quartz_block,
		      Character.valueOf('D'), Blocks.diamond_block});
		
		GameRegistry.addRecipe(new ItemStack(coretorse), new Object[] {"ACA","ABA", "ADA", 
		      Character.valueOf('A'), Items.feather,
		      Character.valueOf('B'), Blocks.redstone_block,
		      Character.valueOf('C'), Blocks.diamond_block,
		      Character.valueOf('D'), Blocks.quartz_block});
		
		
		
		//fut
		
		ItemStack potionfut = new ItemStack(Items.potionitem,1,8258);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fut), new Object[] { "CAC", "B B","D D", 
		      Character.valueOf('A'), Items.leather,
		      Character.valueOf('B'), potionfut,
		      Character.valueOf('C'), Blocks.quartz_block,
		      Character.valueOf('D'), Blocks.end_stone}));
		
		
		//botte
		GameRegistry.addRecipe(new ItemStack(bot), new Object[] {"C C","B B", "A A", 
			Character.valueOf('A'), amorti,
			Character.valueOf('B'), saut,
			Character.valueOf('C'), Blocks.end_stone});
				
		//saut
		GameRegistry.addRecipe(new ItemStack(saut), new Object[] { "C C", "ABA", "ABA", 
			Character.valueOf('A'), Blocks.piston, 
			Character.valueOf('B'), Blocks.redstone_block,
			Character.valueOf('C'), Blocks.stone_button});
				
		//amorti
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(amorti), new Object[] { "AAA", "BAB", "BBB", 
			Character.valueOf('A'), Blocks.planks, 
			Character.valueOf('B'), Blocks.wool}));

			
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockair,9), new Object[] { "AAA", "ABA", "AAA", 
				Character.valueOf('A'), Blocks.stone, 
				Character.valueOf('B'), Items.blaze_powder}));
		
	}
	
	public static void regblock(){
		
		GameRegistry.registerBlock(blockcass, "flamablestone");
		GameRegistry.registerBlock(blockair, "flamableairstone");
		
		GameRegistry.registerBlock(dirtstair, "dirtstair");
		GameRegistry.registerBlock(glassstair, "glassstair");
		GameRegistry.registerBlock(icestair, "icestairs");
		GameRegistry.registerBlock(goldstair, "goldstairs");
		GameRegistry.registerBlock(ironsstair, "ironstairs");
		GameRegistry.registerBlock(diamstair, "diamstairs");
		GameRegistry.registerBlock(emeraldstair, "emeraldstairs");
		GameRegistry.registerBlock(redstonestair, "redstonestairs");
		GameRegistry.registerBlock(lapisstair, "lapisstairs");
		GameRegistry.registerBlock(coalstair, "coalstairs");
		GameRegistry.registerBlock(glowstair, "glowstairs");
		
	
		
	}
	
	public static void regitem(){
		
	//poseur
		GameRegistry.registerItem(booster, "selecteurvitesse");
	
		
	//pioche
		GameRegistry.registerItem(pioche, "pioche");
		GameRegistry.registerItem(piochecore, "piochecore");
		GameRegistry.registerItem(pick, "pick");
	
	//armor	
		
	//reparation
		GameRegistry.registerItem(reparation, "reparation");
	
	//casque
		GameRegistry.registerItem(corecasque, "corecasque");
		GameRegistry.registerItem(casque, "casque");
			
	//torse
		GameRegistry.registerItem(torse, "torse");
		GameRegistry.registerItem(coretorse, "coretorse");
		
	
	//fut
		GameRegistry.registerItem(fut, "fut");
		
		
	//botte
		GameRegistry.registerItem(saut, "saut");
		GameRegistry.registerItem(amorti, "amorti");
		GameRegistry.registerItem(bot, "bot");
		
		
					
				}
	public static void ajouteach(){
		
		
		
		helmet = new Achievement("", "casque", 0, -2, casque, null);
		chestplate = new Achievement("", "torse", 0, 0, torse, null);
		leggins = new Achievement("", "fut", 0, 2, fut, null);
		boot = new Achievement("", "botte", 0, 4, bot, null);
		pickaxe = new Achievement("", "pioche", -2, 0, pioche, null);
		boost = new Achievement("", "booster", 2, 0, booster, null);
		
		 Pageach = new AchievementPage("Armure de ouf", reg.helmet, reg.chestplate,reg.leggins,reg.boot,reg.pickaxe,reg.boost);
    	 AchievementPage.registerAchievementPage(Pageach);
		
    	
		
	}

}
