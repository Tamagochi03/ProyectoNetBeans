/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import java.awt.Label;
import javax.swing.JLabel;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class Comiendo extends EstadoGeneral implements Estado{
    public Comiendo(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("Tal vez después de comer me dé sueño");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("No me interrumpas cuando como!");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("Creo que no podría comer más!");
    }
    
    @Override
    public void runThread(){
        try{
            Thread.sleep(5000);
            getTama().getHiloEneregia().incremento(30);
            getTama().getHiloHambre().decremento(50);
            //TODO: Añadir aquí transformación sobre el modelo
            setEstado(getTama().getNormal());
        }catch (Exception e){
            System.out.println("Error al dormir el hilo"); //TODO: delete , este metodo es solo para debug del manejo de hilos
        }
    }
}
