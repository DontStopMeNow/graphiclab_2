package ru.nsu.shmakov.data;

import java.awt.*;

/**
 * Created by Иван on 08.03.2015.
 */
public class MyMat {

    public MyMat(int width, int height, MyColorScheme colorScheme) {
        if(width <= 0 || height <= 0) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }
        this.width = width;
        this.height = height;
        this.colorScheme = colorScheme;
        createNewArr(Color.WHITE.getRGB());
    }

    public MyMat(int width, int height, MyColorScheme colorScheme, int color) {
        if(width <= 0 || height <= 0) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }
        this.width = width;
        this.height = height;
        this.colorScheme = colorScheme;
        createNewArr(color);
    }

    public MyMat(int width, int height) {
        if(width <= 0 || height <= 0) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }

        this.width = width;
        this.height = height;
        this.colorScheme = MyColorScheme.RGBA;
        createNewArr(Color.WHITE.getRGB());
    }

    public MyMat(int width, int height, MyColorScheme colorScheme, MyColor[][] arr) {
        if(width <= 0 || height <= 0 || width*height != arr[0].length * arr.length) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }

        try {
            MyColor a = arr[width - 1][height - 1];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of array range. Incorrect width/height");
            throw e;
        }

        this.width = width;
        this.height = height;
        this.colorScheme = colorScheme;
        this.arr = arr;

    }

    private int width  = -1;
    private int height = -1;
    private MyColorScheme colorScheme = MyColorScheme.RGBA;
    private MyColor[][] arr = null;

    private void createNewArr(int color) {
        arr = null; // Ходит слушок, что если зануллировать ссылку, то сборщик мусора освободит ее быстрее...
        arr = new MyColor[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                arr[i][j] = new MyColor(color, colorScheme);
            }
        }
    }
}
