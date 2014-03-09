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

public class Ball extends Base {
    
    private boolean movArriba;
    private boolean movDerecha;
      
    public Ball(int posX, int posY) {
        super(posX, posY);
        
        movArriba = true;
        movDerecha = false;

        URL bURL = this.getClass().getResource("ImagesBall/frame_000.gif");
        Image pic0 = Toolkit.getDefaultToolkit().getImage(bURL);

        URL b1URL = this.getClass().getResource("ImagesBall/frame_001.gif");
        Image pic1 = Toolkit.getDefaultToolkit().getImage(b1URL);

        URL b2URL = this.getClass().getResource("ImagesBall/frame_002.gif");
        Image pic2 = Toolkit.getDefaultToolkit().getImage(b2URL);

        URL b3URL = this.getClass().getResource("ImagesBall/frame_003.gif");
        Image pic3 = Toolkit.getDefaultToolkit().getImage(b3URL);
  
        URL b4URL = this.getClass().getResource("ImagesBall/frame_004.gif");
        Image pic4 = Toolkit.getDefaultToolkit().getImage(b4URL);
        
        URL b5URL = this.getClass().getResource("ImagesBall/frame_005.gif");
        Image pic5 = Toolkit.getDefaultToolkit().getImage(b5URL);
        
        URL b6URL = this.getClass().getResource("ImagesBall/frame_006.gif");
        Image pic6 = Toolkit.getDefaultToolkit().getImage(b6URL);
        
        URL b7URL = this.getClass().getResource("ImagesBall/frame_007.gif");
        Image pic7 = Toolkit.getDefaultToolkit().getImage(b7URL);
        
        URL b8URL = this.getClass().getResource("ImagesBall/frame_008.gif");
        Image pic8 = Toolkit.getDefaultToolkit().getImage(b8URL);
        
        URL b9URL = this.getClass().getResource("ImagesBall/frame_009.gif");
        Image pic9 = Toolkit.getDefaultToolkit().getImage(b9URL);
        
        URL b10URL = this.getClass().getResource("ImagesBall/frame_010.gif");
        Image pic10 = Toolkit.getDefaultToolkit().getImage(b10URL);
        
        URL b11URL = this.getClass().getResource("ImagesBall/frame_011.gif");
        Image pic11 = Toolkit.getDefaultToolkit().getImage(b11URL);
        
        URL b12URL = this.getClass().getResource("ImagesBall/frame_012.gif");
        Image pic12 = Toolkit.getDefaultToolkit().getImage(b12URL);
        
        
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
        anima.sumaCuadro(pic11, 200);
        anima.sumaCuadro(pic12, 200);
    }
    
    public void setMovArriba (){
        movArriba = !movArriba;
    }
    
    public void setMovDerecha() {
        movDerecha = !movDerecha;
    }
    
    public boolean getMovArriba() {
        return movArriba;
    }
    
    public boolean getMovDerecha() {
        return movDerecha;
    }
    
    public void move (){
        if (movArriba && movDerecha){
            this.setPosX(this.getPosX()+15);
            this.setPosY(this.getPosY()-15);
        }
        
        if (movArriba && !movDerecha){
            this.setPosX(this.getPosX()-15);
            this.setPosY(this.getPosY()-15);
        }
        
        if (!movArriba && movDerecha){
            this.setPosX(this.getPosX()+15);
            this.setPosY(this.getPosY()+15);
        }
        
        if (!movArriba && !movDerecha){
            this.setPosX(this.getPosX()-15);
            this.setPosY(this.getPosY()+15);
        }
    }
    
    
}
