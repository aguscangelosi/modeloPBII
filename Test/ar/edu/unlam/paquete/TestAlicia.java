package ar.edu.unlam.paquete;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestAlicia {

	@Test
	public void queAlComprarUnAlimentoSeDescuenteElDineroDisponible() throws comprarAlimentoException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento gomitas = new AlimentoAchicador("Mogul", TipoAlimento.GOMITAS);
		
		alicia.comprarAlimento(gomitas);
		
		Double cantidadEsperada = 480.0;
		Double cantidadRecibida = alicia.getDineroParaComprar();
		
		assertEquals(cantidadEsperada, cantidadRecibida);
	}
	
	@Test (expected = comprarAlimentoException.class)
	public void queNoSeExcedaElDineroDisponible() throws comprarAlimentoException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento gomitas = new AlimentoAchicador("Mogul", TipoAlimento.GOMITAS);
		
		for(int i=0; i<26; i++) {
			alicia.comprarAlimento(gomitas);
		}
	}
	
	@Test
	public void queSeAgrandeAlConsumirUnAAlimento() throws comprarAlimentoException, AlimentoDisponibleException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento alfajor = new AlimentoAgrandador("Jorgito", TipoAlimento.ALFAJORES);
		
		alicia.comprarAlimento(alfajor);
		
		alicia.comerAlimento(alfajor);
		
		Integer alturaEsperada = 220;
		Integer alturaObtenida = alicia.getAltura();
		
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@Test
	public void queSeAchiqueAlConsumirUnAlimento() throws comprarAlimentoException, AlimentoDisponibleException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento gomitas = new AlimentoAchicador("Mogul", TipoAlimento.GOMITAS);
		
		alicia.comprarAlimento(gomitas);
		alicia.comerAlimento(gomitas);
		
		Integer alturaEsperada = 130;
		Integer alturaObtenida = alicia.getAltura();
		
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@Test
	public void queNoSePuedaAgrandarMasDeLaAlturaMaximaPermitida() throws comprarAlimentoException, AlimentoDisponibleException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento alfajor = new AlimentoAgrandador("Jorgito", TipoAlimento.ALFAJORES);
		
		for(int i=0; i<4; i++) {
			alicia.comprarAlimento(alfajor);
			
			alicia.comerAlimento(alfajor);
		}
		
		Integer alturaEsperada = 280;
		Integer alturaObtenida = alicia.getAltura();
		
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	
	@Test
	public void queNoSePuedaAchicarMasDeLaAlturaMinimaPermitida() throws comprarAlimentoException, AlimentoDisponibleException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento gomitas = new AlimentoAchicador("Mogul", TipoAlimento.GOMITAS);
		
		for(int i=0; i<4; i++) {
			alicia.comprarAlimento(gomitas);
			alicia.comerAlimento(gomitas);
		}
		
		Integer alturaEsperada = 50;
		Integer alturaObtenida = alicia.getAltura();
		
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@Test
	public void verificarQueLaColeccionDeAlimentosQuedeOrdenadaAlfabeticamente() throws comprarAlimentoException {
		Integer altura = 180;
		Integer peso = 80;
		String nombre = "Alicia";
		Integer edad = 18;
		Double dineroParaComprar = 500.0;
		
		Personaje alicia = new Personaje(altura, peso, nombre, edad, dineroParaComprar);
		
		Alimento gomitas = new AlimentoAchicador("Mogul", TipoAlimento.GOMITAS);
		
		alicia.comprarAlimento(gomitas);
		
		Alimento alfajor = new AlimentoAgrandador("Jorgito", TipoAlimento.ALFAJORES);
		
		alicia.comprarAlimento(alfajor);
		
		
		List<Alimento>alimentosOrdenadosAlfabeticamente = alicia.obtenerAlimentosOrdenadosAlfabeticamente();
		
		assertEquals(alimentosOrdenadosAlfabeticamente.get(0), alfajor);
		assertEquals(alimentosOrdenadosAlfabeticamente.get(1), gomitas);
	}

}
