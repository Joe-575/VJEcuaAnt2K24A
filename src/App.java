import javax.swing.JFrame;

import VJUIC.VJForm.VJHormigaPanel;

public class App {
    public static void main(String[] args) throws Exception {
        //titulo del frame
        JFrame frame = new JFrame("Hormiguero Experimental");
        //tamaño del frame
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VJHormigaPanel panel = new VJHormigaPanel();
        
        //agregar panel al frame
        frame.add(panel);

        //mostrar el frame
        frame.setVisible(true);
    
    }
}
