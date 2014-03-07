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

public class Bar extends Base {
    
    private int direccion;

    public Bar(int posX, int posY) {
        super(posX, posY);

        URL bURL = this.getClass().getResource("ImagesBar/frame_000.gif");
        Image pic0 = Toolkit.getDefaultToolkit().getImage(bURL);

        URL b1URL = this.getClass().getResource("ImagesBar/frame_001.gif");
        Image pic1 = Toolkit.getDefaultToolkit().getImage(b1URL);

        URL b2URL = this.getClass().getResource("ImagesBar/frame_002.gif");
        Image pic2 = Toolkit.getDefaultToolkit().getImage(b2URL);

        anima = new Animacion();
        anima.sumaCuadro(pic0, 200);
        anima.sumaCuadro(pic1, 200);
        anima.sumaCuadro(pic2, 200);

        direccion = -1;
    }
    
    
    /**
     * Metodo de modificacion de la variable direccion del barco
     *
     * @param x es la nueva direccion a asignar
     */
    public void setDireccion(int x) {
        direccion = x;
    }

    /**
     *
     * @return la variable direccion del barco
     */
    public int getDireccion() {
        return direccion;
    }
    
}
