package es.florida.EJERCICIO_03;

public class Principal {
	
	/*
	 * Crea una clase denominada “Caracol” que implemente Runnable y que tenga dos
	 * atributos: velocidad (tipo double) y nombre (tipo String). La aplicación
	 * deberá simular una carrera de 1 m entre 5 caracoles (con nombres y
	 * velocidades distintas), mostrando por pantalla el progreso (en porcentaje) de
	 * cada caracol hasta que recorra la distancia completa.
	 * 
	 **/

	public static void main(String[] args) {
		Caracol_01 caracol;
		Thread hilo;
		double[] velocidades = { 0.01, 0.05, 0.03, 0.04, 0.009 };
		String[] nombres = { "C1", "C2", "C3", "C4", "C5" };

		for (int i = 0; i < nombres.length; i++) {
			caracol = new Caracol_01(velocidades[i], nombres[i]);
			hilo = new Thread(caracol);
			hilo.start();
		}
	}
	


}
