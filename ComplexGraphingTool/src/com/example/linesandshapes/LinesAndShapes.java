package com.example.linesandshapes;

import java.awt.*;
import javax.swing.*;

public class LinesAndShapes extends JPanel{
    public static void main(String[] args) {
        // set up frame
        JFrame f = new JFrame("Twilight Zone");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new LinesAndShapes());
        f.setSize(290,325);
        f.setLocation(550,25);
        f.setVisible(true);
    }
}
