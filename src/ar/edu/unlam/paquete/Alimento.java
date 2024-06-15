package ar.edu.unlam.paquete;

public abstract class Alimento implements modificadorAltura{
	
	
	private String nombre;
	private TipoAlimento tipoDeAlimento;
	
	
	public Alimento(String nombre, TipoAlimento tipoDeAlimento) {
		this.nombre = nombre;
		this.tipoDeAlimento = tipoDeAlimento;
	}


	public TipoAlimento getTipoDeAlimento() {
		return tipoDeAlimento;
	}
	
	public abstract Double getPrecio();
	
	public String getNombre() {
		return nombre;
	}
	
}
