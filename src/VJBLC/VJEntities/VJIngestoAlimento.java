package VJBLC.VJEntities;

public abstract class VJIngestoAlimento {
    protected VJGenoAlimento inyectadoCon;

    public abstract boolean inyectar(VJGenoAlimento genoAlimento);
   
    public String getTipo() {
        if (inyectadoCon != null) {
            return inyectadoCon.getTipo();  // Llama al método getTipo() de Alimento
        }
        return "Desconocido";  // Si no hay alimento inyectado
    }

    protected abstract VJXY getInyectadoCon();
}
