package es.florida.EJERCICIO_06;

public class Principal {

	/*
	 * Basándote en el problema del Productor-Consumidor (comunicación entre hilos), desarrolla 
un programa que tenga una clase “ControlSemaforos” con dos métodos que simulan dos 
semáforos distintos (“encenderSemaforo1” y “encenderSemaforo2”, que hace alternar los 
semáforos entre verde y rojo cada 3 segundos, no pudiendo estar los dos en el mismo estado 
a la vez) y un método “main” que crea un objeto “ControlSemaforos” y dos hilos, uno por 
cada semáforo. 
Puedes utilizar una variable de tipo int para controlar qué semáforo está en verde, de forma 
que cuando 1 esté en verde, el semáforo 2 espere en rojo. Cuando pasen 5 segundos, el 
semáforo 1 que está en verde cambiará a rojo y lo notificará al semáforo 2, que dejará de 
esperar y pasará a verde durante otros 5 segundos. 
	 * */
	
	public static void main(String[] args) {
		final Semaforo semaforo = new Semaforo();

		Thread h1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaforo.encenderSemaforo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread h2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaforo.apagarSemaforo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		h1.start();
		h2.start();
	}

}
