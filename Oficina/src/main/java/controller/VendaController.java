/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helpers.Helper;
import java.io.IOException;
import java.util.ArrayList;
import models.Venda;

/**
 *
 * @author rmb
 */
public class VendaController {
    
    private ArrayList<Venda> vendas;
    
    public VendaController() {
        vendas = new ArrayList<Venda>();
    }
    
    public String realizarVenda(String nome, int quantidade) throws IOException, ClassNotFoundException {
        PecaController pecaController = new PecaController();
        
        float resultado = pecaController.realizarVenda(nome, quantidade);
        
        if(resultado == 0) {
            return("Produto não encontrado no sistema");
        }
        
        else if(resultado == -1) {
            return("A quantidade no estoque é menor do que a quantidade a ser vendida");
        }
        
        else if(resultado == -2) {
            return("Produto sem estoque");
        }
        
        else {
            Venda venda = new Venda(nome, quantidade, resultado, Helper.gerarData());
            vendas.add(venda);
            return("Venda realizada com sucesso!");
        }
    }
    
    public String exibirVendas() {
        String retorno = "----------------Listando Vendas----------------" + "\n" + "\n";
        for(Venda venda : vendas) {
            retorno = retorno + "Nome produto............: " + venda.getProduto() + "\n"
                            + "Quantidade vendida......: " + venda.getQuantidade() + "\n"
                            + "Valor...................: R$" + venda.getValor() + "\n"
                            + "Data....................: " + venda.getData() + "\n"
                            + "_________________________________________" + "\n" + "\n";
        }
        
        return retorno;
    }
    
}
