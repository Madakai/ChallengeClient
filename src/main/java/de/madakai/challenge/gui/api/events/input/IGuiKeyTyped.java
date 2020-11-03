package de.madakai.challenge.gui.api.events.input;

/**
 * @author Madakai
 * @since 24.04.2020 19:40
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IGuiKeyTyped {

    /**
     * It is executed as soon as a key is pressed.
     *
     * @param typedChar
     * @param keyCode
     */
    void keyTyped(char typedChar, int keyCode);
}
