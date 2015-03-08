package ru.nsu.shmakov.data;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Иван on 08.03.2015.
 */
public class MyMat implements Cloneable {

    public MyMat(int width, int height, MyColorScheme colorScheme)
            throws RuntimeException {
        if(width <= 0 || height <= 0) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }
        this.width = width;
        this.height = height;
        this.colorScheme = colorScheme;
        createNewArr(Color.WHITE.getRGB());
    }

    public MyMat(int width, int height, MyColorScheme colorScheme, int color)
            throws RuntimeException {
        if(width <= 0 || height <= 0) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }
        this.width = width;
        this.height = height;
        this.colorScheme = colorScheme;
        createNewArr(color);
    }

    public MyMat(int width, int height)
            throws RuntimeException {
        if(width <= 0 || height <= 0) {
            System.out.println("Invalid width/height.");
            throw new RuntimeException("Invalid width/height.");
        }

        this.width = width;
        this.height = height;
        this.colorScheme = MyColorScheme.RGBA;
        createNewArr(Color.WHITE.getRGB());
    }

    public MyMat(int width, int height, MyColorScheme colorScheme, MyColor[][] arr)
            throws ArrayIndexOutOfBoundsException, RuntimeException {
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

    public Object clone() {
        MyColor[][] arrClone = new MyColor[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                arrClone[i][j] = new MyColor(arr[i][j].getColor(), colorScheme);
            }
        }
        MyMat result = new MyMat(width, height, colorScheme, arrClone);
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public MyColorScheme getColorScheme() {
        return colorScheme;
    }

    public MyColor[][] getArr() {
        return arr;
    }

    public void setColorScheme(MyColorScheme colorScheme) {
        this.colorScheme = colorScheme;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                arr[i][j].setColorScheme(colorScheme);
            }
        }
    }

    public MyColor getMyColor(int x, int y)
            throws RuntimeException {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            System.out.println("Incorrect x/y.");
            throw new RuntimeException("Incorrect x/y.");
        }
        return arr[x][y];
    }

    public void setMyColor(int x, int y, MyColor myColor)
            throws RuntimeException {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            System.out.println("Incorrect x/y.");
            throw new RuntimeException("Incorrect x/y.");
        }

        arr[x][y] = myColor;
        arr[x][y].setColorScheme(colorScheme);
    }

    public BufferedImage toBufferedImage() {
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                result.setRGB(i, j, arr[i][j].getColor());
            }
        }
        return result;
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
