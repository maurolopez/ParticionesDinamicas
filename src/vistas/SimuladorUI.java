package vistas;

import controladores.Controlador;
import javax.swing.JOptionPane;
import modelo.*;
import particionesdinamicas.ParticionesDinamicas;

/**
 *
 * @author Mauro Federico Lopez
 */
public class SimuladorUI extends javax.swing.JPanel {

    private Controlador controlador;
    private Estrategia estrategiaSeleccionParticion;

    /**
     * Creates new form SimuladorUI
     */
    public SimuladorUI() {
        initComponents();
        this.controlador = ParticionesDinamicas.getControlador();
        grupoBotones.add(botonFirstFit);
        grupoBotones.add(botonNextFit);
        grupoBotones.add(botonBestFit);
        grupoBotones.add(botonWorstFit);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botonSimular = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonFirstFit = new javax.swing.JRadioButton();
        botonNextFit = new javax.swing.JRadioButton();
        botonBestFit = new javax.swing.JRadioButton();
        botonWorstFit = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTamañoMemoriaFisicaDisponible = new javax.swing.JTextField();
        campoTiempoSeleccionParticion = new javax.swing.JTextField();
        campoTiempoCargaPromedio = new javax.swing.JTextField();
        campoTiempoLiberacionParticion = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(550, 300));
        setMinimumSize(new java.awt.Dimension(550, 300));
        setPreferredSize(new java.awt.Dimension(550, 300));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos del Simulador");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        botonSimular.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botonSimular.setText("Simular Tanda");
        botonSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSimularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(453, Short.MAX_VALUE)
                .addComponent(botonSimular))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonSimular))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Tamaño de memoria física disponible [kb]");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Estrategia de selección de particiones");

        botonFirstFit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botonFirstFit.setText("First-Fit");
        botonFirstFit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFirstFitActionPerformed(evt);
            }
        });

        botonNextFit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botonNextFit.setText("Next-Fit");
        botonNextFit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNextFitActionPerformed(evt);
            }
        });

        botonBestFit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botonBestFit.setText("Best-Fit");
        botonBestFit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBestFitActionPerformed(evt);
            }
        });

        botonWorstFit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botonWorstFit.setText("Worst-Fit");
        botonWorstFit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonWorstFitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Tiempo de selección de partición [seg]");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Tiempo de carga promedio [seg]");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Tiempo de liberación de partición [seg]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonNextFit)
                            .addComponent(botonFirstFit)
                            .addComponent(botonBestFit)
                            .addComponent(botonWorstFit)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoTamañoMemoriaFisicaDisponible)
                    .addComponent(campoTiempoSeleccionParticion)
                    .addComponent(campoTiempoCargaPromedio)
                    .addComponent(campoTiempoLiberacionParticion, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTamañoMemoriaFisicaDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonFirstFit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonNextFit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBestFit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonWorstFit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTiempoSeleccionParticion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTiempoCargaPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoTiempoLiberacionParticion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSimularActionPerformed
        try {
            String tamañoMemoriaFisica = campoTamañoMemoriaFisicaDisponible.getText();
            String tiempoSeleccionParticion = campoTiempoSeleccionParticion.getText();
            String tiempoCargaPromedio = campoTiempoCargaPromedio.getText();
            String tiempoLiberacionParticion = campoTiempoLiberacionParticion.getText();
            controlador.cargarDatosSimulador(tamañoMemoriaFisica, tiempoSeleccionParticion, tiempoCargaPromedio, tiempoLiberacionParticion, estrategiaSeleccionParticion);
            controlador.iniciarSimulacion();
            controlador.iniciarVentanaResultado();
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null,
                    "Los datos ingresados no son numéricos.",
                    "Error Numérico",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException nullPointerException) {
            JOptionPane.showMessageDialog(null,
                    "Ingrese todos los datos correctamente.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonSimularActionPerformed

    private void botonFirstFitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFirstFitActionPerformed
        this.estrategiaSeleccionParticion = new FirstFit();
    }//GEN-LAST:event_botonFirstFitActionPerformed

    private void botonNextFitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNextFitActionPerformed
        this.estrategiaSeleccionParticion = new NextFit();
    }//GEN-LAST:event_botonNextFitActionPerformed

    private void botonBestFitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBestFitActionPerformed
        this.estrategiaSeleccionParticion = new BestFit();
    }//GEN-LAST:event_botonBestFitActionPerformed

    private void botonWorstFitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonWorstFitActionPerformed
        this.estrategiaSeleccionParticion = new WorstFit();
    }//GEN-LAST:event_botonWorstFitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonBestFit;
    private javax.swing.JRadioButton botonFirstFit;
    private javax.swing.JRadioButton botonNextFit;
    private javax.swing.JButton botonSimular;
    private javax.swing.JRadioButton botonWorstFit;
    private javax.swing.JTextField campoTamañoMemoriaFisicaDisponible;
    private javax.swing.JTextField campoTiempoCargaPromedio;
    private javax.swing.JTextField campoTiempoLiberacionParticion;
    private javax.swing.JTextField campoTiempoSeleccionParticion;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
