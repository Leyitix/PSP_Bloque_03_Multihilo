package es.florida.EJERCICIO_07;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Caracol_03 implements Runnable {

	private double velocidad;
	private String nombre;
	private int prioridad;

	String nombreFichero = "carreraCaracoles.txt";

	public Caracol_03(double velocidad, String nombre, int prioridad) {
		this.velocidad = velocidad;
		this.nombre = nombre;
		this.prioridad = prioridad;
	}

	@Override
	public void run() {

		File fichero = new File(nombreFichero);
		int meta = 1;
		double avance = 0;
		double totalRecorrido = 0;

		System.out.println(nombre + " inicia la carrera: Prioridad - " + prioridad);
		while (avance < meta) {
			if (fichero.exists()) { // si el fichero existe es que ha terminado la carrera
				System.out.println(nombre + " ha sido eliminado. Ha recorrido " + String.format("%.0f", totalRecorrido)
						+ "%  del recorrido");
				avance = meta; // igualeamos el avance a la meta para finalizar los hilos que aun no hayan
								// acabado
			} else {
				avance += velocidad * 1;
				totalRecorrido = 100 * avance / meta;
				System.out.println(nombre + " - " + String.format("%.0f", totalRecorrido) + "%");
			}
		}
		
		if (!fichero.exists()) {
			FileWriter fw;
			try {
				fw = new FileWriter(fichero);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("El caracol " + nombre + " ha alcanzado la meta (Prioridad: " + prioridad + ")");
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getPrioridad() {
		return prioridad;
	}

}
