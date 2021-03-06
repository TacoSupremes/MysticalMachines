package com.tacosupremes.mysticalmachines.common.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tacosupremes.mysticalmachines.common.utils.BlockUtils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LibMisc {
	
	public static final String MODID = "mysticalmachines";
	public static final String VERSION = "0.1";
	public static final String COMMONPROXY = "com.tacosupremes.mysticalmachines.proxy.CommonProxy";
	public static final String CLIENTPROXY = "com.tacosupremes.mysticalmachines.proxy.ClientProxy";
	
	
	public static class Ores {
		
	
	public static List<String> ores = new ArrayList<String>();
	public static List<String> oreName = new ArrayList<String>();
	public static List<String> dusts = new ArrayList<String>();
	
	public static Map<String, ItemStack> oL = new HashMap<String, ItemStack>();
	
	public static void preInit(){
		
		//Stolen From Botania
				addOre("oreAluminum"); // Tinkers' Construct
				addOre("oreAmber"); // Thaumcraft
				addOre("oreApatite"); // Forestry
				addOre("oreBlueTopaz"); // Ars Magica
				addOre("oreCertusQuartz"); // Applied Energistics
				addOre("oreChimerite"); // Ars Magica
				addOre("oreCinnabar"); // Thaumcraft
				addOre("oreCoal"); // Vanilla
				addOre("oreCopper"); // IC2, Thermal Expansion, Tinkers' Construct, etc.
				addOre("oreDark"); // EvilCraft
				addOre("oreDarkIron"); // Factorization (older versions)
				addOre("oreFzDarkIron"); // Factorization (newer versions)
				addOre("oreDiamond"); // Vanilla
				addOre("oreEmerald"); // Vanilla
				addOre("oreGalena"); // Factorization
				addOre("oreGold"); // Vanilla
				addOre("oreInfusedAir"); // Thaumcraft
				addOre("oreInfusedEarth"); // Thaumcraft
				addOre("oreInfusedEntropy"); // Thaumcraft
				addOre("oreInfusedFire"); // Thaumcraft
				addOre("oreInfusedOrder"); // Thaumcraft
				addOre("oreInfusedWater"); // Thaumcraft
				addOre("oreIron"); // Vanilla
				addOre("oreLapis"); // Vanilla
				addOre("oreLead"); // IC2, Thermal Expansion, Factorization, etc.
				addOre("oreMCropsEssence"); // Magical Crops
				addOre("oreMithril"); // Thermal Expansion
				addOre("oreNickel"); // Thermal Expansion
				addOre("oreOlivine"); // Project RED
				addOre("orePlatinum"); // Thermal Expansion
				addOre("oreRedstone"); // Vanilla
				addOre("oreRuby"); // Project RED
				addOre("oreSapphire"); // Project RED
				addOre("oreSilver"); // Thermal Expansion, Factorization, etc.
				addOre("oreSulfur"); // Railcraft
				addOre("oreTin"); // IC2, Thermal Expansion, etc.
				addOre("oreUranium"); // IC2
				addOre("oreVinteum"); // Ars Magica
				addOre("oreYellorite"); // Big Reactors
				addOre("oreZinc"); // Flaxbeard's Steam Power
				addOre("oreMythril"); // Simple Ores2
				addOre("oreAdamantium"); // Simple Ores2
				addOre("oreTungsten"); // Simple Tungsten
		
	}
	
	public static void postInit(){
		
		for(String s : oL.keySet()){
			OreDictionary.registerOre(s, oL.get(s));		
		}
		
		
		
	//	cleanOres();
		makeDusts();
	}
	


	private static void cleanOres() {
		
		for(int i =0; i< ores.size();i++){
			String s = ores.get(i);
			if(OreDictionary.getOres(s) == null || OreDictionary.getOres(s).isEmpty())
				ores.remove(s);	
		}
		
	}
	
	private static void makeDusts() {
		
		for(String s2 : ores){
			String s = s2.replace("ore", "dust");
			if(OreDictionary.getOres(s) != null && !OreDictionary.getOres(s).isEmpty())
				dusts.add(s);	
		}
		
		
	}

	public static void addOre(String s){
		ores.add(s);
		oreName.add(s.substring(3));
	}
	
	public static boolean isOre(IBlockState b){
		
		
		ItemStack is = new ItemStack(b.getBlock(), 1, b.getBlock().getMetaFromState(b));
		
		for(String s : ores){
			
			for(ItemStack is2 : OreDictionary.getOres(s)){
				
				if(is2.areItemsEqual(is, is2))
					return true;
				
			}
				
			
		}
		
		return false;
	}
	
	public static boolean isOre(ItemStack is3){
		
		if(is3 == null)
			return false;
		
		ItemStack is = is3.copy().splitStack(1);
		
		for(String s : ores){
			
			for(ItemStack is2 : OreDictionary.getOres(s)){
				
				if(is2.areItemsEqual(is, is2))
					return true;
				
			}
				
			
		}
		
		return false;
	}
	
	public static String getName(IBlockState b){
		
		
		ItemStack is = new ItemStack(b.getBlock(), 1, b.getBlock().getMetaFromState(b));
		
		for(String s : ores){
			
			for(ItemStack is2 : OreDictionary.getOres(s)){
				
				if(is2.areItemsEqual(is, is2))
					return s;
				
			}
				
			
		}
		
		return null;
	}

	public static String getName(ItemStack is3){
	
		
	if(is3 == null)
		return null;		
	ItemStack is = is3.copy().splitStack(1);
	
	
	for(String s : ores){
		
		for(ItemStack is2 : OreDictionary.getOres(s)){
			
			if(is2.areItemsEqual(is, is2))
				return s;
			
		}
			
		
	}
	
	return null;
}

public ItemStack getOtherForms(ItemStack i){
	
	
	String s = getName(i);
	
	
	
	List<ItemStack> l = OreDictionary.getOres(s);
	
	if(l == null || l.size() == 1 || l.size() == 0)
		return null;
	
	for(ItemStack is : l){
		if(is.isItemEqual(is))
			continue;
		
		return is;
	}
	
	
	
	return null;
	
}


	/**From Ore to Dust **/
	public static String toDust(String s){
	
		if(s == null || !s.contains("ore"))
			return null;
		
		
		
		
		return s.replace("ore","dust");
		
		
		
	}
	
	/**From Ore to Dust **/
	public static ItemStack toDust(ItemStack is){
	
		
		
		return OreDictionary.getOres(toDust(getName(is))).isEmpty() ? null : OreDictionary.getOres(toDust(getName(is))).get(0);

	}
	
	/**From Ore to Dust **/
	public static ItemStack toDust(IBlockState state){
		
		return toDust(BlockUtils.toItemStack(state));
	}
	
	/**From Dust to Ore **/
	public static String toOre(String s){

		return s.replace("dust", "ore");

	}
	

	
	
	
	/**From Dust to Ingot **/
	public static String toIngot(String s){
		
		return s.replace("dust", "ingot");
	}
	
	
	public static String getDustName(ItemStack is3){
		
		ItemStack is = is3.copy().splitStack(1);
		
		
		for(String s : dusts){
			
			for(ItemStack is2 : OreDictionary.getOres(s)){
				
				if(is2.areItemsEqual(is, is2))
					return s;
				
			}
				
			
		}
		
		return null;
	}
	
	
	
	
	
	}
	
	
	public static class GuiIDs {

		public static int MODBOOK = 0;
		
		
		
		public static class Buttons {
			
			public static final int NEXT = 46583;
			public static final int BACK = 45673;
		}
		
		
	}
	
	
}
