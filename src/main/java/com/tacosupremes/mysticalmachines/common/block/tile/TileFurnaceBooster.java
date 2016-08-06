package com.tacosupremes.mysticalmachines.common.block.tile;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ITickable;

public class TileFurnaceBooster extends TileEntity implements ITickable {

	@Override
	public void update() {
		
		if(this.getWorld().getTileEntity(getPos().down()) instanceof TileEntityFurnace){
			
			
			TileEntityFurnace te = (TileEntityFurnace)this.getWorld().getTileEntity(getPos().down());
			
			
			
			
			if(te.getStackInSlot(0) == null){
				if(te.getField(0) > 0)
					te.setField(0, te.getField(0)-1);
				return;
			}
			
		
			
			if(te.getField(0) <= 1){
				te.setField(0, 200);
			}
			
		}
		
	}
	
	
}
