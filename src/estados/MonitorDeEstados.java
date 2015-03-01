/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class MonitorDeEstados extends EstadoGeneral implements Runnable{
   MaquinaTamagochi tama; 
   JLabel mensajeEstado;
   public MonitorDeEstados(MaquinaTamagochi tama, JLabel estado){
       this.tama = tama;
       this.mensajeEstado = estado;
       Thread hilo = new Thread(this);
       setTama(tama);
       hilo.start();
   }
   
   public void run(){
       while(true){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(MonitorDeEstados.class.getName()).log(Level.SEVERE, null, ex);
           }
           setEstado(getTama().getEstadoActual());
           mensajeEstado.setText(tama.getNombreEstado());
           if(!(getTama().getEstadoActual() instanceof Hambriento) || !(getTama().getEstadoActual() instanceof Cansado)){
               getTama().getHiloEneregia().setVelocidad(1000);
           }
       }
   }
    
}
