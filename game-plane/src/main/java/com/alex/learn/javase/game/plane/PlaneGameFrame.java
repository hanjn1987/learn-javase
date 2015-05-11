package com.alex.learn.javase.game.plane;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ZUOZUO on 2015/5/10.
 */
public class PlaneGameFrame extends Frame {
    Image bg = GameUtil.getImage("bg.jpg");
    Plane plane = new Plane("plane.png", 50, 50);
    ArrayList bulletList = new ArrayList();   //泛型暂时未学，暂不加。以后学了，强烈建议加上。

    Date startTime;
    Date endTime;

    Explode explode;

    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        setLocation(100, 100);
        setVisible(true);

        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //增加键盘的监听
        addKeyListener(new KeyMonotor());

        plane.setIsLive(true);
        //生成一堆子弹
        for (int i = 0; i < 30; i++) {
            Bullet bullet = new Bullet();
            bulletList.add(bullet);
        }

        startTime = new Date();
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(bg, 0, 0, null);
        plane.draw(graphics);

        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = (Bullet) bulletList.get(i);
            bullet.draw(graphics);
            boolean peng = plane.getReacangle().intersects(bullet.getReacangle());
            if (peng) {
                plane.setIsLive(false);

                if (null == explode) {
                    endTime = new Date();
                    explode = new Explode(plane.x, plane.y);
                }
                explode.draw(graphics);

                break;
            }
        }

        if (!plane.isLive()) {
            int period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
            printInfo(graphics, "Time:" + period + "second", 20, 120, 260, Color.white);

            switch (period / 10) {
                case 0:
                case 1:
                    printInfo(graphics, "菜鸟", 50, 100, 200, Color.white);
                    break;
                case 2:
                    printInfo(graphics, "小鸟", 50, 100, 200, Color.white);
                    break;
                case 3:
                    printInfo(graphics, "大鸟", 50, 100, 200, Color.yellow);
                    break;
                case 4:
                    printInfo(graphics, "鸟王子", 50, 100, 200, Color.yellow);
                    break;
                default:
                    printInfo(graphics, "鸟人", 50, 100, 200, Color.yellow);
                    break;
            }

        }
        printInfo(graphics, "分数：100", 10, 50, 50, Color.yellow);
    }

    /**
     * 在窗口上打印信息
     *
     * @param g
     * @param str
     * @param size
     */
    public void printInfo(Graphics g, String str, int size, int x, int y, Color color) {
        Color c = g.getColor();
        g.setColor(color);
        Font font = new Font("宋体", Font.BOLD, size);
        g.setFont(font);
        g.drawString(str, x, y);
        g.setColor(c);
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);

        Graphics gOff = offScreenImage.getGraphics();

        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String args[]) {
        new PlaneGameFrame().launchFrame();
    }

    /**
     * 定义一个重画窗口的线程类，是一个内部类
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义为内部类，可以方便的使用外部类的普通属性
    class KeyMonotor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Pressed:" + e.getKeyCode());
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Realeased:" + e.getKeyCode());
            plane.realeaseDireaction(e);
        }
    }
}
