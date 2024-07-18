/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BDLecturaDatos {

    public static ArrayList<String> nombresConsolas = new ArrayList<>();
    public static ArrayList<String> resenas = new ArrayList<>();
    public static ArrayList<String[]> todosLosJuegos = new ArrayList<>();

        public static void leerArchivoCSV(String nombreArchivo, JComboBox<String> jcbConsola, JComboBox<String> jcbResena) {
        HashSet<String> consolas = new HashSet<>();
        HashSet<String> resenas = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine(); // Leer la primera línea que contiene los encabezados
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                
                // Extraer consolas
                String[] consolasArray = partes[0].replace("\"", "").split(",");
                for (String consola : consolasArray) {
                    consolas.add(consola.trim());
                }
                
                // Extraer la reseña (asumiendo que está en la última posición)
                if (partes.length >= 4) {
                    resenas.add(partes[partes.length - 2].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Agregar consolas al JComboBox sin duplicados
        for (String consola : consolas) {
            jcbConsola.addItem(consola);
        }

        // Agregar reseñas al JComboBox sin duplicados
        for (String resena : resenas) {
            jcbResena.addItem(resena);
        }
    }

    public ArrayList<String[]> leerArchivoCSVJuegos(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] juegos = linea.split(",");
                todosLosJuegos.add(juegos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }

        return todosLosJuegos;
    }

}
