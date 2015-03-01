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
public class Jugando extends EstadoGeneral implements Estado, Runnable{
    public Jugando(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("Aún quiero jugar!");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("Qué divertido!");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("No gracias, me podría doler la barriga");
    }
    
    @Override
    public void runThread(){
        Thread hilo = new Thread(this);
        hilo.start();
        }
    
    @Override  
    public void run(){
        try{
            Thread.sleep(5000);
            getTama().getHiloEneregia().decremento(10);
            getTama().getHiloHambre().incremento(20);
            getTama().getHiloHambre().decremento(40);
            //TODO: Añadir aquí transformación sobre el modelo
            setEstado(getTama().getNormal());
        }catch (Exception e){
            System.out.println("Error al dormir el hilo"); //TODO: delete , este metodo es solo para debug del manejo de hilos
        }
    }
}
