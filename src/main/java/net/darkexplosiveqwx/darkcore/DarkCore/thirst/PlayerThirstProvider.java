package net.darkexplosiveqwx.darkcore.DarkCore.thirst;

import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.*;
import org.jetbrains.annotations.*;

public class PlayerThirstProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerThirst> PLAYER_THIRST = CapabilityManager.get(new CapabilityToken<PlayerThirst>() {  });

    private PlayerThirst thirst = null;
    private final LazyOptional<PlayerThirst> optional = LazyOptional.of(this::createPlayerThirst);

    private PlayerThirst createPlayerThirst() {
        if(this.thirst == null){
            this.thirst = new PlayerThirst();
        }

        return this.thirst;
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_THIRST){
            return  optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerThirst().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerThirst().loadNBTData(nbt);
    }
}
