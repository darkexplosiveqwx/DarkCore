package net.darkexplosiveqwx.darkcore.DarkCore.util;

import com.mojang.blaze3d.platform.*;
import net.minecraft.client.*;
import net.minecraftforge.client.settings.*;
import org.lwjgl.glfw.*;

public class KeyBinding {
    public static final String KEY_CATEGORY_MAIN = "key.category.darkcore.main";
    public static final String KEY_CATEGORY_UTIL= "key.category.darkcore.util";
    public static final String KEY_DRINK_WATER = "key.darkcore.drink_water";

    public static final KeyMapping DRINKING_KEY = new KeyMapping(KEY_DRINK_WATER, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O,KEY_CATEGORY_UTIL);


}
