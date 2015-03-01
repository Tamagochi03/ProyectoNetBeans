/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import javax.media.j3d.Transform3D;

/**
 *
 * @author Shinsnake
 */
public interface Estado {
    public abstract void jugar();
    public abstract void comer();
    public abstract void dormir();
    public abstract void runThread();
}
