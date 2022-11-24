package es.florida.EJEMPLO_01;

public class Main {

	private static Thread[] hilos;

	public static void main(String[] args) {
		int NUM_HILOS = 10;
		hilos = new Thread[NUM_HILOS];
		EjecutorTareaCompleja ejecutor;

		for (int i = 0; i < NUM_HILOS; i++) {
			ejecutor = new EjecutorTareaCompleja("Hilo " + i);
			hilos[i] = new Thread(ejecutor);
			hilos[i].start();
			try {
				hilos[i].join(); // esperamos a que finalice un hilo para lanzar el siguiente
				// de esta forma perdemos la capacidad de ejecutar los hilos en paralelo
				// pero obtenemos un cioerto orden de ejecucion
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
