package de.madakai.challenge.gui.api.button.impl;

import de.madakai.challenge.gui.api.button.impl.value.ValueBtn;

/**
 * @author Madakai
 * @since 24.04.2020 22:44
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class CheckBtn extends ValueBtn<CheckBtn> {

    private boolean state;

    public CheckBtn(String name, boolean state) {
        super(name);
        this.state = state;
    }

    @Override
    protected void onMouseClickOnButton(int mouseButton, int mouseX, int mouseY) {
        if (mouseButton == 0) {
            this.toggle();

            if (this.valueChangeListener != null)
                this.valueChangeListener.onChange(this);
        }

        super.onMouseClickOnButton(mouseButton, mouseX, mouseY);
    }

    public boolean getState() {
        return this.state;
    }

    public void toggle() {
        this.state = !this.state;
    }
}
