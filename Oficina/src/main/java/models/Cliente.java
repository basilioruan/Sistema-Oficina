/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author rmb
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private double saldoDevedor;
    private String data;
    
    public Cliente (String nome, String cpf, String email, String telefone, double saldoDevedor, String data) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.saldoDevedor = saldoDevedor;
        this.data = data;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail() {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    } 
    
    public double getSaldoDevedor() {
        return saldoDevedor;
    }
    
    public String getData() {
        return data;
    }
    
}
