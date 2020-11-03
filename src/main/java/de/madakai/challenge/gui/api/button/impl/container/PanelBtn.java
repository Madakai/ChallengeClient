package de.madakai.challenge.gui.api.button.impl.container;

import de.madakai.challenge.gui.api.utils.Vec2D;
import lombok.val;
import lombok.var;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 20:53
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class PanelBtn extends ContainerBtn<PanelBtn> {

    private boolean dragged;

    private int xOffset, yOffset;

    public PanelBtn(@NotNull String name) {
        super(name);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        if (this.dragged)
            this.setPosition(new Vec2D(xOffset + mouseX, yOffset + mouseY));

        val xOffset = this.getAbsoluteX();
        var yOffset = this.getAbsoluteY() + this.height;

        val widgets = this.widgetContainer.getVisibleWidgets();

        for (val widget : widgets) {
            widget.setPosition(new Vec2D(xOffset, yOffset));
            widget.setWidth(this.width);
            widget.setHeight(this.height);

            yOffset += widget.getHeight();
        }

        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        this.dragged = false;

        super.mouseReleased(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (this.isHover(mouseX, mouseY)) {
            if (!this.isDisabled()) {
                if (mouseButton == 0) {
                    this.xOffset = this.getAbsoluteX() - mouseX;
                    this.yOffset = this.getAbsoluteY() - mouseY;

                    this.dragged = true;
                }

                if (mouseButton == 1) {
                    this.widgetContainer.setVisible(!this.widgetContainer.isVisible());
                }
            }

            return true;
        }

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
