package de.madakai.challenge.gui.api.button.look.herocode.look;

import de.madakai.challenge.gui.api.button.impl.ClickBtn;
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
public final class HeroClickBtn extends HeroRenderer<ClickBtn> {

    @Override
    public void render(@NotNull ClickBtn btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks) {
        val hover = btn.isHover(mouseX, mouseY);
        val textColor = hover ? this.getPrimaryColor() : this.getSecPrimaryColor();

        Renderer.drawRect(x, y, width, height, this.getSubBgColor());
        this.drawSiteBarLeft(x, y, height);

        FontHelper.setDefaults();
        FontHelper.setCenter();
        FontHelper.setColor(textColor);
        FontHelper.draw(btn.getName(), x + width / 2, y + height / 2);
    }
}
