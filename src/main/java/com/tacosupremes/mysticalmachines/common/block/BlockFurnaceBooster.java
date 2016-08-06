package com.tacosupremes.mysticalmachines.common.block;

import com.tacosupremes.mysticalmachines.common.block.tile.TileFurnaceBooster;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFurnaceBooster extends BlockModContainer {

	public BlockFurnaceBooster() {
		super(Material.ROCK, "furnaceBooster");
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return new TileFurnaceBooster();
	}

	@Override
	protected Class<? extends TileEntity> tile() {
		
		return TileFurnaceBooster.class;
	}

}
