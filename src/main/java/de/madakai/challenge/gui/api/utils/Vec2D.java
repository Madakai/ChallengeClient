package de.madakai.challenge.gui.api.utils;

import lombok.val;
import lombok.var;
import net.challenge.client.ui.position.scaled.ScaledPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;

import javax.vecmath.Vector2d;
import java.io.Serializable;

/**
 * @author Madakai
 * @since 24.04.2020 19:37
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class Vec2D implements Serializable {

    private double x, y;

    public Vec2D(double x, double y) {
        this.setRelative(x, y);
    }

    public Vec2D(int x, int y) {
        this.setAbsolute(x, y);
    }

    //<editor-fold desc="create vectors">
    public static Vec2D fromRelativePosition(double x, double y) {
        return new Vec2D(x, y);
    }

    public static Vec2D fromAbsolutePosition(int x, int y) {
        return new Vec2D(x, y);
    }
    //</editor-fold>

    //<editor-fold desc="getter">
    public int getAbsoluteX() {
        final double scaledWidth_double = new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth_double();
        return (int) Math.round(x * scaledWidth_double);
    }

    public int getAbsoluteY() {
        final double scaledHeight_double = new ScaledResolution(Minecraft.getMinecraft()).getScaledHeight_double();
        return (int) Math.round(y * scaledHeight_double);
    }

    public double getRelativeX() {
        return this.x;
    }

    public double getRelativeY() {
        return this.y;
    }
    //</editor-fold>

    //<editor-fold desc="setter">
    public void setRelative(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRelativeX(double x) {
        this.x = x;
    }

    public void setRelativeY(double y) {
        this.y = y;
    }

    public void setAbsolute(int x, int y) {
        final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        this.x = (double) x / sr.getScaledWidth_double();
        this.y = (double) y / sr.getScaledHeight_double();
    }
    //</editor-fold>

    //<editor-fold desc="vecmath method">
    /**
     * Computes the dot product of the this vector and vector v1.
     *
     * @param v1 the other vector
     */
    public final double dot(Vec2D v1) {
        return (this.x * v1.x + this.y * v1.y);
    }


    /**
     * Returns the length of this vector.
     *
     * @return the length of this vector
     */
    public final double length() {
        return (double) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Returns the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public final double lengthSquared() {
        return (this.x * this.x + this.y * this.y);
    }

    /**
     * Sets the value of this vector to the normalization of vector v1.
     *
     * @param v1 the un-normalized vector
     */
    public final void normalize(Vector2d v1) {
        var norm = 0.0D;

        norm = 1.0 / Math.sqrt(v1.x * v1.x + v1.y * v1.y);

        this.x = v1.x * norm;
        this.y = v1.y * norm;
    }

    /**
     * Normalizes this vector in place.
     */
    public final void normalize() {
        val norm = 1.0D / Math.sqrt(this.x * this.x + this.y * this.y);

        this.x *= norm;
        this.y *= norm;
    }

    /**
     * Returns the angle in radians between this vector and the vector
     * parameter; the return value is constrained to the range [0,PI].
     *
     * @param v1 the other vector
     * @return the angle in radians in the range [0,PI]
     */
    public final double angle(@NotNull Vec2D v1) {
        var vDot = this.dot(v1) / (this.length() * v1.length());

        if (vDot < -1.0D) vDot = -1.0D;
        if (vDot > 1.0D) vDot = 1.0D;

        return Math.acos(vDot);
    }
    //</editor-fold>
}

