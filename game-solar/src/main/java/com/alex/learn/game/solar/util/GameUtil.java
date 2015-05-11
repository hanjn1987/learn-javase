package com.alex.learn.game.solar.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by hanjunnan on 15/5/11.
 */
public class GameUtil {
    private GameUtil(){}

    public static Image getImage(String path){
        BufferedImage bi=null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            System.out.println(u);
            bi = javax.imageio.ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}
