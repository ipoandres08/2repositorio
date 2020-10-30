

package Temporizador.Principal;


import Temporizador.VentanaDeTiempo.ventanaDeTiempoRestante;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class AccionDelBoton implements java.awt.event.ActionListener {

    //variables de control de tiempo
    int segundos;
    String tiempoRestante;
    
    //control de la ventana de tiempo
    ventanaDeTiempoRestante ventanaDeTiempo;

    //control de temporizador
    Timer temporizador;
    
    //tarea del temporizador
    TimerTask tarea;
    
 
    //controlar ventana principal
    VentanaPrincipal principal;
    
    
    
    public AccionDelBoton(VentanaPrincipal principal) {
        
        this.principal = principal;
        
       ventanaDeTiempo = new ventanaDeTiempoRestante();
       
        
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        recibirDatos();
        principal.dispose();//cierra la ventana principall       
        ventanaDeTiempo.setVisible(true);        
        
        //crea y ajusta el temporizador con la tarea a ejecutar
        temporizador = new Timer();
        tarea = new TimerTask() {

            @Override
            public void run() {

                //se actualizan el tiempo restante y la ventana
                actualizarTiempo();
                actualizar_ventanaDeTiempo();

                if (segundos == 0) {//si se acabo el tiempo...

                    ventanaDeTiempo.dispose();
                    temporizador.cancel();
                 
                    JOptionPane.showMessageDialog(ventanaDeTiempo, "SE ACABO EL TIEMPO DE ENTREGA !!!", "ADVERTENCIA", 2);

                   
                      principal.setVisible(true);//mostrar ventana principal

                         System.exit(0);//salir

                }
               segundos--;           
 }
   };
        
    temporizador.schedule(tarea, 0, 1000);//repetir tarea cada segundo
    }

    void recibirDatos() {

        try {
             
            segundos = 0;
             if (!principal.campoDeTexto_dias.getText().equals("") ){
                segundos += (86400 * Integer.parseInt(principal.campoDeTexto_dias.getText()));
            }

            if (!principal.campoDeTexto_horas.getText().equals("") ){
                segundos += (3600 * Integer.parseInt(principal.campoDeTexto_horas.getText()));
                
            }

            if (!principal.campoDeTexto_minutos.getText().equals("")) {
                segundos += (60 * Integer.parseInt(principal.campoDeTexto_minutos.getText()));
            }

            if (!principal.campoDeTexto_segundos.getText().equals("")) {
                segundos += Integer.parseInt(principal.campoDeTexto_segundos.getText());
            }

        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(principal, "Solo se aceptan numeros !!!", "ADVERTENCIA", 0);

            JOptionPane.showMessageDialog(principal, "Saliendo del sistema", "MENSAJE", 2);

            System.exit(0);

        }
    }


    void actualizarTiempo() {
        
        tiempoRestante = calcular_tiempo_restante();
        ventanaDeTiempo.tiempoRestante.setText(tiempoRestante);
        
    }

    String calcular_tiempo_restante() {

        int seg, min, horas, dias;
        // condicional anidado
        dias = (segundos >= 86400) ? (int) (segundos / 86400) : 0;
        horas = (segundos >= 3600) ? (int) ((segundos - (dias * 86400)) / 3600) : 0;
        min = (segundos >= 60) ? (int) ((segundos - (dias * 86400) - (horas * 3600)) / 60) : 0;
        seg = (int) (segundos - (min * 60) - (horas * 3600) - (dias * 86400));

        return "    Quedan " + (dias) + " dias, " + (horas) + " horas, " + (min) + " minutos y " + (seg) + " segundos";
    }


    void actualizar_ventanaDeTiempo() {

        ventanaDeTiempo.revalidate();
        ventanaDeTiempo.repaint();

    }





    
    
}
