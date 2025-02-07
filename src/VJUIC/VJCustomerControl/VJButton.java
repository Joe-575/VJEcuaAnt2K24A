package VJUIC.VJCustomerControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import VJUIC.VJEcuaAntStyle;

import javax.swing.ImageIcon;

public class VJButton  extends JButton implements MouseListener {
    public VJButton(String text){
        customizeComponent(text);
    }
    public VJButton(String text, String iconPath){
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20); 
        
        setIcon(new ImageIcon(iconPath));
        setFont(VJEcuaAntStyle.VJFONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(VJEcuaAntStyle.VJCOLOR_FONT);
        setHorizontalAlignment(VJEcuaAntStyle.VJALIGNMENT_LEFT);
        setFont(VJEcuaAntStyle.VJFONT);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        setForeground(Color.BLACK);
        setCursor(VJEcuaAntStyle.VJCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(VJEcuaAntStyle.VJCURSOR_DEFAULT);
    }
}
