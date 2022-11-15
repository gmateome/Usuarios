/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.login.proyectologin;

import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
    
    String email;
    String user;
    String password;
    String question;
    String answer;
    ArrayList <Mensaje> mensajes;
    Scanner entrada=new Scanner(System.in);
    
    public Usuario(){}
    
    public Usuario(String email, String user, String password){
      this.email=email;
      this.user=user;
      this.password=password;
      question="";
      answer="";
      mensajes= new ArrayList<Mensaje>();
    }

    public String getEmail() {
        return email;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getQuestion() {
        return question;
    }

    public void setEmail(ArrayList<Usuario> usuarios){
        if(answer.length()!=0){
            System.out.println("Responda a su pregunta de seguridad: "+question);
            String thisAnswer=entrada.nextLine().toLowerCase();
            if(thisAnswer.toLowerCase().equals(answer.toLowerCase())){
                System.out.println("Introduzca su nuevo email");               
                String newEmail=entrada.nextLine().toLowerCase();
                boolean valido=true;
                for(Usuario i: usuarios){
                    if(i.getEmail().equals(newEmail)){
                        System.out.println("Ya existe un usuario con el email indicado");
                        valido=false;
                    }
                }      
                if(valido==true){email=newEmail;System.out.println("Email cambiado correctamente");}
            }else{
                System.out.println("Respuesta equivocada");
            }          
        }else{
            System.out.println("Antes debe asignar una pregunta de seguridad"); 
        }   
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(ArrayList<Usuario> usuarios){
        if(answer.length()!=0){
            System.out.println("Responda a su pregunta de seguridad: "+question);
            String thisAnswer=entrada.nextLine().toLowerCase();
            if(thisAnswer.toLowerCase().equals(answer.toLowerCase())){
                System.out.println("Introduzca su nueva contraseña");               
                String newPassword=entrada.nextLine().toLowerCase();               
                while(newPassword.length()<6 || newPassword.length()>15){
                    System.out.println("La contraseña debe contener entre 6 y 15 carácteres");               
                    newPassword=entrada.nextLine().toLowerCase();
                }                  
                password=newPassword;
                System.out.println("Password cambiada correctamente");
            }else{
                System.out.println("Respuesta equivocada");
            }          
        }else{
            System.out.println("Antes debe asignar una pregunta de seguridad"); 
        }   
    }

    public void setQuestion() {
        String newQuestion="";
        System.out.println("Elija una opción: \n 1:Nombre de tu padre \n 2:Nombre de tu primera escuela \n 3:Nombre de tu primera mascota");               
        newQuestion=entrada.nextLine().toLowerCase(); 
        while(!newQuestion.equals("1")&&!newQuestion.equals("2")&&!newQuestion.equals("3")){
            System.out.println("Opcion no valida. Elija una de las opciones anteriores.");
            newQuestion=entrada.nextLine().toLowerCase();
        }
        switch(newQuestion){
            case "1":
                newQuestion="Nombre de tu padre";
            break;
            case "2":
                newQuestion="Nombre de tu primera escuela";
            break;
            case "3":
                newQuestion="Nombre de tu primera mascota";
            break;
        }
        question = newQuestion;
    }

    public void setAnswer() {
        String newAnswer="";
        System.out.println("Introduca su respuesta a la pregunta: "+question);
        newAnswer=entrada.nextLine().toLowerCase(); 
        answer = newAnswer;
    }
    
    public void addMessage(Usuario emisor, String contenido){
        mensajes.add(new Mensaje(emisor,contenido));
    }
    
    public String getMensajes(){
        String mensajesS="";
        String result="";
        int contador=0;
        for(Mensaje m: mensajes){
            if(m.getLeido()==false){
                m.setLeido();
                contador++;
                mensajesS+="***************************************************** \n Mensaje número:"+contador+"\n De: "+m.getEmisor().getEmail()+"\n"+m.getContenido()+"\n \n";
            }
        }
        result="Tiene "+contador+" mensajes nuevos \n \n"+mensajesS;
        return result;
    }
    
}
