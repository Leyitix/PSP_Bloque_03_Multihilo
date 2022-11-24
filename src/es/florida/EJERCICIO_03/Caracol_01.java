package es.florida.EJERCICIO_03;

public class Caracol_01 implements Runnable{

	private double velocidad;
	private String nombre;
	
	public Caracol_01(double velocidad, String nombre) {
		this.velocidad = velocidad;
		this.nombre = nombre;
	}


	@Override
	public void run() {
		int meta = 1;
		double avance = 0;
		double totalRecorrido = 0;
		
		System.out.println(nombre + " inicia la carrera");
		while (avance < meta) {
			avance += velocidad * 1;
			totalRecorrido = 100 * avance / meta;
			System.out.println(nombre + " - " + String.format("%.0f", totalRecorrido) + "%");
		}
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.err.println("El caracol " + nombre + " ha alcanzado la meta");
		
	}

}
