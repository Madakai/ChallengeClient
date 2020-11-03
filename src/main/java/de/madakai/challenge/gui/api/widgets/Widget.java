package de.madakai.challenge.gui.api.widgets;

import de.madakai.challenge.gui.api.utils.Vec2D;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Madakai
 * @since 24.04.2020 19:49
 * Copyright © 2020 | Madakai | All rights reserved.
 */
@Getter
@Setter
public class Widget implements IWidget {

    @NotNull
    protected Vec2D position = new Vec2D(0, 0);

    protected int width;

    protected int height;

    protected boolean disabled = false;

    protected boolean visible = true;

    //<editor-fold desc="setter">
    @Override
    public void setPosition(int x, int y) {
        this.position.setAbsolute(x, y);
    }

    @Override
    public void setPosition(double x, double y) {
        this.position.setRelative(x, y);
    }
    //</editor-fold>

    //<editor-fold desc="getter">
    @Override
    public int getAbsoluteX() {
        return getPosition().getAbsoluteX();
    }

    @Override
    public double getRelativeX() {
        return getPosition().getRelativeX();
    }

    @Override
    public int getAbsoluteY() {
        return getPosition().getAbsoluteY();
    }

    @Override
    public double getRelativeY() {
        return getPosition().getRelativeY();
    }
    //</editor-fold>
}
