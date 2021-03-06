package vistas;

import controladores.Controlador;
import java.util.Observable;
import java.util.Observer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import particionesdinamicas.ParticionesDinamicas;

/**
 *
 * @author Mauro Federico Lopez
 */
public class EventosUI extends javax.swing.JPanel implements Observer {

    private Controlador controlador;

    /**
     * Creates new form EventosUI
     */
    public EventosUI() {
        initComponents();
        controlador = ParticionesDinamicas.getControlador();
        controlador.addObserver(this);
        slider.setMaximum(controlador.getInstanteFinal());
        slider.setMinimum(0);
        slider.setMajorTickSpacing(controlador.getInstanteFinal());
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                controlador.establecerEvento(slider.getValue());
            }
        });
        slider.setValue(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        botonNuevaSimulacion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        slider = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textoEvento = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jspTabla = new javax.swing.JScrollPane();
        tablaEventos = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(550, 300));
        setMinimumSize(new java.awt.Dimension(550, 300));
        setPreferredSize(new java.awt.Dimension(550, 300));
        setLayout(new java.awt.BorderLayout());

        botonNuevaSimulacion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botonNuevaSimulacion.setText("Nueva Simulación");
        botonNuevaSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaSimulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(botonNuevaSimulacion)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonNuevaSimulacion)
        );

        add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        slider.setForeground(new java.awt.Color(0, 0, 0));
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        jPanel4.add(slider, java.awt.BorderLayout.PAGE_END);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Evento ocurrido");

        textoEvento.setBackground(new java.awt.Color(255, 255, 255));
        textoEvento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textoEvento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoEvento.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Estado de las particiones");

        jspTabla.setName("jspTabla");

        tablaEventos.setModel(new vistas.ParticionTableModel());
        tablaEventos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaEventos.getTableHeader().setReorderingAllowed(false);
        jspTabla.setViewportView(tablaEventos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jspTabla))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevaSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaSimulacionActionPerformed
        getControlador().crearNuevaSimulacion();
        getControlador().iniciarVentanaProceso();
    }//GEN-LAST:event_botonNuevaSimulacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonNuevaSimulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jspTabla;
    private javax.swing.JSlider slider;
    private javax.swing.JTable tablaEventos;
    private javax.swing.JLabel textoEvento;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        textoEvento.setText(slider.getValue() + ": " +controlador.obtenerEvento());
        ((ParticionTableModel) tablaEventos.getModel()).setParticiones(controlador.obtenerPaticiones());
        slider.setToolTipText(String.valueOf(slider.getValue()));
        slider.setName(String.valueOf(slider.getValue()));
    }

    /**
     * @return the controlador
     */
    public Controlador getControlador() {
        return controlador;
    }

    /**
     * @param controlador the controlador to set
     */
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * @return the botonNuevaSimulacion
     */
    public javax.swing.JButton getBotonNuevaSimulacion() {
        return botonNuevaSimulacion;
    }

    /**
     * @param botonNuevaSimulacion the botonNuevaSimulacion to set
     */
    public void setBotonNuevaSimulacion(javax.swing.JButton botonNuevaSimulacion) {
        this.botonNuevaSimulacion = botonNuevaSimulacion;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jPanel2
     */
    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    /**
     * @return the jPanel4
     */
    public javax.swing.JPanel getjPanel4() {
        return jPanel4;
    }

    /**
     * @param jPanel4 the jPanel4 to set
     */
    public void setjPanel4(javax.swing.JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    /**
     * @return the jPanel5
     */
    public javax.swing.JPanel getjPanel5() {
        return jPanel5;
    }

    /**
     * @param jPanel5 the jPanel5 to set
     */
    public void setjPanel5(javax.swing.JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    /**
     * @return the jspTabla
     */
    public javax.swing.JScrollPane getJspTabla() {
        return jspTabla;
    }

    /**
     * @param jspTabla the jspTabla to set
     */
    public void setJspTabla(javax.swing.JScrollPane jspTabla) {
        this.jspTabla = jspTabla;
    }

    /**
     * @return the slider
     */
    public javax.swing.JSlider getSlider() {
        return slider;
    }

    /**
     * @param slider the slider to set
     */
    public void setSlider(javax.swing.JSlider slider) {
        this.slider = slider;
    }

    /**
     * @return the tablaEventos
     */
    public javax.swing.JTable getTablaEventos() {
        return tablaEventos;
    }

    /**
     * @param tablaEventos the tablaEventos to set
     */
    public void setTablaEventos(javax.swing.JTable tablaEventos) {
        this.tablaEventos = tablaEventos;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the textoEvento
     */
    public javax.swing.JLabel getTextoEvento() {
        return textoEvento;
    }

    /**
     * @param textoEvento the textoEvento to set
     */
    public void setTextoEvento(javax.swing.JLabel textoEvento) {
        this.textoEvento = textoEvento;
    }
}
