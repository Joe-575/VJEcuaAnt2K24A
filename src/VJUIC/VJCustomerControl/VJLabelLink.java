package VJUIC.VJCustomerControl;

import javax.swing.ImageIcon;

import VJUIC.VJEcuaAntStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VJLabelLink extends VJLabel implements MouseListener {

    VJLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    VJLabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(VJEcuaAntStyle.VJCOLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(VJEcuaAntStyle.VJCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(VJEcuaAntStyle.VJCURSOR_DEFAULT);
    }
}
