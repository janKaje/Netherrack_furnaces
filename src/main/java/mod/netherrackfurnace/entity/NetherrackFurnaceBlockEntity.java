package mod.netherrackfurnace.entity;

import mod.netherrackfurnace.NetherrackFurnaces;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class NetherrackFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    public NetherrackFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(NetherrackFurnaces.NETHERRACK_FURNACE_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected int getFuelTime(ItemStack fuel) {
        if (!fuel.isEmpty()) {
            Item item = fuel.getItem();
            if (createFuelTimeMap().getOrDefault(item, 0) > 0) {
                return Integer.MAX_VALUE;
            }
        } return 0;
    }

}
