package es.florida.EJERCICIO_07;

public class Principal {

	public static void main(String[] args) {
		Caracol_03 caracol;
		Thread hilo;

		double velocidad = 0.02;
		String[] nombres = {"C1", "C2", "C3", "C4", "C5"};
		int prioridades[] = {1, 3, 2, 5, 4};
		
		for (int i = 0; i < nombres.length; i++) {
			caracol = new Caracol_03(velocidad, nombres[i], prioridades[i]);
			hilo = new Thread(caracol);
			hilo.setPriority(prioridades[i]);
			hilo.start();
		}
	}

}
