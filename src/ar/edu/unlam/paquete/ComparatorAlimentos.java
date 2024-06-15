package ar.edu.unlam.paquete;

import java.util.Comparator;

public class ComparatorAlimentos implements Comparator<Alimento> {

	@Override
	public int compare(Alimento a1, Alimento a2) {
		return a1.getNombre().compareTo(a2.getNombre());
	}

}
