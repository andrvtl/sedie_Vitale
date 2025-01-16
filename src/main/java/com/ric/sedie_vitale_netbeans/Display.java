/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ric.sedie_vitale_netbeans;

/**
 *
 * @author Studente
 */

/**
 * Classe che rappresenta graficamente attraverso una stringa di testo i posti occupati
 * All'asterisco corrisponde un posto occupato, allo zero uno libero
 * Scorrendo l'array è controllando il valore booleano "libero" viene determinato se il posto è libero o meno
 * 
 */
class Display extends Thread

{
	private Posto sedie[];
	private boolean endgame;

	public Display(Posto sedie[]) {


		this.sedie = new Posto[sedie.length];

		for (int s = 0; s < sedie.length; s++)
			this.sedie[s] = sedie[s];
	}

	public void run() {

		try {
			while (!endgame) {
				int count = 0;

				sleep((int) (Math.random() * 250));

				for (int i = 0; i < sedie.length; i++) {
				
                                        // controlla "libero" all'indice "i"
					if (sedie[i].libero())
                                                // se è libero stampa "0"
						System.out.print("0");
					else {
                                                /* altrimenti stampa un'asterisco e 
                                                aumenta il count delle sedie occupate*/
                                                count++;
						System.out.print("*");
					}
				}
				System.out.println();
                                // quando il count delle sedie occupate arriva a 15 il gioco finisce
				endgame = (count == sedie.length);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
