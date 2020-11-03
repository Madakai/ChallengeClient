package de.madakai.challenge.gui.api.renderer;

import de.madakai.challenge.gui.api.renderer.fontRenderer.IFontRenderer;
import de.madakai.challenge.gui.api.renderer.fontRenderer.MCFontRenderer;
import net.minecraft.util.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class FontHelper {

    private static @NotNull IFontRenderer fontRenderer = new MCFontRenderer();

    private static int color;

    private static boolean shadow;

    private static boolean centerHorizontal;

    private static boolean centerVertical;

    private static float scale = 1.0F;

    public static void draw(String text, float x, float y) {
        if (text == null || text.isEmpty())
            return;

        if (centerHorizontal)
            x -= getStringWidth(text) / 2;

        if (centerVertical)
            y -= getFontHeight() / 2.5F;

        if (scale != 1) {
            x /= scale;
            y /= scale;
        }

        fontRenderer.drawString(text, x, y, color, shadow);
    }

    public static float getStringWidth(String text) {
        return fontRenderer.getStringWidth(StringUtils.stripControlCodes(text)) * scale;
    }

    public static float getFontHeight() {
        return fontRenderer.getFontHeight() * scale;
    }

    public static void setCenterHorizontal(boolean centerHorizontal) {
        FontHelper.centerHorizontal = centerHorizontal;
    }

    public static void setCenterVertical(boolean centerVertical) {
        FontHelper.centerVertical = centerVertical;
    }

    public static void setScale(float scale) {
        FontHelper.scale = scale;
    }

    public static void setColor(Color color) {
        FontHelper.color = color.getRGB();
    }

    public static void setColor(int color) {
        FontHelper.color = color;
    }

    public static void setCenter() {
        centerVertical = true;
        centerHorizontal = true;
    }

    public static void setShadow(boolean shadow) {
        FontHelper.shadow = shadow;
    }

    public static void setDefaults() {
        color = Color.WHITE.getRGB();
        shadow = false;
        centerHorizontal = false;
        centerVertical = false;
        scale = 1;
    }

    public static void setLook(@NotNull IFontRenderer look) {
        FontHelper.fontRenderer = look;
    }
}
