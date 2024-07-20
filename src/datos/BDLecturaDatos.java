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
import javax.swing.JOptionPane;
import static negocio.Juegos.juegosNombres;

/**
 *
 * @author Admin
 */
public class BDLecturaDatos {

    private static final String RUTA_ARCHIVO = "src/resources/Games.csv";
    public static ArrayList<String[]> todosLosJuegos = new ArrayList<>();

    public static ArrayList<String[]> leerArchivoCSVJuegos() {
    HashSet<String> juegosSet = new HashSet<>();
    todosLosJuegos.clear(); // Clear the list before reading the file
    try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            String juegoClave = partes[0] + "," + partes[1] + "," + partes[2]; // Ajusta esto según las columnas únicas
            if (juegosSet.add(juegoClave)) { // Solo añade si no está en el Set
                todosLosJuegos.add(partes);
            }
        }
    } catch (Exception e) {
        
    }

    return todosLosJuegos;
}

    public static void cargarDatos(JComboBox<String> jcbNombres, JComboBox<String> jcbResenas, JComboBox<String> jcbConsolas) {
        HashSet<String> nombresUnicos = new HashSet<>();
        HashSet<String> resenasUnicas = new HashSet<>();
        HashSet<String> consolasUnicas = new HashSet<>();

        for (String[] juego : todosLosJuegos) {
            if (juego.length > 1) {
                nombresUnicos.add(juego[1]); // Assuming the game name is in the second column
            }
            if (juego.length > 2) {
                resenasUnicas.add(juego[2]);
            }
            if (juego.length > 0) {
                consolasUnicas.add(juego[0]); // Assuming the console name is in the first column
            }
        }

        System.out.println("Tamaño de nombresUnicos: " + nombresUnicos.size());
        System.out.println("Tamaño de resenasUnicas: " + resenasUnicas.size());
        System.out.println("Tamaño de consolasUnicas: " + consolasUnicas.size());
        System.out.println("Tamaño de todosLosJuegos: " + todosLosJuegos.size());

        // Update the JComboBox components after collecting all unique elements
        jcbNombres.removeAllItems();
        for (String nombre : nombresUnicos) {
            jcbNombres.addItem(nombre);
        }

        jcbResenas.removeAllItems();
        for (String resena : resenasUnicas) {
            jcbResenas.addItem(resena);
        }

        jcbConsolas.removeAllItems();
        for (String consola : consolasUnicas) {
            jcbConsolas.addItem(consola);
        }
    }
}
