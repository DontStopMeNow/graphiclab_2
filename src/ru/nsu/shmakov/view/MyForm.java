package ru.nsu.shmakov.view;

import ru.nsu.shmakov.controller.*;
import ru.nsu.shmakov.data.ConvolutionMat;
import ru.nsu.shmakov.data.MyColor;
import ru.nsu.shmakov.data.MyColorScheme;
import ru.nsu.shmakov.data.MyMat;
import ru.nsu.shmakov.model.ConvolutionPaddingType;
import ru.nsu.shmakov.model.Convolutor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kyb1k on 09.03.15.
 */
public class MyForm extends JFrame  {
    private JPanel rootPanel;
    private ImagePanel srcImagePanel;
    private ImagePanel dstImagePanel;
    private JLabel DestinationLable;
    private JLabel SourceLable;
    private JLabel OptionLable;
    private JButton srcToDstButton;
    private JButton dstToSrcButton;
    private JButton toBNWButton;
    private JSlider contoursSlider;
    private JButton blurButton;
    private JButton sharpenButton;
    private JButton negativeButton;
    private JButton stampingButton;
    private JButton aquaButton;
    private JRadioButton contoursRadioButton;
    private JRadioButton gammaRadioButton;
    private JSlider gammaSlider;
    private JButton saveButton;
    private JButton openButton;

    AquaController aquaController;
    BlurController blurController;
    BNWController  bnwController;
    DstToSrcController dstToSrcController;
    SrcToDstController srcToDstController;
    GammaController    gammaController;
    NegativeController negativeController;
    SharpenController  sharpenController;
    StampingController stampingController;

    public void setAquaController(AquaController aquaController) {
        this.aquaController = aquaController;
    }

    public void setBlurController(BlurController blurController) {
        this.blurController = blurController;
    }

    public void setBnwController(BNWController bnwController) {
        this.bnwController = bnwController;
    }

    public void setDstToSrcController(DstToSrcController dstToSrcController) {
        this.dstToSrcController = dstToSrcController;
    }

    public void setSrcToDstController(SrcToDstController srcToDstController) {
        this.srcToDstController = srcToDstController;
    }

    public void setNegativeController(NegativeController negativeController) {
        this.negativeController = negativeController;
    }

    public void setGammaController(GammaController gammaController) {
        this.gammaController = gammaController;
    }

    public void setSharpenController(SharpenController sharpenController) {
        this.sharpenController = sharpenController;
    }

    public void setStampingController(StampingController stampingController) {
        this.stampingController = stampingController;
    }

    public MyForm() throws IOException {
        super("Main Frame");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new DimensionUIResource(600, 600));

        /*BufferedImage img;
        try {
            img = ImageIO.read(new File("./resources/1.jpg"));
        } catch (IOException e) {
            System.out.println("Cannot open texture image.");
            throw e;
        }

        double[][] a = {{1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}};

        //
        double[][] a = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1}};
        //
        ConvolutionMat cm = new ConvolutionMat(9, 9, a);
        cm.calculateDiv();

        MyMat mm = new MyMat(img, MyColorScheme.RGB);
        //MyColor[][] myColors = Convolutor.doPadding(mm, cm, ConvolutionPaddingType.DUPLICATE);
        //mm = new MyMat(mm.getWidth() + 8, mm.getHeight() + 8, MyColorScheme.RGB, myColors);
        mm = Convolutor.doConvolution(mm, cm, ConvolutionPaddingType.DUPLICATE);
        BufferedImage dstImage = mm.toBufferedImage();

        srcImagePanel.setImage(img);
        dstImagePanel.setImage(dstImage);*/
        setSize(900, 600);
        setVisible(true);

        srcToDstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                srcToDstController.doAction();
                repaint();
            }
        });
        dstToSrcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dstToSrcController.doAction();
                repaint();
            }
        });
        toBNWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bnwController.doAction();
                repaint();
            }
        });
    repaint();
        blurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blurController.doAction();
                repaint();
            }
        });
    }

    public void setSrcImage(BufferedImage bi) {
        srcImagePanel.setImage(bi);
    }
    public void setDstImage(BufferedImage bi) {
        dstImagePanel.setImage(bi);
    }
}
