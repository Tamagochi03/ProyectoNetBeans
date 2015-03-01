/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entorno;

import javax.swing.JProgressBar;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class BarraAburrimiento extends JProgressBar implements Runnable{
    MaquinaTamagochi tama;
    Thread hilo;
    
    public BarraAburrimiento(MaquinaTamagochi tama){
        super();
        this.tama = tama;
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void run(){
        while(true){
            setValue(tama.getAburrimiento());
        }
    }
}
