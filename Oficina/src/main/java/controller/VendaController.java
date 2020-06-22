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
    
    public boolean realizarVenda(ArrayList<Peca> pecas, ArrayList<Integer> quantidades ,ArrayList<Servico> servicos, float valor, int situacao, float desconto) throws IOException, ClassNotFoundException {
        PecaController pecaController = new PecaController();
       
        Venda venda = new Venda(pecas, quantidades, servicos, valor, desconto, situacao, Helper.gerarData());
        vendas.add(venda);
        vendaDAO.salvarArquivo(vendas);
        
        int cont = 0;
        for (Peca peca : pecas) {
            pecaController.realizarVenda(peca.getNome(), quantidades.get(cont));
            cont++;
        }
        
        return true;
    }
    
    public boolean realizarVenda(Venda venda) throws IOException, ClassNotFoundException{
        PecaController pecaController = new PecaController();
        ArrayList<Peca> pecas = venda.getProdutos();
        ArrayList<Integer> quantidades = venda.getQuantidades();
        
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
    
    public ArrayList<Venda> getVendasData (String data) {
        ArrayList<Venda> vendaDia = new ArrayList<Venda>();
        for(Venda venda : vendas) {
            if(venda.getData().contains(data)){
                vendaDia.add(venda);
            }
        }
        
        return vendaDia;
    }
    
    public ArrayList<Venda> getVendasMes (String data) {
        ArrayList<Venda> vendaMes = new ArrayList<Venda>();
        String mes;
        char[] mesVenda;
        for(Venda venda : vendas) {
            mesVenda = venda.getData().toCharArray();
            mes = Character.toString(mesVenda[3]) + Character.toString(mesVenda[4]) + "/"  + Character.toString(mesVenda[6]) 
                    + Character.toString(mesVenda[7])  + Character.toString(mesVenda[8]) + Character.toString(mesVenda[9]);
            if(mes.equals(data)){
                vendaMes.add(venda);
            }
        }
        return vendaMes;
    }
    
    public ArrayList<Venda> getVendasAno (String data) {
        ArrayList<Venda> vendaMes = new ArrayList<Venda>();
        for(Venda venda : vendas) {
            if(venda.getData().contains(data)){
                vendaMes.add(venda);
            }
        }
        return vendaMes;
    }
    
    public int getNumeroProdutosDia(String data) {
        int cont = 0;
        ArrayList<Integer> quantidade;
        for(Venda venda : vendas){
            if(venda.getData().startsWith(data)){
                quantidade = venda.getQuantidades();
                for(int i=0; i<quantidade.size(); i++){
                    cont = cont + quantidade.get(i);
                }
            }
        }
        return cont;
    }
    
    public int getNumeroServicosDia(String data) {
        int cont = 0;
        for(Venda venda : vendas){
            if(venda.getData().startsWith(data)){
                cont = cont + venda.getServico().size();
            }
        }
        return cont;
    }
    
    public float getValorDia(String data) {
        float cont = 0;
        for(Venda venda : vendas) {
            if(venda.getData().startsWith(data)){
                cont = cont + venda.getValor();
            }
        }
        return cont;
    }
    
    public int getNumeroProdutosMes(String data) {
        int cont = 0;
        ArrayList<Integer> quantidade;
        for(Venda venda : vendas){
            if(venda.getData().contains(data)){
                quantidade = venda.getQuantidades();
                for(int i=0; i<quantidade.size(); i++){
                    cont = cont + quantidade.get(i);
                }
            }
        }
        return cont;
    }
    
    public int getNumeroServicosMes(String data) {
        int cont = 0;
        for(Venda venda : vendas){
            if(venda.getData().contains(data)){
                cont = cont + venda.getServico().size();
            }
        }
        return cont;
    }
    
    public float getValorMes(String data) {
        float cont = 0;
        for(Venda venda : vendas) {
            if(venda.getData().contains(data)){
                cont = cont + venda.getValor();
            }
        }
        return cont;
    }
    
    
}
