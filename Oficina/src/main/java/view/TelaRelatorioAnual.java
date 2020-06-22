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
import models.Venda;

/**
 *
 * @author rmb
 */
public class TelaRelatorioAnual extends javax.swing.JFrame {

    /**
     * Creates new form TelaRelatorioMensal
     */
    private final DefaultTableModel tabelaAno;
    private ArrayList<Venda> vendas;
    private VendaController vendaController;
    private final DefaultTableModel tabelaCaderneta;
    private ArrayList<Caderneta> cadernetas;
    CadernetaController cadernetaController;
    
    public TelaRelatorioAnual() {
        initComponents();
        tabelaAno = (DefaultTableModel) jtAno.getModel();
        tabelaCaderneta = (DefaultTableModel) jtCaderneta.getModel(); 
        try {
            vendaController = new VendaController();
            vendaController = new VendaController();
            cadernetaController = new CadernetaController();
            cadernetas = cadernetaController.getCadernetas();
        } catch (IOException ex) {
            Logger.getLogger(TelaRelatorioAnual.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaRelatorioAnual.class.getName()).log(Level.SEVERE, null, ex);
        }
        String data = Helper.gerarDataSimples();
        char[] mes = data.toCharArray();
        data = Character.toString(mes[6]) + Character.toString(mes[7]) + Character.toString(mes[8]) + Character.toString(mes[9]);
        
        contabilizarMes(data);
    }
    
    private void contabilizarMes(String ano) {
        vendas = vendaController.getVendasAno(ano);
        //mm/yyyy
        char[] mesChar;
        String mesString;
        String mes;
        String data;
        ArrayList<String> passados = new ArrayList<String>();
        passados.add("");
        for(Venda venda : vendas) {
            mesChar = venda.getData().toCharArray();
            mesString = Character.toString(mesChar[3]) + Character.toString(mesChar[4]);
            if(!passados.contains(mesString)){
                data = mesString + "/" + ano;
                mes = converterMes(mesString);
                Object[] dados = {mes, vendaController.getNumeroProdutosMes(data), vendaController.getNumeroServicosMes(data),
                String.format("%.2f", vendaController.getValorMes(data))};
                tabelaAno.addRow(dados);
                passados.add(mesString);
            }
        }
        passados = new ArrayList<String>();
        ArrayList<String> datasPagamento = new ArrayList<String>();
        if(cadernetas != null){
            for(Caderneta caderneta : cadernetas) {
                datasPagamento = caderneta.getTodasDataPagamentos();
                for(String s : datasPagamento){
                    mesChar = s.toCharArray();
                    mesString = Character.toString(mesChar[3]) + Character.toString(mesChar[4]);
                    if(!passados.contains(mesString) && s.contains(ano)){
                        data = mesString + "/" + ano;
                        mes = converterMes(mesString);
                        Object[] dados = {mes, cadernetaController.getValorDia(data)};
                        tabelaCaderneta.addRow(dados);
                        passados.add(mesString);
                    }
                }
            }
        }
        gerarTotal();
    }
    
    private void gerarTotal(){
        int tamanho = tabelaAno.getRowCount();
        float total = 0;
        if(tamanho > 0){
            for (int i=0; i<tamanho; i++){
                total = total + Float.parseFloat(tabelaAno.getValueAt(i, 3).toString().replace(",", "."));
            }
        }
        
        tamanho = tabelaCaderneta.getRowCount();
        if(tamanho > 0){
            for (int i=0; i<tamanho; i++){
                total = total + Float.parseFloat(tabelaCaderneta.getValueAt(i, 1).toString().replace(",", "."));
            }
        }
        jlTotal.setText(String.format("%.2f", total));
    }
    
    private String converterMes(String data) {
        if(data.startsWith("01")){
             return "Janeiro";
        }
        if(data.startsWith("02")){
             return "Fevereiro";
        }
        if(data.startsWith("03")){
             return "Março";
        }
        if(data.startsWith("04")){
             return "Abril";
        }
        if(data.startsWith("05")){
             return "Maio";
        }
        if(data.startsWith("06")){
             return "Junho";
        }
        if(data.startsWith("07")){
             return "Julho";
        }
        if(data.startsWith("08")){
             return "Agosto";
        }
        if(data.startsWith("09")){
             return "Setembro";
        }
        if(data.startsWith("10")){
             return "Outubro";
        }
        if(data.startsWith("11")){
             return "Novembro";
        }
        if(data.startsWith("12")){
             return "Dezembro";
        }
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtAno = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tfData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCaderneta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGO - Relatório Anual");
        setResizable(false);

        jtAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtAno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mês", "Qtd produtos", "Qtd serviços", "Valor (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAno);

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ano");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total R$: ");

        jlTotal.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal.setText("0");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tabela Recebimento");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tabela Vendas");

        jtCaderneta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCaderneta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Valor (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane3.setViewportView(jtCaderneta);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        buttonBuscar.setBackground(new java.awt.Color(0, 204, 204));
        buttonBuscar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        buttonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(457, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(buttonBuscar)
                .addContainerGap(574, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jlTotal))))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jlTotal)))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        
        String data = tfData.getText();
        if(!data.equals("")){
            if(data.matches("[0-9][0-9][0-9][0-9]")) {
                for(int i=0; i<tabelaAno.getRowCount(); i++){
                    tabelaAno.removeRow(0);
                }
                for(int i=0; i<tabelaCaderneta.getRowCount(); i++){
                    tabelaCaderneta.removeRow(0);
                }
                contabilizarMes(data);
            }
            else{
                JOptionPane.showMessageDialog(null, "Digite a data no formato AAAA. Ex: 2020");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Digite o ano que deseja buscar.");
        }

    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new MenuCaixaView().setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtCadernetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCadernetaMouseClicked

        jtAno.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jtCadernetaMouseClicked

    private void jtAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAnoMouseClicked
        
        jtCaderneta.getSelectionModel().clearSelection();

    }//GEN-LAST:event_jtAnoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaRelatorioAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioAnual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioAnual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JTable jtAno;
    private javax.swing.JTable jtCaderneta;
    private javax.swing.JTextField tfData;
    // End of variables declaration//GEN-END:variables
}
