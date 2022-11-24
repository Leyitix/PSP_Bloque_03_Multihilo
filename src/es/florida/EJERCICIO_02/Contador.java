package es.florida.EJERCICIO_02;

public class Contador implements Runnable{
	private String nombreHilo;
	private int inicioContador, limiteContador;
	
	public Contador(String nombreHilo, int inicioContador, int limiteContador) {
		this.nombreHilo = nombreHilo;
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
	}

	@Override
	public void run() {
		for (int i = inicioContador; i < limiteContador; i++) {
			inicioContador++;
			System.out.println("Inicio: " + inicioContador + " // Fin: " + limiteContador);
			if (inicioContador == limiteContador) {
				System.out.println("Contador: " + inicioContador);
				System.err.println(nombreHilo + " ha alcanzado el limite");
			}
			
		}
		
	}
}
