package net.darkexplosiveqwx.darkcore.DarkCore.screen;

import net.darkexplosiveqwx.darkcore.DarkCore.DarkCore;
import net.minecraft.world.inventory.*;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.*;


/**
 * @author darkexplosiveqwx
 * @author kaupenjoe
 */
public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, DarkCore.MOD_ID);

    public static final RegistryObject<MenuType<GemInfusingStationMenu>> GEM_INFUSING_STATION_MENU = registerMenuType(GemInfusingStationMenu::new, "gem_infusing_station_menu");
    public static final RegistryObject<MenuType<DarkCraftingTableMenu>> DARK_CRAFTING_TABLE_MENU = registerMenuType(DarkCraftingTableMenu::new, "dark_crafting_table_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
