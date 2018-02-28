/*
 * Juego de los invadores del espacio.
 * Ejericico creado para explicar los siguientes conceptos:
 * - Hilos de ejecución paralela
 * - ArrayList
 */
package codigo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 * @author Gonzalo Izuzquiza
 */
public class VentanaJuego extends javax.swing.JFrame {
    
    static int ANCHOPANTALLA = 600;
    static int ALTOPANTALLA = 400;
    // cuantos marcianos van a salir por pantalla
    int filasMarcianos = 5;
    int columnasMarcianos = 10;
    
    BufferedImage buffer = null;
    int contador = 0;
    Nave miNave = new Nave(ANCHOPANTALLA);
    Disparo miDisparo = new Disparo(ALTOPANTALLA);
    Marciano miMarciano = new Marciano (ANCHOPANTALLA);
    
    // declara array de dos dimesnsiones que guarda la lista de marcianos
    Marciano [] [] listaMarciano = new Marciano [filasMarcianos][columnasMarcianos];
    // direccion en la que se mueve el grupo de marcianos
    boolean direccionMarcianos = false;
    
    // bucle de animacion del juego
    // en este caso, es un hilo de ejercicios nuevos que se encarga
    // de refrescar el contenido de la pantalla
    
    Timer temporizador = new Timer(10, new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
           // codigo de la animacion
           bucleDelJuego();
        }
    });
    
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        setSize(ANCHOPANTALLA +6, ALTOPANTALLA + 29);
        buffer = (BufferedImage)jPanel1.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        buffer.createGraphics();
        miNave.x = ANCHOPANTALLA/2 - miNave.imagen.getWidth(this)/2;
        miNave.y = ALTOPANTALLA - miNave.imagen.getHeight(this) - 10;
        
        // creamos el array de marcianos
        for (int i=0; i<filasMarcianos;i++){
            for (int j=0; j<columnasMarcianos; j++){
                listaMarciano[i][j] = new Marciano(ANCHOPANTALLA);
                listaMarciano[i][j].x = j*(15 + listaMarciano[i][j].imagen.getWidth(null));
                listaMarciano[i][j].y = i*(10 +listaMarciano[i][j].imagen.getHeight(null));
            }
        }
        
        //inicio el temporizador
        temporizador.start();
        
    }
    
    private void pintaMarcianos(Graphics2D _g2){
        for (int i=0; i<filasMarcianos;i++){
            
            for (int j=0; j<columnasMarcianos; j++){
                listaMarciano[i][j].mueve(direccionMarcianos);
                
                if (contador < 50){
                _g2.drawImage(listaMarciano[i][j].imagen, listaMarciano[i][j].x, listaMarciano[i][j].y, null);
                }

                else if (contador < 100){
                _g2.drawImage(listaMarciano[i][j].imagen2, listaMarciano[i][j].x, listaMarciano[i][j].y, null);
                }

                else contador = 0;
                
                if (listaMarciano[i][j].x == ANCHOPANTALLA - listaMarciano[i][j].imagen.getWidth(null) || listaMarciano[i][j].x == 0){
                         direccionMarcianos = !direccionMarcianos;
                         
                         for (int k=0; k<filasMarcianos; k++){
                             for (int m=0; m<columnasMarcianos; m++){
                         listaMarciano[k][m].y+= listaMarciano[k][m].imagen.getHeight(null);
                           }
                       }    
                    }
               }
          }
    }
    
    private void bucleDelJuego(){
        // el bucle de animacion gobierna el redibujado de los objetos en el jpanel1
        // primero borro todo lo que hay en el buffer
        
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA );
        
        ///////////////////////////////////////////////////////////////////////
        //redibujamos cada elemento en su nueva posicion 
        
        
        
        //////////////////////////////////////////////////////////////////////
        
       contador++;
       miDisparo.mueve();
       g2.drawImage(miDisparo.imagen, miDisparo.getX(), miDisparo.getY(), null);
       //pinto la nave
        miNave.mueve();
        g2.drawImage(miNave.imagen, miNave.x, miNave.y, null);
        
        pintaMarcianos(g2);
        
//        miMarciano.mueve();
//        
//        
//        if (contador < 50){
//        // dibujo al marciano
//        g2.drawImage(miMarciano.imagen, miMarciano.x, miMarciano.y, null);
//        }
//        
//        else if (contador < 100){
//        g2.drawImage(miMarciano.imagen2, miMarciano.x, miMarciano.y, null);
//        }
//        
//        else contador = 0;
//        
//        if (miMarciano.x == ANCHOPANTALLA - miMarciano.imagen.getWidth(null) || miMarciano.x == 0){
//            miMarciano.direccion = !miMarciano.direccion;
//            miMarciano.y+= miMarciano.imagen.getHeight(null);
//        }
        
        //dibujo de golpe el buufer sobre el jpanel1
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer, 0, 0, null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    switch (evt.getKeyCode()){
        case KeyEvent.VK_LEFT:miNave.setPulsadoIzquierda(true); break;
        case KeyEvent.VK_RIGHT:miNave.setPulsadoDerecha(true); break;   
        case KeyEvent.VK_SPACE:miDisparo.setDisparado(true); miDisparo.posicionaDisparo(miNave);break;
    }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    switch (evt.getKeyCode()){
        case KeyEvent.VK_LEFT:miNave.setPulsadoIzquierda(false); break;
        case KeyEvent.VK_RIGHT:miNave.setPulsadoDerecha(false); break;   
     }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
