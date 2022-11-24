package es.florida.EJEMPLO_04;

public class Principal {

	public static void main(String[] args) {
		//	se lanzan tres procesos a la vez
		Thread t1 = new Thread(new Tarea("tarea1"));
		Thread t2 = new Thread(new Tarea("tarea2"));
		Thread t3 = new Thread(new Tarea("tarea3"));
		t1.start();
		t2.start();
		t3.start();
	}

}
