/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.VendaDAO;
import helpers.Helper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.Peca;
import models.Servico;
import models.Venda;

/**
 *
 * @author rmb
 */
public class VendaController {
    
    private static ArrayList<Venda> vendas;
    private VendaDAO vendaDAO;
    
    public VendaController() throws IOException, ClassNotFoundException {
        vendas = new ArrayList<Venda>();
        vendaDAO = new VendaDAO();
        File arquivo = new File("vendas.bin");
        if(arquivo.exists()){
            vendas = vendaDAO.buscarArquivo();
        }
    }
    
    public boolean realizarVenda(ArrayList<Peca> pecas, ArrayList<Integer> quantidades ,ArrayList<Servico> servicos, float valor) throws IOException, ClassNotFoundException {
        PecaController pecaController = new PecaController();
       
        Venda venda = new Venda(pecas, quantidades, servicos, valor, Helper.gerarData());
        vendas.add(venda);
        vendaDAO.salvarArquivo(vendas);
        
        int cont = 0;
        for (Peca peca : pecas) {
            pecaController.realizarVenda(peca.getNome(), quantidades.get(cont));
            cont++;
        }
        
        return true;
    }
    
    public ArrayList<Venda> getVendas() {
        return vendas;
    }
    
}
