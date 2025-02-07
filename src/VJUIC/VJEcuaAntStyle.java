package VJUIC;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
public abstract class VJEcuaAntStyle {
    public static final Color VJCOLOR_FONT = new Color(220, 0, 0); //(218, 8, 40)
    public static final Color VJCOLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color VJCOLOR_CURSOR = Color.black;
    public static final Color VJCOLOR_BORDER = Color.lightGray;
    public static final Font  VJFONT         = new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font  VJFONT_BOLD    = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font  VJFONT_SMALL   = new Font("JetBrains Mono", Font.PLAIN| Font.PLAIN, 10);

    public static final int VJALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int VJALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int VJALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor VJCURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor VJCURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL VJURL_MAIN  = VJEcuaAntStyle.class.getResource("/VJUIC/VJResource/logo.png");
    public static final URL VJURL_LOGO  = VJEcuaAntStyle.class.getResource("/VJUIC/VJResource/icono.png");
    public static final URL VJURL_SPLASH = VJEcuaAntStyle.class.getResource("/VJUIC/VJResource/logo.png");


    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

   
    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "🐜 EcuAnt", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "💀 EcuAnt", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg) {
        return (JOptionPane.showConfirmDialog(null, msg, " 🐜 EcuAnt",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
