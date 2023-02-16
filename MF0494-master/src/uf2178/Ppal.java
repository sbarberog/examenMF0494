/**
 * 
 */
package uf2178;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Escribe aquí las sentencias del apartado 3
		
		Scanner teclado = new Scanner(System.in);
		
		try {
			System.out.print("Introduzca la tasa de alcoholemia del conductor: ");
			double tasa = teclado.nextDouble();
			
			while(tasa<0) {
				System.out.println("Tasa incorrecta, debe ser un valor positivo.");
				System.out.print("Introduzca la tasa de alcoholemia del conductor: ");
				tasa = teclado.nextDouble();
			}
			
			Funciones.calculaSancion(tasa);
			
			
			int puntos[]= new int[6];
			int sanciones[]= new int[6];
			System.out.println("\nIntroducción del vector de puntos:");
			Funciones.pedir_vector(puntos);
			Funciones.mostrar_vector(puntos);
			
			System.out.println("\nIntroducción del vector de sanciones:");
			Funciones.pedir_vector(sanciones);
			Funciones.mostrar_vector(sanciones);
			
			Funciones.restaPuntos(puntos, sanciones);
			
			System.out.println("\nVector de puntos tras aplicar las sanciones: ");
			Funciones.mostrar_vector(puntos);
			
		}catch(InputMismatchException e) {
			System.err.println("El dato introducido no es un número válido. "+e.getMessage());
		}finally {
			teclado.close();
		}
	}

}
