package VJUIC.VJCustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import VJUIC.VJEcuaAntStyle;


public class VJLabel extends JLabel{
    public VJLabel(){
        customizeComponent();
    }
    public VJLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), VJEcuaAntStyle.VJFONT, VJEcuaAntStyle.VJCOLOR_FONT_LIGHT, VJEcuaAntStyle.VJALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}