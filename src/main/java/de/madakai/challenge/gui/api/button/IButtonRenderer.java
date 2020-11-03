package de.madakai.challenge.gui.api.button;

import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 20:47
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public interface IButtonRenderer<T extends Button<T>> {

    void render(@NotNull T btn, int x, int y, int width, int height, int mouseX, int mouseY, float partialTicks);
}
