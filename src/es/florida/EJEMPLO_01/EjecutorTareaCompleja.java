package es.florida.EJEMPLO_01;

public class EjecutorTareaCompleja implements Runnable {

	private String nombre;
	int numEjecucion;

	public EjecutorTareaCompleja(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		String mensaje;
		while (numEjecucion < 100) {
			for (double i = 0; i < 499.9; i = i + 0.2) {
				Math.sqrt(i);
			}

			mensaje = "Soy el " + this.nombre;
			mensaje += " ejecutando la operacion i = " + numEjecucion;
			System.out.println(mensaje);
			numEjecucion++;
		}
		System.out.println(this.nombre + " dice: HE TERMINADO!!!");
	}

}
