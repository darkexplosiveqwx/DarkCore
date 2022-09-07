package net.darkexplosiveqwx.darkcore.DarkCore.enchantment;

import net.darkexplosiveqwx.darkcore.DarkCore.Main;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModEnchantments {

    public static final EnchantmentCategory TOOLS = EnchantmentCategory.create("enchantment.category.darkcore.tools", item -> EnchantmentCategory.WEAPON.canEnchant(item) || EnchantmentCategory.DIGGER.canEnchant(item));
    public static final EnchantmentCategory EVERYTHING = EnchantmentCategory.create("enchantment.category.darkcore.everything", item -> TOOLS.canEnchant(item) || EnchantmentCategory.WEARABLE.canEnchant(item) || EnchantmentCategory.VANISHABLE.canEnchant(item) || EnchantmentCategory.BREAKABLE.canEnchant(item));

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Main.MOD_ID);


    public static RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCHANTMENTS.register("lightning_striker",
                    () -> new LightningStrikerEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

public static RegistryObject<Enchantment> WITHER_MAIN =
            ENCHANTMENTS.register("wither_main",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            EVERYTHING, EquipmentSlot.MAINHAND));

public static RegistryObject<Enchantment> WITHER_OFF =
            ENCHANTMENTS.register("wither_off",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            EVERYTHING, EquipmentSlot.OFFHAND));

public static RegistryObject<Enchantment> WITHER_HEAD =
            ENCHANTMENTS.register("wither_head",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            EVERYTHING, EquipmentSlot.HEAD));

public static RegistryObject<Enchantment> WITHER_CHEST =
            ENCHANTMENTS.register("wither_chest",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            EVERYTHING, EquipmentSlot.CHEST));
public static RegistryObject<Enchantment> WITHER_LEGS =
            ENCHANTMENTS.register("wither_legs",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            EVERYTHING, EquipmentSlot.LEGS));
public static RegistryObject<Enchantment> WITHER_FEET =
            ENCHANTMENTS.register("wither_feet",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            EVERYTHING, EquipmentSlot.FEET));



    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
