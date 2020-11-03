package de.madakai.challenge.gui.api.button.look.herocode.look;

import de.madakai.challenge.gui.api.button.impl.container.ModuleBtn;
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
public final class HeroModuleBtn extends HeroRenderer<ModuleBtn> {

    @Override
    public void render(@NotNull ModuleBtn btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks) {
        val state = btn.getState();

        Renderer.drawRect(x, y, width, height, state ? this.getPrimaryColor() : this.getSubBgColor());
        this.drawSiteBarLeft(x, y, height);

        FontHelper.setDefaults();
        FontHelper.setColor(state ? this.getTextColor() : this.getSubTextColor());
        FontHelper.setCenter();
        FontHelper.draw(btn.getName(), x + width / 2, y + height / 2);
    }
}
