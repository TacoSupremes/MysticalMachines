package com.tacosupremes.mysticalmachines.common.block.tile;

import com.tacosupremes.mysticalmachines.common.lib.LibMisc;
import com.tacosupremes.mysticalmachines.common.lib.LibMisc.Ores;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ITickable;

public class TileGrinder extends TileEntity implements ITickable{

	
	
	
	private int i = 0;
	@Override
	public void update() {
		
		if(this.getWorld().getTileEntity(getPos().down()) instanceof TileEntityFurnace){
			
			TileEntityFurnace te = (TileEntityFurnace)this.getWorld().getTileEntity(getPos().down());
			
			if(this.getWorld().isRemote)
				return;
			
			ItemStack is = te.getStackInSlot(0);


			if(is == null)
				return;
			
			
			
			
			
			
			if(Ores.toDust(is) != null){
				
				if(!te.isBurning()){
					
					if(te.getItemBurnTime(te.getStackInSlot(1)) > 0){
						te.setField(0, te.getItemBurnTime(te.getStackInSlot(1)));
						te.decrStackSize(1, 1);
						  BlockFurnace.setState(true, this.worldObj, this.pos.down());
						te.markDirty();
					}else
						return;
					
				}else if (te.getField(0) <= 5){
					
					if(te.getItemBurnTime(te.getStackInSlot(1)) > 0){
						te.setField(0, te.getItemBurnTime(te.getStackInSlot(1)));
						te.decrStackSize(1, 1);
						te.markDirty();
					}
					
					
				}
				
				if(te.getStackInSlot(2) != null){
					
					if(!ItemStack.areItemsEqual(Ores.toDust(is), te.getStackInSlot(2)) || te.getStackInSlot(2).stackSize == 64)
						return;
					
					++i;
					te.setField(2, i);
					
				}else if(FurnaceRecipes.instance().getSmeltingResult(te.getStackInSlot(0)) == null){
					++i;
					te.setField(2, i);
				}
				
				if(te.getField(2) > te.getField(3)-2){
					
						
						te.setInventorySlotContents(2, te.getStackInSlot(2) == null ? withStackSize(Ores.toDust(is), 2) : withStackSize(Ores.toDust(is), te.getStackInSlot(2).stackSize + 2));
						te.setField(2, 0);
						te.decrStackSize(0, 1);
						i = 0;
						te.markDirty();
							
					}
				
			}
			
	}
		
	}
	
	public ItemStack withStackSize(ItemStack is, int size){
		
		return new ItemStack(is.getItem(), size, is.getItemDamage());
	}
	
}
