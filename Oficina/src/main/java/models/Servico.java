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
public class Servico implements Serializable{
    
    private String servico;
    private float valor;
    private String marca;
    private String ano;
    private String modelo;
    private String cliente;
    private String data;
    
    public Servico(String servico, String cliente, float valor, String marca, String ano, String modelo, String data) {
        this.servico = servico;
        this.valor = valor;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
        this.cliente = cliente;
        this.data = data;
    }
    
    public String getServico(){
        return servico;
    }
    
    public float getValor(){
        return valor;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getAno(){
        return ano;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public String getCliente(){
        return cliente;
    }
    
    public String getData() {
        return data;
    }
    
}
