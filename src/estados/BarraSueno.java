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
public class BarraSueno extends BarraEstado implements Runnable{
    MaquinaTamagochi tamagochi;
    public BarraSueno(int contador, MaquinaTamagochi tamagochi){
        super(contador);
        this.tamagochi = tamagochi;
        velocidad = 2000;
        hilo = new Thread(this);
        hilo.start();
    }
    public void run(){
        while(true){
            contador ++;
            try{
                Thread.sleep(velocidad);
                tamagochi.setSueno(contador);
                System.out.println(contador);//TODO:delete
            }catch(Exception e){
                System.out.println("Error al dormir barra de estado");
            }
        }
    }
}
