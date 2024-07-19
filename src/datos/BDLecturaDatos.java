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

/**
 *
 * @author Admin
 */
public class BDLecturaDatos {

public static ArrayList<String[]> todosLosJuegos = new ArrayList<>();

    public static ArrayList<String[]> leerArchivoCSVJuegos(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                todosLosJuegos.add(partes);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }

        return todosLosJuegos;
    }
}
