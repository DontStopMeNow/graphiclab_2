package ru.nsu.shmakov;

import ru.nsu.shmakov.data.MyColor;
import ru.nsu.shmakov.data.MyColorScheme;
import ru.nsu.shmakov.data.MyMat;

/**
 * Created by Иван on 08.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        MyColor[][] mca = new MyColor[10][10];
        MyMat mm = new MyMat(10, 10, MyColorScheme.RGBA, mca);
    }
}
