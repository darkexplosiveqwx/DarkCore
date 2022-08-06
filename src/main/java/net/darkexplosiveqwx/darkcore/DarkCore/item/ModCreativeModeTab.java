package net.darkexplosiveqwx.darkcore.DarkCore.item;

import net.minecraft.world.item.*;

public class ModCreativeModeTab {
    public static final CreativeModeTab DARKCORE_DARK_TAB = new CreativeModeTab("darkcore_dark_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DARK_INGOT.get());
        }
    };

    public static final CreativeModeTab DARKCORE_EXTRATAB = new CreativeModeTab("darkcore_extra_stuff") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };
    public static final CreativeModeTab DARKCORE_MISC = new CreativeModeTab("darkcore_misc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DICE.get());
        }
    };
    public static final CreativeModeTab DARKCORE_ZIRCON = new CreativeModeTab("darkcore_zircon") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ZIRCON.get());
        }
    };
}
