package ar.edu.unlam.pb2.segundoParcial;

public class AlimentoAgrandador extends Alimento {
    public final Double CRECIMIENTO = 40.0;

    public AlimentoAgrandador(String nombre, Double precio,TipoDeAlimento tipo) {
        super(nombre, precio,tipo);
    }

	public Double getCRECIMIENTO() {
		return CRECIMIENTO;
	}
        
}