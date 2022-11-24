package es.florida.EJERCICIO_01;

public class MostrarASCII implements Runnable{
	private String tipo;
	
	public MostrarASCII(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void run() {
		if (tipo.equals("1")) {
			for (int i = 0; i < 128; i++) {
				if (i % 2 == 0) {
					System.out.println((i + 1) + " - " + (char)i );
				}
			}
		}

		if (tipo.equals("2")) {
			for (int i = 0; i < 128; i++) {
				if (i % 2 == 0) {
					System.out.println((i + 1) + " - " + (char)i );
				}
			}
		}
	}
}
