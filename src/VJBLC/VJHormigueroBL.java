package VJBLC;

import java.util.ArrayList;

import VJBLC.VJEntities.VJCarnivoro;
import VJBLC.VJEntities.VJGenoAlimento;
import VJBLC.VJEntities.VJHLarva;
import VJBLC.VJEntities.VJHormiga;
import VJBLC.VJEntities.VJIngestaNativa;
import VJBLC.VJEntities.VJX;
import VJBLC.VJEntities.VJXY;
import VJDAC.VJHormigueroDAC;
import VJInfra.VJAppException;

public class VJHormigueroBL {

    public ArrayList<VJHormiga> lstHormiguero = new ArrayList<>();

    public String crearLarva() throws VJAppException{    
        VJHormiga hormiga = new VJHLarva(lstHormiguero.size()+1); 
        lstHormiguero.add(hormiga); 
        return "HORMIGA LARVA, agregada al hormiguero"; 
    } 

    public String eliminarHormiga(int idHormiga) throws Exception {
        for (VJHormiga hormiga : lstHormiguero) {
            if (hormiga.getId() == idHormiga) {
                hormiga.setEstado("MUERTA");
                return hormiga.getTipo() + " marcada como MUERTA";
            }
        }
        return "HORMIGA no encontrada";
    }

    public String guardarHormiguero() throws VJAppException {
        StringBuilder fullDataHormiga = new StringBuilder();
        for (VJHormiga hormiga : lstHormiguero)
            fullDataHormiga.append(hormiga.toString()).append("\n");
        new VJHormigueroDAC().saveHormigueroCSV(null);
        return "HORMIGUERO GUARDADO";
    }

    public String alimentarHormiga(int Idhormiga, String alimentoGeno, String alimentoNativo) throws VJAppException{ 
        int indexList = 0; 
        VJGenoAlimento    aGeno   = null; 
        VJIngestaNativa   aNativo = null; 
        VJHormiga         hormiga = null; 
        //creando GenoAlimento 
        switch (alimentoGeno) { 
            case "XY":  aGeno = new VJXY(alimentoNativo, alimentoNativo);    break; 
            default:    aGeno = new VJX(alimentoNativo, alimentoNativo);     break; 
        } 
 
        //creando IngestaNativa 
        switch (alimentoNativo) { 
            case "Carnívoro":   aNativo = new VJCarnivoro();    break; 
        } 
        //buscar indexList y hormiga a alimentar 
        for (;indexList < lstHormiguero.size(); indexList++)  
            if (lstHormiguero.get(indexList).getId() == Idhormiga) { 
                hormiga = lstHormiguero.get(indexList); 
                break; 
            } 
         
        //validamos 
        if (aNativo == null || aGeno == null || hormiga == null || hormiga.getEstado() == "MUERTA") 
            return "Ups...! alimento u hormiga no son válidos"; 
 
        //inyectamos el genoAlimento a la ingestaNativa y se procede a alimenta a la hormiga 
        if( aNativo.inyectar(aGeno)) 
            lstHormiguero.set(indexList,  hormiga.comer(aNativo)); 
        else 
            return hormiga.getTipo() + " NO alimentada"; 
 
        return lstHormiguero.get(indexList).getTipo() + " Alimentada"; 
    } 
}


