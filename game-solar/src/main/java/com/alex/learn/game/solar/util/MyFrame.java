package com.alex.learn.game.solar.util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by hanjunnan on 15/5/11.
 */
public class MyFrame extends Frame {
    /**
     * 加载窗口
     */
    public void launchFrame(){
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        setLocation(100, 100);
        setVisible(true);

        new PaintThread().start();  //????????????

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 定义一个重画窗口的线程类，是一个内部类
     */
    class PaintThread extends Thread {

        public void run(){
            while(true){
                repaint();
                try {
                    Thread.sleep(40); //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
