package Controller;

import java.util.concurrent.Semaphore;

public class idPista extends Thread{
	      private int idManobra;
	      private int idTaxiar;
	      private int idDecolagem;
	      private int idAfastamentoarea;
	      public static int posSaida;
	      private Semaphore semaforo;
	      
	      public void Thread(idManobra,idTaxiar,idDecolagem,idAfastamentoarea,semaforo) {
	    	  this.idManobra = idmanobra;
	    	  this.idTaxiar = idtaxiar;
	    	  this.idDecolagem = iddecolagem;
	    	  this.idAfastamentoarea = idafastamentoarea;
	    	  this.semaforo = semaforo;
	      }
	      @Override
	  	public void run() {
	  		idManobra();
	  		try {
	  			semaforo.acquire();
	  			idTaxiar();
	  		} catch (InterruptedException e) {
	  			e.printStackTrace();
	  			idDecolagem();
	  		} finally {
	  			semaforo.release();
	  		}
	  		idAfastamentoarea();
	  	}
	      
	      private void idTaxiar() {
	  		int tempo = 1000;
	  		int distanciaPercorrida = 0;

	  		while (distanciaPercorrida < 200) {
	  			distanciaPercorrida += (int) ((Math.random() * 3) + 4);
	  			try {
	  				Thread.sleep(tempo);
	  			} catch (InterruptedException e) {
	  				e.printStackTrace();
	  			}
	  			System.out.println("O avião " + idPessoa + " já taxiou " + distanciaPercorrida + " da pista");
	  		}
	  	}

	  	private void idDecolagem() {
	  		System.out.println("O avião " + idPista + " já decolou");
	  		double tempoInicial = System.nanoTime();
	  		int tempoParado = (r.nextInt(3 - 1) + 1) * 1000;
	  		try {
	  			Thread.sleep(tempoParado);
	  		} catch (InterruptedException e) {
	  			e.printStackTrace();
	  		}
	  		double tempoFinal = System.nanoTime();
	  		double tempototal = tempoFinal - tempoInicial;
	  		tempototal = tempototal / Math.pow(10, 9);
	  		System.out.println("O avião" + idPista + " Tempo parado: " + tempototal);
	  	}

	  	private void PessoaCruzando() {
	  		posSaida++;
	  		System.out.println("O avião " + idPista + " foi o " + posSaida + "ª. a se afastar da área");
	  	}
	  }

