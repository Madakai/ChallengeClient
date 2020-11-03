package de.madakai.challenge.gui.api.screen;

import de.madakai.challenge.gui.api.events.IGuiAllEvents;
import de.madakai.challenge.gui.api.events.IGuiClosed;
import de.madakai.challenge.gui.api.events.IGuiInit;
import de.madakai.challenge.gui.api.events.IGuiRender;
import de.madakai.challenge.gui.api.events.input.IGuiKeyTyped;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiHandleMouseInput;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiMouseClickAndMove;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiMouseClicked;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiMouseReleased;
import de.madakai.challenge.gui.api.widgets.IWidget;
import de.madakai.challenge.gui.api.widgets.Widget;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@Getter
@NoArgsConstructor
public class WidgetContainer implements IGuiAllEvents {

    private final List<IWidget> widgets = new ArrayList<>();

    @NotNull
    private List<IWidget> visibleWidgets = new ArrayList<>();

    @Setter
    private boolean visible = true;

    public WidgetContainer(boolean visible) {
        this.visible = visible;
    }

    /**
     * Render all visible widgets.
     */
    public void render(int mouseX, int mouseY, float partialTicks) {
        if (this.notVisible())
            return;

        this.visibleWidgets = (this.widgets.stream().filter(IWidget::isVisible).collect(Collectors.toList()));
        Collections.reverse(this.visibleWidgets);

        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiRender)
                ((IGuiRender) widget).render(mouseX, mouseY, partialTicks);
        });
    }

    public final boolean notVisible() {
        return !this.visible;
    }

    public final void addAll(@NotNull Widget... widgets) {
        this.widgets.addAll(Arrays.asList(widgets));
    }

    public final void add(@NotNull Widget widget) {
        this.widgets.add(widget);
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        if (this.notVisible())
            return;

        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiKeyTyped)
                ((IGuiKeyTyped) widget).keyTyped(typedChar, keyCode);
        });
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (this.notVisible())
            return false;

        for (val widget : this.widgets) {
            if (widget instanceof IGuiMouseClicked)
                if (((IGuiMouseClicked) widget).mouseClicked(mouseX, mouseY, mouseButton))
                    return true;
        }

        return false;
    }

    @Override
    public void mouseClickAndMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        if (this.notVisible())
            return;

        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiMouseClickAndMove)
                ((IGuiMouseClickAndMove) widget).mouseClickAndMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
        });
    }

    @Override
    public void handleMouseInput() {
        if (this.notVisible())
            return;

        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiHandleMouseInput)
                ((IGuiHandleMouseInput) widget).handleMouseInput();
        });
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        if (this.notVisible())
            return;

        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiMouseReleased)
                ((IGuiMouseReleased) widget).mouseReleased(mouseX, mouseY, mouseButton);
        });
    }

    @Override
    public void onGuiClosed() {
        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiClosed)
                ((IGuiClosed) widget).onGuiClosed();
        });
    }

    @Override
    public void initGui() {
        this.visibleWidgets.forEach(widget -> {
            if (widget instanceof IGuiInit)
                ((IGuiInit) widget).initGui();
        });
    }
}
