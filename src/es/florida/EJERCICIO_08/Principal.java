package es.florida.EJERCICIO_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	
	public static void getProbabilidad(int cores, String[] arrayNombres, double[] arrayProbabilidades) throws InterruptedException {
		System.out.println("");
		System.out.println("PROBABILIDADES");
		for (int i = 0; i < cores; i++) {
			if (arrayProbabilidades[i] > 10) {
				System.err.println( "ALERTA!! EL NEO " + arrayNombres[i] + " tiene una probabilidad de colisión del " + String.format("%.2f", arrayProbabilidades[i])  + "%");
			} else {
				System.out.println("EL NEO " + arrayNombres[i] + " solo tiene una probabilidad de colisión del " + String.format("%.2f", arrayProbabilidades[i])  + "%"); 
			}
			Thread.sleep(100);
		}
		System.out.println("");
		
	}
	
	public static double getResultadoFichero(String nombreFichero) throws IOException {
		
		// devuelve el resultado obtenido en los ficheros
		
		double probabilidad = 0;
		File fichero = new File(nombreFichero);
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		probabilidad = Double.parseDouble(linea);
		br.close();
		return probabilidad;
	
	}
	
	public static double[] getBloqueAnalisis(String[] arrayNombres) throws IOException {
		
		// devolvemos una array con los resultados
		
		double[] arrayProbabilidades = new double[arrayNombres.length];
		for (int i = 0; i < arrayNombres.length; i++) {
			arrayProbabilidades[i] = getResultadoFichero(arrayNombres[i]);
		}
		return arrayProbabilidades;

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		long tiempoInicio = System.nanoTime(); // inicio del tiempo de ejecución
		
		int cores = Runtime.getRuntime().availableProcessors(); // total cores del sistema
		System.out.println("Total cores: " + cores);
		
		File fichero = new File("NEO.txt"); // leemos el fichero NEO
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		
		String[] arrayNombres = new String[cores]; // el num de items será igual al de cores
		double[] arrayPosiciones = new double[cores];
		double[] arrayVelocidades = new double[cores];
		double[] arrayProbabilidades = new double[cores];
		
		NEO neo;
		Thread hilo;
		
		for (int i = 0; i < cores; i++) {
			String[] arrayLinea = linea.split(",");
			arrayNombres[i] = arrayLinea[0]; // la primera columna serán los nombres de los NEOs
			arrayPosiciones[i] = Double.parseDouble(arrayLinea[1]);
			arrayVelocidades[i] = Double.parseDouble(arrayLinea[2]);
			
			File borrarFichero = new File(arrayNombres[i]); // eliminamos el fichero antes de crear uno nuevo
			borrarFichero.delete();
			
			neo = new NEO(arrayPosiciones[i], arrayVelocidades[i], arrayNombres[i]);
			hilo = new Thread(neo);
			hilo.start();
			
			System.out.println("Analisis " + (i + 1) + " lanzado... (NEO: " + arrayNombres[i] + ")");
			linea = br.readLine();
		}
		
		br.close();
		fr.close();
		
		// comprobamos si se han escrito todos los ficheros
		boolean comprobarFin = false;
		while (!comprobarFin) {
			try {
				
				arrayProbabilidades = getBloqueAnalisis(arrayNombres);
				comprobarFin = true;
				
			} catch (Exception e) {
				Thread.sleep(1000);
				System.out.println("Comprobando...");
			}
		}
		
		getProbabilidad(cores, arrayNombres, arrayProbabilidades);
		
		long tiempoFin = System.nanoTime();
		long duracion = (tiempoFin - tiempoInicio) / 1000000; // milisegundos
		Thread.sleep(100);
		System.out.println("Fin - Tiempo ejecución total: " + duracion + " ms");
		System.out.println("    - Tiempo medio de ejecución por NEO: " + duracion / cores + " ms");
		
		System.out.println("");
		System.out.println("ANALISIS FINALIZADO!");
	}

}
