
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    static public String driver = "com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    static public String usuario = "root";
    static public String password = "1234";
    
    protected Connection conn = null;
    
    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el Driver"+ ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar"+ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconetar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar" + ex.getMessage());
        }
    }
}
