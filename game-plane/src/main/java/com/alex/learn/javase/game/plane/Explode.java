package com.alex.learn.javase.game.plane;

import java.awt.*;

/**
 * Created by ZUOZUO on 2015/5/10.
 */
public class Explode {
    double x, y;
    static Image[] images = new Image[16];

    static {
        for (int i = 0; i < 16; i++) {
            images[i] = GameUtil.getImage("explode/e" + (i + 1) + ".gif");
        }
    }

    int count;

    public void draw(Graphics g) {
        if (count <= 15) {
            g.drawImage(images[count], (int) x, (int) y, null);
            count++;
        }
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
