package de.madakai.challenge.gui.api.button.impl;

import de.madakai.challenge.gui.api.button.impl.value.ValueBtn;
import lombok.Getter;
import lombok.val;
import lombok.var;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@Getter
public final class ComboBoxBtn extends ValueBtn<ComboBoxBtn> {

    private final String[] options;
    private String selectOption;

    private boolean selectable;

    public ComboBoxBtn(@NotNull String name, String selectOption, String[] options) {
        super(name);
        this.options = options;
        this.selectOption = selectOption;
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void onMouseClickOnButton(int mouseButton, int mouseX, int mouseY) {
        if (selectable) {
            val x = this.getAbsoluteX();
            var y = this.getAbsoluteY();

            for (val option : this.options) {
                y = y + this.height;

                if (mouseX > x && mouseX < x + this.width && mouseY > y && mouseY < y + this.height) {
                    this.selectOption = option;

                    if (this.valueChangeListener != null)
                        this.valueChangeListener.onChange(this);
                }
            }
        }

        this.selectable = !this.selectable;

        super.onMouseClickOnButton(mouseButton, mouseX, mouseY);
    }

    @Override
    public int getHeight() {
        return this.selectable ? this.height * (this.options.length + 1) : super.getHeight();
    }
}
