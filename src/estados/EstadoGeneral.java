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
            } else if (tama.getHambre() > 40) {
                estado = tama.getHambriento();
                tama.getHiloEneregia().decremento(3);
                //TODO: delete si no es efectivo tama.getHiloEneregia().setVelocidad(10);
            } else if (tama.getSueno() > 70) {
                estado = tama.getCansado();
                tama.getHiloEneregia().decremento(2);
                //TODO: delete si no es efectivo tama.getHiloEneregia().setVelocidad(1);
            }
        }
        else if(estado instanceof Hambriento || estado instanceof Cansado){
            if (tama.getEnergia() > 0 || tama.getHambre() < 40 || tama.getSueno() < 70) {
                estado = tama.getNormal();
            }
        }
        else if(tama.getEstadoActual() instanceof Muerto){
            
        }
        tama.setEstado(estado);
    }
    
    
}
