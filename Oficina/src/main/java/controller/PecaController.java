/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import models.Peca;

/**
 *
 * @author rmb
 */
public class PecaController {
    
    private static int valorId;
    private ArrayList<Peca> pecas;
    
    public PecaController(){
        valorId=0;
        pecas = new ArrayList<Peca>();
    }
    
    public boolean inserir(String nome, int quantidade, float preco) {
        Peca peca = new Peca(valorId, nome, quantidade, preco);
        pecas.add(peca);
        valorId++;
        return true;
    }
    
    public ArrayList<Peca> getPecas() {
        return pecas;
    }
    
    public Peca consultarPeca(String nome) {
        for (Peca peca : pecas) {
            if(peca.getNome().equals(nome)) {
                return peca;
            }
        }
        
        return null;
    }
}
