package VJBLC;

import java.util.ArrayList;

import VJInfra.VJAppException;

public class VJHormigueroBL {

    public ArrayList<VJHormigueroBL> lstHormiguero = new ArrayList<>();

    public String crearLarva() throws VJAppException {
        Hormiga hormiga = new HLarva(lstHormiguero.size() + 1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
    }

    public String eliminarHormiga(int idHormiga) throws Exception {
        String msg = "HORMIGA, no encontrada";
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getId() == idHormiga) {
                msg = lstHormiguero.get(i).getTipo() + ", eliminada del hormiguero";
                lstHormiguero.remove(i);
            }
        }
        return msg;
    }

    public String guardarHormiquero() throws VJAppException {
        String fullDataHormiga = "";
        for (Hormiga hormiga : lstHormiguero)
            fullDataHormiga += hormiga.toString();
        new HormigueroDAC().saveHormigueroToCSV(fullDataHormiga);
        return "HORMIGUERO, almacenado";
    }

    public String alimentarHormiga(int Idhormiga, String alimentoGeno, String alimentoNativo) throws VJAppException {
        int indexList = 0;
        GenoAlimento aGeno = null;
        IngestaNativa aNativo = null;
        Hormiga hormiga = null;

        //creando GenoAlimento
        switch (alimentoGeno) {
            case "XX": aGeno = new XX(); break;
            case "XY": aGeno = new XY(); break;
            default: aGeno = new X(); break;
        }
        
        // ingestiva Nativa
        switch(alimentoNativo)
    
        {
            case "Carnívoro": aNativo = new Carnivoro(); break;
            case "Herbívoro": aNativo = new Herbivoro(); break;
            case "Omnívoro": aNativo = new Omnivoro(); break;
            case "Insectívoro": aNativo = new Insectivoro(); break;
            case "Nectarívoros":aNativo = new Nectarivoro(); break;
        }
    
        // buscar indexList y hormiga a alimentar
        for(;indexList<lstHormiguero.size();indexList++)if(lstHormiguero.get(indexList).getId()==Idhormiga)
        {
            hormiga = lstHormiguero.get(indexList);
            break;
        }
    
        // validamos
        if(aNativo==null||aGeno==null||hormiga==null||hormiga.getEstado()=="MUERTA")
            return"Ups...! alimento u hormiga no son válidos";
        // inyectamos el genoAlimento a la ingestaNativa y se procede a alimenta a la
        // hormiga
        if(aNativo.inyectar(aGeno))lstHormiguero.set(indexList,hormiga.comer(aNativo));
        else 
        return hormiga.getTipo()+" NO alimentada";
        
        return lstHormiguero.get(indexList).getTipo()+" Alimentada";
    }
}


