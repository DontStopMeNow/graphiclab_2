package ru.nsu.shmakov.model;

import ru.nsu.shmakov.data.ConvolutionMat;
import ru.nsu.shmakov.data.MyColor;
import ru.nsu.shmakov.data.MyColorScheme;
import ru.nsu.shmakov.data.MyMat;

/**
 * Created by Иван on 09.03.2015.
 */
public class Convolutor {
    public static MyMat doConvolution(MyMat source, ConvolutionMat cMat, ConvolutionPaddingType type) {
        MyColor[][] newArr = new MyColor[source.getWidth()  + 2*(cMat.getWidth ()/2)]
                                        [source.getHeight() + 2*(cMat.getHeight()/2)];

        MyMat result = new MyMat(source.getWidth(), source.getHeight(), source.getColorScheme());
        return result;
    }

    public static MyColor[][] doPadding(MyMat source, ConvolutionMat cMat, ConvolutionPaddingType type) {
        int shiftX = (cMat.getWidth ()/2);
        int shiftY = (cMat.getHeight()/2);

        int sourceWidth  = source.getWidth ();
        int sourceHeight = source.getHeight();

        int newWidth  = sourceWidth  + (2 * shiftX);
        int newHeight = sourceHeight + (2 * shiftY);
        MyColor[][] newArr = new MyColor[newWidth][newHeight];

        MyColorScheme cs = source.getColorScheme();

        switch (type) {
            case ZERO_CONST:
                for (int i = 0; i < newWidth; i++) {
                    for (int j = 0; j < newHeight; j++) {
                        if((i < shiftX) || (j < shiftY) || (i >= newWidth - shiftX ) || (j >= newHeight - shiftY) ) {
                            newArr[i][j] = new MyColor(0, cs);
                        }
                        else {
                            newArr[i][j] = source.getMyColor(i - shiftX, j - shiftY);
                        }
                    }
                }
                break;
            case DUPLICATE:
                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        /*
                        100
                        000
                        000
                         */
                        if (x < shiftX && y < shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(0, 0).clone();
                        }
                        /*
                        010
                        000
                        000
                         */
                        if (x >= shiftX && x < newWidth - shiftX && y < shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(x - shiftX, 0).clone();
                        }
                        /*
                        001
                        000
                        000
                         */
                        if (x >= newWidth - shiftX && y < shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(sourceWidth - 1, 0).clone();
                        }

                        /*
                        000
                        100
                        000
                         */
                        if (x < shiftX && y >= shiftY && y < newHeight - shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(0, y - shiftY).clone();
                        }
                        /*
                        000
                        010
                        000
                         */
                        if (x >= shiftX && x < newWidth - shiftX && y >= shiftY && y < newHeight - shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(x - shiftX, y - shiftY).clone();
                        }
                        /*
                        000
                        001
                        000
                         */
                        if (x >= newWidth - shiftX && y >= shiftY && y < newHeight - shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(sourceWidth - 1, y - shiftY).clone();
                        }

                        /*
                        000
                        000
                        100
                         */
                        if (x < shiftX && y >= newHeight - shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(0, sourceHeight - 1).clone();
                        }
                        /*
                        000
                        000
                        010
                         */
                        if (x >= shiftX && x < newWidth - shiftX && y >= newHeight - shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(x - shiftX, sourceHeight - 1).clone();
                        }
                        /*
                        000
                        000
                        001
                         */
                        if (x >= newWidth - shiftX &&  y >= newHeight - shiftY) {
                            newArr[x][y] = (MyColor)source.getMyColor(sourceWidth - 1, sourceHeight - 1).clone();
                        }
                    }
                }
                break;
        }
        return newArr;
    }
}
