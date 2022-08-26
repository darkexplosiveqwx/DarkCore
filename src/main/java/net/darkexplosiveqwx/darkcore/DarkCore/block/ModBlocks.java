package net.darkexplosiveqwx.darkcore.DarkCore.block;

import net.darkexplosiveqwx.darkcore.DarkCore.Main;
import net.darkexplosiveqwx.darkcore.DarkCore.block.custom.*;
import net.darkexplosiveqwx.darkcore.DarkCore.fluid.ModFluids;
import net.darkexplosiveqwx.darkcore.DarkCore.item.ModCreativeModeTab;
import net.darkexplosiveqwx.darkcore.DarkCore.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);


    //The Block
    public static final RegistryObject<Block> DARK_BLOCK = registerBlockSpecialStack("dark_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()), ModCreativeModeTab.DARKCORE_DARK_TAB, 32);
    //end of Block

    public static final RegistryObject<Block> DARK_ORE = registerBlock("dark_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops(), UniformInt.of(20,45)), ModCreativeModeTab.DARKCORE_DARK_TAB);


    public static final RegistryObject<Block> DEEPSLATE_DARK_ORE = registerBlock("deepslate_dark_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops(), UniformInt.of(25,60)), ModCreativeModeTab.DARKCORE_DARK_TAB);



    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()), ModCreativeModeTab.DARKCORE_EXTRATAB);
    public static final RegistryObject<Block> CITRIN_BLOCK = registerBlock("citrin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()), ModCreativeModeTab.DARKCORE_EXTRATAB);
  public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("saphir_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()), ModCreativeModeTab.DARKCORE_EXTRATAB);


    public static final RegistryObject<Block> DEEPSLATE_GEMSTONE_ORE = registerBlock("deepslate_gemstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops(), UniformInt.of(10,13)), ModCreativeModeTab.DARKCORE_EXTRATAB);




    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()), ModCreativeModeTab.DARKCORE_MISC);

 public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock("zircon_lamp",
            () -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.DARKCORE_ZIRCON);

    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> GEM_INFUSING_STATION =registerBlock("gem_infusing_station",
            () -> new GemInfusingStationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.DARKCORE_MISC);

    public static final RegistryObject<Block> DARK_CRAFTING_TABLE =registerBlock("dark_crafting_table",
            () -> new DarkCraftingTableBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.DARKCORE_MISC);



    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DARKCORE_ZIRCON);
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DARKCORE_ZIRCON);
    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DARKCORE_ZIRCON);
    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DARKCORE_ZIRCON);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()), ModCreativeModeTab.DARKCORE_ZIRCON);





    public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK = BLOCKS.register("soap_water_block", () -> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));




    public static final RegistryObject<Block> DARK_AIR = BLOCKS.register("dark_air",
            () -> new Block(BlockBehaviour.Properties.of(Material.AIR).air().noCollission().noOcclusion().noLootTable().jumpFactor(0f)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockSpecialStack(String name, Supplier<T> block, CreativeModeTab tab,int stacksto){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItemSpecialStack(name, toReturn, tab, stacksto);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItemSpecialStack(String name, RegistryObject<T> block, CreativeModeTab tab, int stacksto){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).stacksTo(stacksto)));
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
