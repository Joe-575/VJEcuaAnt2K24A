package VJBLC;

import java.util.HashMap;
import java.util.Map;

import VJDAC.VJDAO.VJCatalogoDAO;
import VJDAC.VJDTO.VJCatalogoDTO;

public class VJCatalogo {

    protected VJCatalogoDAO oCatalogoDAO = new VJCatalogoDAO();
    public Map<Integer, String> vjgetAllHormigaTipo() throws Exception{
        return vjgetMap(1);
    }

    
    public Map<Integer, String> vjgetAllHormigaTipoSexo() throws Exception{
        return vjgetMap(2);
    }
    
    public Map<Integer, String> vjgetAllHormigaTipoEstado() throws Exception{
        return vjgetMap(3);
    }

    public Map<Integer, String> raGetAllHormigaTipoGeno() throws Exception{
        return vjgetMap(4);
    }

    public Map<Integer, String> raGetAllHormigaTipoIngesta() throws Exception{
        return vjgetMap(5);
    }

    private Map<Integer, String> vjgetMap(Integer idCatalogoPadre) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        for (VJCatalogoDTO pt : oCatalogoDAO.vjreadByPadre(idCatalogoPadre)) {
            map.put(pt.getIdCatalogoPadre(), pt.getNombre());  // Cambiar IdCatalogo por IdCatalogoPadre
        }
        return map;
    }   
}
