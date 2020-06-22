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
public class TelaExibirVendas extends javax.swing.JFrame {
    private final DefaultTableModel tabelaVenda;
    private final DefaultTableModel tabelaCaderneta;
    private ArrayList<Venda> vendasDia;
    private ArrayList<Peca> pecas;
    private ArrayList<Servico> servicos;
    private ArrayList<Integer> quantidade;
    private ArrayList<Caderneta> cadernetas;
    CadernetaController cadernetaController;
    private String dataHoje;
    private float total;
    /**
     * Creates new form TelaExibirVendas
     */
    public TelaExibirVendas() throws IOException, ClassNotFoundException {
        initComponents();
        tabelaVenda = (DefaultTableModel) jtVendaDia.getModel();
        tabelaCaderneta = (DefaultTableModel) jtCaderneta.getModel();
        total = 0;
        
        dataHoje = Helper.gerarDataSimples();
        VendaController vendaController = new VendaController();
        vendasDia = vendaController.getVendas();
        
        cadernetaController = new CadernetaController();
        cadernetas = cadernetaController.getCadernetas();
        
        pecas = null;
        servicos = null;
        quantidade = null;
        
        if(vendasDia == null && cadernetas == null){
            JOptionPane.showMessageDialog(null, "Não possui vendas nesse dia");
        }
        else{
            listarVendas();
            jlTotal.setText(String.format("%.2f", total));
        }
    }
    
    private void listarVendas(){
        total = 0;
        int tamanho = tabelaVenda.getRowCount();
        for(int i=0; i<tamanho; i++){
            tabelaVenda.removeRow(0);
        }
        
        tamanho = tabelaCaderneta.getRowCount();
        for(int i=0; i<tamanho; i++){
            tabelaCaderneta.removeRow(0);
        }
        String data = Helper.gerarDataSimples();
        int cont;
        if(vendasDia != null){
            for(Venda venda : vendasDia) {
                if(venda.getData().contains(data)){
                    cont = 0;
                    this.total = total + venda.getValor()-venda.getDescontoRs();
                    pecas = venda.getProdutos();
                    servicos = venda.getServico();

                    if(pecas != null){
                        quantidade = venda.getQuantidades();

                        float valor;
                        for(Peca peca : pecas){
                            valor = (peca.getPrecoVenda()*quantidade.get(cont)) * (1 - venda.getDesconto()/100);
                            Object[] dados = {peca.getNome(), quantidade.get(cont), String.format("%.2f", valor), "Produto", venda.getData()};
                            tabelaVenda.addRow(dados);
                            cont++;
                        }
                    }

                    if(servicos != null) {
                        float total;
                        for(Servico servico : servicos) {
                            total = (servico.getValor() * (1 + venda.getDesconto()/100));
                            Object[] dados = {servico.getServico(), "1", String.format("%.2f", total), "Serviço", venda.getData()};
                            tabelaVenda.addRow(dados);
                        }
                    }
                }
            }
        }
        if(cadernetas != null){
            for(Caderneta caderneta : cadernetas){
                if(caderneta.getPagamentoData(data) != -1){
                    Object[] dados = {caderneta.getCliente().getNome(), String.format("%.2f", caderneta.getPagamentoData(data)), caderneta.getDataPagamentos(), caderneta.getDataAbertura()};
                    tabelaCaderneta.addRow(dados);
                    this.total = total + caderneta.getPagamentoData(data);
                }
            }
        }
        
        jlTotal.setText(String.format("%.2f", total));
    }
    
    private void listarVendas(String buscar) {
        total = 0;
        int tamanho = tabelaVenda.getRowCount();
        for(int i=0; i<tamanho; i++){
            tabelaVenda.removeRow(0);
        }
        
        tamanho = tabelaCaderneta.getRowCount();
        for(int i=0; i<tamanho; i++){
            tabelaCaderneta.removeRow(0);
        }
        
        int cont;
        if(vendasDia != null){
            for(Venda venda : vendasDia) {
                cont = 0;
                if(venda.getData().contains(buscar)){
                    this.total = total + venda.getValor();
                    pecas = venda.getProdutos();
                    servicos = venda.getServico();

                    if(pecas != null){
                        quantidade = venda.getQuantidades();

                        float valor;
                        for(Peca peca : pecas){
                            valor = peca.getPrecoVenda()*quantidade.get(cont);
                            Object[] dados = {peca.getNome(), quantidade.get(cont), String.format("%.2f", valor), "Produto", venda.getData()};
                            tabelaVenda.addRow(dados);
                            cont++;
                        }
                    }

                    if(servicos != null) {
                        for(Servico servico : servicos) {
                            Object[] dados = {servico.getServico(), "1", String.format("%.2f", servico.getValor()), "Servico", venda.getData()};
                            tabelaVenda.addRow(dados);
                        }
                    }
                }
            }
        }
        if(cadernetas != null){
            for(Caderneta caderneta : cadernetas){
                if(caderneta.existePagamento(buscar)){
                    Object[] dados = {caderneta.getCliente().getNome(), String.format("%.2f", caderneta.getPagamentoData(buscar)), caderneta.getDataPagamentos(), caderneta.getDataAbertura()};
                    tabelaCaderneta.addRow(dados);
                    this.total = total + caderneta.getPagamentoData(buscar);
                }
            }
        }
        jlTotal.setText(String.format("%.2f", total));
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
        buttonDetalhes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtVendaDia = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jtCaderneta.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jtCaderneta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Valor (R$)", "Data do recebimento", "Data de abertura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCaderneta.setGridColor(new java.awt.Color(165, 224, 220));
        jtCaderneta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCadernetaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCaderneta);
        if (jtCaderneta.getColumnModel().getColumnCount() > 0) {
            jtCaderneta.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        tfBuscar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tfBuscar.setPreferredSize(new java.awt.Dimension(11, 30));
        tfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarActionPerformed(evt);
            }
        });
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
        jLabel2.setText("Data");

        buttonDetalhes.setBackground(new java.awt.Color(0, 194, 181));
        buttonDetalhes.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        buttonDetalhes.setForeground(new java.awt.Color(254, 254, 254));
        buttonDetalhes.setText("Ver detalhes");
        buttonDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetalhesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total R$: ");

        jlTotal.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal.setText("0");

        jtVendaDia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtVendaDia.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jtVendaDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantidade", "Valor (R$)", "Tipo", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVendaDia.setGridColor(new java.awt.Color(165, 224, 220));
        jtVendaDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVendaDiaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtVendaDia);
        if (jtVendaDia.getColumnModel().getColumnCount() > 0) {
            jtVendaDia.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtVendaDia.getColumnModel().getColumn(1).setHeaderValue("Quantidade");
            jtVendaDia.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtVendaDia.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtVendaDia.getColumnModel().getColumn(3).setHeaderValue("Tipo");
        }

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tabela Recebimento");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tabela Vendas");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(620, 620, 620)
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jlTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buttonVoltar)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(290, 290, 290)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDetalhes)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jlTotal)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel4))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed

        dispose();
        new MenuCaixaView().setVisible(true);
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void tfBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyPressed
   

    }//GEN-LAST:event_tfBuscarKeyPressed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased


    }//GEN-LAST:event_tfBuscarKeyReleased

    private void buttonDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetalhesActionPerformed
        
        int linhaVenda = jtVendaDia.getSelectedRow();
        int linhaCaderneta = jtCaderneta.getSelectedRow();
        if(linhaVenda != -1){
            String tipo = tabelaVenda.getValueAt(linhaVenda, 3).toString();
            String item = tabelaVenda.getValueAt(linhaVenda, 0).toString();
            String data = tabelaVenda.getValueAt(linhaVenda, 4).toString();
            boolean achou = false;
            if(tipo.equals("Produto")){
                Peca p = null;
                int qtd = 0;
                for(Venda venda : vendasDia){
                    pecas = venda.getProdutos();
                    quantidade = venda.getQuantidades();
                    int cont = 0;
                    for(Peca peca : pecas) {
                        if(peca.getNome().equals(item) && venda.getData().equals(data)){
                            p = peca;
                            qtd = quantidade.get(cont);
                            achou = true;
                            break;
                        }
                        cont++;
                    }
                    if(achou){
                        break;
                    }
                }
                new TelaDetalhesProduto(p, data, qtd).setVisible(true);
            }
            else{
                Servico s = null;
                for(Venda venda : vendasDia){
                    servicos = venda.getServico();
                    for (Servico servico : servicos) {
                        if(servico.getServico().equals(item) && venda.getData().equals(data)){
                            s = servico;
                            achou = true;
                            break;
                        }
                    }
                    if(achou){
                        break;
                    }
                }
                new TelaDetalhesServico(s, data).setVisible(true);
            }
            jtVendaDia.getSelectionModel().clearSelection();
        }
        else if(linhaCaderneta != -1){
            String cliente = tabelaCaderneta.getValueAt(linhaCaderneta, 0).toString();
            String data = tabelaCaderneta.getValueAt(linhaCaderneta, 3).toString();
            
            Caderneta caderneta = cadernetaController.buscar(cliente, data);
            
            new TelaDetalhesCaderneta(caderneta).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela");
        }

    }//GEN-LAST:event_buttonDetalhesActionPerformed

    private void jtVendaDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVendaDiaMouseClicked

       jtCaderneta.getSelectionModel().clearSelection(); 

    }//GEN-LAST:event_jtVendaDiaMouseClicked

    private void jtCadernetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCadernetaMouseClicked

        jtVendaDia.getSelectionModel().clearSelection();
        
    }//GEN-LAST:event_jtCadernetaMouseClicked

    private void tfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String buscar = tfBuscar.getText();
        
        if(!buscar.equals("")){
            if(buscar.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]")){
                listarVendas(buscar);
            }
            else{
                JOptionPane.showMessageDialog(null, "Digite a data nesse formato: dd/MM/aaaa");
            }
        }
        else{
            listarVendas();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExibirVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExibirVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExibirVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExibirVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaExibirVendas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TelaExibirVendas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaExibirVendas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDetalhes;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JTable jtCaderneta;
    private javax.swing.JTable jtVendaDia;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
