package com.tacosupremes.mysticalmachines.common.block;

import com.tacosupremes.mysticalmachines.common.block.tile.TileGrinder;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGrinder extends BlockModContainer {

	public BlockGrinder() {
		super(Material.ROCK, "grinder");
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileGrinder();
	}

	@Override
	protected Class<? extends TileEntity> tile() {
		// TODO Auto-generated method stub
		return TileGrinder.class;
	}

}
