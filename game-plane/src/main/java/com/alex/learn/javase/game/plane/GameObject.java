package com.alex.learn.javase.game.plane;

import java.awt.*;

/**
 * Created by ZUOZUO on 2015/5/10.
 */
public class GameObject {
    Image image;
    double x, y;
    int speed;
    int width, height;

    public Rectangle getReacangle() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public GameObject(Image image, double x, double y, int speed, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.speed = 3;
    }

    public GameObject() {
        this.speed = 3;
    }
}


