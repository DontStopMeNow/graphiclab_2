package ru.nsu.shmakov.model;

import ru.nsu.shmakov.controller.*;
import ru.nsu.shmakov.data.ConvolutionMat;
import ru.nsu.shmakov.data.MyColorScheme;
import ru.nsu.shmakov.data.MyMat;
import ru.nsu.shmakov.view.MyForm;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kyb1k on 10.03.15.
 */
public class Filtrator {

    public Filtrator(String filename) throws IOException {
        try {
            srcImage = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("Cannot open texture image.");
            throw e;
        }

        srcMat = new MyMat(srcImage, dstScheme);
        dstMat = (MyMat) srcMat.clone();
        dstImage = dstMat.toBufferedImage();


        myForm = new MyForm();
        setControllers();

        myForm.setSrcImage(srcImage);
        myForm.setDstImage(dstImage);
    }

    public void redraw() {
        myForm.setSrcImage(srcImage);
        myForm.setDstImage(dstImage);
    }

    public void srcToDst() {
        dstMat = (MyMat) srcMat.clone();
        dstScheme = srcScheme;
        dstMat.setColorScheme(dstScheme);

        dstImage = dstMat.toBufferedImage();
        redraw();
    }

    public void dstToSrc() {
        srcMat = (MyMat) dstMat.clone();
        srcScheme = dstScheme;
        srcMat.setColorScheme(srcScheme);
        srcImage = srcMat.toBufferedImage();
        redraw();
    }

    public void doBNW() {
        srcToDst();
        dstScheme = MyColorScheme.GREY;
        dstMat.setColorScheme(dstScheme);
        dstImage = dstMat.toBufferedImage();
        redraw();
    }

    public void doBlur() {
        srcToDst();
        double[][] a = {{1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}};
        ConvolutionMat convolutionMat = new ConvolutionMat(3, 3, a);
        dstMat = Convolutor.doConvolution(dstMat, convolutionMat, ConvolutionPaddingType.DUPLICATE);
        dstImage = dstMat.toBufferedImage();
        redraw();
    }

    private MyMat srcMat;
    private BufferedImage srcImage;
    private MyColorScheme srcScheme = MyColorScheme.RGBA;

    private MyMat dstMat;
    private BufferedImage dstImage;
    private MyColorScheme dstScheme = MyColorScheme.RGBA;

    private void setControllers() {
        AquaController aquaController = new AquaController(this);
        BlurController blurController = new BlurController(this);
        BNWController bnwController   = new BNWController (this);
        DstToSrcController dstToSrcController = new DstToSrcController(this);
        SrcToDstController srcToDstController = new SrcToDstController(this);
        GammaController    gammaController    = new GammaController   (this);
        NegativeController negativeController = new NegativeController(this);
        SharpenController  sharpenController  = new SharpenController (this);
        StampingController stampingController = new StampingController(this);

        myForm.setAquaController(aquaController);
        myForm.setBlurController(blurController);
        myForm.setBnwController (bnwController);
        myForm.setDstToSrcController(dstToSrcController);
        myForm.setGammaController(gammaController);
        myForm.setNegativeController(negativeController);
        myForm.setSharpenController(sharpenController);
        myForm.setSrcToDstController(srcToDstController);
        myForm.setStampingController(stampingController);
    }
    MyForm myForm;
}
