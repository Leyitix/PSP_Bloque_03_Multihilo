package es.florida.EJERCICIO_04;

public class Caracol_02 implements Runnable{

	private double velocidad;
	private String nombre;
	private int prioridad;
	
	public Caracol_02(double velocidad, String nombre, int prioridad) {
		this.velocidad = velocidad;
		this.nombre = nombre;
		this.prioridad = prioridad;
	}
	
	@Override
	public void run() {
		int meta = 1;
		double avance = 0;
		double totalRecorrido = 0;
		
		System.out.println(nombre  + " inicia la carrera: Prioridad" + prioridad);
		while (avance < meta) {
			avance += velocidad * 1;
			totalRecorrido = 100 * avance / meta;
			System.out.println(nombre + " - " + String.format("%.0f", totalRecorrido) + "%");
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El caracol " + nombre + " ha alcanzado la meta (Prioridad: " + prioridad + ")");
	}

	public int getPrioridad() {
		return prioridad;
	}
	
}
