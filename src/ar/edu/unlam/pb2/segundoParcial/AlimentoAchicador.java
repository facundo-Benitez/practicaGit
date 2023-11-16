package ar.edu.unlam.pb2.segundoParcial;

public class AlimentoAchicador extends Alimento {
    public final Double ACHICAR = 50.0;

    public AlimentoAchicador(String nombre, Double precio,TipoDeAlimento tipo) {
        super(nombre, precio,tipo);
    }

	public Double getACHICAR() {
		return ACHICAR;
	}
    
}