package VJInfra;

import javax.swing.JOptionPane;

public abstract class VJConfig {
    //public static final String URL_LOGO = VJConfig.class.getResourceAsStream("VJUIC/VJResource/logo.png");
    //public static final URL URL_LOGO = Config.class.getResource("VJUIC/VJResource/logo.png");
    
    
    public static final String DATAFILE = "VJDataFile/hormiguero.csv";
    public static final String LOGFILE = "VJDataFile/log.txt";
    

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
