package de.madakai.challenge.gui.api.events.input.mouse;

/**
 * @author Madakai
 * @since 24.04.2020 19:40
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IGuiMouseClicked {

    /**
     * Called when the mouse is clicked.
     *
     * @param mouseX Mouse X position in pixel.
     * @param mouseY Mouse Y position in pixel.
     * @param mouseButton The button that was clicked on the mouse.
     *
     * @return TODO mouse
     */
     boolean mouseClicked(int mouseX, int mouseY, int mouseButton);
}
