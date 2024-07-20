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

    public static ArrayList<String[]> juegosNombres = new ArrayList<>();
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
            if (juego.length > 1) { // Asegúrate de que hay al menos dos elementos
                nombresUnicos.add(juego[1]); // Asumiendo que el nombre del juego está en la segunda columna
            }
        }
        jcbNombres.removeAllItems(); // Limpiar el JComboBox antes de añadir nuevos elementos
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
            if (juego.length >= 4 && juego[1].equals(nombreJuego)) { // Verificar longitud mínima y nombre del juego
                // Asegúrate de que el índice 4 existe para la ruta de la imagen
                String rutaImagen = juego.length > 4 ? juego[4] : null;
                return new String[]{
                    juego[0], // Consola
                    juego[2], // Reseña
                    juego[3], // Puntaje
                    rutaImagen // Ruta de la imagen (ajusta si es necesario)
                };
            }
        }
        return null; // Retorna null si no se encuentra el juego
    }

    public void modificarJuego(String[] datosJuego) {
        boolean encontrado = false;
        for (int i = 0; i < juegosNombres.size(); i++) {
            if (juegosNombres.get(i)[1].equals(datosJuego[1])) { // Compara por nombre
                juegosNombres.set(i, datosJuego);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            juegosNombres.add(datosJuego);
        }
    }

    public void modificarOInsertarJuego(String[] datosJuego) {
        boolean encontrado = false;
        ArrayList<String[]> juegosActualizados = new ArrayList<>();

        // Leer todos los juegos del archivo CSV
        ArrayList<String[]> juegos = BDLecturaDatos.leerArchivoCSVJuegos("src/resources/Games.csv");

        // Buscar el juego por nombre y actualizar sus datos
        for (String[] juego : juegos) {
            if (juego.length > 1 && juego[1].equals(datosJuego[1])) { // Comparar por nombre del juego
                juegosActualizados.add(datosJuego); // Actualizar datos del juego
                encontrado = true;
            } else {
                juegosActualizados.add(juego); // Mantener el juego existente sin cambios
            }
        }

        if (!encontrado) {
            juegosActualizados.add(datosJuego); // Si no se encontró el juego, agregarlo como nuevo
        }

        // Guardar la lista actualizada en el archivo CSV
        BDEscrituraDatos.escribirArchivoCSVJuegos("src/resources/Games.csv", juegosActualizados);

        JOptionPane.showMessageDialog(null, "Los datos del juego se han guardado correctamente.");
    }



}
