package es.florida.EJEMPLO_03;

import java.util.LinkedList;

public class ProductorConsumidor {

	public static class Productor {
		// Crea una lista compartida de tamano <capacity>
		LinkedList<Integer> listaProductos = new LinkedList<>();
		int capacidad = 2;

		// Funcion del productor
		public void produce() throws InterruptedException {
			int valor = 0;
			while (true) {
				synchronized (this) {
					// El hilo productor espera mientras la lista este llena
					while (listaProductos.size() == capacidad)
						wait();

					// Inserta el producto en la lista
					listaProductos.add(valor++);
					System.out.println(
							"Productor produjo: item nº " + valor + " (stock " + listaProductos.size() + " productos)");

					// Notifica al consumidor que empiece a consumir
					notify();

					// Pausa para ver el proceso paso a paso
					Thread.sleep(1000);
				}
			}
		}

		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					// El hilo consumidor espera mientras la lista este vacia
					while (listaProductos.size() == 0)
						wait();

					// Elimina el producto de la lista
					int valor = listaProductos.removeFirst();
					System.err.println("Consumidor consumió: item nº " + valor + " (stock " + listaProductos.size()
							+ " productos)");

					// Notifica al productor que empiece a producir
					notify();

					// Pausa para ver el proceso paso a paso
					Thread.sleep(1000);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Crea la cola y los hilos productor y consuidor
		final Productor productor = new Productor();

		// Hilo productor
		Thread hilo1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					productor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// Hilo consumidor
		Thread hilo2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					productor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//	Iniciar los hilos
		hilo1.start();
		hilo2.start();
		
		//	Finalizar hilos, hilo1 antes que hilo2
		hilo1.join();
		hilo2.join();
	}

}
