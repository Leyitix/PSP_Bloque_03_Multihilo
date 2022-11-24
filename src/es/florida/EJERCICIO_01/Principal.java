package es.florida.EJERCICIO_01;

public class Principal {
	
	private static Thread[] hilos;

	public static void main(String[] args) {
		int NUM_HILOS = 2;
		hilos = new Thread[NUM_HILOS];
		MostrarASCII ascii;
		String tipo = "1";
		
		System.out.println("Primero hilo");
		for (int i = 0; i < NUM_HILOS; i++) {
			ascii = new MostrarASCII(tipo);
			hilos[i] = new Thread(ascii);
			hilos[i].start();
			
			tipo = "2";
			try {
				hilos[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
