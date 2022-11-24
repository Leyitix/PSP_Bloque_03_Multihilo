package es.florida.MINIPROYECTO;

public class Ventilador {
	boolean funcionando = true;
	int tiempo = 5000;
	
	public void encenderVentilador() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (!funcionando) wait();
				System.err.println("Ventilacion encendida durante " + tiempo / 1000 + " segundos");
				Thread.sleep(tiempo);
				funcionando = false;
				notify();
			}
		}
	}
	
	public void apagarVentilador() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (funcionando) wait();
				System.err.println("Ventilacion apagada durante " + tiempo / 1000 + " segundos");
				Thread.sleep(tiempo);
				funcionando = true;
				notify();
			}
		}
	}
}
