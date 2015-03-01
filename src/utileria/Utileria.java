/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utileria;

/**
 *
 * @author Shinsnake
 */
public class Utileria {
    public static void TiempoEspera(int tiempoEspera){
        try {
            Thread.sleep (tiempoEspera);
        } catch (Exception e) {
            System.out.println("No se pudo realizar el tiempo de espera");
        }
    }
}
