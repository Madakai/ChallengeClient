package de.madakai.challenge.gui.api.events.input.mouse;

/**
 * @author Madakai
 * @since 24.04.2020 19:41
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IGuiMouseClickAndMove {

    /**
     * Called when a mouse button is pressed and the mouse is moved around.
     *
     * @param mouseX Mouse X position in pixel.
     * @param mouseY Mouse Y position in pixel.
     * @param clickedMouseButton The button that was clicked on the mouse.
     * @param timeSinceLastClick The time between now and the last click is in milliseconds.
     */
     void mouseClickAndMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick);
}
