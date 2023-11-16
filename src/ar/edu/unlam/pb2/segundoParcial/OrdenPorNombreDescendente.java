package ar.edu.unlam.pb2.segundoParcial;

import java.util.Comparator;

public class OrdenPorNombreDescendente implements Comparator<Alimento> {

	@Override
	public int compare(Alimento a1, Alimento a2) {
		 return a2.getNombre().compareTo(a1.getNombre());
	}

}
