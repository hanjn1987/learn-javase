package com.alex.learn.game.solar.solar;

import com.alex.learn.game.solar.util.GameUtil;

import java.awt.*;

/**
 * Created by hanjunnan on 15/5/12.
 */
public class Star {
    Image image;
    double x, y;
    int width, height;

    public void draw(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }

    public Star() {
    }

    public Star(Image image) {
        this.image = image;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public Star(Image image, double x, double y) {
        this(image);
        this.x = x;
        this.y = y;
    }

    public Star(String imagePath, double x, double y) {
        this(GameUtil.getImage(imagePath), x, y);
    }
}
