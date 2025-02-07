package VJBLC.VJEntities;

public abstract class VJGenoAlimento extends VJIngestaNativa {
    private String VJcaracteristicasGeneticas;

    public abstract void aplicarEvolucion(VJHormiga hormiga);

    public VJGenoAlimento(String tipo, String VJcaracteristicasGeneticas) {
        super();
        this.VJcaracteristicasGeneticas = VJcaracteristicasGeneticas;
    }
}
