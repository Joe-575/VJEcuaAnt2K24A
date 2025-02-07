package VJBLC.VJEntities;

import java.util.List;

import VJBLC.VJBLFactory;
import VJDAC.VJDAO.VJHormigaDAO;
import VJDAC.VJDTO.VJHormigaDTO;

public class VJHormiga implements IVJHormiga {

    private int id;
    private String tipo;
    private String estado;
    private String nombre;
    protected VJHormigaDTO VJhormigaDTO = new VJHormigaDTO();
    private VJBLFactory<VJHormigaDTO> bl = new VJBLFactory<>(VJHormigaDAO::new);
    public VJIngestaNativa aComido;

    public VJHormiga() {
    }

    public boolean add(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String nombre) throws Exception {
        VJhormigaDTO = new VJHormigaDTO(idCatalogoTipo, idCatalogoSexo, idCatalogoEstado, idCatalogoGenoAlimento,
                idCatalogoIngestaNativa, nombre);
        return bl.add(VJhormigaDTO);
    }

    public boolean upd(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String nombre) throws Exception {
        if (VJhormigaDTO != null) {
            VJhormigaDTO.setIdCatalogoTipo(idCatalogoTipo);
            VJhormigaDTO.setIdCatalogoSexo(idCatalogoSexo);
            VJhormigaDTO.setIdCatalogoEstado(idCatalogoEstado);
            VJhormigaDTO.setIdCatalogoGenoAlimento(idCatalogoGenoAlimento);
            VJhormigaDTO.setIdCatalogoIngestaNativa(idCatalogoIngestaNativa);
            VJhormigaDTO.setNombre(nombre);
            return bl.upd(VJhormigaDTO);
        }
        return false;
    }

    public List<VJHormigaDTO> getAll() throws Exception {
        return bl.getAll();
    }

    public VJHormigaDTO getBy(Integer id) throws Exception {
        VJhormigaDTO = bl.getBy(id);
        return VJhormigaDTO;

    }

    public boolean del() throws Exception {
        if (VJhormigaDTO != null)
            return bl.del(VJhormigaDTO.getIdHormiga());
        return false;
    }

    public VJHormigaDTO get() {
        return VJhormigaDTO;
    }

    public void set(VJHormigaDTO VJhormigaDTO) {
        this.VJhormigaDTO = VJhormigaDTO;
    }

    public VJHormiga(int id) {
        this.id = id;
        this.estado = "Viva";
        this.tipo = "Desconocida"; // o cualquier otro valor por defecto
        this.nombre = "Hormiga " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para simular el proceso de comer
    public VJHormiga comer(VJIngestaNativa ingestaNativa) {
        // lógica para la alimentación
        return this; // Devuelve la misma hormiga tras alimentarse
    }

    @Override
    public String toString() {
        return VJhormigaDTO
                + " - " + aComido.getTipo()
                + "\n";
    }

    
}
