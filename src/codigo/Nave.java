/*
 * La nave del juego
 */
package codigo;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Gonzalo Izuzquiza
 */
public class Nave {
    public Image imagen = null;
    public int x = 0;
    public int y = 0;

    private boolean pulsadoIzquierda = false;
    private boolean pulsadoDerecha = false;
    
    private int anchoPantalla;
    
        public Nave(int _anchoPantalla){
            
        anchoPantalla = _anchoPantalla;
    }
    
    public boolean isPulsadoIzquierda() {
        return pulsadoIzquierda;
    }

    public void setPulsadoIzquierda(boolean pulsadoIzquierda) {
        this.pulsadoIzquierda = pulsadoIzquierda;
    }

    public boolean isPulsadoDerecha() {
        return pulsadoDerecha;
    }

    public void setPulsadoDerecha(boolean pulsadoDerecha) {
        this.pulsadoDerecha = pulsadoDerecha;
    }
    
    // metodo para mover la nave
    public void mueve (){
        if (pulsadoIzquierda && x > 0){
            x-=3;
            
        }
        
        if (pulsadoDerecha && x < anchoPantalla - imagen.getWidth(null)){
            x+=3;
            
        }
    }

}
