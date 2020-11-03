package de.madakai.challenge.gui.api.button.impl;

import de.madakai.challenge.gui.api.button.impl.value.ValueBtn;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiMouseClicked;
import de.madakai.challenge.gui.api.events.input.mouse.IGuiMouseReleased;
import lombok.Getter;
import net.minecraft.util.MathHelper;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 25.04.2020 17:54
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@Getter
public final class SliderBtn extends ValueBtn<SliderBtn> implements IGuiMouseClicked, IGuiMouseReleased {

    private double max, min;

    private double value;

    private boolean dragging;

    private int decimalPlaces = 1;

    private boolean percent;

    public SliderBtn(@NotNull String name, double value) {
        super(name);

        this.value = value;
    }

    public SliderBtn(@NotNull String name, double value, double min, double max) {
        this(name, value);

        this.max = max;
        this.min = min;
    }


    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);

        if (!this.dragging)
            return;

        double diff = this.max - this.min;
        double val = this.min + (MathHelper.clamp_double((mouseX - (float) this.getAbsoluteX()) / width, 0, 1)) * diff;

        this.setValue(val);
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (this.notHover(mouseX, mouseY))
            return false;

        if (!this.isDisabled() && mouseButton == 0) {
            this.dragging = true;

            return true;
        }

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        this.dragging = false;
    }

    public double getAsPercent() {
        return (this.value - this.min) / (this.max - this.min);
    }

    private void setValue(double value) {
        this.value = round(value, this.decimalPlaces);

        if (this.valueChangeListener == null)
            return;

        this.valueChangeListener.onChange(this);
    }

    public static double round(double number, int places) {
        return (int) number + (Math.round(Math.pow(10, places) * (number - (int) number))) / (Math.pow(10, places));
    }

    public SliderBtn toPercent() {
        this.percent = true;

        return this;
    }

    public SliderBtn toEvenNumber() {
        this.decimalPlaces = 0;

        return this;
    }

    public @NotNull SliderBtn setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;

        return this;
    }

    public SliderBtn setDistance(double min, double max) {
        this.max = max;
        this.min = min;

        return this;
    }
}