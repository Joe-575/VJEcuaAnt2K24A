package VJBLC.VJEntities;

public class VJNectarivoros extends VJGenoAlimento {

    public VJNectarivoros(String tipo, String VJcaracteristicasGeneticas) {
        super(tipo, VJcaracteristicasGeneticas);
    }

    @Override
    public boolean inyectar(VJGenoAlimento genoAlimento) {
        // Lógica específica para Carnívoro
        genoAlimento.aplicarEvolucion(new VJHormiga(0)); // Puede alimentar la hormiga
        return true;
    }

    @Override
    public void aplicarEvolucion(VJHormiga hormiga) {
        throw new UnsupportedOperationException("Unimplemented method 'aplicarEvolucion'");
    }

    @Override
    protected VJXY getInyectadoCon() {
        throw new UnsupportedOperationException("Unimplemented method 'getInyectadoCon'");
    }

}
