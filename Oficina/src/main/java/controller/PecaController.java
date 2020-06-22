/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PecaDAO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.Peca;

/**
 *
 * @author rmb
 */
public class PecaController {
    
    private static ArrayList<Peca> pecas;
    private PecaDAO pecaDAO;
    
    public PecaController() throws IOException, ClassNotFoundException{
        pecas = new ArrayList<Peca>();
        pecaDAO = new PecaDAO();
        File arquivo = new File("pecas.bin");
        if(arquivo.exists()){
            pecas = pecaDAO.buscarArquivo();
        }
    }
    
    public boolean inserir(String nome, int quantidade, float precoCusto, float precoVenda, String data, String prateleira, String local) {
        nome = nome.toLowerCase();
        Peca peca = new Peca(nome, quantidade, precoCusto, precoVenda, data, prateleira, local);
        pecas.add(peca);
        if(pecaDAO.salvarArquivo(pecas)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public ArrayList<Peca> getPecas() {
        return pecas;
    }
    
    public ArrayList<Peca> buscarPorNome(String nome) {
        nome = nome.toLowerCase();
        ArrayList<Peca> pecaProcurada = new ArrayList<Peca>();
        boolean achou = false;
        for (Peca p : pecas) {
            if(p.getNome().startsWith(nome)) {
                pecaProcurada.add(p);
                achou = true;
            }
        }
        
        if(achou){
            return pecaProcurada;
        }
        else{
            return null;
        }
    }
    
    
    public Peca consultarPeca(String nome) throws IOException, ClassNotFoundException {
        nome = nome.toLowerCase();
        for (Peca p : pecas) {
            if(p.getNome().equals(nome)) {
                return p;
            }
        }
        
        return null;
    }
    
    public boolean removerPeca(String nome) throws ClassNotFoundException, IOException {
        nome = nome.toLowerCase();
        boolean check = false;
        for (Peca peca: pecas) {
            if(peca.getNome().equals(nome)) {
                pecas.remove(peca);
                check = true;
                break;
            }
        }
        
        if(check) {
            pecaDAO.salvarArquivo(pecas);
        }
        
        return check;
    }
    
    public boolean editarPeca(String pecaRemovida, String nome, int quantidade, float precoCusto, float precoVenda, String data, String prateleira, String local) throws ClassNotFoundException, IOException {
        nome = nome.toLowerCase();
        pecaRemovida = pecaRemovida.toLowerCase();
        for (Peca peca : pecas) {
            if(peca.getNome().equals(pecaRemovida)) {
                peca.setNome(nome);
                peca.setQuantidade(quantidade);
                peca.setPrecoCusto(precoCusto);
                peca.setPrecoVenda(precoVenda);
                peca.setData(data);
                peca.setPrateleira(prateleira);
                peca.setLocal(local);
                break;
            }
        }
        
        pecaDAO.salvarArquivo(pecas);
        
        return true;
    }
    
    public int adicionarEstoque(int quantidade, String nome) {
        int novaQuantidade = -1;
        nome = nome.toLowerCase();
        for (Peca peca : pecas) {
            if(peca.getNome().equals(nome)) {
                novaQuantidade = quantidade + peca.getQuantidade();
                peca.setQuantidade(novaQuantidade);
                break;
            }
        }
        
        pecaDAO.salvarArquivo(pecas);
        
        return novaQuantidade;
        
    }
    
    public ArrayList<Peca> getSemEstoque() {
        if(pecas.size() > 0) {
            
            ArrayList<Peca> semEstoque = new ArrayList<Peca>();
            for (Peca peca : pecas) {
                if(peca.getQuantidade() == 0) {
                    semEstoque.add(peca);
                }
            }
            
            return semEstoque;
        }
        else {
            return null;
        }
    }
    
    public float realizarVenda(String nome, int vendidos) {
        nome = nome.toLowerCase();
        float retorno = 0;
        for (Peca peca : pecas) {
            if(peca.getNome().equals(nome)) {
                int quantidade = peca.getQuantidade();
                if(vendidos > quantidade) {
                    retorno = -1;
                    return retorno;
                }
                else if(quantidade == 0){
                    return -2;
                }
                else {
                    peca.setQuantidade(quantidade - vendidos);
                    retorno = peca.getPrecoCusto() * vendidos;
                }
                break;
            }
        }
        
        
        pecaDAO.salvarArquivo(pecas);
        
        return retorno;
    }
    
    public String contabilizarProdutos() {
        int totalPecas = 0;
        float totalCusto = 0;
        
        for(Peca peca : pecas) {
            totalCusto = totalCusto + peca.getPrecoCusto()*peca.getQuantidade();
            totalPecas+=peca.getQuantidade();
        }
        
        return "Total de peças em estoque: " + totalPecas + "\n" + "Total preço de custo: R$" + String.format("%.2f", totalCusto);
    }
}
