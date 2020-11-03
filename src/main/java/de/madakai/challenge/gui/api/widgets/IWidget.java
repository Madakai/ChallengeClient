package de.madakai.challenge.gui.api.widgets;

import de.madakai.challenge.gui.api.utils.Vec2D;
import lombok.val;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 19:49
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IWidget {

    //<editor-fold desc="is">
    boolean isVisible();

    boolean isDisabled();
    //</editor-fold>

    //<editor-fold desc="getter">
    Vec2D getPosition();

    int getWidth();

    int getHeight();

    int getAbsoluteX();

    int getAbsoluteY();

    double getRelativeX();

    double getRelativeY();
    //</editor-fold>

    //<editor-fold desc="setter">
    void setPosition(@NotNull Vec2D position);

    void setWidth(int width);

    void setHeight(int height);

    void setPosition(int x, int y);

    void setPosition(double x, double y);
    //</editor-fold>

    //<editor-fold desc="interact test">
    /**
     * Is the widget visible and not disabled.
     *
     * @see Widget#isDisabled()
     * @see Widget#isVisible()
     */
    default boolean canInteract() {
        return this.isVisible() && !this.isDisabled();
    }

    default boolean notInteract() {
        return !this.isVisible() || this.isDisabled();
    }
    //</editor-fold>

    //<editor-fold desc="hover test">
    /**
     * If the mouse is over the renderer.
     *
     * @param mouseX Mouse X position in pixel.
     * @param mouseY Mouse Y position in pixel.
     *
     * @return Is mouse over
     */
    default boolean isHover(int mouseX, int mouseY) {
        val x = this.getAbsoluteX();
        val y = this.getAbsoluteY();

        return mouseX >= x && mouseX <= x + this.getWidth() && mouseY >= y && mouseY <= y + this.getHeight();
    }

    /**
     * If the mouse is not over the renderer.
     *
     * @param mouseX Mouse X position in pixel.
     * @param mouseY Mouse Y position in pixel.
     *
     * @return Is mouse not hover
     *
     * @see IWidget#isHover(int, int)
     */
    default boolean notHover(int mouseX, int mouseY) {
        return !this.isHover(mouseX, mouseY);
    }
    //</editor-fold>
}
