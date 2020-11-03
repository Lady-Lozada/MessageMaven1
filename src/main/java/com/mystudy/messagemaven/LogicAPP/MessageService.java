
package com.mystudy.messagemaven.LogicAPP;

import java.util.Scanner;
/*
 * Esta clase es la capa intermedia entre el menú principal y la capa de acceso
 */

public class MessageService {
    
    static Scanner teclado = new Scanner(System.in);
    public static void createMessage(){
        
        System.out.println("Escribe tu mensaje");
        String message = teclado.nextLine();
        
        System.out.println("Escribe tu nombre");
        String name = teclado.nextLine();
        
        MessageInit sms = new MessageInit();
        sms.setMessage(message);
        sms.setAuthor_message(name);
        MessageDAO.createMessageDB(sms);
    }
    
    public static void listMessage(){
        MessageDAO.readMessageDB();
       
    }
    
    public static void deleteMessage(){
        
        System.out.println("Indica el ID del mensaje que desea borrar");
        int id_message = teclado.nextInt();
        MessageDAO.deleteMessageDB(id_message);
    }
    
    public static void editMessage(){
        
        System.out.println("Escribe nuevamente el mensaje");
        String newMessage = teclado.nextLine();
        
        System.out.println("Escribe el ID del mensaje a editar");
        int id = teclado.nextInt();
        
        MessageInit updateMessage = new MessageInit();
        updateMessage.setId_message(id);
        updateMessage.setMessage(newMessage);
        MessageDAO.updateMessageDB(updateMessage);
    }
}
