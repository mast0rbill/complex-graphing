package com.example.graphicstest;

import javax.swing.*;

public class graphicsSetup {
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsTest gt = new GraphicsTest();
        f.add(gt);
        f.setSize(400, 250);
        f.setVisible(true);
    }
}
