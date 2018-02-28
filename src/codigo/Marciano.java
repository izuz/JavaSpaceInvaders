/*
 * El marciano del juego
 */
package codigo;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Gonzalo Izuzquiza
 */
public class Marciano {
    public Image imagen = null;
    public Image imagen2 = null;
    public int x = 0;
    public int y = 0;
    private int anchoPantalla;
    
    public boolean vida = true;

    
        public Marciano(int _anchoPantalla){
        try {
            imagen = ImageIO.read(getClass().getResource("/imagenes/marcianito1.png"));
            imagen2 = ImageIO.read(getClass().getResource("/imagenes/marcianito2.png"));
        }
        catch (IOException ramon){
            
        }
        anchoPantalla = _anchoPantalla;
    }
        public void mueve (boolean direccion){
            if (direccion){
                if (x < anchoPantalla - imagen.getWidth(null) ){
                       x++;
                }
            }
            else{
                if(x>0){
                    x--;
                }
            }
        }
}