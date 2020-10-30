/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasentregar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andres Eloy Iporre
 */
public class TareasEntregar {

    /**
     * @param args the command line arguments
     */
    public TareasEntregar(){
     Connection c = null;
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex) {
            System.out.println(ex.getMessage());}
            
        } 
    
    public Connection getConnection(){
        Connection c = null;    
        try{
            c = DriverManager.getConnection("jdbc:postgresql://motty.db.elephantsql.com:5432/bmfkrrne","bmfkrrne","QqHVEx3Ovha37eRxLFhDpwI12gGkHvyx");
            System.out.println("Conexion Con Exito"  + c);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return c;
    } 
    public static void main(String[] args){
    
        TareasEntregar con = new TareasEntregar();
        con.getConnection();
    }
}
