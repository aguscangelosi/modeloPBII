package ar.edu.unlam.paquete;

public class AlimentoAgrandador extends Alimento implements modificadorAltura{

	public AlimentoAgrandador(String nombre, TipoAlimento tipoDeAlimento) {
		super(nombre, tipoDeAlimento);
	}

	@Override
	public Double getPrecio() {
		switch(this.getTipoDeAlimento()) {
		case MASITAS:
			return 10.0;
		case ALFAJORES:
			return 15.0;
		case BAGELS:
			return 20.0;
		}
		return 0.0;
	}

	@Override
	public Integer getModificacionAltura() {
		// TODO Auto-generated method stub
		return 40;
	}

}
