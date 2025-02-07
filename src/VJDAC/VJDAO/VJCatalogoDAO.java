package VJDAC.VJDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import VJDAC.VJDataHelperSQLite;
import VJDAC.VJIDAO;
import VJDAC.VJDTO.VJCatalogoDTO;
import VJInfra.VJAppException;

public class VJCatalogoDAO extends VJDataHelperSQLite implements VJIDAO<VJCatalogoDTO> {
    private static final String SELECT_QUERY = "SELECT "
    + "idCatalogo, "
    + "idCatalogoPadre, "
    + "nombre, "
    + "detalle, "
    + "estado, "
    + "fechaCrea, "
    + "fechaModificacion "
    + " FROM Catalogo WHERE estado = 'A";

    @Override
    public VJCatalogoDTO newDTO(ResultSet rs) {
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
            new VJAppException(e, getClass().getName(), "NewDTO()");
        }
        return null;
    }

    @Override
    public VJCatalogoDTO readBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND idCatalogo = ?";
        return executeReadBy(query, rs -> newDTO(rs), id);
    }

    public List<VJCatalogoDTO> readByPadre(Integer idPadre) throws Exception {
        String query = "SELECT   h.idCatalogo, " + 
                                "h.idCatalogoPadre, " +
                                "h.nombre, " +     
                                "h.detalle, " +       
                                "h.estado, " +             
                                "h.fechaCreacion, " +          
                                "h.fechaModificacion " +
                        " FROM Catalogo p " +
                        " JOIN Catalogo h ON h.idCatalogoPadre = p.idCatalogo " +
                        " WHERE h.estado = 'A' AND p.idCatalogo = ?";

        return executeReadByPadre(query, rs -> newDTO(rs), idPadre);
    }

    @Override
    public List<VJCatalogoDTO> readAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> newDTO(rs));
    }

    @Override
    public boolean create(VJCatalogoDTO dto) throws Exception {
       String query = "INSERT INTO Catalogo ("
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
    public boolean update(VJCatalogoDTO dto) throws Exception {
        String query = "UPDATE Catalogo SET "
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
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Catalogo SET estado = ?, fechaModificacion = ? WHERE idCatalogo = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer getMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }


}
