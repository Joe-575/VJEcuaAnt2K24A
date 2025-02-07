package VJDAC.VJDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import VJDAC.VJDataHelperSQLite;
import VJDAC.VJIDAO;
import VJDAC.VJDTO.VJHormigaDTO;
import VJInfra.VJAppException;

public class VJHormigaDAO  extends VJDataHelperSQLite implements VJIDAO<VJHormigaDTO>{
private static final String SELECT_QUERY = "SELECT "
    + "idHormiga, "
    + "idCatalogoTipo, "
    + "idCatalogoSexo, "
    + "idCatalogoEstado, "
    + "idCatalogoGenoAlimento, "
    + "idCatalogoIngestaNativa, "
    + "nombre, "
    + "entrenada, "
    + "estado, "
    + "fechaCreaacion, "
    + "FechaModificacion "
    + "FROM VJHormiga WHERE estado = 'A'";

    @Override
    public VJHormigaDTO newDTO(ResultSet rs) {
        try {
            return new VJHormigaDTO(
                    rs.getInt("IdHormiga"),
                    rs.getInt("IdCatalogoTipo"),
                    rs.getInt("IdCatalogoSexo"),
                    rs.getInt("IdCatalogoEstado"),
                    rs.getInt("IdCatalogoGenoAlimento"),
                    rs.getInt("IdCatalogoIngestaNativa"),
                    rs.getString("Nombre"),
                    rs.getString("entrenada"),
                    rs.getString("estado"),
                    rs.getString("fechaCreacion"),
                    rs.getString("fechaModificacion")
            );
        } catch (SQLException e) {
            new VJAppException(e, getClass().getName(), "newDTO()");
        }
        return null;
    }

    @Override
    public VJHormigaDTO readBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND idHormiga = ?";
        return executeReadBy(query, rs -> newDTO(rs), id);
    }

    
    public List<VJHormigaDTO> readByPadre(Integer idPadre) throws Exception {
        String query = "SELECT h.idHormiga, " +
                "h.idCatalogoTipo, " +
                "h.idCatalogoSexo, " +
                "h.idCatalogoEstado, " +
                "h.idCatalogoGenoAlimento, " +
                "h.idCatalogoIngestaNativa, " +
                "h.nombre, " +
                "h.entrenada, " +
                "h.estado, " +
                "h.fechaCreacion, " +
                "h.fechaModificacion " +
                " FROM VJHormiga h " +
                " JOIN VJCatalogo c ON h.idCatalogoTipo = c.IdCatalogo " +
                " WHERE c.nombre = 'HormigaTipo' AND h.idCatalogoTipo = ?";
        return executeReadByPadre(query, rs -> newDTO(rs), idPadre);
    }

    @Override
    public List<VJHormigaDTO> readAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> newDTO(rs));
    }

    @Override
    public boolean create(VJHormigaDTO dto) throws Exception {
        String query = "INSERT INTO VJHormiga ("
                        + "idCatalogoTipo, "
                        + "idCatalogoSexo, "
                        + "idCatalogoEstado, "
                        + "idCatalogoGenoAlimento, "
                        + "idCatalogoIngestaNativa, "
                        + "nombre, "
                        + "entrenada, "
                        + "estado, "
                        + "fechaCreacion"
                        + ") VALUES (?,?,?,?,?,?,?,?)";
        return execute(query,
                        dto.getIdCatalogoTipo(),
                        dto.getIdCatalogoSexo(),
                        dto.getIdCatalogoEstado(),
                        dto.getIdCatalogoGenoAlimento(),
                        dto.getIdCatalogoIngestaNativa(),
                        dto.getNombre(),
                        (dto.getEstado() != null) ? dto.getEstado() : "A",
                        dto.getFechaCreacion());
    }

    @Override
    public boolean update(VJHormigaDTO dto) throws Exception {
        String query = "UPDATE VJHormiga SET "
                        + "idCatalogoTipo = ?, "
                        + "idCatalogoSexo = ?, "
                        + "idCatalogoEstado = ?, "
                        + "idCatalogoGenoAlimento = ?, "
                        + "idCatalogoIngestaNativa = ?, "
                        + "bombre = ?, "
                        + "entrenada = ?, "
                        + "estado = ?, "
                        + "fechaModificacion = ? "
                        + "WHERE idHormiga = ?";
        return execute(query,
                        dto.getIdCatalogoTipo(),
                        dto.getIdCatalogoSexo(),
                        dto.getIdCatalogoEstado(),
                        dto.getIdCatalogoGenoAlimento(),
                        dto.getIdCatalogoIngestaNativa(),
                        dto.getNombre(),
                        dto.getEntrenada(),
                        dto.getEstado(),
                        getDateTimeNow(),
                        dto.getIdHormiga());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE VJHormiga SET estado = ?, fechaModificacion = ? WHERE idHormiga = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    @Override
    public Integer getMaxRow() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMaxRow'");
    }

}
