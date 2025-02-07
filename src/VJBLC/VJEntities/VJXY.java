package VJBLC.VJEntities;

public class VJXY extends VJGenoAlimento{

    public VJXY(String VJtipo, String VJcaracterísticasGenéticas) {
        super(VJtipo, VJcaracterísticasGenéticas);
    }    
    @Override
    public void aplicarEvolucion(VJHormiga hormiga) {
        
        throw new UnsupportedOperationException("Unimplemented method 'aplicarEvolucion'");
    }

    @Override
    public boolean inyectar(VJGenoAlimento genoAlimento) {
        throw new UnsupportedOperationException("Unimplemented method 'inyectar'");
    }

    @Override
    protected VJXY getInyectadoCon() {
        throw new UnsupportedOperationException("Unimplemented method 'getInyectadoCon'");
    }

}
