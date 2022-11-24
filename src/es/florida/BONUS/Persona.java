package es.florida.BONUS;

import java.util.ArrayList;

public class Persona implements Runnable {

	static ArrayList<String> coloresAnyadidos = new ArrayList<String>();
	String[] colores = { "azul", "amarillo", "rojo", "verde", "morado" };
	String color = "";

	Persona() {
	}

	synchronized public void añadirColor(int colorAleatorio, String nombrePersona) {
		color = colores[colorAleatorio];
		coloresAnyadidos.add(color);

		System.out.println(nombrePersona + " a anyadido su color favorito, que es " + color);

	}

	@Override
	public void run() {
		int numAleatorio = (int) (Math.random() * 4);
		String nombre = Thread.currentThread().getName();
		añadirColor(numAleatorio, nombre);
	}

}
