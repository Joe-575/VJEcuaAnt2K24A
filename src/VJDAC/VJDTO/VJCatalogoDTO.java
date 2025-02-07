package VJDAC.VJDTO;

public class VJCatalogoDTO {
    private Integer idCatalogoPadre;
    private Integer idCatalogo;
    private String nombre;
    private String detalle;
    private String estado;
    private String fechaCreacion;
    private String fechaModificacio;
    
    public VJCatalogoDTO() {
    }

    public VJCatalogoDTO(Integer idCatalogo, String nombre) {
        this.idCatalogo = idCatalogo;
        this.nombre = nombre;
    }

    public VJCatalogoDTO(Integer idCatalogoPadre, Integer idCatalogo, String nombre, String detalle, String estado,
            String fechaCreacion, String fechaModificacio) {
        this.idCatalogoPadre = idCatalogoPadre;
        this.idCatalogo = idCatalogo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacio = fechaModificacio;
    }

    public Integer getIdCatalogoPadre() {
        return idCatalogoPadre;
    }

    public void setIdCatalogoPadre(Integer idCatalogoPadre) {
        this.idCatalogoPadre = idCatalogoPadre;
    }

    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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

    public String getFechaModificacio() {
        return fechaModificacio;
    }

    public void setFechaModificacio(String fechaModificacio) {
        this.fechaModificacio = fechaModificacio;
    }

    @Override
    public String toString() {
        return getClass().getName()
        +"\n idCatalogo: "          + getIdCatalogo()
        + "\n idCatalogoPadre: "    + getIdCatalogoPadre()  
        + "\n nombre: "             + getNombre()
        + "\n detalle: "            + getDetalle()
        + "\nestado: "              + getEstado()
        + "\nfechaCreacion: "       + getFechaCreacion()
        + "\nfechaModificacion: "   + getFechaModificacio();
    }
}
