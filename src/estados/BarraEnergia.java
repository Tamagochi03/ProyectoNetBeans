/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class BarraEnergia extends BarraEstado implements Runnable {
    MaquinaTamagochi tama;
    public BarraEnergia(int contador, MaquinaTamagochi tama){
        super(contador);
        hilo = new Thread(this);
        this.tama = tama;
        hilo.start();
    }
    
    public void run(){
        while(true){
            contador --;
            tama.setEnergia(contador);
            System.out.println("Energia: " + contador);//TODO:delete
            try{
                Thread.sleep(velocidad);
            }catch(Exception e){
                System.out.println("Error al dormir barra de energía");
            }
        }
    }  
}
