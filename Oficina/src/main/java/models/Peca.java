/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author rmb
 */
public class Peca implements Serializable{
    
    private String nome;
    private int quantidade;
    private float precoCusto;
    private float precoVenda;
    private String data;
    private String prateleira;
    private String local;
    
    public Peca() { }
    
    public Peca(String nome, int quantidade, float precoCusto, float precoVenda, String data, String prateleira, String local) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.data = data;
        this.prateleira = prateleira;
        this.local = local;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    } 
    
    public float getPrecoCusto() {
        return precoCusto;
    }
    
    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    public float getPrecoVenda() {
        return precoVenda;
    }
    
    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getPrateleira() {
        return prateleira;
    }
    
    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }
    
    public String getLocal() {
        return local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
}
