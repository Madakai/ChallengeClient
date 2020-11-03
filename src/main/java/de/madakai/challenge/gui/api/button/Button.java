package de.madakai.challenge.gui.api.button;

import de.madakai.challenge.gui.api.button.look.ButtonLook;
import de.madakai.challenge.gui.api.events.IGuiRender;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiMouseClicked;
import de.madakai.challenge.gui.api.widgets.Widget;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Madakai
 * @since 24.04.2020 20:14
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@Getter
@Setter
public abstract class Button<T extends Button<T>> extends Widget implements IGuiMouseClicked, IGuiRender {

    @NotNull
    protected final String name;

    @Nullable
    protected IButtonClick<T> clickListener;

    @Nullable
    protected IButtonRenderer<T> buttonRenderer;

    @SuppressWarnings("ALL")
    public Button(@NotNull String name) {
        this.name = name;
        this.buttonRenderer = ButtonLook.getRenderer(this.getClass());
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        if (this.buttonRenderer == null)
            return;

        this.buttonRenderer.render(castClass(), this.getAbsoluteX(), this.getAbsoluteY(), this.getWidth(), this.getHeight(), mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (this.notInteract() || this.notHover(mouseX, mouseY))
            return false;

        if (this.clickListener != null)
            this.clickListener.onClick(castClass(), mouseButton);

        this.onMouseClickOnButton(mouseButton, mouseX, mouseY);

        return true;
    }

    protected void onMouseClickOnButton(int mouseButton, int mouseX, int mouseY) {
    }

    public @NotNull T renderer(@NotNull IButtonRenderer<T> buttonRenderer) {
        this.buttonRenderer = buttonRenderer;

        return castClass();
    }

    public @NotNull T onClick(@NotNull IButtonClick<T> clickListener) {
        this.clickListener = clickListener;

        return castClass();
    }

    public @NotNull T disabled(boolean disabled) {
        this.disabled = disabled;

        return castClass();
    }

    public @NotNull T position(int x, int y) {
        this.position.setAbsolute(x, y);

        return castClass();
    }

    public @NotNull T position(double x, double y) {
        this.position.setRelative(x, y);

        return castClass();
    }

    public @NotNull T width(int widht) {
        this.width = widht;

        return castClass();
    }

    public @NotNull T size(int width, int height) {
        this.height = height;
        this.width = width;

        return castClass();
    }

    @NotNull
    public T height(int height) {
        this.height = height;

        return castClass();
    }

    @NotNull
    public T visible(boolean visible) {
        this.visible = visible;

        return castClass();
    }

    @SuppressWarnings("ALL")
    public T castClass() {
        return (T) this;
    }
}

