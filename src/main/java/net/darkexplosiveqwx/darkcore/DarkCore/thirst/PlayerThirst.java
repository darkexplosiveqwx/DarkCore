package net.darkexplosiveqwx.darkcore.DarkCore.thirst;

import net.minecraft.nbt.*;
import org.jetbrains.annotations.*;

public class PlayerThirst {
    private int thirst;
    private final int MIN_THIRST = 0;
    private final int MAX_THIRST = 10;


    public int getThirst() {
        return thirst;
    }

    public void addThirst(int add) {
        this.thirst = Math.min(thirst + add, MAX_THIRST);
    }

    public void subThirst(int sub) {
        this.thirst = Math.max(thirst - sub, MIN_THIRST);
    }

    public void copyFrom(@NotNull PlayerThirst source){
        this.thirst = source.thirst;
    }

    public void saveNBTData(@NotNull CompoundTag nbt){
        nbt.putInt("thirst", this.thirst);
    }

    public void loadNBTData(@NotNull CompoundTag nbt){
        this.thirst = nbt.getInt("thirst");
    }
}
