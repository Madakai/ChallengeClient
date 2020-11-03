package de.madakai.challenge.gui.api.events.input.mouse;

/**
 * @author Madakai
 * @since 24.04.2020 19:41
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IGuiMouseReleased {

    /**
     * Called when a mouse button is released.
     *
     * @param mouseX Mouse X position in pixel.
     * @param mouseY Mouse Y position in pixel.
     * @param mouseButton The button that was clicked on the mouse.
     */
     void mouseReleased(int mouseX, int mouseY, int mouseButton);
}
