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
        RepositorioImagenes repositorioImagen = new RepositorioImagenes();
        return repositorioImagen.guardarImagen(archivo, directorio);
    }
}
