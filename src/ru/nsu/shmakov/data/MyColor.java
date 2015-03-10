package ru.nsu.shmakov.data;

import java.awt.*;

/**
 * Created by Иван on 09.03.2015.
 */
public class MyColor implements Cloneable {
    private int color = Color.WHITE.getRGB();
    private MyColorScheme colorScheme = MyColorScheme.RGBA;



    public MyColor(int color, MyColorScheme colorScheme) {
        this.color = color;
        this.colorScheme = colorScheme; // Вообще, цветовая схема - абстракция высшего порядка, т.ч. выпилить бы это отсюда.
    }

    public MyColor(Vector3 vec, MyColorScheme colorScheme) {
        int r = (int)Math.round(vec.getX());
        if (r > 255)
            r = 255;
        if (r < 0)
            r = 0;

        int g = (int)Math.round(vec.getY());
        if (g > 255)
            g = 255;
        if (g < 0)
            g = 0;

        int b = (int)Math.round(vec.getZ());
        if (b > 255)
            b = 255;
        if (b < 0)
            b = 0;

        color = 0xFF000000 | (r << 16) | (g << 8) | b;
        this.colorScheme = colorScheme;
    }
    public MyColorScheme getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(MyColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }

    public int getColor() {
        int result = Color.WHITE.getRGB();

        switch (colorScheme) {
            case RGB:
                result = color | 0xFF000000;
                break;
            case RGBA:
                result = color;
                break;
            case GREY:
                // (0.299·R+0.587·G+0.114·B)
                int shadeOfGrey = (int)Math.floor(0.299 * ((color >> 16) & 0xFF) +
                                                  0.587 * ((color >> 8 ) & 0xFF) +
                                                  0.114 * ((color)       & 0xFF));

                result = 0xFF000000 | (shadeOfGrey << 16) | (shadeOfGrey << 8) | shadeOfGrey;
                break;
        }

        return result;
    }

    public int getRed() {
        return (color >> 16) & 0xFF;
    }

    public int getGreen() {
        return (color >> 8) & 0xFF;
    }

    public int getBlue() {
        return color & 0xFF;
    }

    public int getAlpha() {
        return (color >> 24) & 0xFF;
    }

    public Vector3 multiplex(double k) {
        int r = getRed();
        int g = getGreen();
        int b = getBlue();

        double dr = r * k;
        double dg = g * k;
        double db = b * k;


        return new Vector3(dr, dg, db);
    }

    public void setColor(int color) {
        this.color = color;
    }

}
