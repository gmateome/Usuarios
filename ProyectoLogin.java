

package my.login.proyectologin;

import java.util.Scanner;


public class ProyectoLogin {

    public static void main(String[] args) {
        
        UserDB thisDB = new UserDB();
        Scanner entrada=new Scanner(System.in);
        String opcion="";
        Usuario userLogged=new Usuario("","","");
        ServidorMensajes server=new ServidorMensajes();
        
        System.out.println("Se ha conectado a la Intranet de T-Systems");    
        
        do{
            
            if(userLogged.getEmail().length()==0){
                System.out.println("Que desea hacer ahora? 1:LogIn    2:Registrarse     Exit:Salir");                   
                opcion=entrada.nextLine().toLowerCase();
                while(!opcion.equals("1")&&!opcion.equals("2")&&!opcion.equals("exit")){
                    System.out.println("La opcion elegida no es válida. Elija de nuevo entre: 1:LogIn    2:Registrarse     Exit:Salir");
                    opcion=entrada.nextLine().toLowerCase();
                }            
                switch(opcion){
                    case "1":
                        userLogged=thisDB.getLogIn();                        
                    break;
                    case "2":
                        thisDB.addUser();                               
                    break;
                }
            }else{
                System.out.println("Logeado con el email "+userLogged.getEmail());
                System.out.println("Que desea hacer ahora? 1:Leer mensajes    2:Enviar mensaje     3:Cambiar pregunta    4:Cambiar email    5:Cambiar password    6:LogOut    Exit:Salir");                   
                opcion=entrada.nextLine().toLowerCase();
                while(!opcion.equals("1")&&!opcion.equals("2")&&!opcion.equals("3")&&!opcion.equals("4")&&!opcion.equals("5")&&!opcion.equals("6")&&!opcion.equals("exit")){
                    System.out.println("La opcion elegida no es válida. Elija de nuevo entre: 1:Leer mensajes    2:Enviar mensaje     3:Cambiar pregunta    4:Cambiar email    5:Cambiar password    6:LogOut    Exit:Salir");
                    opcion=entrada.nextLine().toLowerCase();
                }            
                switch(opcion){
                    case "1":
                        System.out.println(userLogged.getMensajes());
                    break;
                    case "2":
                        server.sendMessage(userLogged,thisDB.getUsuarios());
                    break;
                    case "3":
                        userLogged.setQuestion();
                        System.out.println("Su nueva pregunta de seguridad es:"+userLogged.getQuestion());
                        userLogged.setAnswer();
                        System.out.println("Respuesta cambiada");                     
                    break;
                    case "4":   
                        userLogged.setEmail(thisDB.getUsuarios());
                    break;
                    case "5":
                        userLogged.setPassword(thisDB.getUsuarios());
                    break;
                    case "6":
                        userLogged= new Usuario("","","");
                        System.out.println("Se ha cerrado la sesion");
                    break;
                }
            }
        } while(opcion.equals("1")||opcion.equals("2")||opcion.equals("3")||opcion.equals("4")||opcion.equals("5")||opcion.equals("6"));
        
        
    }
}
