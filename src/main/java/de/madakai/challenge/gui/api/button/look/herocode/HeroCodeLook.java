package de.madakai.challenge.gui.api.button.look.herocode;

import de.madakai.challenge.gui.api.button.IButtonRenderer;
import de.madakai.challenge.gui.api.button.impl.CheckBtn;
import de.madakai.challenge.gui.api.button.impl.ClickBtn;
import de.madakai.challenge.gui.api.button.impl.ComboBoxBtn;
import de.madakai.challenge.gui.api.button.impl.SliderBtn;
import de.madakai.challenge.gui.api.button.impl.container.ModuleBtn;
import de.madakai.challenge.gui.api.button.impl.container.PanelBtn;
import de.madakai.challenge.gui.api.button.look.IButtonLook;
import de.madakai.challenge.gui.api.button.look.herocode.look.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Madakai
 * @since 24.04.2020 20:47
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class HeroCodeLook implements IButtonLook {

    public static final Color BACKGROUND_COLOR = Color.BLACK, PRIMARY_COLOR = Color.RED, TEXT_COLOR = Color.WHITE;

    private final Map<Class, IButtonRenderer> lookMap = new HashMap<>();

    public HeroCodeLook() {
        lookMap.put(CheckBtn.class, new HeroCheckBtn());
        lookMap.put(SliderBtn.class, new HeroSliderBtn());
        lookMap.put(ClickBtn.class, new HeroClickBtn());
        lookMap.put(PanelBtn.class, new HeroPanelBtn());
        lookMap.put(ModuleBtn.class, new HeroModuleBtn());
        lookMap.put(ComboBoxBtn.class, new HeroComboBoxBtn());
    }

    @Override
    public Map<Class, IButtonRenderer> getLookMap() {
        return this.lookMap;
    }
}
