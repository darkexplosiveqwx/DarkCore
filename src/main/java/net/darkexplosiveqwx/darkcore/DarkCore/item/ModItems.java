package net.darkexplosiveqwx.darkcore.DarkCore.item;

import net.darkexplosiveqwx.darkcore.DarkCore.Main;
import net.darkexplosiveqwx.darkcore.DarkCore.block.ModBlocks;
import net.darkexplosiveqwx.darkcore.DarkCore.item.custom.DiceItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public  static final RegistryObject<Item> DARK_INGOT = ITEMS.register("dark_ingot", ()-> new Item(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DARKCORE_DARK_TAB).rarity(Rarity.RARE).fireResistant()));
    public  static final RegistryObject<Item> DARK_GEM = ITEMS.register("dark_gem", ()-> new Item(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DARKCORE_DARK_TAB).rarity(Rarity.RARE).fireResistant()));
    public  static final RegistryObject<Item> RAW_DARK_INGOT = ITEMS.register("raw_dark_ingot", ()-> new Item(new Item.Properties().stacksTo(32).tab(ModCreativeModeTab.DARKCORE_DARK_TAB).rarity(Rarity.RARE).fireResistant()));

    public  static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ()-> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.DARKCORE_EXTRATAB)));
    public  static final RegistryObject<Item> CITRIN = ITEMS.register("citrin", ()-> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.DARKCORE_EXTRATAB)));
    public  static final RegistryObject<Item> SAPHIR = ITEMS.register("saphir", ()-> new Item(new Item.Properties().stacksTo(64).tab(ModCreativeModeTab.DARKCORE_EXTRATAB)));


    public  static final RegistryObject<Item> DICE = ITEMS.register("dice", ()-> new DiceItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DARKCORE_MISC)));
    public  static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", ()-> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.DARKCORE_MISC)));
    public  static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", ()-> new Item(new Item.Properties().tab(ModCreativeModeTab.DARKCORE_MISC).food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
