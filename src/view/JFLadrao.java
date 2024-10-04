/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ladrao;
import servicos.LadraoServicos;
import servicos.ServicosFactory;

/**
 *
 * @author 182310065
 */
public class JFLadrao extends javax.swing.JFrame {

    int idEdit;

    /**
     * Creates new form JFLadrao
     */
    public JFLadrao() {
        initComponents();
        addRowToTable();
        jbEditarLadrao.setVisible(false);
        jbDeletarLadrao.setVisible(false);
    }

    private void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) jtLadrao.getModel();
        model.getDataVector().removeAllElements(); 
        model.fireTableDataChanged();
        Object rowData[] = new Object[6];
        LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
        for (Ladrao ladrao : ladraoS.listaLadroes()) {
            rowData[0] = ladrao.getId();
            rowData[1] = ladrao.getNome();
            rowData[2] = ladrao.getOlho();
            rowData[3] = ladrao.isSexo() == false ? "FEMININO" : "MASCULINO"; 
            rowData[4] = ladrao.getPontosDeVida();
            rowData[5] = ladrao.getPlanoDeFuga();
            model.addRow(rowData);
        }
    }//fim addRowToTable
    
    private void limpaCampos() {
        jtfNomeLadrao.setText("");
        jtfCabeloLadrao.setText("");
        jtfOlhoLadrao.setText("");
        jtfPeleLadrao.setText("");
        jtfPlanoDeFugaLadrao.setText("");
        bgSexoLadrao.clearSelection();
        jtfNomeLadrao.requestFocus();
    }
    
        private boolean validaInputs() {
        if (jtfNomeLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher o nome");
            jtfNomeLadrao.requestFocus();
            return false;
        }
        if (jtfCabeloLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher o cabelo");
            jtfCabeloLadrao.requestFocus();
            return false;
        }
        if (jtfOlhoLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher o olho");
            jtfOlhoLadrao.requestFocus();
            return false;
        }
        if (jtfPeleLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher a pele");
            jtfPeleLadrao.requestFocus();
            return false;
        }
        if (jtfPlanoDeFugaLadrao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher o armamento");
            jtfPlanoDeFugaLadrao.requestFocus();
            return false;
        }
        if (!jrbFemininoLadrao.isSelected() && !jrbMasculinoLadrao.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecionar sexo");
            return false;
        }
        return true;
    }

    private void jbDefault() {
        jbSalvarLadrao.setText("Salvar");
        jbDeletarLadrao.setText("Deletar");
        jlSexoLadrao.setVisible(true);
        jrbFemininoLadrao.setVisible(true);
        jrbMasculinoLadrao.setVisible(true);
        jbEditarLadrao.setVisible(false);
        jbDeletarLadrao.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexoLadrao = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jbEditarLadrao = new javax.swing.JButton();
        jtfPeleLadrao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jrbFemininoLadrao = new javax.swing.JRadioButton();
        jtfPlanoDeFugaLadrao = new javax.swing.JTextField();
        jrbMasculinoLadrao = new javax.swing.JRadioButton();
        jlSexoLadrao = new javax.swing.JLabel();
        jbSalvarLadrao = new javax.swing.JButton();
        jbLimparLadrao = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLadrao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeLadrao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCabeloLadrao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfOlhoLadrao = new javax.swing.JTextField();
        jbDeletarLadrao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("Pele:");

        jbEditarLadrao.setBackground(new java.awt.Color(204, 204, 255));
        jbEditarLadrao.setForeground(new java.awt.Color(102, 102, 255));
        jbEditarLadrao.setText("Editar");
        jbEditarLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarLadraoActionPerformed(evt);
            }
        });

        jtfPeleLadrao.setToolTipText("Informe a cor de pele do ladrão.");

        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("Plano de fuga:");

        bgSexoLadrao.add(jrbFemininoLadrao);
        jrbFemininoLadrao.setForeground(new java.awt.Color(153, 153, 255));
        jrbFemininoLadrao.setText("Feminino");

        jtfPlanoDeFugaLadrao.setToolTipText("Informe a cor de pele do ladrão.");

        bgSexoLadrao.add(jrbMasculinoLadrao);
        jrbMasculinoLadrao.setForeground(new java.awt.Color(153, 153, 255));
        jrbMasculinoLadrao.setText("Masculino");

        jlSexoLadrao.setForeground(new java.awt.Color(153, 153, 255));
        jlSexoLadrao.setText("Sexo:");

        jbSalvarLadrao.setBackground(new java.awt.Color(204, 204, 255));
        jbSalvarLadrao.setForeground(new java.awt.Color(102, 102, 255));
        jbSalvarLadrao.setText("Salvar");
        jbSalvarLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarLadraoActionPerformed(evt);
            }
        });

        jbLimparLadrao.setBackground(new java.awt.Color(204, 204, 255));
        jbLimparLadrao.setForeground(new java.awt.Color(102, 102, 255));
        jbLimparLadrao.setText("Limpar");
        jbLimparLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparLadraoActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 255));

        jtLadrao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jtLadrao.setForeground(new java.awt.Color(153, 153, 255));
        jtLadrao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Olho", "Sexo", "HP", "Plano de Fuga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLadrao.setGridColor(new java.awt.Color(204, 204, 255));
        jtLadrao.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jtLadrao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLadraoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLadrao);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Ladrão");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 255));

        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Nome:");

        jtfNomeLadrao.setToolTipText("Informe o nome do ladrão.");
        jtfNomeLadrao.setName(""); // NOI18N

        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Cabelo:");

        jtfCabeloLadrao.setToolTipText("Informe a cor do cabelo do ladrão.");

        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("Olho:");

        jtfOlhoLadrao.setToolTipText("Informe a cor do olho do ladrão.");

        jbDeletarLadrao.setBackground(new java.awt.Color(204, 204, 255));
        jbDeletarLadrao.setForeground(new java.awt.Color(102, 102, 255));
        jbDeletarLadrao.setText("Deletar");
        jbDeletarLadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarLadraoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfNomeLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtfPeleLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtfCabeloLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtfPlanoDeFugaLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jlSexoLadrao))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(jtfOlhoLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jrbMasculinoLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jrbFemininoLadrao))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbSalvarLadrao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbLimparLadrao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbEditarLadrao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbDeletarLadrao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomeLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCabeloLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfOlhoLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfPeleLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSexoLadrao)
                    .addComponent(jrbFemininoLadrao))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMasculinoLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPlanoDeFugaLadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDeletarLadrao)
                    .addComponent(jbEditarLadrao)
                    .addComponent(jbLimparLadrao)
                    .addComponent(jbSalvarLadrao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditarLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarLadraoActionPerformed
        // TODO add your handling code here:
        jbLimparLadrao.setEnabled(false);
        jbSalvarLadrao.setText("Atualizar");
        jbDeletarLadrao.setText("Cancelar");
        jrbFemininoLadrao.setVisible(false);
        jrbMasculinoLadrao.setVisible(false);
        jlSexoLadrao.setVisible(false);

        //buscar vítima e carregar nos campos
        int linha = jtLadrao.getSelectedRow();
        idEdit = (int) jtLadrao.getValueAt(linha, 0);
        LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
        Ladrao ladrao = ladraoS.getLadraoById(idEdit);
        //carrega na tela
        jtfNomeLadrao.setText(ladrao.getNome());
        jtfOlhoLadrao.setText(ladrao.getOlho());
        jtfCabeloLadrao.setText(ladrao.getCabelo());
        jtfPeleLadrao.setText(ladrao.getPele());
        jtfPlanoDeFugaLadrao.setText(ladrao.getPlanoDeFuga());
    }//GEN-LAST:event_jbEditarLadraoActionPerformed

    private void jbSalvarLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarLadraoActionPerformed
        // TODO add your handling code here:
        if (jbSalvarLadrao.getText().equals("Salvar")) {
            if (validaInputs()) {
                Ladrao l = new Ladrao();
                l.setNome(jtfNomeLadrao.getText().toUpperCase());
                l.setOlho(jtfOlhoLadrao.getText().toUpperCase());
                l.setCabelo(jtfCabeloLadrao.getText().toUpperCase());
                l.setPele(jtfPeleLadrao.getText().toUpperCase());
                l.setPlanoDeFuga(jtfPlanoDeFugaLadrao.getText().toUpperCase());
                if (jrbFemininoLadrao.isSelected() || jrbMasculinoLadrao.isSelected()) {
                    l.setSexo(!jrbFemininoLadrao.isSelected());
                }
                LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
                ladraoS.cadastrarLadrao(l);
                addRowToTable();
                limpaCampos();
            }
        }//fim da condição de salvar
        else {
            Ladrao lad = new Ladrao();
            lad.setId(idEdit);
            lad.setNome(jtfNomeLadrao.getText());
            lad.setOlho(jtfOlhoLadrao.getText());
            lad.setCabelo(jtfCabeloLadrao.getText());
            lad.setPele(jtfPeleLadrao.getText());
            lad.setPlanoDeFuga(jtfPlanoDeFugaLadrao.getText());
            LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
            ladraoS.atualizarLadrao(lad);
            addRowToTable();
            JOptionPane.showMessageDialog(this, "Ladrão atualizado com sucesso!");
            jbDefault();
            limpaCampos();
        }//fim da condição de atualizar
    }//GEN-LAST:event_jbSalvarLadraoActionPerformed

    private void jbLimparLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparLadraoActionPerformed
        // TODO add your handling code here:
        limpaCampos();
    }//GEN-LAST:event_jbLimparLadraoActionPerformed

    private void jtLadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLadraoMouseClicked
        // TODO add your handling code here:
        jbEditarLadrao.setVisible(true);
        jbDeletarLadrao.setVisible(true);
    }//GEN-LAST:event_jtLadraoMouseClicked

    private void jbDeletarLadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarLadraoActionPerformed
        // TODO add your handling code here:
        if (jbDeletarLadrao.getText().equals("Deletar")) {
            int linha = jtLadrao.getSelectedRow();
            int id = (int) jtLadrao.getValueAt(linha, 0);
            String nome = (String) jtLadrao.getValueAt(linha, 1);
            Object[] btnMSG = {"Sim", "Não"};
            int resp = JOptionPane.showOptionDialog(this,
                    "Deseja realmente deletar " + nome,
                    ".: Deletar :.",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null, btnMSG, btnMSG[0]);
            if (resp == 0) {
                LadraoServicos ladraoS = ServicosFactory.getLadraoServicos();
                ladraoS.deletarLadrao(id);
                addRowToTable();
                JOptionPane.showMessageDialog(this, "Ladrão " + nome + " deletada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Ok, delete cancelado pelo usuário.");
            }
            jbEditarLadrao.setVisible(false);
            jbDeletarLadrao.setVisible(false);
        }//fim da condição de deletar
        else {
            limpaCampos();
            jbDefault();
        }
    }//GEN-LAST:event_jbDeletarLadraoActionPerformed

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
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLadrao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexoLadrao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbDeletarLadrao;
    private javax.swing.JButton jbEditarLadrao;
    private javax.swing.JButton jbLimparLadrao;
    private javax.swing.JButton jbSalvarLadrao;
    private javax.swing.JLabel jlSexoLadrao;
    private javax.swing.JRadioButton jrbFemininoLadrao;
    private javax.swing.JRadioButton jrbMasculinoLadrao;
    private javax.swing.JTable jtLadrao;
    private javax.swing.JTextField jtfCabeloLadrao;
    private javax.swing.JTextField jtfNomeLadrao;
    private javax.swing.JTextField jtfOlhoLadrao;
    private javax.swing.JTextField jtfPeleLadrao;
    private javax.swing.JTextField jtfPlanoDeFugaLadrao;
    // End of variables declaration//GEN-END:variables
}
