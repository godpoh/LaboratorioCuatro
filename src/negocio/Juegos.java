/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BDEscrituraDatos;
import datos.BDLecturaDatos;
import static datos.BDLecturaDatos.consolasUnicas;
import static datos.BDLecturaDatos.nombresUnicos;
import static datos.BDLecturaDatos.resenasUnicas;
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

    // Method to initialize the game data
    public static void inicializarDatos() {
        // Read the CSV file and populate the juegosNombres list
        if (juegosNombres.isEmpty()) {
            juegosNombres = BDLecturaDatos.leerArchivoCSVJuegos();
        }
    }

    // Method to populate the JComboBox components
    public static void cargarDatosEnComboBox(JComboBox<String> jcbNombres, JComboBox<String> jcbResenas, JComboBox<String> jcbConsolas) {
        BDLecturaDatos bdLecturaDatos = new BDLecturaDatos();
        bdLecturaDatos.cargarDatos(jcbNombres, jcbResenas, jcbConsolas);
    }

    BDEscrituraDatos bdEscrituraDatos = new BDEscrituraDatos();

    public Juegos() {
        cargarDatos();
    }

    private void cargarDatos() {
        juegosNombres = BDLecturaDatos.leerArchivoCSVJuegos();
        // Asignar las listas para resenas y consolas

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
        ArrayList<String[]> juegos = BDLecturaDatos.leerArchivoCSVJuegos();

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

    public void eliminarJuegoPorNombre(String nombreJuego) {
        juegosNombres.removeIf(juego -> juego.length > 1 && juego[1].equals(nombreJuego));
        bdEscrituraDatos.guardarDatosActualizados(juegosNombres);
        JOptionPane.showMessageDialog(null, "Juego eliminado correctamente.");
    }

    public static void actualizarJComboBox(JComboBox<String> jcbNombres, JComboBox<String> jcbResenas, JComboBox<String> jcbConsolas) {
        // Limpiar los JComboBox
        jcbNombres.removeAllItems();
        jcbResenas.removeAllItems();
        jcbConsolas.removeAllItems();

        // Cargar los datos actualizados en los JComboBox
        cargarDatosEnComboBox(jcbNombres, jcbResenas, jcbConsolas);
    }

}
