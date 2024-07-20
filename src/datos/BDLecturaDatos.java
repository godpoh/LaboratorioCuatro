/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComboBox;

/**
 *
 * @author Admin
 */
public class BDLecturaDatos {

    public static HashSet<String> nombresUnicos = new HashSet<>();
    public static HashSet<String> resenasUnicas = new HashSet<>();
    public static HashSet<String> consolasUnicas = new HashSet<>();
    private static final String RUTA_ARCHIVO = "src/resources/Games.csv";
    public static ArrayList<String[]> todosLosJuegos = new ArrayList<>();

    public static ArrayList<String[]> leerArchivoCSVJuegos() {
        ArrayList<String[]> juegosList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim(); // Eliminar espacios en blanco al principio y al final
                if (linea.isEmpty()) {
                    continue; // Omitir líneas vacías
                }
                String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (partes.length >= 3) { // Verificar que hay al menos 3 columnas
                    juegosList.add(partes);
                } else {
                    System.err.println("Línea inválida en CSV: " + linea);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el stack trace en caso de error
        }

        // Crear un Set para eliminar duplicados
        HashSet<String> juegosSet = new HashSet<>();
        ArrayList<String[]> juegosSinDuplicados = new ArrayList<>();
        for (String[] juego : juegosList) {
            String juegoClave = juego[0] + "," + juego[1] + "," + juego[2]; // Ajusta esto según las columnas únicas
            if (juegosSet.add(juegoClave)) {
                juegosSinDuplicados.add(juego);
            }
        }

        todosLosJuegos.clear();
        todosLosJuegos.addAll(juegosSinDuplicados);

        return todosLosJuegos;
    }

    public static void cargarDatos(JComboBox<String> jcbNombres, JComboBox<String> jcbResenas, JComboBox<String> jcbConsolas) {

        for (String[] juego : todosLosJuegos) {
            if (juego.length > 1) {
                nombresUnicos.add(juego[1]); // Asumiendo que el nombre del juego está en la segunda columna
            }
            if (juego.length > 2) {
                resenasUnicas.add(juego[2]);
            }
            if (juego.length > 0) {
                consolasUnicas.add(juego[0]); // Asumiendo que el nombre de la consola está en la primera columna
            }
        }

        System.out.println("Tamaño de nombresUnicos: " + nombresUnicos.size());
        System.out.println("Tamaño de resenasUnicas: " + resenasUnicas.size());
        System.out.println("Tamaño de consolasUnicas: " + consolasUnicas.size());
        System.out.println("Tamaño de todosLosJuegos: " + todosLosJuegos.size());

        // Update the JComboBox components after collecting all unique elements
        
        for (String nombre : nombresUnicos) {
            jcbNombres.addItem(nombre);
        }

        
        for (String resena : resenasUnicas) {
            jcbResenas.addItem(resena);
        }

        
        for (String consola : consolasUnicas) {
            jcbConsolas.addItem(consola);
        }
    }

}

