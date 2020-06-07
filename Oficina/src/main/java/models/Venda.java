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
public class Venda implements Serializable{
    
    private ArrayList<Peca> produtos;
    private ArrayList<Integer> quantidades;
    private ArrayList<Servico> servicos;
    private float valor;
    private String data;
    
    public Venda(ArrayList<Peca> produtos, ArrayList<Integer> quantidades, ArrayList<Servico> servicos, float valor, String data) {
        this.produtos = produtos;
        this.quantidades = quantidades;
        this.servicos = servicos;
        this.valor = valor;
        this.data = data;
    }
    
    public ArrayList<Peca> getProdutos() {
        return produtos;
    }
    
    public ArrayList<Integer> getQuantidades() {
        return quantidades;
    }
    
    public void setProduto(ArrayList<Peca> produto) {
        this.produtos = produtos;
    }
    
    public float getValor() {
        return valor;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
}
