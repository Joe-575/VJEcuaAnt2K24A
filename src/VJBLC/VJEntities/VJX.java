package VJBLC.VJEntities;

public class VJX extends VJGenoAlimento {
    public VJX(String tipo, String VJcaracteristicasGeneticas) {
        super(tipo, VJcaracteristicasGeneticas);
    }

    @Override
    public void aplicarEvolucion(VJHormiga hormiga) {
        // Lógica de evolución específica para RAX
        hormiga.setTipo("Tipo X");
    }

    @Override
    public boolean inyectar(VJGenoAlimento genoAlimento) {
        return false;

    }

    @Override
    protected VJXY getInyectadoCon() {
        System.out.println("Error en VJX");
        throw new UnsupportedOperationException("Unimplemented method 'getInyectadoCon'");
    }
}
