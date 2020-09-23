/*
 * 
 */
package com.mystudy.messagemaven;
//package com.mystudy.messagemaven.ConecctionDB.class;
//import static com.mystudy.messagemaven.ConecctionDB;

import java.sql.Connection;

/**
 * @author Lady Lozada
 */
public class PpalMain {
    public static void main(String[] args) {
        
        ConexionDB conex = new ConexionDB();
        
        try(Connection cnx = conex.get_connection()) {
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
