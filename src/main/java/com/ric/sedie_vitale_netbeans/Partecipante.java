/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ric.sedie_vitale_netbeans;

/**
 *
 * @author andrvtl
 */
class Partecipante extends Thread

{
	Posto sedie[];

	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}

	public void run() {

		try {
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
					System.out.println("Sono il Thread " + this.getName()
							+ ". Sono riuscito a sedermi sul posto " + i);
                                        
                                        Scrittore scrittore = new Scrittore("Risultato.txt", "Posto: " + i + ", Thread seduto: " + getName() + " ID: " + getId());
                                        scrittore.scrivi();
                                        
					return;
				}
			}
			System.out.println("Sono il Thread " + this.getName()
					+ ". Ho perso :((((");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}