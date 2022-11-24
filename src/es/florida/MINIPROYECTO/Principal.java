package es.florida.MINIPROYECTO;

public class Principal {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int stockMina = 100;
		Mina mina = new Mina(stockMina);	//	asignamos un determinado stock a la mina
		Ventilador ventilador = new Ventilador();
		
		Thread hilo;
		Minero minero;
		
		Thread encendido = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ventilador.encenderVentilador();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread apagado = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ventilador.apagarVentilador();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Esta mina contiene " + mina.stock + " unidades de oro");
		
		encendido.start();
		apagado.start();
		
		while (mina.stock != 0) {
			for (int i = 1; i <= 10; i++) {
				minero = new Minero(mina);
				hilo = new Thread(minero);
				hilo.setName("Minero " + i);
				hilo.start();
			}
		}
		
		System.out.println("!!!La mina se ha agotado, los mineros han recolectado " + Minero.bolsa + " unidades de oro");
	}

}
