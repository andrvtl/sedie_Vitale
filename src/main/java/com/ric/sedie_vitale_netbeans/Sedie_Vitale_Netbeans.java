/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ric.sedie_vitale_netbeans;

// Importa classe Scanner per permettere di scegliere il n partecipanti
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author andrvtl
 */
public class Sedie_Vitale_Netbeans {

 /* Non serve più dichiarare NUMSEDIE
 private final static int NUMSEDIE = 15;
 */ 
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args metodo main
     */
    public static void main(String[] args) {

        // Nuova sezione di codice per richiedere il n partecipanti in input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di partecipanti: ");
        int numPartecipanti = scanner.nextInt();

        // Verifica che il numero di partecipanti sia accettabile
        if (numPartecipanti <= 1) {
            System.out.println("Inserisci un numero di partecipanti maggiore di 1.");
            return;
        }

        // Calcola il numero delle sedie (una in meno rispetto ai partecipanti)
        int NUMSEDIE = numPartecipanti - 1;


        // Dichiara un array prendendo il tipo dalla classe Posto
        Posto sedie[] = new Posto[NUMSEDIE];

        
	for (int k = 0; k < sedie.length; k++)
                // Crea un oggetto di tipo posto per ogni indice dell'array (ogni sedia)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();

	Partecipante array[] = new Partecipante[NUMSEDIE+1];
	for (int i = 0; i < NUMSEDIE + 1; i++) {
		array[i] = new Partecipante(sedie);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
                }

        // Chiudi scanner
        scanner.close();
	}
}
