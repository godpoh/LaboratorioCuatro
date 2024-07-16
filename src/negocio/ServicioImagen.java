/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.RepositorioImagenes;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class ServicioImagen {
        public File guardarImagen(File archivo, String directorio) throws IOException {
        // Crear una instancia del repositorio de imágenes
        RepositorioImagenes repositorioImagen = new RepositorioImagenes();
        
        // Delegar la tarea de guardar la imagen al repositorio de imágenes
        return repositorioImagen.guardarImagen(archivo, directorio);
    }
}
