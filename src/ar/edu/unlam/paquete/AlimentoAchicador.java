package ar.edu.unlam.paquete;

public class AlimentoAchicador extends Alimento implements modificadorAltura{

	public AlimentoAchicador(String nombre, TipoAlimento tipoDeAlimento) {
		super(nombre, tipoDeAlimento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getPrecio() {
		switch(this.getTipoDeAlimento()) {
		case BOCADITOS_DE_CHOCOLATE:
			return 10.0;
		case CARAMELOS:
			return 15.0;
		case GOMITAS:
			return 20.0;
		}
		return 0.0;
	}

	@Override
	public Integer getModificacionAltura() {
		// TODO Auto-generated method stub
		return -50;
	}

	
	
}
