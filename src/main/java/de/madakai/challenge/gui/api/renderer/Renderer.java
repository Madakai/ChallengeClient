package de.madakai.challenge.gui.api.renderer;

import lombok.val;
import lombok.var;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * @author Madakai
 * @since 09.07.2020 05:27
 * Copyright © 2020 | Madakai | All rights reserved.
 */
public final class Renderer {

    public static void drawRoundRect(int x, int y, int width, int height, int cornerRadius, @NotNull Color color) {
        Gui.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        Gui.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        Gui.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());

        drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }

    private static void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f((float) color.getRed() / 255, (float) color.getGreen() / 255, (float) color.getBlue() / 255, (float) color.getAlpha() / 255);

        val tessellator = Tessellator.getInstance();
        val worldRenderer = tessellator.getWorldRenderer();

        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0).endVertex();

        for (var i = (int) (startAngle / 360.0 * 100); i <= (int) (endAngle / 360.0 * 100); i++) {
            var angle = (Math.PI * 2 * i / 100) + Math.toRadians(180);
            worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0).endVertex();
        }

        tessellator.draw();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    public static void drawRect(float x, float y, float width, float height, int color) {
        Gui.drawRect((int) x, (int) y, (int) (x + width), (int) (y + height), color);
    }

    public static void drawRect(float x, float y, float width, float height, @NotNull Color color) {
        drawRect(x, y, width, height, color.getRGB());
    }

    public static void drawHollowRect(int x, int y, int width, int height, int borderSize, int color) {
        drawRect(x, y, width, borderSize, color);
        drawRect(x, y + height, width, borderSize, color);

        drawRect(x, y, borderSize, height, color);
        drawRect(x + width, y, borderSize, height, color);
    }

    /**
     * Draw a 1 pixel withe horizontal line.
     */
    public static void drawHorizontalLine(int x, int y, int width, int color) {
        drawRect(x, y, width, 1, color);
    }

    /**
     * Draw a 1 pixel withe vertical line.
     */
    public static void drawVerticalLine(int x, int y, int height, int color) {
        drawRect(x, y, 1, height, color);
    }


    /**
     * @see GL11#glScissor(int, int, int, int)
     */
    public static void glScissor(float x, float y, float width, float height) {
        val sr = new ScaledResolution(Minecraft.getMinecraft());
        val factor = sr.getScaleFactor();

        val x2 = x + width;
        val y2 = y + height;

        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        GL11.glScissor((int) (x * factor), (int) ((sr.getScaledHeight() - y2) * factor), (int) ((x2 - x) * factor), (int) ((y2 - y) * factor));
    }
}
