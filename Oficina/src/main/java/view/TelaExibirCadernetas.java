/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CadernetaController;
import controller.VendaController;
import helpers.Helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Caderneta;
import models.Peca;
import models.Servico;
import models.Venda;

/**
 *
 * @author rmb
 */
public class TelaExibirCadernetas extends javax.swing.JFrame {
    private final DefaultTableModel tabelaCaderneta;
    private ArrayList<Caderneta> cadernetas;
    private CadernetaController cadernetaController;
    /**
     * Creates new form TelaExibirVendas
     */
    public TelaExibirCadernetas() throws IOException, ClassNotFoundException {
        initComponents();
        tabelaCaderneta = (DefaultTableModel) jtCaderneta.getModel();
        
        radioCpf.setSelected(true);
        
        cadernetaController = new CadernetaController();
        
        cadernetas = cadernetaController.getCadernetas();
        if(cadernetas != null){
            listarCadernetas();
        }
        
    }
    
    private void listarCadernetas(){
        int tamanho = tabelaCaderneta.getRowCount();
        for(int i=0; i<tamanho; i++){
            tabelaCaderneta.removeRow(0);
        }

        for(Caderneta caderneta : cadernetas){
            String cpf = caderneta.getCliente().getCpf();
            String nome = caderneta.getCliente().getNome();
            String total = String.format("%.2f", caderneta.getValorTotal());
            String pago = String.format("%.2f", caderneta.getValorPago());
            String restante = String.format("%.2f", caderneta.getValorDevedor());
            String dataInicial = caderneta.getDataAbertura();
            String dataPagamento = caderneta.getDataPagamento();
            String dataFechamento = caderneta.getDataFechamento();
            String status = caderneta.getStatus();
            Object[]dados = {cpf, nome, total, pago, restante, dataInicial, dataPagamento, dataFechamento, status};
            tabelaCaderneta.addRow(dados);
        }
    }
    
    private void listarCadernetasDebito(){
        int tamanho = tabelaCaderneta.getRowCount();
        for(int i=0; i<tamanho; i++){
            tabelaCaderneta.removeRow(0);
        }

        for(Caderneta caderneta : cadernetas){
            String status = caderneta.getStatus();
            if(status.equals("Aberto")){
                String cpf = caderneta.getCliente().getCpf();
                String nome = caderneta.getCliente().getNome();
                String total = String.format("%.2f", caderneta.getValorTotal());
                String pago = String.format("%.2f", caderneta.getValorPago());
                String restante = String.format("%.2f", caderneta.getValorDevedor());
                String dataInicial = caderneta.getDataAbertura();
                String dataPagamento = caderneta.getDataPagamento();
                String dataFechamento = caderneta.getDataFechamento();
                Object[]dados = {cpf, nome, total, pago, restante, dataInicial, dataPagamento, dataFechamento, status};
                tabelaCaderneta.addRow(dados);
            }
        }
    }
    
    private void listarCadernetas(String buscar) {
        if(radioNome.isSelected()){
            for(Caderneta caderneta : cadernetas){
                String nome = caderneta.getCliente().getNome();
                if(nome.startsWith(buscar)){
                    String cpf = caderneta.getCliente().getCpf();
                    String total = String.format("%.2f", caderneta.getValorTotal());
                    String pago = String.format("%.2f", caderneta.getValorPago());
                    String restante = String.format("%.2f", caderneta.getValorDevedor());
                    String dataInicial = caderneta.getDataAbertura();
                    String dataPagamento = caderneta.getDataPagamento();
                    String dataFechamento = caderneta.getDataFechamento();
                    String status = caderneta.getStatus();
                    Object[]dados = {cpf, nome, total, pago, restante, dataInicial, dataPagamento, dataFechamento, status};
                    tabelaCaderneta.addRow(dados);
                }
            }
        }
        else if(radioCpf.isSelected()){
            for(Caderneta caderneta : cadernetas){
                String cpf = caderneta.getCliente().getCpf();
                if(cpf.startsWith(buscar)){
                    String nome = caderneta.getCliente().getNome();
                    String total = String.format("%.2f", caderneta.getValorTotal());
                    String pago = String.format("%.2f", caderneta.getValorPago());
                    String restante = String.format("%.2f", caderneta.getValorDevedor());
                    String dataInicial = caderneta.getDataAbertura();
                    String dataPagamento = caderneta.getDataPagamento();
                    String dataFechamento = caderneta.getDataFechamento();
                    String status = caderneta.getStatus();
                    Object[]dados = {cpf, nome, total, pago, restante, dataInicial, dataPagamento, dataFechamento, status};
                    tabelaCaderneta.addRow(dados);
                }
            }
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

        buttonVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCaderneta = new javax.swing.JTable();
        tfBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonPagamento = new javax.swing.JButton();
        radioCpf = new javax.swing.JRadioButton();
        radioNome = new javax.swing.JRadioButton();
        buttonDetalhes1 = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();
        buttonListarDebito = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGO - Listar Vendas");
        setResizable(false);

        buttonVoltar.setBackground(new java.awt.Color(206, 206, 206));
        buttonVoltar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        jtCaderneta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtCaderneta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCaderneta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cpf", "Nome", "Total (R$)", "Pago (R$)", "Restante (R$)", "Data inicial", "Data de pagamento", "Data de fechamento", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCaderneta.setGridColor(new java.awt.Color(165, 224, 220));
        jScrollPane2.setViewportView(jtCaderneta);

        tfBuscar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tfBuscar.setPreferredSize(new java.awt.Dimension(11, 30));
        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar");

        buttonPagamento.setBackground(new java.awt.Color(0, 194, 181));
        buttonPagamento.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        buttonPagamento.setForeground(new java.awt.Color(254, 254, 254));
        buttonPagamento.setText("Receber Pag.");
        buttonPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPagamentoActionPerformed(evt);
            }
        });

        radioCpf.setBackground(new java.awt.Color(51, 51, 51));
        radioCpf.setForeground(new java.awt.Color(255, 255, 255));
        radioCpf.setText("CPF");
        radioCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCpfActionPerformed(evt);
            }
        });

        radioNome.setBackground(new java.awt.Color(51, 51, 51));
        radioNome.setForeground(new java.awt.Color(255, 255, 255));
        radioNome.setText("Nome");
        radioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNomeActionPerformed(evt);
            }
        });

        buttonDetalhes1.setBackground(new java.awt.Color(0, 194, 181));
        buttonDetalhes1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        buttonDetalhes1.setForeground(new java.awt.Color(254, 254, 254));
        buttonDetalhes1.setText("Ver detalhes");
        buttonDetalhes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetalhes1ActionPerformed(evt);
            }
        });

        buttonFechar.setBackground(new java.awt.Color(0, 194, 181));
        buttonFechar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        buttonFechar.setForeground(new java.awt.Color(254, 254, 254));
        buttonFechar.setText("Fechar");
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        buttonListarDebito.setBackground(new java.awt.Color(0, 204, 204));
        buttonListarDebito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonListarDebito.setForeground(new java.awt.Color(255, 255, 255));
        buttonListarDebito.setText("Clientes em débito");
        buttonListarDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarDebitoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(radioCpf)
                        .addGap(107, 107, 107)
                        .addComponent(buttonListarDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonDetalhes1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(buttonPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(radioNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(buttonVoltar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioCpf)
                    .addComponent(buttonListarDebito))
                .addGap(421, 421, 421)
                .addComponent(buttonFechar))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(buttonDetalhes1))
            .addGroup(layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(buttonPagamento))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(radioNome))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buttonVoltar))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed

        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonListarDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarDebitoActionPerformed

        if(buttonListarDebito.isSelected()){
            listarCadernetasDebito();
        }
        else{
            listarCadernetas();
        }
    }//GEN-LAST:event_buttonListarDebitoActionPerformed

    private void radioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNomeActionPerformed

        radioCpf.setSelected(false);
        radioNome.setSelected(true);
    }//GEN-LAST:event_radioNomeActionPerformed

    private void radioCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCpfActionPerformed

        radioNome.setSelected(false);
        radioCpf.setSelected(true);
    }//GEN-LAST:event_radioCpfActionPerformed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased

        int tamanho = tabelaCaderneta.getRowCount();
        for (int i=0; i<tamanho; i++) {
            tabelaCaderneta.removeRow(0);

        }

        String buscar = tfBuscar.getText();
        if(!buscar.equals("")){
            listarCadernetas(buscar);
        }
        else{
            listarCadernetas();
        }
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void tfBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyPressed
        int tamanho = tabelaCaderneta.getRowCount();
        for (int i=0; i<tamanho; i++) {
            tabelaCaderneta.removeRow(0);

        }

        String buscar = tfBuscar.getText();
        if(!buscar.equals("")){
            listarCadernetas(buscar);
        }
        else{
            listarCadernetas();
        }
    }//GEN-LAST:event_tfBuscarKeyPressed

    private void buttonPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagamentoActionPerformed

        int linha = jtCaderneta.getSelectedRow();

        if(linha != -1){
            if(!tabelaCaderneta.getValueAt(linha, 8).toString().equals("Fechado")){
                String cpf = tabelaCaderneta.getValueAt(linha, 0).toString();
                String dataInicial = tabelaCaderneta.getValueAt(linha, 5).toString();
                Caderneta c = cadernetaController.getCadernetaCpfData(cpf, dataInicial);

                new TelaRecebimento(c).setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Caderneta já fechada");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela de cadernetas");
        }
    }//GEN-LAST:event_buttonPagamentoActionPerformed

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed

        int linha = jtCaderneta.getSelectedRow();

        if(linha != -1){
            if(!tabelaCaderneta.getValueAt(linha, 8).toString().equals("Fechado")){
                String cpf = tabelaCaderneta.getValueAt(linha, 0).toString();
                String dataInicial = tabelaCaderneta.getValueAt(linha, 5).toString();

                cadernetaController.fecharCaderneta(cpf, dataInicial);

                listarCadernetas();
            }
            else{
                JOptionPane.showMessageDialog(null, "Caderneta já fechada");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela de cadernetas");
        }
    }//GEN-LAST:event_buttonFecharActionPerformed

    private void buttonDetalhes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetalhes1ActionPerformed

        int linha = jtCaderneta.getSelectedRow();

        if(linha != -1){
            String cpf = tabelaCaderneta.getValueAt(linha, 0).toString();
            String dataInicial = tabelaCaderneta.getValueAt(linha, 5).toString();

            Caderneta caderneta = cadernetaController.getCadernetaCpfData(cpf, dataInicial);

            new TelaDetalhesCaderneta(caderneta).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela de cadernetas");
        }
    }//GEN-LAST:event_buttonDetalhes1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaExibirCadernetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExibirCadernetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExibirCadernetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExibirCadernetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaExibirCadernetas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TelaExibirCadernetas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaExibirCadernetas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDetalhes1;
    private javax.swing.JButton buttonFechar;
    private javax.swing.JToggleButton buttonListarDebito;
    private javax.swing.JButton buttonPagamento;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtCaderneta;
    private javax.swing.JRadioButton radioCpf;
    private javax.swing.JRadioButton radioNome;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
