package ru.nsu.shmakov;

import ru.nsu.shmakov.data.ConvolutionMat;
import ru.nsu.shmakov.data.MyColorScheme;
import ru.nsu.shmakov.data.MyMat;
import ru.nsu.shmakov.model.ConvolutionPaddingType;
import ru.nsu.shmakov.model.Convolutor;
import ru.nsu.shmakov.model.Filtrator;
import ru.nsu.shmakov.view.MyForm;

import java.io.IOException;

/**
 * Created by Иван on 08.03.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Filtrator filtrator = new Filtrator("./resources/1.jpg");
    }
}
