package com.ric.sedie_vitale_netbeans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrvtl
 * @version 12/01/23
 */

public class Scrittore implements Runnable{

    String nomeFile = "Risultato.txt";
    String dati;
    
    public Scrittore(String nomeFile, String dati){
        this.nomeFile = nomeFile;
        this.dati = dati;
    }
    
    
    @Override
    public void run() {
        scrivi();
    }
    
    
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile, true));
            
            //2) scrivo nel buffer
            br.write(dati);
            br.write("\n\r");
            
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}