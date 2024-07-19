/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BDEscrituraDatos;
import datos.BDLecturaDatos;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import objetos.objDatosJuego;

/**
 *
 * @author Admin
 */
public class Juegos {

    public ArrayList<String[]> juegosNombres = new ArrayList<>();
    ArrayList<String[]> resenas = new ArrayList<>();
    ArrayList<String[]> consolas = new ArrayList<>();

    BDEscrituraDatos bdEscrituraDatos = new BDEscrituraDatos();

    public Juegos() {
        cargarDatos();
    }

    private void cargarDatos() {
        juegosNombres = BDLecturaDatos.leerArchivoCSVJuegos("src/resources/Games.csv");
        // Asignar las listas para resenas y consolas
        resenas = juegosNombres; // Si el CSV contiene reseñas y las resenas tienen la misma estructura que juegos
        consolas = juegosNombres; // Si el CSV contiene consolas y las consolas tienen la misma estructura que juegos
    }

    public void insertarJuego(ArrayList<objDatosJuego> listaJuego) {
        String datos = "";
        for (int i = 0; i < listaJuego.size(); i++) {
            String consola = listaJuego.get(i).getConsola();
            String nombre = listaJuego.get(i).getNombre();
            String resena = listaJuego.get(i).getResena();
            int puntuacion = listaJuego.get(i).getPuntaje();
            String imagenNombre = listaJuego.get(i).getImagen();

            datos = consola + "," + nombre + "," + resena + "," + puntuacion + "," + imagenNombre;
        }
        bdEscrituraDatos.insertarEnArchivoJuego(datos);
        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente la informacion.");
    }

    public void cargarJuegosNombre(JComboBox<String> jcbNombres) {
        juegosNombres = BDLecturaDatos.leerArchivoCSVJuegos("src/resources/Games.csv");
        HashSet<String> nombresUnicos = new HashSet<>();
        for (String[] juego : juegosNombres) {
            if (juego.length > 1) { // Ensure there are at least two elements
                nombresUnicos.add(juego[1]);
            }
        }
        for (String nombre : nombresUnicos) {
            jcbNombres.addItem(nombre);
        }
    }

    public void cargarResenas(JComboBox<String> jcbResenas) {
        HashSet<String> nombresUnicos = new HashSet<>();
        for (String[] resena : resenas) {
            if (resena.length > 2) { // Ensure there are at least three elements
                nombresUnicos.add(resena[2]);
            }
        }
        for (String nombre : nombresUnicos) {
            jcbResenas.addItem(nombre);
        }
    }

    public void cargarConsolas(JComboBox<String> jcbResenas) {
        consolas = BDLecturaDatos.leerArchivoCSVJuegos("src/resources/Games.csv");
        HashSet<String> nombresUnicos = new HashSet<>();
        for (String[] consola : consolas) {
            nombresUnicos.add(consola[0]); // Asumiendo que el nombre del juego está en la primera columna
        }
        for (String nombre : nombresUnicos) {
            jcbResenas.addItem(nombre);
        }
    }

    public String[] obtenerDatosJuegoPorNombre(String nombreJuego) {
        for (String[] juego : juegosNombres) {
            if (juego[1].equals(nombreJuego)) { // Asumiendo que el nombre del juego está en la segunda columna
                return new String[]{
                    juego[0], // Consola
                    juego[2], // Reseña
                    juego[3] // Puntaje
                };
            }
        }
        return null; // Retorna null si no se encuentra el juego
    }
}
