package es.florida.EJEMPLO_02;

public class MultihiloSync implements Runnable{
	
	int entradasDisponibles = 100;
	static int entradasVendidas = 0;

	synchronized public void reservaEntrada(String nombre, int entradas) {
		if (entradas <= entradasDisponibles) {
			System.out.println(entradas + " reservadas para " + nombre);
			entradasDisponibles = entradasDisponibles - entradas;
			entradasVendidas = entradasVendidas + entradas;
		} else {
			System.err.println("No quedan entradas para " + nombre);
		}
	}

	public void run() {
		String nombre = Thread.currentThread().getName();
		int entradas = (int) (Math.random() * 10 + 1);
		reservaEntrada(nombre, entradas);
	}

	public static void main(String[] args) {

		MultihiloSync s = new MultihiloSync();
		Thread t;

		for (int i = 0; i < 100; i++) {
			t = new Thread(s);
			t.setName("Cliente " + (i + 1));
			t.start(); // llamada a la clase
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();// pausa para dejar que acaben todos los threads
		}

		System.out.println("Total entradas vendidas: " + entradasVendidas);
	}

}
