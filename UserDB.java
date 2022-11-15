
package my.login.proyectologin;

import java.util.ArrayList;
import java.util.Scanner;


public class UserDB {
   
    ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
    Scanner entrada=new Scanner(System.in);
    
    public UserDB(){
        
    }
    
    public void addUser(){
        String email="";
        String user="";
        String password="";
     
        System.out.println("Introduzca su email");               
        email=entrada.nextLine().toLowerCase();
        boolean valido=true;
        for(Usuario i: usuarios){
            if(i.getEmail().equals(email)){
                System.out.println("Ya existe un usuario con el email indicado");
                valido=false;
            }
        }       
        if(valido==true){
            do{
                valido=true;
                System.out.println("Introduzca su nombre de usuario:");               
                user=entrada.nextLine().toLowerCase();
                for(Usuario i: usuarios){
                    if(i.getUser().equals(user)){
                    System.out.println("Este nombre de usuario ya está ocupado. Elija otro nombre de usuario.");
                    valido=false;
                    }
                } 
            }while(valido==false);
            System.out.println("Introduzca su contraseña");               
            password=entrada.nextLine().toLowerCase(); 
            while((password.length()<6 || password.length()>15)){
                System.out.println("La contraseña debe contener entre 6 y 15 carácteres. Vuelva a intentarlo.");
                password=entrada.nextLine().toLowerCase();
            }
            usuarios.add(new Usuario(email,user,password));
            System.out.println("Usuario registrado correctamente!");
        }
    }
    
    public Usuario getLogIn(){
        String email="";
        String password="";
        boolean login = false;
        int retry=0;
        Usuario userLogged= new Usuario("","","");
        
        
        
        while(login==false && retry<3){
            System.out.println("Introduzca su email");               
            email=entrada.nextLine().toLowerCase();
            System.out.println("Introduzca su contraseña");               
            password=entrada.nextLine().toLowerCase();           
            for(Usuario i: usuarios){
                if(i.getEmail().equals(email)&&i.getPassword().equals(password)){
                    System.out.println("LogIn correcto!");
                    login=true; 
                    userLogged=i;
                }
            }
            if(login==false){
                retry++;
                System.out.println("Error en los datos de LogIn. Intento "+retry);
            }
        }
        
        return userLogged;
        
    }    

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
}
