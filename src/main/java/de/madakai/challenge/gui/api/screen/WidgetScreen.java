package de.madakai.challenge.gui.api.screen;

import de.madakai.challenge.gui.api.widgets.Widget;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public class WidgetScreen extends GuiScreen {

    private final WidgetContainer widgetContainer = new WidgetContainer();

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.widgetContainer.render(mouseX, mouseY, partialTicks);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void handleMouseInput() throws IOException {
        this.widgetContainer.handleMouseInput();

        super.handleMouseInput();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (this.widgetContainer.mouseClicked(mouseX, mouseY, mouseButton))
            return;

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        this.widgetContainer.mouseReleased(mouseX, mouseY, state);

        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        this.widgetContainer.keyTyped(typedChar, keyCode);

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public final void addAll(@NotNull Widget... widgets) {
        this.widgetContainer.addAll(widgets);
    }

    public final void add(@NotNull Widget widget) {
        this.widgetContainer.add(widget);
    }
}
