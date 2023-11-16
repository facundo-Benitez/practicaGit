package ar.edu.unlam.pb2.segundoParcial;

import java.util.Objects;

public abstract class Alimento implements Comparable<Alimento> {
    
	private String nombre;
    private Double precio;
    private TipoDeAlimento tipo;

    public Alimento(String nombre, Double precio,TipoDeAlimento tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo=tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    
    public TipoDeAlimento getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	@Override
    public int compareTo(Alimento otro) {
        return this.nombre.compareTo(otro.getNombre());
    }

	@Override
	public String toString() {
		return "nombre= " + nombre + ", precio= " + precio;
	}
	   
}
