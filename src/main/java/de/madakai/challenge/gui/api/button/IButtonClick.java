package de.madakai.challenge.gui.api.button;

/**
 * @author Madakai
 * @since 24.04.2020 22:32
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IButtonClick<T extends Button<T>> {

    int LEFT = 0;
    int RIGHT = 1;
    int MIDDLE = 2;

    void onClick(T btn, int mouseButton);
}
