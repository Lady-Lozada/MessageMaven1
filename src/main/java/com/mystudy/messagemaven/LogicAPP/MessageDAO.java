package com.mystudy.messagemaven.LogicAPP;

import com.mystudy.messagemaven.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * DAO: Data Acces Objet
 * En esta clase estarán los metodos que nos permitiran hacer conexion con la Base de datos
 */

public class MessageDAO {
    
    public static void createMessageDB(MessageInit message){
        ConexionDB conexDB = new ConexionDB();
        
        try(Connection cnxDB = conexDB.get_connection()) {
            PreparedStatement ps = null;
            cnxDB.setAutoCommit(false);
            try {
               String query = "INSERT INTO messageApp (message, author) VALUES (?,?)"; 
               ps = cnxDB.prepareStatement(query);
               ps.setString(1, message.getMessage());
               ps.setString(2, message.getAuthor_message());
               ps.executeUpdate();
               System.out.println("Mensage creado correctamente");
               cnxDB.setAutoCommit(true);
            } catch (SQLException s) {
                cnxDB.rollback();
                System.out.println(s);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void readMessageDB(){
        ConexionDB conexDB = new ConexionDB();
        PreparedStatement ps = null;
        ResultSet rs = null; // trae los datos para poder procesarlos
        try(Connection cnxDB = conexDB.get_connection()) {
            String query = "SELECT * FROM messageApp";
            ps = cnxDB.prepareStatement(query);
            rs = ps.executeQuery(); // Ejecutar la consulta
            
            while (rs.next()) {
                System.out.println("");
                System.out.println("ID: "+rs.getInt("id_message")); //System.out.println("ID: "+rs.getInt(1));
                System.out.println("Mensaje: "+rs.getString("message")); //System.out.println("Mensaje: "+rs.getString(2));
                System.out.println("Autor: "+ rs.getString("author")); //System.out.println("Autor: "+ rs.getString(3));
                System.out.println("Fecha envio: " + rs.getString("fecha")); //System.out.println("Fecha envio: " + rs.getString(4));
            }            
        } catch (SQLException e) {
            System.out.println("No se recuperaron los mensajes");
            System.out.println(e);
        }
    }
    
    public static void deleteMessageDB(int id_message){
        ConexionDB conexDB = new ConexionDB();
        PreparedStatement ps = null;
        
        try(Connection cnxDB = conexDB.get_connection()) {
            try {
                String query = "DELETE FROM messageApp WHERE id_message = ?";
                ps = cnxDB.prepareStatement(query);
                ps.setInt(1, id_message);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            } catch (SQLException s) {
                System.out.println("El mensaje no pudo ser borrado");
                System.out.println(s);
            } 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        
    public static void updateMessageDB(MessageInit message){
        ConexionDB conexDB = new ConexionDB();
        
        try(Connection cnxDB = conexDB.get_connection()) {
            PreparedStatement ps = null;
            cnxDB.setAutoCommit(false);
            try {
               String query = "UPDATE messageApp SET message = ? WHERE id_message = ?"; 
               ps = cnxDB.prepareStatement(query);
               ps.setString(1, message.getMessage());
               ps.setInt(2, message.getId_message());
               ps.executeUpdate();
               System.out.println("Mensage actualizado correctamente");
               cnxDB.setAutoCommit(true);
            } catch (SQLException s) {
                cnxDB.rollback();
                System.out.println("El mensaje no pudo ser actualizado!");
                System.out.println(s);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
