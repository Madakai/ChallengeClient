package de.madakai.challenge.gui.api.renderer.fontRenderer;

import org.jetbrains.annotations.Nullable;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IFontRenderer {

    float getStringWidth(@Nullable String text);

    float getFontHeight();

    void drawString(@Nullable String text, float x, float y, int color, boolean shadow);
}
