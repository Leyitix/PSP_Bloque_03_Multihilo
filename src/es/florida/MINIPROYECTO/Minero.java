package es.florida.MINIPROYECTO;

public class Minero implements Runnable {

	static int bolsa;
	int tiempoExtraccion = 1000;
	Mina mina;
	
	Minero(Mina mina) {
		this.mina = mina;
	}
	
	public void extraerRecurso(String nombre, int unidadesExtraidas) {
		synchronized (mina) {	//	sincronizamos el stock que se va a consumir
			int cambioTurno = 1;
			while (mina.stock != 0 && cambioTurno == 1) {	//	mientras el stock sea distinto de 0 y el turno 1
				if (unidadesExtraidas <= mina.stock) {	//	si las unidades extraidas  son inferiores al stock de la mina
				mina.stock -= unidadesExtraidas;	//	extraemos unidades
					bolsa += unidadesExtraidas;	//	añadimos unidades a la bolsa
					System.out.println("El " + nombre + " ha obtenido " + unidadesExtraidas + " unidades de oro");
				} else {
					System.err.println("El " + nombre + " ha encontrado mas oro del que puede llevar");	//	no se pueden extraer mas unidades
				}
				cambioTurno = 2;
				try {
					Thread.sleep(tiempoExtraccion);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		int unidadesExtraidas = (int) (Math.random() * 10 + 1);
		String nombre = Thread.currentThread().getName();
		extraerRecurso(nombre, unidadesExtraidas);
		
	}
}
