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
public class Normal extends EstadoGeneral implements Estado {
    public Normal(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("No tengo mucho sueño");
    }

    @Override
    public void jugar() {
        if(getTama().getAburrimiento() > 10){
        setEstado(getTama().getJugando());
        getTama().getEstadoActual().runThread();
        }
        else{
            System.out.println("No estoy aburrido");//TODO: delete
            getMensajePensamiento().setText("No estoy aburrido");
        }
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("No tengo mucha hambre");
    }
    
    @Override
    public void runThread(){
    }
}
