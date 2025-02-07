package VJBLC;

import java.util.HashMap;
import java.util.Map;

import VJDAC.VJDAO.VJCatalogoDAO;
import VJDAC.VJDTO.VJCatalogoDTO;

public class VJCatalogo {

    protected VJCatalogoDAO oCatalogoDAO = new VJCatalogoDAO();
    public Map<Integer, String> getAllHormigaTipo() throws Exception{
        return getMap(1);
    }

    
    public Map<Integer, String> getAllHormigaTipoSexo() throws Exception{
        return getMap(2);
    }
    
    public Map<Integer, String> getAllHormigaTipoEstado() throws Exception{
        return getMap(3);
    }

    private Map<Integer, String> getMap(Integer idCatalogoPadre) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        for (VJCatalogoDTO pt : oCatalogoDAO.readByPadre(idCatalogoPadre)) {
            map.put(pt.getIdCatalogoPadre(), pt.getNombre());  // Cambiar IdCatalogo por IdCatalogoPadre
        }
        return map;
    }   
}
