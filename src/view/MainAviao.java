package view;

import java.util.concurrent.Semaphore;
import Controller.idPista;

public class MainAviao {

	public static void main(String[] args) {
		int permissoes = 4;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idPista = 1; idPista < 12; idPista++) {
			Thread pista = new Pista(idPista, semaforo);
			pista.start();
		}
	}
	
}

	
