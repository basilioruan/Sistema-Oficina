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
public class Cliente implements Serializable{
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private float saldoDevedor;
    private float saldoPago;
    private float total;
    private String data;
    
    public Cliente (String nome, String cpf, String email, String telefone, float saldoDevedor, float saldoPago, float total, String data) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.saldoDevedor = saldoDevedor;
        this.saldoPago = saldoPago;
        this.total = total;
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
    
    public float getSaldoDevedor() {
        return saldoDevedor;
    }
    
    public float getSaldoPago() {
        return saldoPago;
    }
    
    public float getTotal() {
        return total;
    }
    
    public String getData() {
        return data;
    }
    
}
