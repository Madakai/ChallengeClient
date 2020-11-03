package de.madakai.challenge.gui.api.button.impl.value;

import de.madakai.challenge.gui.api.button.Button;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public class ValueBtn<T extends ValueBtn<T>> extends Button<T> {

    protected @Nullable IValueChange<T> valueChangeListener;

    public ValueBtn(@NotNull String name) {
        super(name);
    }

    public T onChange(@NotNull IValueChange<T> listener) {
        this.valueChangeListener = listener;

        return this.castClass();
    }
}
