package com.alex.learn.javase.game.plane;

import java.awt.*;

/**
 * Created by ZUOZUO on 2015/5/10.
 */
public class Bullet extends GameObject {
    double degree;

    public Bullet() {
        this.degree = Math.random() * 2 * Math.PI;
        this.x = Constant.GAME_WIDTH / 2;
        this.y = Constant.GAME_HEIGHT / 2;
        this.width = 10;
        this.height = 10;
    }

    public void draw(Graphics graphics) {
        Color c = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        graphics.fillOval((int) x, (int) y, width, height);

        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        if(y>Constant.GAME_HEIGHT-height||y<30){
            degree = -degree;
        }

        if(x<0||x>Constant.GAME_WIDTH-width){
            degree = Math.PI-degree;
        }
        graphics.setColor(c);
    }
}
