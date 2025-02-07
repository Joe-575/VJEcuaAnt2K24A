package VJUIC.VJCustomerControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import VJUIC.VJEcuaAntStyle;



public class VJTextBox extends JTextField {

    public VJTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(VJEcuaAntStyle.VJFONT);  
        setForeground(VJEcuaAntStyle.VJCOLOR_FONT_LIGHT);  
        setCaretColor(VJEcuaAntStyle.VJCOLOR_CURSOR);    // Color del cursor
        setMargin(new Insets(5, 5, 5, 5));      // Ajusta los márgenes
        setOpaque(false);                       // Fondo transparente
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(VJEcuaAntStyle.VJCOLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, VJEcuaAntStyle.VJCOLOR_BORDER) 
        ));
    }
}
