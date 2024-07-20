/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static negocio.Juegos.juegosNombres;

/**
 *
 * @author Admin
 */
public class BDEscrituraDatos {

    private static final String RUTA_ARCHIVO = "src/resources/Games.csv";

    public void insertarEnArchivoJuego(String datosJuego) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
            bw.write("\n" + datosJuego);
            bw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar informacion del juego", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void escribirArchivoCSVJuegos(String rutaArchivo, ArrayList<String[]> juegos) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));

            for (String[] juego : juegos) {
                String linea = String.join(",", juego);
                bw.write(linea);
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo CSV", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }
        public void guardarDatosActualizados(ArrayList<String[]> juegosNombres) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            for (String[] juego : juegosNombres) {
                String linea = String.join(",", juego);
                bw.write(linea + "\n");
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos actualizados", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
