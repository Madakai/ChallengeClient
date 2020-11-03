package de.madakai.challenge.gui.api.button.look;

import de.madakai.challenge.gui.api.button.IButtonRenderer;

import java.util.Map;

/**
 * @author Madakai
 * @since 24.04.2020 21:15
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@SuppressWarnings("ALL")
public interface IButtonLook {

    Map<Class, IButtonRenderer> getLookMap();
}
