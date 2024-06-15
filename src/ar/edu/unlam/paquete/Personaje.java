package ar.edu.unlam.paquete;

import java.util.*;

public class Personaje {
	
	private Integer altura;
	private Integer peso;
	private String nombre;
	private Integer edad;
	private Double dineroParaComprar;
	private List<Alimento>alimentosParaConsumir;
	private final Integer ALTURA_MAXIMA_PERMITIDA;
	private final Integer ALTURA_MINIMA_PERMITIDA;
	
	public Personaje(Integer altura, Integer peso, String nombre, Integer edad, Double dineroParaComprar) {
		this.altura = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dineroParaComprar = dineroParaComprar;
		this.alimentosParaConsumir = new ArrayList<>();
		this.ALTURA_MAXIMA_PERMITIDA = 280;
		this.ALTURA_MINIMA_PERMITIDA = 50;
	}
	
	

	public Integer getAltura() {
		return altura;
	}



	public Double getDineroParaComprar() {
		return dineroParaComprar;
	}



	public List<Alimento> getAlimentosParaConsumir() {
		return alimentosParaConsumir;
	}



	public void comprarAlimento(Alimento alimento) throws comprarAlimentoException{
		if(alimento.getPrecio()<=this.dineroParaComprar) {
			this.dineroParaComprar -= alimento.getPrecio();
			this.alimentosParaConsumir.add(alimento);
		}else {
			throw new comprarAlimentoException("No hay dinero suficiente");
		}
	}



	public void comerAlimento(Alimento alimento) throws AlimentoDisponibleException{
		Boolean alimentoExiste = false;
		
		for(Alimento a : this.alimentosParaConsumir) {
			if(a.equals(alimento)) {
				alimentoExiste = true;
				break;
			}
		}
		
		Integer alturaNueva = this.altura + alimento.getModificacionAltura();
		
		Boolean alturaPosible = false;
		
		if(alturaNueva >= this.ALTURA_MINIMA_PERMITIDA && alturaNueva <= this.ALTURA_MAXIMA_PERMITIDA) {
			alturaPosible = true;
		}
		
		if(!alimentoExiste) {
			throw new AlimentoDisponibleException("Alicia no tiene el alimento disponible");
		}
		
		if(alimentoExiste) {
			this.alimentosParaConsumir.remove(alimento);
			
			if(alturaPosible) {
				this.altura = alturaNueva;
			}else if(alturaNueva<this.ALTURA_MINIMA_PERMITIDA) {
				this.altura = this.ALTURA_MINIMA_PERMITIDA;
			}else if(alturaNueva > this.ALTURA_MAXIMA_PERMITIDA) {
				this.altura = this.ALTURA_MAXIMA_PERMITIDA;
			}
		}
		
		
		
	}



	public List<Alimento> obtenerAlimentosOrdenadosAlfabeticamente() {
		List <Alimento>alimentosOrdenados = this.alimentosParaConsumir;
		
		Collections.sort(alimentosOrdenados, new ComparatorAlimentos());
		
		/*for(int i=0; i<alimentosOrdenados.size(); i++) {
			System.out.println(alimentosOrdenados.get(i).getNombre());
		}*/
		return alimentosOrdenados;
	}

	
}
