package de.madakai.challenge.gui.api.button.impl.container;

import de.madakai.challenge.gui.api.button.Button;
import de.madakai.challenge.gui.api.events.IGuiAllEvents;
import de.madakai.challenge.gui.api.screen.WidgetContainer;
import de.madakai.challenge.gui.api.widgets.Widget;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 20:53
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public class ContainerBtn<T extends ContainerBtn<T>> extends Button<T> implements IGuiAllEvents {

    protected final WidgetContainer widgetContainer = new WidgetContainer(false);

    public ContainerBtn(@NotNull String name) {
        super(name);
    }

    //<editor-fold desc="gui events">
    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);

        this.widgetContainer.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        this.widgetContainer.mouseReleased(mouseX, mouseY, mouseButton);
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        this.widgetContainer.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (this.widgetContainer.mouseClicked(mouseX, mouseY, mouseButton))
            return true;

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseClickAndMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        this.widgetContainer.mouseClickAndMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    @Override
    public void handleMouseInput() {
        this.widgetContainer.handleMouseInput();
    }

    @Override
    public void onGuiClosed() {
        this.widgetContainer.onGuiClosed();
    }

    @Override
    public void initGui() {
        this.widgetContainer.initGui();
    }
    //</editor-fold>

    //<editor-fold desc="add widgets">
    public final @NotNull T addAll(@NotNull Widget... widgets) {
        this.widgetContainer.addAll(widgets);

        return this.castClass();
    }

    public final @NotNull T add(@NotNull Widget widget) {
        this.widgetContainer.add(widget);

        return this.castClass();
    }
    //</editor-fold>
}
