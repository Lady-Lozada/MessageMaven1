
package com.mystudy.messagemaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexionDB {
    
    public Connection get_connection(){
        Connection conexion= null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            if (conexion != null) {
                System.out.println("Conexion Exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        return conexion;
    }
}
