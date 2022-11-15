/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.login.proyectologin;



import java.util.ArrayList;
import java.util.Scanner;

public class ServidorMensajes {
    
    Scanner entrada=new Scanner(System.in);
    
    public ServidorMensajes(){}
    
    public void sendMessage(Usuario emisor, ArrayList<Usuario> usuarios){
        String email="";
        String contenido="";
        Usuario receptor=new Usuario();
        System.out.println("Introduzca el email del destinatario");               
        email=entrada.nextLine().toLowerCase();
        boolean valido=false;        
        for(Usuario i: usuarios){
            if(i.getEmail().equals(email)){
                valido=true;
                receptor=i;
            }
        } 
        
        while(valido==false){
            System.out.println("El destinatario introducido no existe. Por favor introduzca un email valido.");               
            email=entrada.nextLine().toLowerCase();
            valido=false;        
            for(Usuario i: usuarios){
                if(i.getEmail().equals(email)){
                    valido=true;
                    receptor=i;
                }
            }
        }       
        System.out.println("Introduzca el cuerpo del mensaje:");               
        contenido=entrada.nextLine().toLowerCase();
        receptor.addMessage(emisor, contenido);
        System.out.println("Mensaje enviado correctamente"); 
    }
    
}
