/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CadernetaController;
import controller.ClienteController;
import helpers.Helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Caderneta;
import models.Cliente;
import models.Peca;
import models.Servico;
import models.Venda;

/**
 *
 * @author rmb
 */
public class TelaCadastroCaderneta extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCaderneta
     */
    protected final DefaultTableModel tabelaClientes;
    protected ArrayList<Cliente> clientes;
    private Venda venda;
    private ClienteController clienteController;
    public TelaCadastroCaderneta(Venda venda) {
        initComponents();
        
        this.venda = venda;
        tabelaClientes = (DefaultTableModel) jtCliente.getModel();
        
        radioCpf.setSelected(true);
        
        jlTotal.setText(String.format("%.2f", venda.getValor()));
        jlRestante.setText(jlTotal.getText());
        
        try {
            clienteController = new ClienteController();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroCaderneta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastroCaderneta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listarClientes();
        
    }
    
    protected void listarClientes(){
        int tamanho = tabelaClientes.getRowCount();
        for (int i=0; i<tamanho; i++) {
            tabelaClientes.removeRow(0);
            
        }
        try {
            clienteController = new ClienteController();
            clientes = clienteController.getClientes();
        
            if(clientes != null){
                for(Cliente cliente : clientes) {
                String nome = cliente.getNome();
                String cpf = cliente.getCpf();
                String telefone = cliente.getTelefone();
                String email = cliente.getEmail();
                Object[] dados = {cpf, nome, telefone, email};
                tabelaClientes.addRow(dados);
        }
            }
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroCaderneta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastroCaderneta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void listarClientes(String buscar){
        if(radioCpf.isSelected()){
            for(Cliente cliente : clientes) {
                String cpf = cliente.getCpf();
                if(cpf.startsWith(buscar)){
                    String nome = cliente.getNome();
                    String telefone = cliente.getTelefone();
                    String email = cliente.getEmail();
                    Object[] dados = {cpf, nome, telefone, email};
                    tabelaClientes.addRow(dados);
                }
            }
        }
        else if(radioNome.isSelected()){
            for(Cliente cliente : clientes) {
                String nome = cliente.getNome();
                if(nome.startsWith(buscar)){
                    String cpf = cliente.getCpf();
                    String telefone = cliente.getTelefone();
                    String email = cliente.getEmail();
                    Object[] dados = {cpf, nome, telefone, email};
                    tabelaClientes.addRow(dados);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfBuscar = new javax.swing.JTextField();
        radioCpf = new javax.swing.JRadioButton();
        radioNome = new javax.swing.JRadioButton();
        buttonCadastrarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jlTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jlRestante = new javax.swing.JLabel();
        buttonAbrirCaderneta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfPagamento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGO - Cadastro Caderneta");
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(614, 439));
        setResizable(false);

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(614, 439));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar cliente");

        tfBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        buttonCadastrarCliente.setBackground(new java.awt.Color(0, 204, 204));
        buttonCadastrarCliente.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        buttonCadastrarCliente.setText("Cadastrar Cliente");
        buttonCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarClienteActionPerformed(evt);
            }
        });

        jtCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Telefone", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtCliente);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor total (R$):");

        jlTotal.setForeground(new java.awt.Color(255, 255, 255));
        jlTotal.setText("0");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor pago (R$):");

        tfPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPagoKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor restante (R$):");

        jlRestante.setForeground(new java.awt.Color(255, 255, 255));
        jlRestante.setText("0");

        buttonAbrirCaderneta.setBackground(new java.awt.Color(0, 204, 204));
        buttonAbrirCaderneta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonAbrirCaderneta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAbrirCaderneta.setText("Abrir caderneta");
        buttonAbrirCaderneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirCadernetaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data de pagamento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonAbrirCaderneta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radioCpf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioNome)
                            .addGap(18, 18, 18)
                            .addComponent(buttonCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlRestante))
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfPago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlTotal)
                                    .addGap(210, 210, 210)
                                    .addComponent(jLabel6)
                                    .addGap(3, 3, 3)
                                    .addComponent(tfPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioCpf)
                    .addComponent(radioNome)
                    .addComponent(buttonCadastrarCliente))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jlTotal))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlRestante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAbrirCaderneta)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(buttonVoltar))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyPressed

        int tamanho = tabelaClientes.getRowCount();
        for (int i=0; i<tamanho; i++) {
            tabelaClientes.removeRow(0);
            
        }
        
        String buscar = tfBuscar.getText();
        buscar = buscar.toLowerCase();
        if(!buscar.equals("")){
            listarClientes(buscar);
        }
        else{
            listarClientes();
        }
    }//GEN-LAST:event_tfBuscarKeyPressed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        
        int tamanho = tabelaClientes.getRowCount();
        for (int i=0; i<tamanho; i++) {
            tabelaClientes.removeRow(0);
            
        }
        
        String buscar = tfBuscar.getText();
        buscar = buscar.toLowerCase();
        if(!buscar.equals("")){
            listarClientes(buscar);
        }
        else{
            listarClientes();
        }
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed

        dispose();
        new TelaRealizarVenda().setVisible(true);
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void radioCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCpfActionPerformed

        radioNome.setSelected(false);
        radioCpf.setSelected(true);
    }//GEN-LAST:event_radioCpfActionPerformed

    private void radioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNomeActionPerformed

        radioCpf.setSelected(false);
        radioNome.setSelected(true);
    }//GEN-LAST:event_radioNomeActionPerformed

    private void tfPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPagoKeyPressed
        String pago = tfPago.getText();
        pago = pago.replace(",", ".");
        
        if(!pago.equals("")){
            float total = Float.parseFloat(jlTotal.getText().replace(",", "."));
            float pagoConvertido = Float.parseFloat(pago);
            float restante = total-pagoConvertido;

            jlRestante.setText(String.format("%.2f", restante));
        }
        else{
            jlRestante.setText(jlTotal.getText());
        }

    }//GEN-LAST:event_tfPagoKeyPressed

    private void tfPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPagoKeyReleased
    
        String pago = tfPago.getText();
        pago = pago.replace(",", ".");
        
        if(!pago.equals("")){
            float total = Float.parseFloat(jlTotal.getText().replace(",", "."));
            float pagoConvertido = Float.parseFloat(pago);
            float restante = total-pagoConvertido;

            jlRestante.setText(String.format("%.2f", restante));
        }
        else{
            jlRestante.setText(jlTotal.getText());
        }


    }//GEN-LAST:event_tfPagoKeyReleased

    private void gerarCanhoto(String nome, String cpf, float pago){
        String conteudo = "";
        nome.toUpperCase();
        ArrayList<Peca> pecas = venda.getProdutos();
        ArrayList<Integer> quantidade = venda.getQuantidades();
        int cont = 0;
        String Nome;
        for(Peca peca : pecas){
            Nome = peca.getNome();
            if(Nome.length() < 25){
                for(int j=Nome.length(); j<25; j++){
                    nome = nome + " ";
                }
            }
            conteudo += Nome 
                    + quantidade.get(cont) + "    "
                    + peca.getPrecoVenda() + "\n\r";
        }
        
        ArrayList<Servico> servicos = venda.getServico();
        for(Servico servico : servicos){
            Nome = servico.getServico();
            if(Nome.length() < 25){
                for(int j=Nome.length(); j<25; j++){
                    nome = nome + " ";
                }
            }
            conteudo += Nome + " "
                    + "1" + "    "
                    + servico.getValor() + "\n\r";
        }
        
        Helper.imprimir("   JUNINHO MOTO PECAS E SERVICOS   \n\r"
                + "------------------------------------\n\r"
                + "            VIA DA LOJA        \n\r"
                + "------------------------------------\n\r"
                + "DATA DE IMPRESSAO: " + Helper.gerarData() + "\n\r"
                + "------------------------------------\n\r"
                + "CLIENTE: " + nome.toUpperCase() + "\n\r"
                + "CPF: " + cpf + "\n\r"
                + "------------------------------------\n\r"
                + "DESCRICAO              QTD   PRECO \n\r"
                + conteudo
                + "------------------------------------\n\r"
                + "VALOR: " + venda.getValor() + "\n\r"
                + "DESC.: " + venda.getDescontoRs() + "\n\r"
                + "TOTAL: " + venda.getTotal() + "\n\r"
                + "------------------------------------\n\r"
                + "Valor recebido: " + pago
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "_____________________________________\n"
                + "             ASSINATURA                \n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r\f"
        );
        
        Helper.imprimir("   JUNINHO MOTO PECAS E SERVICOS   \n\r"
                + "------------------------------------\n\r"
                + "            VIA DO CLIENTE        \n\r"
                + "------------------------------------\n\r"
                + "DATA DE IMPRESSAO: " + Helper.gerarData() + "\n\r"
                + "------------------------------------\n\r"
                + "CLIENTE: " + nome.toUpperCase() + "\n\r"
                + "CPF: " + cpf + "\n\r"
                + "------------------------------------\n\r"
                + "DESCRICAO              QTD   PRECO \n\r"
                + conteudo
                + "------------------------------------\n\r"
                + "VALOR: " + venda.getValor() + "\n\r"
                + "DESC.: " + venda.getDescontoRs() + "\n\r"
                + "TOTAL: " + venda.getTotal() + "\n\r"
                + "------------------------------------\n\r"
                + "Valor recebido: " + pago
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "_____________________________________\n"
                + "             ASSINATURA                \n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r"
                + "\n\r\f"
        );
        
    }
    
    private void buttonAbrirCadernetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrirCadernetaActionPerformed

        String dataPagamento = tfPagamento.getText();
        
        if(!dataPagamento.equals("")){
            int linha = jtCliente.getSelectedRow();
            if(linha != -1){
                String cpf = tabelaClientes.getValueAt(linha, 0).toString();
                Cliente cliente = clienteController.buscarClienteCpf(cpf);
                float total = venda.getValor();
                float pago = Float.parseFloat(tfPago.getText().replace(",", "."));
                
                CadernetaController cadernetaController;
                try {
                    cadernetaController = new CadernetaController();
                    if(cadernetaController.cadastrarCaderneta(cliente, venda, total, pago, dataPagamento)){
                        JOptionPane.showMessageDialog(null, "Caderneta criada com sucesso");
                        gerarCanhoto(cliente.getNome(), cpf, pago);
                        new TelaRealizarVenda().setVisible(true);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Falha ao criar caderneta");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TelaCadastroCaderneta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaCadastroCaderneta.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Selecione um cliente");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "A data de pagamento não pode ser vazia");
        }

    }//GEN-LAST:event_buttonAbrirCadernetaActionPerformed

    private void buttonCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarClienteActionPerformed

        new TelaCadastroCliente(this).setVisible(true);

    }//GEN-LAST:event_buttonCadastrarClienteActionPerformed

    private void tfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbrirCaderneta;
    private javax.swing.JButton buttonCadastrarCliente;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlRestante;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JTable jtCliente;
    private javax.swing.JRadioButton radioCpf;
    private javax.swing.JRadioButton radioNome;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfPagamento;
    private javax.swing.JTextField tfPago;
    // End of variables declaration//GEN-END:variables
}
