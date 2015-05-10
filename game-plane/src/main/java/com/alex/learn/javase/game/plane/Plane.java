package com.alex.learn.javase.game.plane;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by ZUOZUO on 2015/5/10.
 */
public class Plane extends GameObject {
    private boolean isLive;

    private boolean left, right, up, down;

    public void draw(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, null);
        if (isLive) {
            move();
        }
    }

    private void move() {
        if (up) {
            y -= speed;
        }

        if (down) {
            y += speed;
        }

        if (left) {
            x -= speed;
        }

        if (right) {
            x += speed;
        }
    }

    public void addDirection(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            default:
                break;
        }
    }

    public void realeaseDireaction(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            default:
                break;
        }
    }

    public Plane(String imagePath, double x, double y) {
        this.image = GameUtil.getImage(imagePath);
        this.x = x;
        this.y = y;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public Plane() {

    }

    public boolean isLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }
}
