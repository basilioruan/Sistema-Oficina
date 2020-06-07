/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import models.Servico;

/**
 *
 * @author rmb
 */
public class ServicoController {
    
    private static ArrayList<Servico> servicos;
    
    public ServicoController (){
        servicos = new ArrayList<Servico>();
    }
    
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }
    
    public ArrayList<Servico> getServicos(){
        return servicos;
    }
    
    public Servico consultarServico(String nome) {
        for (Servico s : servicos) {
            if(s.getServico().equals(nome)){
                return s;
            }
        }
        return null;
    }
    
    public void limparServicos() {
        servicos.removeAll(servicos);
    }
}
