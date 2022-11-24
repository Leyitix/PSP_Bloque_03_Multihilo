package es.florida.BONUS;

public class Subproceso {

	public static void main(String[] args) {
		int personas = 0;
		Persona persona = null;
		Thread hilo;
		
		if (args.length == 0) {
			personas = 10;
		} else {
			personas = Integer.parseInt(args[0]);
		}
		
		for (int i = 0; i < personas; i++) {
			persona = new Persona();
			hilo = new Thread(persona);
			hilo.setName("Persona " + i);
			hilo.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(personas + " personas añadieron un color a la lista");
		System.out.println("A la lista se han añadido " + Persona.coloresAnyadidos.size() + " colores");
	}

}
