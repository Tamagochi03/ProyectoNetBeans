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
public class Muerto extends EstadoGeneral implements Estado {

    public Muerto(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("...");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("...");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("...");
    }
    
    @Override
    public void runThread(){
    }
}
