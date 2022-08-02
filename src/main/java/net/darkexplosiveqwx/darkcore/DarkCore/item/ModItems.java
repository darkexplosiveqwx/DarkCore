package net.darkexplosiveqwx.darkcore.DarkCore.item;

import net.darkexplosiveqwx.darkcore.DarkCore.Main;
import net.darkexplosiveqwx.darkcore.DarkCore.item.custom.DiceItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public  static final RegistryObject<Item> DARK_INGOT = ITEMS.register("dark_ingot", ()-> new Item(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DARKCORE_DARK_TAB).rarity(Rarity.RARE).fireResistant()));
    public  static final RegistryObject<Item> DARK_GEM = ITEMS.register("dark_gem", ()-> new Item(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DARKCORE_DARK_TAB).rarity(Rarity.RARE).fireResistant()));
    public  static final RegistryObject<Item> RAW_DARK_INGOT = ITEMS.register("raw_dark_ingot", ()-> new Item(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DARKCORE_DARK_TAB).rarity(Rarity.RARE).fireResistant()));

    public  static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ()-> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.DARKCORE_EXTRATAB)));
    public  static final RegistryObject<Item> CITRIN = ITEMS.register("citrin", ()-> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.DARKCORE_EXTRATAB)));
    public  static final RegistryObject<Item> SAPHIR = ITEMS.register("saphir", ()-> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.DARKCORE_EXTRATAB)));


    public  static final RegistryObject<Item> DICE = ITEMS.register("dice", ()-> new DiceItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DARKCORE_MISC)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
