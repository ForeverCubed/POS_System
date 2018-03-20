package com.roundtheclock.pos;

import java.awt.*;

public class Display
{

    private static int width;
    private static int height;
    private static Dimension screenSize;
 public Display()
 {

 }
 public static Dimension getScreenSize () {
     screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
     return screenSize;
 }
 public static int getDisplayHeight() {
     if(screenSize != null){
         height = screenSize.height;
     }
     else return Toolkit.getDefaultToolkit().getScreenSize().height;
     return height;
 }

 public static int getDisplayWidth(){
     if(screenSize != null){
         width = screenSize.width;
     }
     else return Toolkit.getDefaultToolkit().getScreenSize().width;
    return width;
}
}
