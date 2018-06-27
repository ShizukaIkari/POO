/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.cartao.Cartao;
import modelo.pagamento.Tarifa;
import modelo.usuario.Usuario;
import persistencia.transpoint.PersistenciaCartao;
import persistencia.transpoint.PersistenciaTarifa;

/**
 *
 * @author Serenna
 */
public class UITranspoint extends javax.swing.JFrame {

    
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    private void atualizaTabela(Usuario u){
        DefaultTableModel tableCards = (DefaultTableModel) tabelaCartoes.getModel();
        tableCards.getDataVector().removeAllElements();
        tableCards.fireTableDataChanged();
        PersistenciaCartao persCard = new PersistenciaCartao();
        ArrayList<Cartao> cartoes = null;
        try{
            cartoes = persCard.recuperaCartoesUsuario(u);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        for (Cartao card: cartoes){
            
            String disponibilidade;
            if(card.isDisponivel()){
                disponibilidade="Disponível";
            }
            else{
                disponibilidade="Indisponível";
            }
            tableCards.addRow(new Object[] {
                card.getCodigo(),
                card.getCategoria().getTipo(),
                card.getSaldo(),
                disponibilidade
                    
            });
        }
        
    }
    
        
    /**
     * Creates new form UITranspoint
     */
    public UITranspoint(Usuario user) {
        this.user = user;
        initComponents();
        nomeUser.setText(user.nome); //mostrando o nome do usuário na tela
        atualizaTabela(user);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelGreetings = new javax.swing.JLabel();
        nomeUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCartoes = new javax.swing.JTable();
        jbRecarga = new javax.swing.JButton();
        jbBloqueio = new javax.swing.JButton();
        lblCartoes = new javax.swing.JLabel();
        jbTarifa = new javax.swing.JButton();
        menuOpcoes = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jmTrocaSenha = new javax.swing.JMenuItem();
        jmHistorico = new javax.swing.JMenuItem();
        jmLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelGreetings.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelGreetings.setText("Olá,");

        nomeUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tabelaCartoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Saldo", "Disponibilidade"
            }
        ));
        jScrollPane1.setViewportView(tabelaCartoes);

        jbRecarga.setText("Recarregar");
        jbRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecargaActionPerformed(evt);
            }
        });

        jbBloqueio.setText("Solicitar Bloqueio");
        jbBloqueio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBloqueioActionPerformed(evt);
            }
        });

        lblCartoes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCartoes.setText("Cartões Cadastrados:");

        jbTarifa.setText("Pagar Passagem");
        jbTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTarifaActionPerformed(evt);
            }
        });

        jMenu2.setText("Opções");

        jmTrocaSenha.setText("Trocar Senha");
        jmTrocaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTrocaSenhaActionPerformed(evt);
            }
        });
        jMenu2.add(jmTrocaSenha);

        jmHistorico.setText("Exibir Histórico");
        jmHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHistoricoActionPerformed(evt);
            }
        });
        jMenu2.add(jmHistorico);

        jmLogout.setText("Sair");
        jmLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLogoutActionPerformed(evt);
            }
        });
        jMenu2.add(jmLogout);

        menuOpcoes.add(jMenu2);

        setJMenuBar(menuOpcoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelGreetings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCartoes, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbRecarga, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbBloqueio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGreetings)
                    .addComponent(nomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(lblCartoes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRecarga)
                    .addComponent(jbBloqueio)
                    .addComponent(jbTarifa))
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecargaActionPerformed
        int iRow = tabelaCartoes.getSelectedRow(); //indice da linha
        
        if(iRow != -1){
            String codigo = tabelaCartoes.getValueAt(iRow, 0)+""; //gambiarra admito
            int cod = Integer.parseInt(codigo);
            UIRecarga recharge = new UIRecarga(cod);
            recharge.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um cartão.");
            return;
        }
        
    }//GEN-LAST:event_jbRecargaActionPerformed

    private void jbBloqueioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBloqueioActionPerformed
        int iRow = tabelaCartoes.getSelectedRow(); //indice da linha
        if (iRow!=-1){
            String codigo = tabelaCartoes.getValueAt(iRow, 0)+""; 
            int cod = Integer.parseInt(codigo);

            UIBloqueioCartao block = new UIBloqueioCartao(cod);
            block.setVisible(true);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(rootPane, "Selecione um cartão.");
            
            return;
        }
        
    }//GEN-LAST:event_jbBloqueioActionPerformed

    private void jmHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHistoricoActionPerformed
        HistoricoUsuario histUser = new HistoricoUsuario(this.user);
        histUser.setVisible(true);
    }//GEN-LAST:event_jmHistoricoActionPerformed

    private void jmLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLogoutActionPerformed
        TelaInicial inicial = new TelaInicial();
        inicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmLogoutActionPerformed

    private void jmTrocaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTrocaSenhaActionPerformed
        UITrocarSenha change = new UITrocarSenha(user);
        change.setVisible(true);
    }//GEN-LAST:event_jmTrocaSenhaActionPerformed

    private void jbTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTarifaActionPerformed
       int iRow = tabelaCartoes.getSelectedRow(); //indice da linha
        
        if(iRow != -1){
            JOptionPane.showMessageDialog(rootPane, "Estou mexendo, relaxa");
            /*
            String codigo = tabelaCartoes.getValueAt(iRow, 0)+""; //gambiarra admito
            int cod = Integer.parseInt(codigo);
            */
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um cartão.");
            return;
        }
    }//GEN-LAST:event_jbTarifaActionPerformed

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
            java.util.logging.Logger.getLogger(UITranspoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UITranspoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UITranspoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UITranspoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Usuario exibU = new Usuario();
        exibU.setNome("Test User");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UITranspoint(exibU).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBloqueio;
    private javax.swing.JButton jbRecarga;
    private javax.swing.JButton jbTarifa;
    private javax.swing.JMenuItem jmHistorico;
    private javax.swing.JMenuItem jmLogout;
    private javax.swing.JMenuItem jmTrocaSenha;
    private javax.swing.JLabel labelGreetings;
    private javax.swing.JLabel lblCartoes;
    private javax.swing.JMenuBar menuOpcoes;
    private javax.swing.JLabel nomeUser;
    private javax.swing.JTable tabelaCartoes;
    // End of variables declaration//GEN-END:variables
}
