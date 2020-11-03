package de.madakai.challenge.gui.api.button.look.herocode.look;

import de.madakai.challenge.gui.api.button.impl.ComboBoxBtn;
import de.madakai.challenge.gui.api.button.look.herocode.HeroRenderer;
import de.madakai.challenge.gui.api.renderer.FontHelper;
import de.madakai.challenge.gui.api.renderer.Renderer;
import lombok.val;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class HeroComboBoxBtn extends HeroRenderer<ComboBoxBtn> {

    @Override
    public void render(@NotNull ComboBoxBtn btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks) {
        this.drawSiteBarRight(x, y, width, height);

        Renderer.drawRect(x, y, width, height, this.getSubBgColor());
        this.drawSiteBarRight(x, y, width, height);

        val options = btn.getOptions();
        val selectOption = btn.getSelectOption();

        if (btn.isSelectable())
            height = height / (options.length + 1);

        FontHelper.setDefaults();
        FontHelper.setCenter();
        FontHelper.draw(btn.getName(), x + width / 2, y + height / 2);

        if (!btn.isSelectable())
            return;

        for (val option : options) {
            y += height;

            val selected = option.equalsIgnoreCase(selectOption);

            Renderer.drawRect(x, y, width, height, selected ? this.getPrimaryColor() : this.getSubBgColor());

            FontHelper.setDefaults();
            FontHelper.setColor(selected ? this.getTextColor() : this.getSubTextColor());
            FontHelper.setCenterVertical(true);
            FontHelper.draw(option, x + 3, y + height / 2);
        }
    }
}
