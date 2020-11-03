package de.madakai.challenge.gui.api.button.look;

import de.madakai.challenge.gui.api.button.IButtonRenderer;
import de.madakai.challenge.gui.api.button.look.herocode.HeroCodeLook;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Madakai
 * @since 24.04.2020 20:51
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@SuppressWarnings("ALL")
public final class ButtonLook {

    private static Map<Class, IButtonRenderer> lookMap = new HashMap<>();

    public static final HeroCodeLook HERO_CODE_LOOK = new HeroCodeLook();

    static {
        setLook(HERO_CODE_LOOK);
    }

    @Nullable
    public static IButtonRenderer getRenderer(Class clazz) {
        return lookMap.getOrDefault(clazz, null);
    }

    public static void setLook(@NotNull IButtonLook buttonLook) {
        lookMap = buttonLook.getLookMap();
    }
}
