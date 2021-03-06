package org.cyclops.commoncapabilities.modcompat.vanilla.capability.work;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import org.cyclops.commoncapabilities.api.capability.work.IWorker;

/**
 * Worker capability for the vanilla brewing stand tile entity.
 * @author rubensworks
 */
public class VanillaBrewingStandWorker implements IWorker {
    private static final int[] outputSlots = new int[] {0, 1, 2};
    
    private final TileEntityBrewingStand brewingStand;

    public VanillaBrewingStandWorker(TileEntityBrewingStand brewingStand) {
        this.brewingStand = brewingStand;
    }

    @Override
    public boolean hasWork() {
        ItemStack[] inputs = new ItemStack[outputSlots.length]; 
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = brewingStand.getStackInSlot(outputSlots[i]);
        }
        return BrewingRecipeRegistry.canBrew(inputs, brewingStand.getStackInSlot(outputSlots.length), outputSlots);
    }

    @Override
    public boolean canWork() {
        return brewingStand.getField(1) > 0;
    }
}
