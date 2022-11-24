package es.florida.EJERCICIO_06;

public class Semaforo {

	int semaforo = 1;
	int espera = 2000;
	
	void encenderSemaforo() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (semaforo == 2) wait();
				
				System.out.println("Semaforo 1 en VERDE");
				System.err.println("Semaforo 2 en ROJO");
				Thread.sleep(espera);
				semaforo = 2;
				notify();
			}
		}
	}
	
	void apagarSemaforo() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (semaforo == 1) wait();
				
				System.out.println("Semaforo 2 en VERDE");
				System.err.println("Semaforo 1 en ROJO");
				Thread.sleep(espera);
				semaforo = 1;
				notify();
			}
		}
	}
}
