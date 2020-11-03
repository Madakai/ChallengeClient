package de.madakai.challenge.gui.api.button.impl.container;

import de.madakai.challenge.gui.api.button.impl.value.IValueChange;
import de.madakai.challenge.gui.api.utils.Vec2D;
import lombok.val;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Madakai
 * @since 24.04.2020 20:53
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class ModuleBtn extends ContainerBtn<ModuleBtn> {

    private boolean alwaysEnabled;

    private boolean state;

    private @Nullable IModuleStateChange stateChangeListener;

    public ModuleBtn(@NotNull String name, boolean state) {
        super(name);

        this.state = state;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        int xOffset = this.getAbsoluteX() + this.width;
        int yOffset = this.getAbsoluteY();

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
    protected void onMouseClickOnButton(int mouseButton, int mouseX, int mouseY) {
        if (mouseButton == 0 && !this.alwaysEnabled) {
            this.state = !this.state;

            if (this.stateChangeListener != null)
                this.stateChangeListener.changeState(this.state);
        }

        else if (mouseButton == 1)
            this.widgetContainer.setVisible(!this.widgetContainer.isVisible());

        super.onMouseClickOnButton(mouseButton, mouseX, mouseY);
    }

    public boolean getState() {
         return this.state;
    }

    public @NotNull ModuleBtn setAlwaysEnabled(boolean alwaysEnabled) {
        this.alwaysEnabled = alwaysEnabled;

        return this.castClass();
    }

    public @NotNull ModuleBtn onStateChange(@NotNull IModuleStateChange stateChangeListener) {
        this.stateChangeListener = stateChangeListener;

        return this.castClass();
    }
}
