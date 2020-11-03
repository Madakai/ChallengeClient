package de.madakai.challenge.gui.api.button.look.herocode.look;

import de.madakai.challenge.gui.api.button.impl.CheckBtn;
import de.madakai.challenge.gui.api.button.look.herocode.HeroRenderer;
import de.madakai.challenge.gui.api.renderer.FontHelper;
import de.madakai.challenge.gui.api.renderer.Renderer;
import lombok.val;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 20:47
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class HeroCheckBtn extends HeroRenderer<CheckBtn> {

    @Override
    public void render(@NotNull CheckBtn btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks) {
        Renderer.drawRect(x, y, width, height, this.getSubBgColor());
        this.drawSiteBarRight(x, y, width, height);

        val state = btn.getState();

        val offsetBorder = 3;
        val size = height - offsetBorder * 2;
        val stateColor = state ? this.getPrimaryColor() : this.getBgColor();

        Renderer.drawRect(x + offsetBorder, y + offsetBorder, size, size, stateColor);

        FontHelper.setDefaults();
        FontHelper.setColor(state ? this.getTextColor(): this.getSubTextColor());
        FontHelper.setCenterVertical(true);

        val name = btn.getName();
        FontHelper.draw(name, x + width - FontHelper.getStringWidth(name) - 3, y + height / 2);
    }
}
