/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class MonitorDeEstados extends EstadoGeneral implements Runnable{
    
   public MonitorDeEstados(MaquinaTamagochi tama){
       Thread hilo = new Thread(this);
       setTama(tama);
       hilo.start();
   }
   
   public void run(){
       
   }
    
}
