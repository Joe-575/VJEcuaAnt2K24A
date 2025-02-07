package VJDAC.VJDTO;

public class VJHormigaDTO {
    private Integer idHormiga;
    private Integer idCatalogoTipo;
    private Integer idCatalogoSexo;
    private Integer idCatalogoEstado;
    private Integer idCatalogoGenoAlimento;
    private Integer idCatalogoIngestaNativa;
    private String entrenada;
    private String nombre;
    private String estado;
    private String sexo;
    private String genoAlimento;
    private String ingestaNativa;
    private String fechaCreacion;
    private String fechaModificacion;

    public VJHormigaDTO() {
    }

    public VJHormigaDTO(Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String nombre) {
        this.idCatalogoTipo = idCatalogoTipo;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idCatalogoEstado = idCatalogoEstado;
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
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

    

    public VJHormigaDTO(Integer idHormiga, Integer idCatalogoTipo, Integer idCatalogoSexo, Integer idCatalogoEstado,
            Integer idCatalogoGenoAlimento, Integer idCatalogoIngestaNativa, String entrenada, String nombre,
            String estado, String sexo, String genoAlimento, String ingestaNativa, String fechaCreacion,
            String fechaModificacion) {
        this.idHormiga = idHormiga;
        this.idCatalogoTipo = idCatalogoTipo;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idCatalogoEstado = idCatalogoEstado;
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
        this.idCatalogoIngestaNativa = idCatalogoIngestaNativa;
        this.entrenada = entrenada;
        this.nombre = nombre;
        this.estado = (estado != null) ? estado : "A";
        this.sexo = sexo;
        this.genoAlimento = genoAlimento;
        this.ingestaNativa = ingestaNativa;
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
        return entrenada;
    }

    public void setEntrenada(String entrenada) {
        this.entrenada = entrenada;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenoAlimento() {
        return genoAlimento;
    }

    public void setGenoAlimento(String genoAlimento) {
        this.genoAlimento = genoAlimento;
    }

    public String getIngestaNativa() {
        return ingestaNativa;
    }

    public void setIngestaNativa(String ingestaNativa) {
        this.ingestaNativa = ingestaNativa;
    }

    @Override
    public String toString() {
        return getClass().getName()
        + "\n idHormiga: "                  + getIdHormiga()
        + "\n idCatalogoTipo: "             + getIdCatalogoTipo()
        + "\n idCatalogoSexo: "             + getIdCatalogoSexo()
        + "\n idCatalogoEstado: "           + getIdCatalogoEstado()
        + "\n idCatalogoGenoAlimento: "     + getIdCatalogoGenoAlimento()
        + "\n idCatalogoIngestaNativa: "    + getIdCatalogoIngestaNativa()
        + "\n entrenada: "                  + getEntrenada()
        + "\n nombre: "                     + getNombre()
        + "\n estado: "                     + getEstado()
        + "\n fechaCreacion: "                  + getFechaCreacion()
        + "\n fechaModificacion:  "              + getFechaModificacion();
    }
}
