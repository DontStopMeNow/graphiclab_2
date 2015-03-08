package ru.nsu.shmakov.data;

import java.awt.*;

/**
 * Created by Иван on 09.03.2015.
 */
public class MyColor {
    private int color = Color.WHITE.getRGB();
    private MyColorScheme colorScheme = MyColorScheme.RGBA;

    public MyColor(int color, MyColorScheme colorScheme) {
        this.color = color;
        this.colorScheme = colorScheme;
    }

    public MyColorScheme getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(MyColorScheme colorScheme) {
        this.colorScheme = colorScheme;
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

    public void setColor(int color) {
        this.color = color;
    }

}
