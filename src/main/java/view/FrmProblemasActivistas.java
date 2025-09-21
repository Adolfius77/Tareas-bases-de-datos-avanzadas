/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import Controller.ProblemaActivistaController;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class FrmProblemasActivistas extends javax.swing.JPanel {

    private ProblemaActivistaController problemaActivistaController;

    /**
     * Creates new form FrmProblemasActivistas
     */
    public FrmProblemasActivistas() {
        initComponents();
        problemaActivistaController = new ProblemaActivistaController();

    }

    private void limpiarCampos() {
        txtIDProblema.setText("");
        txtIDActivista.setText("");
        btnGuardar.setText("GUARDAR");
        btnEliminar.setVisible(false);
    }

    private void cargarProblemasActivistas() {
        tablaActivistas.setModel(problemaActivistaController.obtenerTablaActivistasProblemas());
    }

    private void guardarProblemaActivista() {
        try {
            String idActivistaStr = txtIDActivista.getText();
            String idProblemaStr = txtIDProblema.getText();

            if (idActivistaStr.isEmpty() || idProblemaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son necesarios", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idActivista = Integer.parseInt(idActivistaStr);
            int idProblema = Integer.parseInt(idProblemaStr);

            if (btnGuardar.getText().equals("GUARDAR")) {
                boolean exito = problemaActivistaController.asignarAtivista(idProblema, idActivista);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Asignación guardada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    limpiarCampos();
                    cargarProblemasActivistas();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la asignación.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Error: Los IDs deben ser números válidos. " + e.getMessage(), "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatos() {
        int fila = tablaActivistas.getSelectedRow();
        if (fila >= 0) {
            txtIDActivista.setText(tablaActivistas.getValueAt(fila, 0).toString());
            txtIDProblema.setText(tablaActivistas.getValueAt(fila, 1).toString());

            btnGuardar.setText("ACTUALIZAR");
            btnEliminar.setVisible(true);
        }
    }

    private void eliminarAsignacion() {
        try {

            int filaSeleccionada = tablaActivistas.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una asignación de la tabla para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idProblema = Integer.parseInt(tablaActivistas.getValueAt(filaSeleccionada, 0).toString());
            int idActivista = Integer.parseInt(tablaActivistas.getValueAt(filaSeleccionada, 2).toString());

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar esta asignacion?",
                    "Confirmar eliminacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean exito = problemaActivistaController.eliminarAsignacion(idProblema, idActivista);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Asignacion eliminada correctamente.");
                    cargarProblemasActivistas();

                } else {
                    JOptionPane.showMessageDialog(this,
                            "Ocurrió un error al eliminar la asignacion.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El ID seleccionado no es un numero valido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscar() {
        String filtro = txtBuscar.getText().trim();
        tablaActivistas.setModel(problemaActivistaController.obtenerTablaAsignacionesPorFiltro(filtro));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFchFin = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDActivista = new javax.swing.JTextField();
        txtIDProblema = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tablaActivistas = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("TELEFONO:");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("fecha ingreso");

        txtFchFin.setBackground(new java.awt.Color(255, 255, 255));
        txtFchFin.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID ACTIVISTA:");

        txtIDActivista.setBackground(new java.awt.Color(255, 255, 255));
        txtIDActivista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActivistaActionPerformed(evt);
            }
        });

        txtIDProblema.setBackground(new java.awt.Color(255, 255, 255));
        txtIDProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDProblemaActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID PROBLEMA");

        tablaActivistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaActivistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaActivistasMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaActivistas);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Buscar");

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

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDActivista, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtIDProblema)))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addComponent(txtBuscar))
                    .addComponent(jLabel7))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDActivista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIDProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnGuardar)
                        .addGap(26, 26, 26)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActivistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActivistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActivistaActionPerformed

    private void txtIDProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDProblemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDProblemaActionPerformed

    private void tablaActivistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaActivistasMouseClicked
        cargarDatos();
    }//GEN-LAST:event_tablaActivistasMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        buscar();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarProblemaActivista();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarAsignacion();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaActivistas;
    private javax.swing.JTextField txtBuscar;
    private com.toedter.calendar.JDateChooser txtFchFin;
    private javax.swing.JTextField txtIDActivista;
    private javax.swing.JTextField txtIDProblema;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
