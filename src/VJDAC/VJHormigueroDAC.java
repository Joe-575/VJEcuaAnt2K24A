package VJDAC;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;

import VJInfra.VJAppException;
import VJInfra.VJConfig;

import java.io.PrintWriter;

public class VJHormigueroDAC {
    public void saveHorigueroToCSV(String fullDataHormiga) throws VJAppException{
        try (PrintWriter writer = new PrintWriter(new FileWriter(VJConfig.DATEFILE))) {
            writer.println("id,tipo,sexo,estado,Comido");
            writer.println(fullDataHormiga);
        } catch (IOException e){
            throw new VJAppException(e, this.getClass().toString(), "saveHormigueroToCSV(...)");
        }
    }
}
