package com.tacosupremes.mysticalmachines;


import java.util.Random;

import com.tacosupremes.mysticalmachines.common.block.ModBlocks;
import com.tacosupremes.mysticalmachines.common.item.ModItems;
import com.tacosupremes.mysticalmachines.common.lib.LibMisc;
import com.tacosupremes.mysticalmachines.common.recipes.ModRecipes;
import com.tacosupremes.mysticalmachines.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = LibMisc.MODID, version = LibMisc.VERSION)
public class MysticalMachines
{

    
    @SidedProxy(clientSide = LibMisc.CLIENTPROXY, serverSide = LibMisc.COMMONPROXY)
    public static CommonProxy proxy;
    
    public static CreativeTabs tab;
    
    @Instance(LibMisc.MODID)
    public static MysticalMachines instance;
	
    public static Random rand;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	tab = new RTab();	
  
    	rand = new Random();
    	

    	ModBlocks.preInit();
    	ModItems.preInit();
    	LibMisc.Ores.preInit();
    }
    
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModItems.init();
    //	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		proxy.registerRenders();
		

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	ModRecipes.postInit();
    	LibMisc.Ores.postInit();
    	//Pages.postInit();
    	
    	
   
		
    }
    
    public static int randInt(int max, int exclude){
    	
    	int i = rand.nextInt(max);
    	
    	while(i == exclude)
    		i = rand.nextInt(max);
    	
    		
    	
    	return i;
    }
    
    public class RTab extends CreativeTabs {

		public RTab() {
			super(CreativeTabs.getNextID(), LibMisc.MODID);
			
		}

		@Override
		public Item getTabIconItem() {
		
			return Item.getItemFromBlock(Blocks.OBSIDIAN);
		}
    	
    }
}
