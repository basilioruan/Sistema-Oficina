/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author rmb
 */
public class Caderneta implements Serializable{
    private Cliente cliente;
    private Venda venda;
    private float valorTotal;
    private float valorPago;
    private float valorDevedor;
    private ArrayList<Float> pagamentos;
    private ArrayList<String> datasPagamento;
    private String dataAbertura;
    private String dataPagamento;
    private String dataFechamento;
    private String status;
    
    public Caderneta(Cliente cliente, Venda venda, float valorTotal, float valorPago, float valorDevedor, String dataAbertura, String dataPagamento){
        this.cliente = cliente;
        this.venda = venda;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.valorDevedor = valorDevedor;
        this.dataAbertura = dataAbertura;
        this.dataPagamento = dataPagamento;
        this.pagamentos = new ArrayList<Float>();
        this.pagamentos.add(valorPago);
        this.datasPagamento = new ArrayList<String>();
        this.datasPagamento.add(dataAbertura);
        status = "Aberto";
        dataFechamento = "-";
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Venda getVenda(){
        return venda;
    }
    
    public float getValorTotal(){
        return valorTotal;
    }
    
    public float getValorPago(){
        return valorPago;
    }
    
    public void setValorPago(float valorPago){
        this.valorPago = valorPago;
    }   
    
    public float getValorDevedor(){
        return valorDevedor;
    }
    
    public void setValorDevedor(float valorDevedor){
        this.valorDevedor = valorDevedor;
    }
    
    public String getDataAbertura(){
        return dataAbertura;
    }
    
    public String getDataPagamento(){
        return dataPagamento;
    }
    
    public void setDataPagamento(String novaData){
        dataPagamento = novaData;
    }
    
    public String getDataFechamento(){
        return dataFechamento;
    }
    
    public void setDataFechamento(String dataFechamento){
        this.dataFechamento = dataFechamento;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void fechar(String data){
        status = "Fechado";
        dataFechamento = data;
    }
    
    public void adicionarPagamento(float pagamento){
        pagamentos.add(pagamento);
    }
    
    public void adicionarDataPagamento(String data){
        datasPagamento.add(data);
    }
    
    public float getPagamentoData(String data){
        for(int i=0; i<datasPagamento.size(); i++){
            if(datasPagamento.get(i).contains(data)){
                return pagamentos.get(i);
            }
        }
        return -1;
    }
    
    public boolean existePagamento(String data){
        for(int i=0; i<datasPagamento.size(); i++){
            if(datasPagamento.get(i).startsWith(data)){
                return true;
            }
        }
        return false;
    }
    
    public String getDataPagamentos(){
        return datasPagamento.get(datasPagamento.size() - 1);
    }
    
    public ArrayList<String> getTodasDataPagamentos(){
        return datasPagamento;
    }
    
}
