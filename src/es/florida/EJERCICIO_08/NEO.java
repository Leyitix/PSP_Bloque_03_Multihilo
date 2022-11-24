package es.florida.EJERCICIO_08;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class NEO implements Runnable{
	
	private double posicionNEO, velocidadNEO;
	private String nombreNEO;
	
	public NEO(double posicionNEO, double velocidadNEO, String nombreNEO) {
		this.posicionNEO = posicionNEO;
		this.velocidadNEO = velocidadNEO;
		this.nombreNEO = nombreNEO;
	}

	@Override
	public void run() {
		double resultado = 0;
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		resultado = 100 * Math.random()
				* Math.pow(((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra)), 2);
		
		File fichero = new File(nombreNEO);
		FileWriter fw;
		
		try {
			
			fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(String.valueOf(resultado));
			bw.close();
			fw.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
