
package Temporizador.VentanaDeTiempo;


import javax.swing.JLabel;


public class ventanaDeTiempoRestante extends javax.swing.JFrame {

    //tiempo restante 
    public JLabel tiempoRestante;
        
    
    //sirve para poner la ventana del tiempo
    int anchoDePantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

        public ventanaDeTiempoRestante() {
        
            iniciarVentana();
        
    } // inicia la ventana
    
    private void iniciarVentana() {
        
        setTitle("TIEMPO RESTANTE PARA LA ENTREGA");
        setSize(450, 80);
        
        setResizable(false);
        setAlwaysOnTop(true);        
        
        //posiciona la ventana en la esquina superior derecha
        setLocation((anchoDePantalla - getWidth()), 0);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tiempoRestante = new JLabel();
        tiempoRestante.setBounds(0, 5, 100, 50);

        add(tiempoRestante);
        
    }
    

}
