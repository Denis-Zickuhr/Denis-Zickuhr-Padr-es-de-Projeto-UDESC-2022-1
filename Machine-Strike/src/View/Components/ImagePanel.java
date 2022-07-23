package View.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel{

    private BufferedImage[] images;

    public ImagePanel(String path) {
        images = new BufferedImage[1];
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path));
            images[0] = bufferedImage;
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public ImagePanel(String path, Dimension dimension) {
        images = new BufferedImage[1];
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path));
            setPreferredSize(dimension);
            images[0] = bufferedImage;
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public ImagePanel(String[] paths, Dimension dimension) {
        images = new BufferedImage[paths.length];
        int i = 0;
        try {
            for (String s: paths
                 ) {
                BufferedImage bufferedImage = ImageIO.read(new File(paths[i]));
                setPreferredSize(dimension);
                images[i] = bufferedImage;
                i++;
            }
        } catch (IOException e) {
            System.out.println("javax.imageio.IIOException: Can't read input at file "+i+"!");
        }
    }

    public ImagePanel(String[] paths) {
        images = new BufferedImage[paths.length];
        int i = 0;
        try {
            for (String s: paths
            ) {
                BufferedImage bufferedImage = ImageIO.read(new File(paths[i]));
                images[i] = bufferedImage;
                i++;
            }
        } catch (IOException e) {
            System.out.println("javax.imageio.IIOException: Can't read input at file "+i+"!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BufferedImage image: images
             ) {
            g.drawImage(image, 0, 0, this);
        }
    }

}