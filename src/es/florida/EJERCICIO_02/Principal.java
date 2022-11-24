package es.florida.EJERCICIO_02;

public class Principal {
	
	/*Implementa una clase denominada “Contador” que implemente Runnable con tres 
atributos: un atributo de tipo String denominado “nombreHilo”, otro atributo de tipo entero 
denominado “inicioContador” y otro de tipo entero denominado “limiteContador”, que 
indicará el fin de la cuenta. El programa principal deberá crear 5 hilos contadores con límites 
distintos y que se muestre por pantalla la cuenta de cada uno.
**/

	private static Thread[] hilos;
	
	public static void main(String[] args) {
		int NUM_HILOS = 5;
		hilos = new Thread[NUM_HILOS];
		Contador cont;
		for (int i = 0; i < NUM_HILOS; i++) {
			cont = new Contador("Hilo " + i, i, i * 2);
			hilos[i] = new Thread(cont);
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
