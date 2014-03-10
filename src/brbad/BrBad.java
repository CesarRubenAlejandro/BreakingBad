/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brbad;

//Importar todas las librerias a utilizar
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author Cesar , Angela A01036009, A01139764
 */
public class BrBad extends JFrame implements Runnable, KeyListener, MouseListener {

    // Declarar todas las variables
    private Color c;
    private long tiempoActual; //Variables de control de tiempo de la animacion
    private long tiempoInicial; //Variables de control de tiempo de la animacion
    private boolean pausa; // bandera para manejar la pausa
    //banderas para activar o no sonido y musica
    private boolean sonido;
    private boolean musica;
    private Image dbImage;// Imagen a proyectar	
    private Graphics dbg; // Objeto grafico
    private Meth block; //bloque de metanfetamina
    private Ball bola; //pelotita para destruir
    private Bar barra; //fila de carros como barra
    private int numBloques; //numero de bloques de meth
    private Image fondo; //fondo del juego
    private int score; //puntaje
    private int vidas; //vidas del juego
    //imagenes pantallas
    private Image pantallaInstrucciones;
    private Image pantallaAjustes;
    private Image pantallaGameOver;
    private Image pantallaGoodJob;
    private Image pantallaCreditos;
    private Image pantallaPausa;
    private Image pantallaInicio;
    //sonidos
    private SoundClip rebota;
    private SoundClip destruye;
    private SoundClip pierde;
    private SoundClip musicaFondo;
    //booleanos para control de pantallas
    private boolean gano;
    private boolean Menu;
    private boolean Ajustes;
    private boolean Creditos;
    private boolean Instrucciones;
    private boolean juegoInicia;
    //botones
    private botonAjustes botonAj;
    private botonCreditos botonCre;
    private botonIniciar botonIni;
    private botonInstrucciones botonInst;
    private botonBack botonBack;
    //click
    private int clickX;
    private int clickY;
    private boolean click;
    //movimiento barra
    private boolean limiteBarraDerecha;
    private boolean limiteBarraIzquierda;
    private int bloqX;
    private int bloqY;
    
    private int auxVelocidad;
    

    private LinkedList list; //lista para bricks

    //Constructor
    public BrBad() {
        setTitle("JFrame Breaking Blocks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        this.setSize(800, 600); //tamaño del jframe
        numBloques = 30; //crear bloques de metanfetaminas
        bloqX = 70;
        bloqY = 110;
        list = new LinkedList();
        auxVelocidad = 0;
        //int contador = 0;

        for (int i = 0; i < 10; i++) {
            block = new Meth(bloqX, bloqY);
            bloqX += 65;
            list.add(block);
        }
        bloqX = 70;
        bloqY += 70;
        for (int i = 0; i < 10; i++) {
            block = new Meth(bloqX, bloqY);
            bloqX += 65;
            list.add(block);
        }
        bloqX = 70;
        bloqY += 70;
        for (int i = 0; i < 10; i++) {
            block = new Meth(bloqX, bloqY);
            bloqX += 65;
            list.add(block);
            
        }

        score = 0; //el score inicia en 0
        vidas = 1; //solo hay 1 vida en el juego
        //booleanos de audio
        sonido = true;
        musica = true;
        addMouseListener(this);
        addKeyListener(this);
        c = new Color(255, 255, 255); //para el string de vidas 
        //Imagenes
        fondo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("fondo/fondo2soft.jpg"));
        pantallaInstrucciones = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaInstrucciones.jpg"));
        pantallaPausa = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaPausa.jpg"));
        pantallaCreditos = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaCreditos.jpg"));
        pantallaAjustes = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaAjustes.jpg"));
        pantallaGameOver = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaGameOver.jpg"));
        pantallaGoodJob = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaGoodJob.jpg"));
        pantallaInicio = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Pantallas/pantallaInicio.jpg"));

        //botones
        botonIni = new botonIniciar(getWidth() / 2 - 150, 300);
        botonInst = new botonInstrucciones(getWidth() / 2 - 150, 350);
        botonAj = new botonAjustes(getWidth() / 2 - 150, 400);
        botonCre = new botonCreditos(getWidth() / 2 - 150, 450);
        botonBack = new botonBack(getWidth() - 150, 40);

        //sonidos
        rebota = new SoundClip("Sounds/vida.wav");
        destruye = new SoundClip("Sounds/desk_bell.wav");
        pierde = new SoundClip("Sounds/dead.wav");
        musicaFondo = new SoundClip("Sounds/shorter-swbl.wav");

        //musica
        //Activa la repetición del clip
        musicaFondo.setLooping(true);
        //Reproduce el clip
        musicaFondo.play();
        //inicializar variables booleanas 
        gano = false;
        Menu = true;
        Ajustes = false;
        Creditos = false;
        Instrucciones = false;
        limiteBarraDerecha = false;
        limiteBarraIzquierda = false;
        //crear bloques
        //posicionar bloques
        //crear barra
        barra = new Bar(0, 0);
        //reposicionar barra al centro abajo del JFrame
        barra.setPosX((getWidth() / 2) - (barra.getAncho() / 2));
        barra.setPosY(getHeight() - barra.getAlto());
        //crear bola
        bola = new Ball(0, 0);
        //reposicionarla sobre la barra
        bola.setPosX(getWidth() / 2);
        bola.setPosY(barra.getPosY() - bola.getAlto());

        juegoInicia = false;
        
        //HILO
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }
    
    /**
     * Reset - limpia y prepara todo para el inicio del nuevo juego. 
     */
    public void reset() {
        numBloques = 30; //crear bloques de metanfetaminas
        bloqX = 70;
        bloqY = 110;
        
        for (int i = 0; i < 10; i++) {
            ((Meth) list.get(i)).setPosX((bloqX));
            ((Meth) list.get(i)).setPosY((bloqY));
            bloqX += 65;
        }
        bloqX = 70;
        bloqY += 70;
        for (int i = 10; i < 20; i++) {
            ((Meth) list.get(i)).setPosX((bloqX));
            ((Meth) list.get(i)).setPosY((bloqY));
             bloqX += 65;
        }
        bloqX = 70;
        bloqY += 70;
        for (int i = 20; i < 30; i++) {
            ((Meth) list.get(i)).setPosX((bloqX));
            ((Meth) list.get(i)).setPosY((bloqY));
            bloqX += 65;
        }

        score = 0; //el score inicia en 0
        vidas = 1; //solo hay 1 vida en el juego
        
         //inicializar variables booleanas
        limiteBarraDerecha = false;
        limiteBarraIzquierda = false;
        
        //reposicionar barra al centro abajo del JFrame
        barra.setPosX((getWidth() / 2) - (barra.getAncho() / 2));
        barra.setPosY(getHeight() - barra.getAlto());
        
        //reposicionarla sobre la barra
        bola.setPosX(getWidth() / 2);
        bola.setPosY(barra.getPosY() - bola.getAlto());

        juegoInicia = false;
        //HILO
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
         
    }
    
    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>JFrame</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {

        //Guarda el tiempo actual del sistema
        tiempoActual = System.currentTimeMillis();

        //Ciclo principal del JFrame. Actualiza y despliega en pantalla hasta que se acaben las vidas
        while (vidas > 0) {

            //si esta pausado no actualizas ni checas colision 
            if (!pausa) {
                actualiza();
                checaColision();
            }
            repaint(); // Se actualiza el <code>JFrame</code> repintando el contenido.
            try {
                // El thread se duerme.
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }

        }
    }

    /**
     * Metodo <I>actualiza</I>
     * Es usado para actualizar la posicion de los personajes y los valores de
     * las variables.
     */
    public void actualiza() {
        //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecuciÃ³n
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;

        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;
        barra.actualiza(tiempoActual);
        bola.actualiza(tiempoActual);
        for (int i = 0; i < numBloques; i++) {
            ((Meth) list.get(i)).actualiza(tiempoActual);
        }

        if (juegoInicia) {
            bola.move();
        }

        //actualizar posición dela barra
        switch (barra.getDireccion()) {
            case 1: // se mueve a la izquierda
                if (!limiteBarraIzquierda) {
                    barra.setPosX(barra.getPosX() - 35);
                }

                break;
            case 2: // se mueve a la derecha
                if (!limiteBarraDerecha) {
                    barra.setPosX(barra.getPosX() + 35);
                }
                break;
        }

        //apago los valores booleanos despues de haberlos usado para evitar ciclos
        barra.setDireccion(-1); // detiene al barquito
        limiteBarraIzquierda = false; // reiniciamos para que se pueda mover hacia el lado contrario
        limiteBarraDerecha = false; // reiniciamos para que se pueda mover al lado contrario

        if (score == numBloques) {
            gano = true;
            juegoInicia = false;
        }
    }

    /**
     * Metodo <I>checaColision</I>
     * Metodo usado para checar las colisiones de los objetos barquito y rayito
     * entre sí y con las orillas del <code>JFrame</code>.
     */
    public void checaColision() {
        //revisa si la barra intenta salir del JFrame  
        if (barra.getPosX() < 0) {
            limiteBarraIzquierda = true;
        }
        if (barra.getPosX() + barra.getAncho() > getWidth()) {
            limiteBarraDerecha = true;
        }

        //Colisiones de la bola
        //colision con la pared derecha
        if (bola.getPosX() + bola.getAncho() >= getWidth()) {
            bola.setMovDerecha();
            if (sonido) {
                rebota.play();
            }
        }
        // colision con la pared izquierda
        if (bola.getPosX() <= 0) {
            bola.setMovDerecha();
            if (sonido) {
                rebota.play();
            }
        }
        // colision arriba
        if (bola.getPosY() < 10) {
            bola.setMovArriba();
            if (sonido) {
                rebota.play();
            }
        }
        //colision abajo
        if (bola.getPosY() + bola.getAlto() > getHeight()) {
            vidas--;
            if (sonido) {
                pierde.play();
            }
        }
        //colision con la barra
        if (bola.intersecta(barra)) {
            if (bola.getPosY() < barra.getPosY()) {
                bola.setMovArriba();
                
                int puntoMedio = barra.getPosX() + barra.getAncho() / 2;
                int puntoFinal = barra.getPosX() + barra.getAncho();
                int puntoInicio = barra.getPosX();

                if (bola.getPosX() <= puntoMedio) {
                    if (bola.getMovDerecha()) {
                        bola.setMovDerecha();
                    }       
                    
                }

                if (bola.getPosX() > puntoMedio) {
                    if (!bola.getMovDerecha()) {
                        bola.setMovDerecha();
                    }
                }

                if (sonido) {
                    rebota.play();
                }
            }
        }

        //Colision con bloques
        for (int i = 0; i < numBloques; i++) {
            if (bola.intersecta((Meth) list.get(i))) {
                if (sonido) {
                    destruye.play();
                }
                score++;

                if (bola.getPosY() > ((Meth) list.get(i)).getPosY()) {
                    bola.setMovArriba();
                }

                if (bola.getPosY() <= ((Meth) list.get(i)).getPosY()) {
                    bola.setMovArriba();
                }
                
                int puntoMedio =  ((Meth) list.get(i)).getPosX() + ((Meth) list.get(i)).getAncho()/2;
                
                 if (bola.getPosX() <= puntoMedio) {
                    if (bola.getMovDerecha()) {
                        bola.setMovDerecha();
                    }
                }

                if (bola.getPosX() > puntoMedio) {
                    if (!bola.getMovDerecha()) {
                        bola.setMovDerecha();
                    }
                }

                //Destruir
                ((Meth) list.get(i)).setPosX((-1000));
                ((Meth) list.get(i)).setPosY((-1000));
             //   Meth block = (Meth) list.get(i);
             //   list.remove(block);
            }
        }
    }

    /**
     * Metodo <I>paint</I>
     * En este metodo lo que hace es actualizar el contenedor (Update)
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);

    }

    /**
     * Metodo <I>paint1</I>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia. (Paint)
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {
        g.setColor(c);
        //Revisa si aun hay vidas o se ha acabado el juego
        if (vidas <= 0) {
            //Despliega GameOver al perder
            g.drawImage(pantallaGameOver, 0, 0, getSize().width, getSize().height, this);
            g.drawImage(botonBack.getImagenI(), botonBack.getPosX(), botonBack.getPosY(), this);

        } else if (gano) {
            //Despliega GoodJob al ganar
            g.drawImage(pantallaGoodJob, 0, 0, getSize().width, getSize().height, this);
            g.drawImage(botonBack.getImagenI(), botonBack.getPosX(), botonBack.getPosY(), this);
        } else if (Menu) {
            //Despliega pantalla de inicio
            g.drawImage(pantallaInicio, 0, 0, getSize().width, getSize().height, this);
            g.drawImage(botonInst.getImagenI(), botonInst.getPosX(), botonInst.getPosY(), this);
            g.drawImage(botonIni.getImagenI(), botonIni.getPosX(), botonIni.getPosY(), this);
            g.drawImage(botonAj.getImagenI(), botonAj.getPosX(), botonAj.getPosY(), this);
            g.drawImage(botonCre.getImagenI(), botonCre.getPosX(), botonCre.getPosY(), this);
        } else if (Ajustes) {
            //Despliega ajustes si son pedidos
            g.drawImage(pantallaAjustes, 0, 0, getSize().width, getSize().height, this);
            g.drawImage(botonBack.getImagenI(), botonBack.getPosX(), botonBack.getPosY(), this);
            if (sonido) {
                g.drawString("ON", 100, 310);
            } else {
                g.drawString("OFF", 100, 310);
            }
            if (musica) {
                g.drawString("ON", 100, 460);
            } else {
                g.drawString("OFF", 100, 460);
            }
        } else if (Creditos) {
            //Despliega creditos si son pedidos
            g.drawImage(pantallaCreditos, 0, 0, getSize().width, getSize().height, this);
            g.drawImage(botonBack.getImagenI(), botonBack.getPosX(), botonBack.getPosY(), this);
        } else if (Instrucciones) {
            //Despliega instrucciones si son pedidas
            g.drawImage(pantallaInstrucciones, 0, 0, getSize().width, getSize().height, this);
            g.drawImage(botonBack.getImagenI(), botonBack.getPosX(), botonBack.getPosY(), this);
        } else if (pausa) {
            //Indica pausa si el juego ha sido pausado
            g.drawImage(pantallaPausa, 0, 0, getSize().width, getSize().height, this);
        } else {
            //Dibuja la imagen de fondo y los strings de vidas y score
            g.drawImage(fondo, 0, 0, getSize().width, getSize().height, this);
            g.drawString("Score: " + score, getWidth() - 200, 70);
            //Dibuja los personajes
            if ((barra != null) && (bola != null) && !list.isEmpty()) {
                //dibujar barra
                g.drawImage(barra.getImagenI(), barra.getPosX(), barra.getPosY(), this);
                //dibujar bola
                g.drawImage(bola.getImagenI(), bola.getPosX(), bola.getPosY(), this);
                //dibujar bloques

                for (int i = 0; i < numBloques; i++) {
                    Meth block = (Meth) list.get(i);
                    g.drawImage(block.getImagenI(), block.getPosX(), block.getPosY(), this);
                }

            }
        }

    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {    //Presiono letra P
            pausa = !pausa; //cambio valor de pausa
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) { //Presiono flecha izquierda
            barra.setDireccion(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //Presiono flecha derecha
            barra.setDireccion(2);
        }

        if (Ajustes && e.getKeyCode() == KeyEvent.VK_S) { //Presiono tecla S
            sonido = !sonido;
        }

        if (Ajustes && e.getKeyCode() == KeyEvent.VK_M) { //Presiono tecla M
            musica = !musica;
        }
    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     * Metodo mouseClicked sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al hacer click con el mouse sobre
     * algun componente. e es el evento generado al hacer click con el mouse.
     */
    public void mouseClicked(MouseEvent e) {
        clickX = e.getX();
        clickY = e.getY();

        //checa clicks en botones
        if (botonInst.clickEnPersonaje(clickX, clickY)) {
            if (!juegoInicia) {
                Menu = false;
                Instrucciones = true;
            }
        }
        if (botonIni.clickEnPersonaje(clickX, clickY)) {
            pausa = false;
            Menu = false;
            juegoInicia = true;
        }
        if (botonAj.clickEnPersonaje(clickX, clickY)) {
            if (!juegoInicia) {
                Menu = false;
                Ajustes = true;
            }
        }
        if (botonCre.clickEnPersonaje(clickX, clickY)) {
            if (!juegoInicia) {
                Menu = false;
                Creditos = true;
            }
        }
        if (botonBack.clickEnPersonaje(clickX, clickY)) {
            if (vidas==0 || gano) 
            {
                vidas=1;
                gano = false;
                reset();
            }
            Menu = true;
            Instrucciones = false;
            Ajustes = false;
            Creditos = false;
            juegoInicia=false;
            
            
        }

    }

    /**
     * Metodo mousePressed sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al presionar un botón del mouse
     * sobre algun componente. e es el evento generado al presionar un botón del
     * mouse sobre algun componente.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Metodo mouseReleased sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al soltar un botón del mouse sobre
     * algun componente. e es el evento generado al soltar un botón del mouse
     * sobre algun componente.
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Metodo mouseEntered sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera cuando el mouse entra en algun
     * componente. e es el evento generado cuando el mouse entra en algun
     * componente.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Metodo mouseExited sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera cuando el mouse sale de algun
     * componente. e es el evento generado cuando el mouse sale de algun
     * componente.
     */
    public void mouseExited(MouseEvent e) {
    }

}
