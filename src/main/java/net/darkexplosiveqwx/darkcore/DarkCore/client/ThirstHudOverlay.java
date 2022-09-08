package net.darkexplosiveqwx.darkcore.DarkCore.client;

import com.mojang.blaze3d.systems.*;
import net.darkexplosiveqwx.darkcore.DarkCore.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;
import net.minecraft.resources.*;
import net.minecraftforge.client.gui.overlay.*;

public class ThirstHudOverlay {
    private static final ResourceLocation FILLED_THIRST = new ResourceLocation(MainForge.MOD_ID,
            "textures/thirst/filled_thirst.png");
    private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(MainForge.MOD_ID,
            "textures/thirst/empty_thirst.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;



        if(!gui.getMinecraft().player.isCreative() && !gui.getMinecraft().player.isSpectator()){
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, EMPTY_THIRST);
            for(int i = 0; i < 10; i++) {
                GuiComponent.blit(poseStack,x - 94 + (i * 9), y - 54,0,0,12,12,
                        12,12);
            }

            RenderSystem.setShaderTexture(0, FILLED_THIRST);
            for(int i = 0; i < 10; i++) {
                if(ClientThirstData.getPlayerThirst() > i) {
                    GuiComponent.blit(poseStack,x - 94 + (i * 9),y - 54,0,0,12,12,
                            12,12);
                } else {
                    break;
                }
            }
        }
    });
}
