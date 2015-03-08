package ru.nsu.shmakov;

import ru.nsu.shmakov.data.ConvolutionMat;
import ru.nsu.shmakov.data.MyColorScheme;
import ru.nsu.shmakov.data.MyMat;
import ru.nsu.shmakov.model.ConvolutionPaddingType;
import ru.nsu.shmakov.model.Convolutor;

/**
 * Created by Иван on 08.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        MyMat mm = new MyMat(100, 100, MyColorScheme.RGBA);
        ConvolutionMat cm = new ConvolutionMat(3, 3);
        Convolutor.doPadding(mm, cm, ConvolutionPaddingType.ZERO_CONST);
    }
}
