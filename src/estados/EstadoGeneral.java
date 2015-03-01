/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import javax.media.j3d.TransformGroup;
import javax.swing.JLabel;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */

//TODO: delete mensajePensamiento del constructor
public class EstadoGeneral {
    private TransformGroup tg;
    private MaquinaTamagochi tama;
    private int energia;
    private JLabel mensajePensamiento;

    public TransformGroup getTg() {
        return tg;
    }

    public void setTg(TransformGroup tg) {
        this.tg = tg;
    }

    public MaquinaTamagochi getTama() {
        return tama;
    }

    public void setTama(MaquinaTamagochi tama) {
        this.tama = tama;
    }
    
//TODO:delete if energia is never used
//    public int getEnrgia() {
//        return energia;
//    }
//
//    public void setEnrgia(int energia) {
//        this.energia = energia;
//    }

    public JLabel getMensajePensamiento() {
        return mensajePensamiento;
    }

    public void setMensajePensamiento(JLabel mensajePensamiento) {
        this.mensajePensamiento = mensajePensamiento;
    }
    
    public void setEstado(Estado estado){
        if (estado instanceof Normal || estado instanceof Cansado || estado instanceof Hambriento) {
            if (tama.getEnergia() <= 0) {
                estado = tama.getMuerto();
            } else if (tama.getHambre() > 50) {
                estado = tama.getHambriento();
                tama.getHiloEneregia().setVelocidad(tama.getHiloEneregia().getVelocidad() / 3);
            } else if (tama.getSueno() > 80) {
                estado = tama.getCansado();
                tama.getHiloEneregia().setVelocidad(tama.getHiloEneregia().getVelocidad() / 2);
            }
        }
            tama.setEstado(estado);
    }
    
    
}
