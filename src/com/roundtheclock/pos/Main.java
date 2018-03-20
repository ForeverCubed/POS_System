package com.roundtheclock.pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    //Konor is smart!
    public static void main(String[] args)
    {
        //TODO: settings file that controls a lot of settings
        GridLayout mainGridLayout = new GridLayout();
        mainGridLayout.setRows(10);
        mainGridLayout.setColumns(10);
        JFrame mainFrame = new JFrame("Alone in Ruins POS system");
        //Allow for this to be changed to fullscreen or not fullscreen
        mainFrame.setSize(Display.getDisplayWidth(),Display.getDisplayHeight());
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);

        JPanel mainPanel = new JPanel();
       mainPanel.setLayout(mainGridLayout);

       JButton exit = new JButton("Exit");
       exit.setVisible(true);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(exit);
        mainFrame.add(mainPanel);

        mainFrame.setUndecorated(true);
        mainFrame.setVisible(true);
    }
}
