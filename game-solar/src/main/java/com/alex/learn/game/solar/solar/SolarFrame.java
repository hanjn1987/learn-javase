package com.alex.learn.game.solar.solar;

import com.alex.learn.game.solar.util.GameUtil;
import com.alex.learn.game.solar.util.MyFrame;

import java.awt.*;

/**
 * Created by hanjunnan on 15/5/11.
 */
public class SolarFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);
    }

    public static void main(String args[]) {
        new SolarFrame().launchFrame();
    }
}
