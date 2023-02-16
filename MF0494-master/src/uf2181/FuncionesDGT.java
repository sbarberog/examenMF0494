/**
 * 
 */
package uf2181;

/**
 * @author David
 * 
 */
public class FuncionesDGT {

	/**
	 * Devuelve la media de los puntos almacenados en el vector introducido como parámetro.
	 * @throws ArrayIndexOutOfBoundsException cuando la longitud del vector introducido sea 0.
	 * @param puntos Vector de valores enteros cuya media se desea calcular.
	 * @return Media de los puntos en el vector, de tipo float.
	 */
	public double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	
	/**
	 * Devuelve la tasa máxima de alcoholemia permitida en función de dos parámetros introducidos: 
	 * el tipo de conductor, y el tipo de medición.
	 * @param tipoConductor String que almacena el tipo de conductor, "General" o "Novel".
	 * @param aire Booleano que indica el tipo de medición, <strong>true</strong> si es en
	 * aire aspirado, o <strong>false</strong> si es en sangre.
	 * @return Tasa máxima de alcoholemia permitida, de tipo float.
	 */
	public double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
