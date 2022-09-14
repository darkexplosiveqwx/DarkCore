package net.darkexplosiveqwx.darkcore.DarkCore.item.enchantment;

import net.darkexplosiveqwx.darkcore.DarkCore.DarkCore;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModEnchantments {

    public static final EnchantmentCategory CATEGORY_TOOLS = EnchantmentCategory.create("enchantment.category.darkcore.tools", item -> EnchantmentCategory.WEAPON.canEnchant(item) || EnchantmentCategory.DIGGER.canEnchant(item));
    public static final EnchantmentCategory CATEGORY_EVERYTHING = EnchantmentCategory.create("enchantment.category.darkcore.everything", item -> CATEGORY_TOOLS.canEnchant(item) || EnchantmentCategory.WEARABLE.canEnchant(item) || EnchantmentCategory.VANISHABLE.canEnchant(item) || EnchantmentCategory.BREAKABLE.canEnchant(item));

    private static final EquipmentSlot[] ARMOR_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    private static final EquipmentSlot[] SLOT_HAND = new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND};
    private static final EquipmentSlot[] SLOT_EVERYTHING = new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};


    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DarkCore.MOD_ID);


    public static RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCHANTMENTS.register("lightning_striker",
                    () -> new LightningStrikerEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.WEAPON, SLOT_HAND));

public static RegistryObject<Enchantment> WITHER_MAIN =
            ENCHANTMENTS.register("wither",
                    () -> new WitherEnchantment(Enchantment.Rarity.RARE,
                            CATEGORY_EVERYTHING, SLOT_EVERYTHING));




    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
