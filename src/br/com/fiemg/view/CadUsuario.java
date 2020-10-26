/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiemg.view;

import br.com.fiemg.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus
 */
public class CadUsuario extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public CadUsuario() {
        initComponents();
        con = Conexao.conectar();
        desabilitarCampos();

    }

    private void consultar() {
        //comando para consultar o banco
        String sql = "Select * from usuario where id = ?";
        try {
            //envia a consulta para o banco
            pst = con.prepareStatement(sql);
            //seta o valor de ID para o primeiro indice do comando
            pst.setString(1, txtCadId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtCadNome.setText(rs.getString(2));
                txtCadLogin.setText(rs.getString(3));
                txtCadSenha.setText(rs.getString(4));
                cbCadPerfil.setSelectedItem(rs.getString(5));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void inserir() {
        String sql = "Insert into usuario (nome, login, senha, perfil) values (?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtCadNome.getText());
            pst.setString(2, txtCadLogin.getText());
            pst.setString(3, txtCadSenha.getText());
            pst.setString(4, cbCadPerfil.getSelectedItem().toString());
            int op = pst.executeUpdate();
            if (op > 0) {
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void editar() {
        String sql = "update usuario set nome = ?, login = ?, senha = ?, perfil = ? where id = ? ";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtCadNome.getText());
            pst.setString(2, txtCadLogin.getText());
            pst.setString(3, txtCadSenha.getText());
            pst.setString(4, cbCadPerfil.getSelectedItem().toString());
            pst.setString(5, txtCadId.getText());
            int op = pst.executeUpdate();
            if (op > 0) {
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir() {
        String sql = "Delete from usuario where id = ?";
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, txtCadId.getText());
                int op = pst.executeUpdate();
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCadId = new javax.swing.JTextField();
        txtCadNome = new javax.swing.JTextField();
        txtCadLogin = new javax.swing.JTextField();
        txtCadSenha = new javax.swing.JTextField();
        cbCadPerfil = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCadNovo = new javax.swing.JButton();
        btnCadPesquisar = new javax.swing.JButton();
        btnCadEditar = new javax.swing.JButton();
        btnCadExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Usuário");
        setPreferredSize(new java.awt.Dimension(430, 280));

        jLabel4.setText("Senha:");

        jLabel5.setText("Perfil:");

        cbCadPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuário" }));

        jLabel1.setText("Id:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Login:");

        btnCadNovo.setText("Novo");
        btnCadNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadNovoActionPerformed(evt);
            }
        });

        btnCadPesquisar.setText("Pesquisar");
        btnCadPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPesquisarActionPerformed(evt);
            }
        });

        btnCadEditar.setText("Editar");
        btnCadEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadEditarActionPerformed(evt);
            }
        });

        btnCadExcluir.setText("Excluir");
        btnCadExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbCadPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCadNome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCadId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtCadLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCadNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCadLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbCadPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadNovo)
                    .addComponent(btnCadPesquisar)
                    .addComponent(btnCadEditar)
                    .addComponent(btnCadExcluir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPesquisarActionPerformed
        consultar();
    }//GEN-LAST:event_btnCadPesquisarActionPerformed

    private void btnCadNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadNovoActionPerformed
        inserir();
    }//GEN-LAST:event_btnCadNovoActionPerformed

    private void btnCadEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnCadEditarActionPerformed

    private void btnCadExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnCadExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadEditar;
    private javax.swing.JButton btnCadExcluir;
    private javax.swing.JButton btnCadNovo;
    private javax.swing.JButton btnCadPesquisar;
    private javax.swing.JComboBox<String> cbCadPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCadId;
    private javax.swing.JTextField txtCadLogin;
    private javax.swing.JTextField txtCadNome;
    private javax.swing.JTextField txtCadSenha;
    // End of variables declaration//GEN-END:variables

    private void desabilitarCampos() {
        txtCadNome.setText(null);
        txtCadLogin.setText(null);
        txtCadSenha.setText(null);
        cbCadPerfil.setSelectedItem(null);
    }
}
