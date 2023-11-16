package ar.edu.unlam.pb2.segundoParcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Alicia {
	
	private String nombre;
    private Integer edad;
    private Double altura;
    private Double peso;
    private Double dineroDisponible;
    private ArrayList<Alimento> alimentosComprados;
    private ArrayList<Alimento> consumido;
    public final Double ALTURA_MININA_REQUERIDA = 50.0;
    public final Double ALTURA_MAXIMA_REQUERIDA  = 280.0;

    public Alicia(String nombre, Integer edad, Double altura, Double peso, Double dineroDisponible) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.dineroDisponible = dineroDisponible;
        this.alimentosComprados = new ArrayList<Alimento>();
        this.consumido=new ArrayList<Alimento>();
    }
    
    public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(Double dineroDisponible) {
		this.dineroDisponible =dineroDisponible;
	}

	public ArrayList<Alimento> getAlimentosComprados() {
		return alimentosComprados;
	}

	public void setAlimentosComprados(ArrayList<Alimento> alimentosComprados) {
		this.alimentosComprados = alimentosComprados;
	}

	public ArrayList<Alimento> getConsumido() {
		return consumido;
	}

	public void setConsumido(ArrayList<Alimento> consumido) {
		this.consumido = consumido;
	}

	public Double getALTURA_MININA_REQUERIDA() {
		return ALTURA_MININA_REQUERIDA;
	}

	public Double getALTURA_MAXIMA_REQUERIDA() {
		return ALTURA_MAXIMA_REQUERIDA;
	}
	
    public Boolean comprarAlimento(Alimento alimento) throws DineroExcedidoException {
    	Boolean seCompro=false;
        if (this.dineroDisponible >= alimento.getPrecio()) {
        	alimentosComprados.add(alimento);
        	dineroDisponible -= alimento.getPrecio();
            return seCompro=true;
        } else {
            throw new DineroExcedidoException("Dinero Excedido, supero el limite del dinero disponible ");
        }
    }

	public Alimento buscarAlimento(String nombreAlimento) {
		for (Alimento actual : alimentosComprados) {
			if(actual.getNombre().equals(nombreAlimento)) {
				return actual;
				
			}
		}
		return null;
	}
	
    public ArrayList<Alimento> consumirAlimentos(String nombreAlimento) throws AlturaExcedidaException { 	
    	Alimento buscado=this.buscarAlimento(nombreAlimento);
    	
        if ((buscado instanceof AlimentoAchicador)&&(this.altura -(((AlimentoAchicador)buscado).getACHICAR()) >= ALTURA_MININA_REQUERIDA)) {
            altura -=(((AlimentoAchicador)buscado).getACHICAR());
            consumido.add(buscado);
            this.alimentosComprados.remove(buscado);
            return consumido;
           } 
        else if ((buscado instanceof AlimentoAgrandador)&&(this.altura +(((AlimentoAgrandador)buscado).getCRECIMIENTO())<= ALTURA_MAXIMA_REQUERIDA)) {                   
                  altura += (((AlimentoAgrandador)buscado).getCRECIMIENTO());
                  consumido.add(buscado);
                  this.alimentosComprados.remove(buscado);
                  return consumido;
                 } 
        else {
                 throw new AlturaExcedidaException("Ha superado los limites de altura requerido");
             }
    }
    

	public void OrdenarLosAlimentosDeManeraNaturalAscendente() {	
		Collections.sort(alimentosComprados);
	}
	
	public void OrdenarLosAlimentosDeManeraDescendente() {	
		Collections.sort(alimentosComprados,new OrdenPorNombreDescendente());
	}
	
	public Integer getCantidadComprado() {
		return this.alimentosComprados.size();
	}
	
	public Map<TipoDeAlimento,Integer> cantidadDeAlimentosPorTipoCompradosPorAlicia() {
		Map<TipoDeAlimento,Integer>AlimentosPorTipo=new HashMap<TipoDeAlimento,Integer>();
		
		for (Alimento actual : alimentosComprados) {
			TipoDeAlimento keyAlimento=actual.getTipo();
			if(AlimentosPorTipo.containsKey(keyAlimento)) {
				Integer valor=AlimentosPorTipo.get(keyAlimento)+1;
				AlimentosPorTipo.put(keyAlimento, valor);
			}else {
				AlimentosPorTipo.put(keyAlimento, 1);
			}
		}
		return AlimentosPorTipo;
	 }	

}


