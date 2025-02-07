package VJBLC.VJEntities;

public class VJCarnivoro extends VJIngestaNativa {
    @Override
    public boolean inyectar(VJGenoAlimento genoAlimento) {
        // Lógica específica para Carnívoro
        genoAlimento.aplicarEvolucion(new VJHormiga(0));  // Puede alimentar la hormiga
        return true;
    }

    @Override
    protected VJXY getInyectadoCon() {
        System.out.println("Error en VJCarnivoro");
        throw new UnsupportedOperationException("Unimplemented method 'getInyectadoCon'");
    }
}
