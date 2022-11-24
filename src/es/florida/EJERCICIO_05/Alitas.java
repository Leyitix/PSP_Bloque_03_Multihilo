package es.florida.EJERCICIO_05;

public class Alitas implements Runnable {

	int numAlitas;
	int disponibles = 100;
	int totalAlitasConsumidas = 0;
	String nombre;
	
	public Alitas() {}
	
	synchronized public void consumirAlita(int numAlitas, String nombre) {
		System.out.println(nombre + " ha pedido " + numAlitas +  " alitas");
		if (numAlitas < disponibles) {
			disponibles -= numAlitas;
			totalAlitasConsumidas += numAlitas;
			System.out.println("Quedan " + disponibles + " alitas (alitas consumidas: " + totalAlitasConsumidas + ")");
		} else {
			System.err.println(nombre + " se ha quedado sin alitas");
		}
	}

	@Override
	public void run() {
		// nombre del hilo
		String nombreHilo = Thread.currentThread().getName();
		int alitas = (int) (Math.random() * 10 + 1); // se piden un total de alitas entre 1 y 10 cada vez
		consumirAlita(alitas, nombreHilo);
	}
}
