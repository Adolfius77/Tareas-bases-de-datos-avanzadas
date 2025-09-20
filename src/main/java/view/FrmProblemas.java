/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Controller.ActivistaController;
import Controller.ClienteController;
import Controller.ProblemaActivistaController;
import Controller.ProblemaController;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Activista;
import model.Cliente;

/**
 *
 * @author USER
 */
public class FrmProblemas extends javax.swing.JPanel {

    private Cliente cliente;
    private ClienteController clController;
    private ActivistaController acController;
    private ProblemaActivistaController paController;
    private ProblemaController pController;
    private Activista activista;

    public FrmProblemas() {
        initComponents();
        initComponents();
        clController = new ClienteController();
        acController = new ActivistaController();
        pController = new ProblemaController();
        paController = new ProblemaActivistaController();
        cargarProblemas();
    }

    private void cargarProblemas() {
        this.tblProblemas.setModel(pController.obtenerTablaProblemas());
    }

    private void limpiarCampos() {
        txtID.setText("0");
        txtDesc.setText("");
        txtFchInicio.setDate(null);
        txtFchFin.setDate(null);
        cmbEstado.setSelectedItem(1);
        txtCliente.setText("");
        btnGuardar.setText("GUARDAR");
    }

    private void cargarDatos() {
        int fila = tblProblemas.getSelectedRow();
        if (fila >= 0) {
            String id = tblProblemas.getValueAt(fila, 0).toString();
            txtID.setText(id);
            txtDesc.setText(tblProblemas.getValueAt(fila, 1).toString());
            cmbEstado.setSelectedItem(tblProblemas.getValueAt(fila, 2));
            txtFchInicio.setDate((java.util.Date) tblProblemas.getValueAt(fila, 3));
            txtFchFin.setDate((java.util.Date) tblProblemas.getValueAt(fila, 4));
            this.cliente = clController.obtenerCliente(Integer.parseInt(id));
            txtCliente.setText(this.cliente.getNombre());
            btnGuardar.setText("ACTUALIZAR");
        }
    }

    private void buscar() {
        int id = this.cliente.getIdCliente();
        if (id > 0) {
            tblProblemas.setModel(pController.obtenerTablaProblemas());
        } else {
            cargarProblemas();
        }
    }

    private void guardarProblema() {
        try {
            String descripcion = txtDesc.getText().trim();
            String estado = cmbEstado.getSelectedItem().toString().trim();

            
            java.util.Date fechaInicioUtil = txtFchInicio.getDate();
            java.util.Date fechaFinUtil = txtFchFin.getDate();

            
            if (descripcion.isEmpty() || fechaInicioUtil == null || this.cliente == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "La descripción, la fecha de inicio y el cliente son obligatorios.",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            java.sql.Date sqlDateInicio = new java.sql.Date(fechaInicioUtil.getTime());
            java.sql.Date sqlDateFin = null;
            if (fechaFinUtil != null) { 
                sqlDateFin = new java.sql.Date(fechaFinUtil.getTime());
            }

            if (btnGuardar.getText().equals("GUARDAR")) {
                boolean exito = pController.agregarProblema(sqlDateInicio, sqlDateFin, estado, this.cliente.getIdCliente(), descripcion);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Problema guardado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Ocurrió un error al guardar el problema.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                int id = Integer.parseInt(txtID.getText());

                boolean exito = pController.actualizarProblema(id, sqlDateInicio, sqlDateFin, estado, this.cliente.getIdCliente(), descripcion);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Problema actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Ocurrió un error al actualizar los datos del problema.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            
            cargarProblemas();
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblFchIni = new javax.swing.JLabel();
        lblFchFin = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        txtFchInicio = new com.toedter.calendar.JDateChooser();
        txtFchFin = new com.toedter.calendar.JDateChooser();
        cmbEstado = new javax.swing.JComboBox<>();
        btnClientes = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        scrlPanel = new javax.swing.JScrollPane();
        tblProblemas = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Administración de Problemas");

        lblID.setText("ID");

        lblDesc.setText("DESCRIPCIÓN");

        lblFchIni.setText("FECHA INICIO");

        lblFchFin.setText("FECHA FIN");

        lblEstado.setText("ESTADO");

        lblCliente.setText("CLIENTE");

        txtID.setEditable(false);
        txtID.setEnabled(false);

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Concluido", "Cancelado" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        btnClientes.setText("Buscar ");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblProblemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProblemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProblemasMouseClicked(evt);
            }
        });
        scrlPanel.setViewportView(tblProblemas);

        btnFiltrar.setText("Filtrar por Cliente");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        txtCliente.setEditable(false);
        txtCliente.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(123, 123, 123))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblFchIni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFchInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFchFin)
                                    .addComponent(lblEstado)
                                    .addComponent(lblCliente))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFchFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClientes))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDesc)
                                    .addComponent(lblID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(113, 113, 113)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblTitulo)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblID)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnFiltrar)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDesc))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFchIni)
                                    .addComponent(txtFchInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblFchFin))
                            .addComponent(txtFchFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCliente)
                                .addComponent(btnClientes))
                            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(scrlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        DlgBuscarClientes dlg = new DlgBuscarClientes(frame, true); // modal
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true); // esto bloquea hasta cerrar el diálogo

        // Después de cerrar, obtener el cliente seleccionado
        Integer idCliente = dlg.getClienteSeleccionado();
        if (idCliente != null) {
            this.cliente = clController.obtenerCliente(idCliente);
            txtCliente.setText(this.cliente.getNombre());
        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarProblema();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        DlgBuscarClientes dlg = new DlgBuscarClientes(frame, true); // modal
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true); // esto bloquea hasta cerrar el diálogo

        // Después de cerrar, obtener el cliente seleccionado
        Integer idCliente = dlg.getClienteSeleccionado();
        if (idCliente != null) {

        }  // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void tblProblemasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProblemasMouseClicked
        cargarDatos();
    }//GEN-LAST:event_tblProblemasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFchFin;
    private javax.swing.JLabel lblFchIni;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrlPanel;
    private javax.swing.JTable tblProblemas;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDesc;
    private com.toedter.calendar.JDateChooser txtFchFin;
    private com.toedter.calendar.JDateChooser txtFchInicio;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
