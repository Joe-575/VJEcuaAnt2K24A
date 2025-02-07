package VJBLC;

import java.util.ArrayList;

public class VJHormigueroBL {
    public class HormigueroBL {
    public ArrayList<Hormiga> lstHormiguero = new ArrayList<>();
    
    public String crearLarva() throws AppException{
        Hormiga hormiga = new HLarva(lstHormiguero.size()+1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
        }

    public String eliminarHormiga(int idHormiga) throws Exception{
        String msg = "HORMIGA, no encontrada";
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getId() == idHormiga) {
            msg= lstHormiguero.get(i).getTipo() + ", eliminada del hormiguero";
            lstHormiguero.remove(i);
            }
        }
        return msg;
    }
}
