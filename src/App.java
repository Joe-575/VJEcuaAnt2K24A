import javax.swing.JFrame;

import VJUIC.VJForm.VJHormigaPanel;
import VJUIC.VJForm.VJSplashForm;

public class App {
    public static void main(String[] args) throws Exception {
        
        VJSplashForm.show();
        //titulo del frame
        JFrame frame = new JFrame("Hormiguero Experimental");
        //tamaño del frame
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VJHormigaPanel panel = new VJHormigaPanel();
        
        //agregar panel al frame
        frame.add(panel);

        //mostrar el frame
        frame.setVisible(true);
    
    }
}
