package VJDAC.VJDTO;

public class VJHormigaDTO {
    private Integer idHormiga;
    private Integer idCatalogoTipo;
    private Integer idCatalogoSexo;
    private Integer idCatalogoEstado;
    private Integer idCatalogoGenoAlimento;
    private Integer idCatalogoIngestaNativa;
    private String Entrenada;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModificacion;

    public VJHormigaDTO() {
    }

    public VJHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String entrenada, String nombre,
            String estado, String fechaCreacion, String fechaModificacion) {
        this.idHormiga = idHormiga;
        this.idCatalogoTipo = idCatalogoTipo;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idCatalogoEstado = idCatalogoEstado;
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
        Entrenada = entrenada;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public VJHormigaDTO(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado, String nombre) {
        this.idCatalogoTipo = idCatalogoTipo;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idCatalogoEstado = idCatalogoEstado;
        this.nombre = nombre;
    }

    public VJHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            String nombre, String estado, String fechaCreacion, String fechaModificacion) {
        this.idHormiga = idHormiga;
        this.idCatalogoTipo = idCatalogoTipo;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idCatalogoEstado = idCatalogoEstado;
        this.nombre = nombre;
        this.estado = (estado != null) ? estado : "A";
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getIdCatalogoTipo() {
        return idCatalogoTipo;
    }

    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        this.idCatalogoTipo = idCatalogoTipo;
    }

    public Integer getIdCatalogoSexo() {
        return idCatalogoSexo;
    }

    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        this.idCatalogoSexo = idCatalogoSexo;
    }

    public Integer getIdCatalogoEstado() {
        return idCatalogoEstado;
    }

    public void setIdCatalogoEstado(Integer idCatalogoEstado) {
        this.idCatalogoEstado = idCatalogoEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdCatalogoGenoAlimento() {
        return idCatalogoGenoAlimento;
    }

    public void setIdCatalogoGenoAlimento(Integer idCatalogoGenoAlimento) {
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
    }

    public Integer getIdCatalogoIngestaNativa() {
        return idCatalogoIngestaNativa;
    }

    public void setIdCatalogoIngestaNativa(Integer idCatalogoIngestaNativa) {
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
    }

    public String getEntrenada() {
        return Entrenada;
    }

    public void setEntrenada(String entrenada) {
        Entrenada = entrenada;
    }

    @Override
    public String toString() {
        return getClass().getName()
        + "\n IdHormiga: "                  + getIdHormiga()
        + "\n IdCatalogoTipo: "             + getIdCatalogoTipo()
        + "\n IdCatalogoSexo: "             + getIdCatalogoSexo()
        + "\n IdCatalogoEstado: "           + getIdCatalogoEstado()
        + "\n IdCatalogoGenoAlimento: "     + getIdCatalogoGenoAlimento()
        + "\n IdCatalogoIngestaNativa: "    + getIdCatalogoIngestaNativa()
        + "\n Entrenada: "                  + getEntrenada()
        + "\n Nombre: "                     + getNombre()
        + "\n Estado: "                     + getEstado()
        + "\n FechaCrea: "                  + getFechaCreacion()
        + "\n FechaModifica  "              + getFechaModificacion();
    }
}
