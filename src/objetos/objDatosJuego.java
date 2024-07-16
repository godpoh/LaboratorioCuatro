/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class objDatosJuego {
    String consola;
    String nombre;
    String resena;
    int puntaje;
    
    public static ArrayList<objDatosJuego> listaObjetoJuegos = new ArrayList<>(); 
  
    public objDatosJuego(String consola, String nombre, String resena, int puntaje) {
        this.consola = consola;
        this.nombre = nombre;
        this.resena = resena;
        this.puntaje = puntaje;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
