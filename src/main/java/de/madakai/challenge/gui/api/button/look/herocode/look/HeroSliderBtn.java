package de.madakai.challenge.gui.api.button.look.herocode.look;

import de.madakai.challenge.gui.api.button.impl.SliderBtn;
import de.madakai.challenge.gui.api.button.look.herocode.HeroCodeLook;
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
public final class HeroSliderBtn extends HeroRenderer<SliderBtn> {

    @Override
    public void render(@NotNull SliderBtn btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks) {
        Renderer.drawRect(x, y, width, height, this.getSubBgColor());

        FontHelper.setDefaults();
        FontHelper.setColor(this.getTextColor());
        FontHelper.draw(btn.getName(), x + 2, y + 2);

        val valueText = btn.getValue() + (btn.isPercent() ? "%" : "");
        FontHelper.draw(valueText, x + width - FontHelper.getStringWidth(valueText) - 3, y + 2);

        val percentBar = (float) btn.getAsPercent();
        Renderer.drawRect(x, y + height - 3, Math.min((percentBar * width), width), 2, HeroCodeLook.PRIMARY_COLOR.getRGB());

        this.drawSiteBarRight(x, y, width, height);
    }
}
