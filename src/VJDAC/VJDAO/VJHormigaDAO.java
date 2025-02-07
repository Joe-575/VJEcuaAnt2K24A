package VJDAC.VJDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VJDAC.VJDataHelperSQLite;
import VJDAC.VJIDAO;
import VJDAC.VJDTO.VJHormigaDTO;
import VJInfra.VJAppException;

public class VJHormigaDAO extends VJDataHelperSQLite implements VJIDAO<VJHormigaDTO> {
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
            + "fechaCreacion, "  // Corrección aquí
            + "fechaModificacion "
            + "FROM VJHormiga WHERE estado = 'A'";

    @Override
    public VJHormigaDTO vjnewDTO(ResultSet rs) {
        try {
            return new VJHormigaDTO(
                    rs.getInt("idHormiga"),
                    rs.getInt("idCatalogoTipo"),
                    rs.getInt("idCatalogoSexo"),
                    rs.getInt("idCatalogoEstado"),
                    rs.getInt("idCatalogoGenoAlimento"),
                    rs.getInt("idCatalogoIngestaNativa"),
                    rs.getString("nombre"),
                    rs.getString("entrenada"),
                    rs.getString("estado"),
                    rs.getString("fechaCreacion"),  // Corrección aquí
                    rs.getString("fechaModificacion"), null, null, null);
        } catch (SQLException e) {
            System.out.println(e);
            //new VJAppException(e, getClass().getName(), "newDTO()");
        }
        return null;
    }

    @Override
    public VJHormigaDTO vjreadBy(Integer id) throws Exception {
        String query = SELECT_QUERY + " AND idHormiga = ?";
        return executeReadBy(query, rs -> vjnewDTO(rs), id);
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
                "h.fechaCreacion, " +  // Corrección aquí
                "h.fechaModificacion " +
                " FROM VJHormiga h " +
                " JOIN VJCatalogo c ON h.idCatalogoTipo = c.idCatalogo " +
                " WHERE c.nombre = 'HhrmigaTipo' AND h.idCatalogoTipo = ?";
        return executeReadByPadre(query, rs -> vjnewDTO(rs), idPadre);
    }

    @Override
    public List<VJHormigaDTO> vjreadAll() throws Exception {
        String query = SELECT_QUERY;
        return executeReadAll(query, rs -> vjnewDTO(rs));
    }

    @Override
    public boolean vjcreate(VJHormigaDTO dto) throws Exception {
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
                + ") VALUES (?,?,?,?,?,?,?,?,?)";
        return execute(query,
                dto.getIdCatalogoTipo(),
                dto.getIdCatalogoSexo(),
                dto.getIdCatalogoEstado(),
                dto.getIdCatalogoGenoAlimento(),
                dto.getIdCatalogoIngestaNativa(),
                dto.getNombre(),
                dto.getEstado(),
                dto.getFechaCreacion());
    }

    @Override
    public boolean vjupdate(VJHormigaDTO dto) throws Exception {
        String query = "UPDATE VJHormiga SET "
                + "idCatalogoTipo = ?, "
                + "idCatalogoSexo = ?, "
                + "idCatalogoEstado = ?, "
                + "idCatalogoGenoAlimento = ?, "
                + "idCatalogoIngestaNativa = ?, "
                + "nombre = ?, "
                + "entrenada = ?, "
                + "estado = ? "
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
                dto.getIdHormiga());
    }

    @Override
    public boolean vjdelete(Integer id) throws Exception {
        String query = "UPDATE VJHormiga SET estado = ?, fechaModificacion = ? WHERE idHormiga = ?";
        return execute(query, "X", getDateTimeNow(), id);
    }

    public void entrenada(int idHormiga) throws SQLException, VJAppException {
        String query = "UPDATE VJHormiga SET entrenada = 'SI' WHERE idHormiga = ?";
        
        try (Connection conn = openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idHormiga);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Integer vjgetMaxRow() throws Exception {
        String query = "SELECT MAX(idHormiga) FROM VJHormiga";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }

    public List<VJHormigaDTO> readVw() throws Exception {
        String query = "SELECT * FROM VJVwHormiga"; 

        List<VJHormigaDTO> hormigas = new ArrayList<>();

        try (Connection conn = openConnection(); // Obtén conexión a la base de datos
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Crear un DTO y mapear los resultados
                VJHormigaDTO dto = new VJHormigaDTO();
                dto.setIdHormiga(rs.getInt("ID"));
                dto.setNombre(rs.getString("TIPOHORMIGA"));
                dto.setSexo(rs.getString("SEXO"));
                dto.setIngestaNativa(rs.getString("ALIMENTACION"));
                dto.setEstado(rs.getString("ESTADO"));
                dto.setEntrenada(rs.getString("ENTRENADA"));
                hormigas.add(dto);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return hormigas;
    }
    
}
