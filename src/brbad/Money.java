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

public class Money extends Base {
    
     public Money(int posX, int posY) {
        super(posX, posY);

        URL bURL = this.getClass().getResource("ImagesMoney/frame_000.gif");
        Image pic0 = Toolkit.getDefaultToolkit().getImage(bURL);
        URL b1URL = this.getClass().getResource("ImagesMoney/frame_001.gif");
        Image pic1 = Toolkit.getDefaultToolkit().getImage(b1URL);
        anima = new Animacion();
        anima.sumaCuadro(pic0, 200);
        anima.sumaCuadro(pic1, 200);
     }
    
}
