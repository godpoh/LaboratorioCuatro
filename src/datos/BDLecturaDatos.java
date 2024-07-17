/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BDLecturaDatos {

    public static ArrayList<String> nombresConsolas = new ArrayList<>();
    public static ArrayList<String> resenas = new ArrayList<>();
    public static ArrayList<String[]> todosLosJuegos = new ArrayList<>();

    public ArrayList<String> leerArchivoTxTConsolas(String nombreArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                nombresConsolas.add(linea);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo txt de consolas", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
        return nombresConsolas;
    }

    public ArrayList<String> leerArchivoTxTResenas(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
 
                resenas.add(linea);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo txt de Resenas", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
        return resenas;
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
