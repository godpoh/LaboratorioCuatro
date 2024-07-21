package presentacion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import negocio.Juegos;

/**
 *
 * @author Admin
 */
public class EliminarJuego extends javax.swing.JDialog {

    String rutaImagen;

    /**
     * Creates new form EliminarJuego
     */
    public EliminarJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cargarJuegosNombresYDatos();
        Juegos.inicializarDatos();
        inicializarListeners();
        jcbConsolas.setEnabled(false);
        jcbResena.setEnabled(false);
        jSpinner1.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelImagen = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        panelInsertarJuego = new javax.swing.JPanel();
        btnEliminarJuego = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jcbNombreJuegos = new javax.swing.JComboBox<>();
        panelBotones = new javax.swing.JPanel();
        rdAaE = new javax.swing.JRadioButton();
        rdFaK = new javax.swing.JRadioButton();
        rdLaP = new javax.swing.JRadioButton();
        rdQaV = new javax.swing.JRadioButton();
        rdWaZ = new javax.swing.JRadioButton();
        panelInformacion = new javax.swing.JPanel();
        lblConsola = new javax.swing.JLabel();
        lblResena = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jcbConsolas = new javax.swing.JComboBox<>();
        jcbResena = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImagenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEliminarJuego.setText("Eliminar Juego");
        btnEliminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarJuegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInsertarJuegoLayout = new javax.swing.GroupLayout(panelInsertarJuego);
        panelInsertarJuego.setLayout(panelInsertarJuegoLayout);
        panelInsertarJuegoLayout.setHorizontalGroup(
            panelInsertarJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarJuegoLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btnEliminarJuego)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInsertarJuegoLayout.setVerticalGroup(
            panelInsertarJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertarJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminarJuego)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNombre.setText("Nombres de juegos:");

        jcbNombreJuegos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un juego:" }));

        buttonGroup1.add(rdAaE);
        rdAaE.setText("A a E");

        buttonGroup1.add(rdFaK);
        rdFaK.setText("F a K");

        buttonGroup1.add(rdLaP);
        rdLaP.setText("L a P");

        buttonGroup1.add(rdQaV);
        rdQaV.setText("Q a V");

        buttonGroup1.add(rdWaZ);
        rdWaZ.setText("W a Z");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdAaE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdFaK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdLaP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdQaV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdWaZ)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdAaE)
                    .addComponent(rdFaK)
                    .addComponent(rdLaP)
                    .addComponent(rdQaV)
                    .addComponent(rdWaZ))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblConsola.setText("Consola:");

        lblResena.setText("Reseña:");

        lblPuntaje.setText("Puntaje:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jcbConsolas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una consola" }));
        jcbConsolas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbConsolasActionPerformed(evt);
            }
        });

        jcbResena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija un reseña" }));

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConsola, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbConsolas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbResena, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPuntaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsola, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbConsolas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbResena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(panelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNombreJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbNombreJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInsertarJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInsertarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarListeners() {

        jcbNombreJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosJuegoSeleccionado();
            }
        });

        rdAaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarJuegosPorInicial('A', 'E');
            }
        });

        rdFaK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarJuegosPorInicial('F', 'K');
            }
        });

        rdLaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarJuegosPorInicial('L', 'P');
            }
        });

        rdQaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarJuegosPorInicial('Q', 'V');
            }
        });

        rdWaZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarJuegosPorInicial('W', 'Z');
            }
        });
        
    }

    private void btnEliminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarJuegoActionPerformed
        String nombre = (String) jcbNombreJuegos.getSelectedItem();
        Juegos juegos = new Juegos();
        if (nombre != null && !nombre.isEmpty()) {
            juegos.eliminarJuegoPorNombre(nombre);
            actualizarComboBoxes(); // Actualizar los JComboBox después de eliminar el juego
            // Limpiar la informacion del juego eliminado
            jcbConsolas.setSelectedIndex(0);
            jcbResena.setSelectedIndex(0);
            jSpinner1.setValue(1);
            lblImagen.setIcon(null);
            lblImagen.setText("Juego sin imagen");
            buttonGroup1.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un juego para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarJuegoActionPerformed

    private void actualizarComboBoxes() {
        DefaultComboBoxModel<String> modelNombres = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> modelResenas = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> modelConsolas = new DefaultComboBoxModel<>();

        for (String[] juego : Juegos.juegosNombres) {
            if (juego.length > 1) {
                modelNombres.addElement(juego[1]);
            }
            if (juego.length > 2) {
                modelResenas.addElement(juego[2]);
            }
            if (juego.length > 0) {
                modelConsolas.addElement(juego[0]);
            }
        }

        jcbNombreJuegos.setModel(modelNombres);
        jcbResena.setModel(modelResenas);
        jcbConsolas.setModel(modelConsolas);
    }

    private void filtrarJuegosPorInicial(char inicio, char fin) {
        Juegos juegos = new Juegos();
        TreeSet<String> nombresFiltrados = new TreeSet<>();
        for (String[] juego : juegos.juegosNombres) {
            if (juego.length > 1) {
                char inicial = Character.toUpperCase(juego[1].charAt(0));
                if (inicial >= inicio && inicial <= fin) {
                    nombresFiltrados.add(juego[1]);
                }
            }
        }
        actualizarComboBoxNombres(nombresFiltrados);
    }

    private void actualizarComboBoxNombres(TreeSet<String> nombresFiltrados) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String nombre : nombresFiltrados) {
            model.addElement(nombre);
        }
        jcbNombreJuegos.setModel(model);
    }

    public void cargarJuegosNombresYDatos() {
        Juegos juegos = new Juegos();
        Juegos.cargarDatosEnComboBox(jcbNombreJuegos, jcbResena, jcbConsolas);

    }

    private void cargarDatosJuegoSeleccionado() {
        String nombreSeleccionado = (String) jcbNombreJuegos.getSelectedItem();
        Juegos juegos = new Juegos();
        String[] datosJuego = juegos.obtenerDatosJuegoPorNombre(nombreSeleccionado);

        if (datosJuego != null) {
            jcbConsolas.setSelectedItem(datosJuego[0]);
            jcbResena.setSelectedItem(datosJuego[1]);
            jSpinner1.setValue(Integer.parseInt(datosJuego[2]));

            rutaImagen = datosJuego.length > 3 ? datosJuego[3] : null;
            if (rutaImagen != null && !rutaImagen.isEmpty()) {
                // Ajustar la ruta de la imagen para buscar en el directorio adecuado
                File file = new File("src/resources/imagenes/" + rutaImagen);
                if (!file.exists()) {
                    lblImagen.setText("Error: Archivo no encontrado");
                    lblImagen.setIcon(null);
                    return;
                }

                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    if (bufferedImage != null) {
                        ImageIcon imagenIcon = new ImageIcon(bufferedImage);
                        lblImagen.setIcon(imagenIcon);
                        lblImagen.setText(""); // Limpiar texto si se carga la imagen
                        lblImagen.revalidate();
                        lblImagen.repaint();
                    } else {
                        lblImagen.setText("Error al cargar la imagen");
                        lblImagen.setIcon(null);
                    }
                } catch (Exception e) {
                    lblImagen.setText("Error al cargar la imagen");
                    lblImagen.setIcon(null);
                    JOptionPane.showMessageDialog(null, "Error al cargar la imagen");
                }
            } else {
                lblImagen.setText("Juego sin imagen");
                lblImagen.setIcon(null);
            }
        }
    }
    private void jcbConsolasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbConsolasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbConsolasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EliminarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EliminarJuego dialog = new EliminarJuego(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarJuego;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox<String> jcbConsolas;
    private javax.swing.JComboBox<String> jcbNombreJuegos;
    private javax.swing.JComboBox<String> jcbResena;
    private javax.swing.JLabel lblConsola;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblResena;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelInsertarJuego;
    private javax.swing.JRadioButton rdAaE;
    private javax.swing.JRadioButton rdFaK;
    private javax.swing.JRadioButton rdLaP;
    private javax.swing.JRadioButton rdQaV;
    private javax.swing.JRadioButton rdWaZ;
    // End of variables declaration//GEN-END:variables
}
