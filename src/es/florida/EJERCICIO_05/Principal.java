package es.florida.EJERCICIO_05;

public class Principal {
	
	/*
	 *  El delegado de clase ha comprado un bote extra grande de alitas de pollo en el KFC (100 
		alitas) y los va a repartir entre los 30 compañeros de clase. Para ello crea una clase que 
		implementa Runnable y que tiene un método “consumirAlita” que mientras queden alitas 
		permite consumir el número que pida cada compañero (entre 1 y 10 alitas, de forma 
		aleatoria), un método “run” (obligado al implementar Runnable) que llama a 
		“consumirAlita” y un “main” que crea un hilo por cada compañero. El “main” deberá mostrar 
		al final de la ejecución cuántas alitas se han comido entre todos. Realiza dos ejecuciones: sin 
		y con sincronización del método “consumirAlita” (problema similar al de las entradas).
	 * **/

	public static void main(String[] args) {
		Alitas alitas = new Alitas();
		Thread hilo;
		int NUM_ALUMNOS = 30;

		for (int i = 0; i < NUM_ALUMNOS; i++) {
			hilo = new Thread(alitas);
			hilo.setName("Alumno " + (i + 1));
			hilo.start();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
