
package com.mystudy.messagemaven;
//package com.mystudy.messagemaven.ConecctionDB.class;
//import static com.mystudy.messagemaven.ConecctionDB;

import com.mystudy.messagemaven.LogicAPP.MessageService;
import java.sql.Connection;
import java.util.Scanner;

/**
 * @author Lady Lozada
 */
public class PpalMain {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int opc = 0;
        
        do {
            //Menu de ingreso
            System.out.println("------------------------------------");
            System.out.println("Aplicación de mensajería");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            
            //captura de la opcion ingresada por el usuario
            opc = teclado.nextInt();
            switch(opc){
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.editMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                default:
                    break;
            }
            System.out.println("");
        } while (opc != 5);
        
        /*
        ConexionDB conex = new ConexionDB();
        
        try(Connection cnx = conex.get_connection()) {
            
        } catch (Exception e) {
            System.out.println(e);
        }*/
    }
}
