package de.madakai.challenge.gui.api.button.look.herocode.look;

import de.madakai.challenge.gui.api.button.impl.container.PanelBtn;
import de.madakai.challenge.gui.api.button.look.herocode.HeroCodeLook;
import de.madakai.challenge.gui.api.button.look.herocode.HeroRenderer;
import de.madakai.challenge.gui.api.renderer.FontHelper;
import de.madakai.challenge.gui.api.renderer.Renderer;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 20:47
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class HeroPanelBtn extends HeroRenderer<PanelBtn> {

    @Override
    public void render(@NotNull PanelBtn btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks) {
        Renderer.drawRect(x, y, width, height, this.getBgColor());
        this.drawSiteBarLeft(x, y, height);

        FontHelper.setDefaults();
        FontHelper.setColor(HeroCodeLook.TEXT_COLOR);
        FontHelper.setCenterVertical(true);
        FontHelper.draw(btn.getName(), x + 4, y + height / 2);
    }
}
