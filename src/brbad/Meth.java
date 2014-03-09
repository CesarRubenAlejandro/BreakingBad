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

public class Meth extends Base {

    public Meth(int posX, int posY) {
        super(posX, posY);

        URL bURL = this.getClass().getResource("ImagesMeth/meth_100.jpg");
        Image pic0 = Toolkit.getDefaultToolkit().getImage(bURL);

        URL b1URL = this.getClass().getResource("ImagesMeth/meth_101.jpg");
        Image pic1 = Toolkit.getDefaultToolkit().getImage(b1URL);

        URL b2URL = this.getClass().getResource("ImagesMeth/meth_102.jpg");
        Image pic2 = Toolkit.getDefaultToolkit().getImage(b2URL);

        URL b3URL = this.getClass().getResource("ImagesMeth/meth_103.jpg");
        Image pic3 = Toolkit.getDefaultToolkit().getImage(b3URL);
  
        URL b4URL = this.getClass().getResource("ImagesMeth/meth_104.jpg");
        Image pic4 = Toolkit.getDefaultToolkit().getImage(b4URL);
        
        URL b5URL = this.getClass().getResource("ImagesMeth/meth_105.jpg");
        Image pic5 = Toolkit.getDefaultToolkit().getImage(b5URL);
        
        URL b6URL = this.getClass().getResource("ImagesMeth/meth_106.jpg");
        Image pic6 = Toolkit.getDefaultToolkit().getImage(b6URL);
        
        URL b7URL = this.getClass().getResource("ImagesMeth/meth_107.jpg");
        Image pic7 = Toolkit.getDefaultToolkit().getImage(b7URL);
        
        URL b8URL = this.getClass().getResource("ImagesMeth/meth_108.jpg");
        Image pic8 = Toolkit.getDefaultToolkit().getImage(b8URL);
        
        URL b9URL = this.getClass().getResource("ImagesMeth/meth_109.jpg");
        Image pic9 = Toolkit.getDefaultToolkit().getImage(b9URL);
        
        URL b10URL = this.getClass().getResource("ImagesMeth/meth_110.jpg");
        Image pic10 = Toolkit.getDefaultToolkit().getImage(b10URL);
        
        anima = new Animacion();
        anima.sumaCuadro(pic0, 200);
        anima.sumaCuadro(pic1, 200);
        anima.sumaCuadro(pic2, 200);
        anima.sumaCuadro(pic3, 200);
        anima.sumaCuadro(pic4, 200);
        anima.sumaCuadro(pic5, 200);
        anima.sumaCuadro(pic6, 200);
        anima.sumaCuadro(pic7, 200);
        anima.sumaCuadro(pic8, 200);
        anima.sumaCuadro(pic9, 200);
        anima.sumaCuadro(pic10, 200);
        
    }
}

