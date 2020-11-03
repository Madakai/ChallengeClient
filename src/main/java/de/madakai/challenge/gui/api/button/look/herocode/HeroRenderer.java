package de.madakai.challenge.gui.api.button.look.herocode;

import de.madakai.challenge.gui.api.button.Button;
import de.madakai.challenge.gui.api.button.IButtonRenderer;
import de.madakai.challenge.gui.api.renderer.Renderer;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public abstract class HeroRenderer<T extends Button<T>> implements IButtonRenderer<T> {

    protected final int siteBarWidth = 2;

    protected void drawSiteBarLeft(int x, int y, int height) {
        Renderer.drawRect(x, y, siteBarWidth, height, this.getSecPrimaryColor());
    }

    protected void drawSiteBarRight(int x, int y, int width, int height) {
        Renderer.drawRect(x + width - siteBarWidth, y, siteBarWidth, height, this.getSecPrimaryColor());
    }

    public @NotNull Color getPrimaryColor() {
        return new Color(255, 41, 41);
    }

    public @NotNull Color getSecPrimaryColor() {
        return new Color(255, 73, 73);
    }

    public @NotNull Color getTextColor() {
        return Color.WHITE;
    }

    public @NotNull Color getSubTextColor() {
        return Color.GRAY;
    }

    public @NotNull Color getBgColor() {
        return Color.BLACK;
    }

    public @NotNull Color getSubBgColor() {
        return new Color(14, 14, 14, 238);
    }
}
