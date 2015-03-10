package ru.nsu.shmakov.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by kyb1k on 09.03.15.
 */
public class ImagePanel extends JPanel {
    public ImagePanel() {
        super(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        if(image != null) {
            Graphics2D g2 = image.createGraphics();
            g2d.drawImage(image, ((getWidth()- image.getWidth())/2), (getHeight()- image.getHeight())/2, new Color(255,255,255), null);
        }
    }

    private int imageWidth;
    private int imageHeight;


    private Graphics2D g2d;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    private BufferedImage image;
}
