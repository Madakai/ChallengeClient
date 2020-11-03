package de.madakai.challenge.gui.api.button.impl.value;

/**
 * @author Madakai
 * @since 24.04.2020 20:53
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IValueChange<T extends ValueBtn<T>> {

    void onChange(T btn);
}
