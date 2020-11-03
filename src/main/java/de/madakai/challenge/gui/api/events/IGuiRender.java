package de.madakai.challenge.gui.api.events;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IGuiRender {

    /**
     * Render the renderer.
     *
     * @param mouseX Mouse X position in pixel.
     * @param mouseY Mouse Y position in pixel.
     * @param partialTicks How much time has elapsed since the last tick, in ticks,
     *                     for use by display rendering routines (range: 0.0 - 1.0).
     *                     This field is frozen if the display is paused to eliminate jitter.
     */
    void render(int mouseX, int mouseY, float partialTicks);
}
