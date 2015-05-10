package com.alex.learn.javase.game.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by ZUOZUO on 2015/5/10.
 */
public class GameUtil {
    private GameUtil() {}

    public static Image getImage(String path) {
        BufferedImage image = null;
        URL u = GameUtil.class.getClassLoader().getResource(path);

        try {
            image = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
