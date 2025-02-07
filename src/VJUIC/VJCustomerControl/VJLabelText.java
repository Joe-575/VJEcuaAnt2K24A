package VJUIC.VJCustomerControl;

import javax.swing.*;

import VJUIC.VJEcuaAntStyle;

import java.awt.*;

public class VJLabelText extends JPanel{
    private VJLabel    lblEtiqueta = new VJLabel();
    private VJTextBox  txtContenido= new VJTextBox();

    public VJLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  
                                            etiqueta, 
                                            VJEcuaAntStyle.VJFONT_SMALL, 
                                            VJEcuaAntStyle.VJCOLOR_FONT_LIGHT, 
                                            VJEcuaAntStyle.VJALIGNMENT_LEFT
                                        ); 
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
