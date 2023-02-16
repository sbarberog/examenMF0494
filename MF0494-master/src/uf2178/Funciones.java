package uf2178;

import java.util.Scanner;

public class Funciones {
	
	/** 
	 * Método de la clase que pide un vector por teclado
	 * @param v int[] el vector a introducir por teclado
	 */
	public static void  pedir_vector(int v[]) {
		Scanner entrada = new Scanner(System.in);
		
		for (int i = 0; i < v.length; i++) {
			System.out.printf("Introduce el elemento %d: ", i);
			v[i] = entrada.nextInt();
		}
	}
	
	/**
	 * Método para mostrar por pantalla el vector pasado como parámetro
	 * @param v int [] el vector a mostrar en pantalla
	 */
	public static void  mostrar_vector(int v[]) {
		for (int i = 0; i < v.length; i++) {
			System.out.printf("%3d ", v[i]);
		}
		System.out.println();
	}
	
	// Escribe las sentencias de los apartados 1 y 2

	
	public static void calculaSancion(double tasa) {
		
		String sancion="";
		
		if(tasa<0.25) {
			sancion="Sin sanción";
		} else if(tasa<0.5) {
			sancion="500 € y pérdida de 4 puntos";
		} else if(tasa<0.6) {
			sancion="1000 € y pérdida de 6 puntos";
		} else {
			sancion="Retirada del carnet y de 3 a 6 meses de cárcel";
		}
		
		System.out.printf("El conductor con tasa de alcoholemia %.2f tiene la sanción: %s\n",
				tasa, sancion);
	}
	
	public static void restaPuntos(int[] puntos, int[] sanciones) {
		
		// antes nos aseguramos de que los vectores tengan la misma longitud
		if(puntos.length!=sanciones.length) {
			System.err.println("Error. Los vectores no tienen la misma longitud.");
			return;
		}
		
		// bucle que recorre el vector de puntos y le resta las sanciones
		for (int i = 0; i < sanciones.length; i++) {
			puntos[i]=puntos[i]-sanciones[i];
			if (puntos[i]<0) {
				puntos[i]=0;
			}
		}
	}
}
