package uf2181;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FuncinesDGTTest {

	private static FuncionesDGT funciones;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		funciones=new FuncionesDGT();
	}

	@Test
	void testMediaPuntos() {
		int prueba[]= {3,5,7,10,0};
		int prueba2[]=new int[0];
		assertEquals(5, funciones.mediaPuntos(prueba));
		assertThrows(ArrayIndexOutOfBoundsException.class, 
				()->funciones.mediaPuntos(prueba2));
	}

	@Test
	void testMaximaTasaPermitida() {
		assertEquals(0.25, funciones.maximaTasaPermitida("General", true));
		assertEquals(0.5, funciones.maximaTasaPermitida("General", false));
		assertEquals(0.15, funciones.maximaTasaPermitida("Novel", true));
		assertEquals(0.3, funciones.maximaTasaPermitida("Novel", false));
	}

}
