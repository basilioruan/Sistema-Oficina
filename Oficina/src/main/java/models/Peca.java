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
    
    private int id;
    private String nome;
    private int quantidade;
    private float preco;
    private String data;
    private String prateleira;
    private String local;
    
    public Peca() { }
    
    public Peca(int id, String nome, int quantidade, float preco, String data, String prateleira, String local) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = data;
        this.prateleira = prateleira;
        this.local = local;
    }
    
    public int getId(){
        return id;
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
    
    public float getPreco() {
        return preco;
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
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
