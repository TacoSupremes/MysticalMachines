package com.tacosupremes.mysticalmachines.common.block;

import com.tacosupremes.mysticalmachines.MysticalMachines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMod extends Block {

	public BlockMod(Material materialIn, String s) {
		super(materialIn);
		this.setUnlocalizedName(s);
		this.setCreativeTab(MysticalMachines.tab);
		this.setRegistryName(s);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this).setRegistryName(s));
		ModBlocks.blocks.add(this);
	}

	
	
}