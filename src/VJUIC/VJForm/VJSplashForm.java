package VJUIC.VJForm;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import VJUIC.VJEcuaAntStyle;

public abstract class VJSplashForm   {
    private static JFrame       VJfrmSplash;
    private static JProgressBar VJprbLoaging;
    private static ImageIcon    VJicoImagen ;
    private static JLabel       VJlblSplash ;

    public static void show() {
        
        try {
            VJicoImagen  = new ImageIcon(VJEcuaAntStyle.VJURL_SPLASH);
            VJlblSplash  = new JLabel(VJicoImagen);
            VJprbLoaging = new JProgressBar(0, 100);
            VJprbLoaging.setStringPainted(true);
            
            VJfrmSplash = new JFrame();
            VJfrmSplash.setUndecorated(true);
            VJfrmSplash.getContentPane().add(VJlblSplash, BorderLayout.CENTER);
            VJfrmSplash.add(VJprbLoaging, BorderLayout.SOUTH);
            VJfrmSplash.setSize(VJicoImagen.getIconWidth(), VJicoImagen.getIconHeight());
            VJfrmSplash.setLocationRelativeTo(null); // Centrar en la pantalla
      
            VJfrmSplash.setVisible(true);
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // Espera por 50 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                VJprbLoaging.setValue(i);
            }
            VJfrmSplash.setVisible(false);
        } catch (Exception e) {
            VJEcuaAntStyle.showMsgError(" Problemas con splash ");

            e.printStackTrace();
        }
    }

}
