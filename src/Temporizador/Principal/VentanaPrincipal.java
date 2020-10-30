
package Temporizador.Principal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import plataforma.Plataforma;


public class VentanaPrincipal extends javax.swing.JFrame {

    //variables 
    JLabel txt_dias;
    JLabel txt_horas;
    JLabel txt_minutos;
    JLabel txt_segundos;
    JTextField campoDeTexto_dias;
    JTextField campoDeTexto_horas;
    JTextField campoDeTexto_minutos;
    JTextField campoDeTexto_segundos;
    JButton botonAceptar;



    public VentanaPrincipal() {

        iniciarVentana();
        

    }

    private void iniciarVentana() {

        setTitle(" PROGRAMAR FECHA DE ENTREGA ");
        setSize(500, 200);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       txt_dias = new JLabel("DIAS:");
        txt_dias.setBounds(35, 20, 60, 30);
        txt_horas = new JLabel("HORAS:");
        txt_horas.setBounds(250, 20, 60, 30);
        txt_minutos = new JLabel("MINUTOS:");
        txt_minutos.setBounds(35, 55, 60, 30);
       txt_segundos = new JLabel("SEGUNDOS:");
        txt_segundos.setBounds(250, 55, 90, 30);

        campoDeTexto_dias = new JTextField();
        campoDeTexto_dias.setBounds(115, 20, 100, 30);
        
        
        campoDeTexto_horas = new JTextField();
        campoDeTexto_horas.setBounds(350, 20, 100, 30);

        campoDeTexto_minutos = new JTextField();
        campoDeTexto_minutos.setBounds(115, 50, 100, 30);

        campoDeTexto_segundos = new JTextField();
        campoDeTexto_segundos.setBounds(350, 50, 100, 30);

        botonAceptar = new JButton();
        botonAceptar.setText("ACEPTAR");
        botonAceptar.setBounds(200, 100, 100, 27);
       Plataforma p = new Plataforma();
       p.setVisible(true);
               
        botonAceptar.addActionListener(new AccionDelBoton(this));//accion del boton
        
       add(txt_dias);
        add(txt_horas);
        add(txt_minutos);
        add(txt_segundos);
        add(campoDeTexto_dias);
        add(campoDeTexto_horas);
        add(campoDeTexto_minutos);
        add(campoDeTexto_segundos);
        add(botonAceptar);

    }
// ejecuta el programa del temporizador
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }

        });

    }

}
