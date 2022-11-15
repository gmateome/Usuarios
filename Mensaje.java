/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.login.proyectologin;


public class Mensaje {
    
    Usuario emisor;
    String contenido;
    boolean leido;
    
    public Mensaje(Usuario emisor, String contenido){
        this.emisor=emisor;
        this.contenido=contenido;
        leido=false;
    }

    public void setLeido(){
        leido=true;
    }
    
    public Usuario getEmisor() {
        return emisor;
    }

    public String getContenido() {
        return contenido;
    }
    
    public boolean getLeido() {
        return leido;
    }

    public boolean isLeido() {
        return leido;
    }
    
    
    
    
    
}
