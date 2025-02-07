package VJDAC;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

import VJInfra.VJAppException;
import VJInfra.VJConfig;

import java.io.PrintWriter;

public class VJHormigueroDAC {
    public void saveHormigueroCSV(List<String> fullDataHormiga) throws VJAppException{
        try (PrintWriter writer = new PrintWriter(new FileWriter(VJConfig.DATEFILE, true))) {
            for (String hormiga : fullDataHormiga) {
                writer.println(hormiga);
            }
        } catch (IOException e) {
            throw new VJAppException(e, this.getClass().toString(), "saveHormigueroCSV(...)");
        }
    }
}
