/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class RepositorioImagenes {

    public File guardarImagen(File archivo, String directorio) throws IOException {
        // Crear el directorio si no existe
        File directory = new File(directorio);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Ruta completa del nuevo archivo en el proyecto
        File nuevoArchivo = new File(directory, archivo.getName());

        // Leer la imagen seleccionada
        BufferedImage bI = ImageIO.read(archivo);

        // Escribir la imagen en el directorio del proyecto
        ImageIO.write(bI, "jpg", nuevoArchivo);

        return nuevoArchivo;
    }
}
