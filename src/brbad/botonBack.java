/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brbad;

/**
 *
 * @author Angela Romo, Cesar Rdz
 */

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class botonBack extends Base{
    
     public botonBack(int posX, int posY) {
        super(posX, posY);

        URL bURL = this.getClass().getResource("Botones/Back.gif");
        Image pic0 = Toolkit.getDefaultToolkit().getImage(bURL);
        anima = new Animacion();
        anima.sumaCuadro(pic0, 200);
     }
    
}
