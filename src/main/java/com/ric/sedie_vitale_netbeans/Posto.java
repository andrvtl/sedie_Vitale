/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ric.sedie_vitale_netbeans;

/**
 *
 * @author andrvtl
 */

/**
 * Classe che definisce il comportamento delle sedie rispetto ai giocatori
 * Il posto può essere occupato o non occupato (!occupato)
 * Nei due metodi libero() e occupa() viene definito lo stato della variabile occupato
 * Se il posto è già occupato occupa() restituisce false, altrimenti imposta occupato su true
 * 
 */
class Posto

{
	private boolean occupato;

	public Posto()

	{
		occupato = false;
	}

	
	/** 
	 * @return boolean
	 */
	public synchronized boolean libero() {
		return (!occupato);
	}

	
	/** 
	 * @return boolean
	 */
	public synchronized boolean occupa() {
		if (occupato)
			return false;
		else
			return occupato = true;
	}
}