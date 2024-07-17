/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BDEscrituraDatos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.objDatosJuego;

/**
 *
 * @author Admin
 */
public class Juegos {

    BDEscrituraDatos bdEscrituraDatos = new BDEscrituraDatos();

    public void insertarJuego(ArrayList<objDatosJuego> listaJuego) {
        String datos = "";
        for (int i = 0; i < listaJuego.size(); i++) {
            String consola = listaJuego.get(i).getConsola();
            String nombre = listaJuego.get(i).getNombre();
    String resena = listaJuego.get(i).getResena();
            int puntuacion = listaJuego.get(i).getPuntaje();
            String imagenNombre = listaJuego.get(i).getImagen();

            datos = consola + "," + nombre + "," + resena + "," + puntuacion + ","  + imagenNombre;
        }
        bdEscrituraDatos.insertarEnArchivoJuego(datos);
        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente la informacion.");
    }
    
    public void cargarJuegos (ArrayList<String[]> leerArchivoCSV) {
        
    }
}
