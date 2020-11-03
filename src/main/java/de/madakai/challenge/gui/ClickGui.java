package de.madakai.challenge.gui;

import de.madakai.challenge.gui.api.button.Button;
import de.madakai.challenge.gui.api.button.impl.CheckBtn;
import de.madakai.challenge.gui.api.button.impl.SliderBtn;
import de.madakai.challenge.gui.api.button.impl.container.ModuleBtn;
import de.madakai.challenge.gui.api.button.impl.container.PanelBtn;
import de.madakai.challenge.gui.api.screen.WidgetScreen;
import net.challenge.client.core.ClientCore;
import net.challenge.client.features.modules.IModule;
import net.challenge.client.features.modules.ModuleCategory;
import net.challenge.configu.value.Value;
import net.challenge.configu.value.impl.VBool;
import net.challenge.configu.value.impl.VNumber;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * @author Madakai
 * @since 09.07.2020 05:33
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class ClickGui extends WidgetScreen {

    public ClickGui() {
        final Collection<IModule> mods = ClientCore.INSTANCE.getModuleRegistry().getModules();

        for (ModuleCategory category : ModuleCategory.values()) {
            final PanelBtn categoryBtn = new PanelBtn(category.name())
                    .position(10, 30)
                    .size(80, 15);

            final Collection<IModule> categoryMods = mods.stream()
                    .filter(mod -> mod.getCategory().equals(category))
                    .sorted(Comparator.comparingInt(module -> module.getName().length()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            categoryMods.forEach(module -> {
                final ModuleBtn modBtn = new ModuleBtn(module.getName(), module.isEnabled())
                        .onStateChange(module::setEnabled);

                final Collection<Value<?, ?>> values = module.getValues();

                if (values == null)
                    return;

                values.forEach(value -> {
                            final Button<?> button = this.valueToButton(value);

                            if (button != null)
                                modBtn.add(button);
                        });

                categoryBtn.add(modBtn);
            });

            this.add(categoryBtn);
        }
    }

    private @Nullable Button valueToButton(@NotNull Value value) {
        Button button = null;

        /*if (value instanceof VOption) {
            val option = (VOption) value;
            button = new ComboBoxBtn(option.getName(), option.get(), option.getOptions())
                    .onChange(btn -> option.set(btn.getSelectOption()));

        } else */

        if (value instanceof VBool) {
            final VBool bool = (VBool) value;

            button = new CheckBtn(bool.getName(), bool.getValue())
                    .onChange(btn -> bool.setValue(btn.getState()));

        } else if (value instanceof VNumber) {
            final VNumber number = (VNumber) value;

            if (number.hasDistance())
                button = new SliderBtn(number.getName(), number.getValue())
                        .setDistance(number.getMinimum(), number.getMaximum())
                        .setDecimalPlaces(number.getDecimalPlaces())
                        .onChange(btn -> number.setValue(btn.getValue()));
        }

        return button;
    }
}
