package moi.config;

import java.util.HashSet;
import java.util.Set;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class conf {
	
	
	public static int durapioche = 2000;
	public static int duraarmor = 10;
	public static int spawnratem = 20;
	public static int spawnratep = 20;
	public static int spawnratec = 20;
	public static boolean mess = true;
	public static int forcespace = 7;
	
	public static void configs(FMLPreInitializationEvent e){

	Configuration config = new Configuration(e.getSuggestedConfigurationFile());
	
	config.load();
	 Property property;
	 
		
	property = config.get("general","durapioche",durapioche);
	property.comment = "durability de tool";
	durapioche = property.getInt();
	
	property = config.get("general","duraarmor",duraarmor);
	property.comment = "durability de armor";
	duraarmor = property.getInt();
	
	property = config.get("general","spawnrateminion",spawnratem);
	property.comment = "spawn rate de minion";
	spawnratem = property.getInt();
	
	property = config.get("general","spawnrateperceval",spawnratep);
	property.comment = "spawn rate de perceval";
	spawnratep = property.getInt();
	
	property = config.get("general","spawnratecaradoc",spawnratec);
	property.comment = "spawn rate de caradoc";
	spawnratec = property.getInt();
	
	property = config.get("general","messagelogin",mess);
	property.comment = "affiche message/son au login du joueur";
	mess = property.getBoolean();
	
	property = config.get("general","force space",forcespace);
	property.comment = "resistance aux temperatures de l'armure additionnel de galcticraft. Range(entre 1 et 20)";
	forcespace = property.getInt();
	
	
	config.save();


}}
