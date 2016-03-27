package moi.mob;

import moi.armormod;
import moi.config.conf;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;

import cpw.mods.fml.common.registry.EntityRegistry;

public class entitymobregistry {
	
	 static BiomeGenBase[] allbiomes = Iterators.toArray(Iterators.filter(Iterators.forArray(BiomeGenBase.getBiomeGenArray()), Predicates.notNull()), BiomeGenBase.class);
		
	
	public static void registerEntity(){
		
		EnumCreatureType type = EnumCreatureType.creature;
		
		createEntity(entityminion.class, "minion", 0x99ff99, 0x112);
		createEntity(entityperceval.class, "perceval", 0x005, 0x99ff99);
		createEntity(entitycaradoc.class, "caradoc", 0x005, 0x55ff55);
	
		EntityRegistry.addSpawn(entityminion.class, conf.spawnratem, 1, 1, type, allbiomes);
		EntityRegistry.addSpawn(entityperceval.class, conf.spawnratep, 1, 1, type, allbiomes);
		EntityRegistry.addSpawn(entitycaradoc.class, conf.spawnratec, 1, 1, type, allbiomes);
		
	}
	
//	static BiomeGenBase[] biomesf = BiomeDictionary.getBiomesForType(Type.FOREST);
	
  
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		int uniqueId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, uniqueId);
		EntityRegistry.registerModEntity(entityClass, entityName, uniqueId, armormod.modid, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(uniqueId), new EntityList.EntityEggInfo(uniqueId, solidColor, spotColor));
		
	}
	
}
