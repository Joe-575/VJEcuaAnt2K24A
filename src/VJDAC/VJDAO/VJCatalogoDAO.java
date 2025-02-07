package VJDAC.VJDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import VJDAC.VJDataHelperSQLite;
import VJDAC.VJIDAO;
import VJDAC.VJDTO.VJCatalogoDTO;

public class VJCatalogoDAO extends VJDataHelperSQLite implements VJIDAO<VJCatalogoDTO> {
    private static final String SELECT_QUERY = "SELECT "
    + "idCatalogo, "
    + "idCatalogoPadre, "
    + "nombre, "
    + "detalle, "
    + "estado, "
    + "fechaCrea, "
    + "fechaModificacion "
    + " FROM VJCatalogo WHERE estado = 'A";

    @Override
    public VJCatalogoDTO vjnewDTO(ResultSet rs) {
        try{
            return new VJCatalogoDTO(
                rs.getInt("idCatalogo"),
                rs.getInt("idCatalogoPadre"),
                rs.getString("nombre"),
                rs.getString("detalle"),
                rs.getString("estado"),
                rs.getString("fechaCreacion"),
                rs.getString("fechaModificacion")
            );
        }catch (SQLException e){
            System.out.println(e);
            //new VJAppException(e, getClass().getName(), "NewDTO()");
        }
        return null;
    }

    @Override
    public VJCatalogoDTO vjreadBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND idCatalogo = ?";
        return executeReadBy(query, rs -> vjnewDTO(rs), id);
    }

    public List<VJCatalogoDTO> vjreadByPadre(Integer idPadre) throws Exception {
        String query = "SELECT   h.idCatalogo, " + 
                                "h.idCatalogoPadre, " +
                                "h.nombre, " +     
                                "h.detalle, " +       
                                "h.estado, " +             
                                "h.fechaCreacion, " +          
                                "h.fechaModificacion " +
                        " FROM VJCatalogo p " +
                        " JOIN VJCatalogo h ON h.idCatalogoPadre = p.idCatalogo " +
                        " WHERE h.estado = 'A' AND p.idCatalogo = ?";

        return executeReadByPadre(query, rs -> vjnewDTO(rs), idPadre);
    }

    @Override
    public List<VJCatalogoDTO> vjreadAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> vjnewDTO(rs));
    }

    @Override
    public boolean vjcreate(VJCatalogoDTO dto) throws Exception {
       String query = "INSERT INTO VJCatalogo ("
                     + "idCatalogoPadre, "
                     + "nombre,"
                     + "detalle,"
                     + "estado,"
                     + "fechaCreacion"
                     + ") VALUES (?,?,?,?,?)";
                     return execute(query, dto.getIdCatalogoPadre(),
                                    dto.getNombre(),
                                    dto.getDetalle(),
                                    dto.getEstado(),
                                    dto.getFechaCreacion()); 

    }

    @Override
    public boolean vjupdate(VJCatalogoDTO dto) throws Exception {
        String query = "UPDATE VJCatalogo SET "
                                    + "idCatalogoPadre = ?, "
                                    + "nombre = ?, "
                                    + "detalle = ?, "
                                    + "fechaModificacion = ? "
                                    + "WHERE idCatalogo = ?";
        return execute(query,    dto.getIdCatalogoPadre(),
                                 dto.getNombre(),
                                 dto.getDetalle(),
                                 getDateTimeNow(),
                                 dto.getIdCatalogo());
    }

    @Override
    public boolean vjdelete(Integer id) throws Exception {
        String query = "UPDATE VJCatalogo SET estado = ?, fechaModificacion = ? WHERE idCatalogo = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer vjgetMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }


}
