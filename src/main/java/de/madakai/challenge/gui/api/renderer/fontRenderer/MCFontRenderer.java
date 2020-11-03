package de.madakai.challenge.gui.api.renderer.fontRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class MCFontRenderer implements IFontRenderer {

    @NotNull
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;

    //<editor-fold desc="font">
    @Override
    public float getStringWidth(@Nullable String text) {
        return this.fontRenderer.getStringWidth(text);
    }

    @Override
    public float getFontHeight() {
        return this.fontRenderer.FONT_HEIGHT;
    }

    @Override
    public void drawString(@Nullable String text, float x, float y, int color, boolean shadow) {
        fontRenderer.drawString(text, x, y, color, shadow);
    }
    //</editor-fold>
}
