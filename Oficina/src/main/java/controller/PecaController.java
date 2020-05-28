/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PecaDAO;
import java.io.IOException;
import java.util.ArrayList;
import models.Peca;

/**
 *
 * @author rmb
 */
public class PecaController {
    
    private static int valorId;
    private ArrayList<Peca> pecas;
    private PecaDAO pecaDAO;
    
    public PecaController(){
        valorId=0;
        pecas = new ArrayList<Peca>();
        pecaDAO = new PecaDAO();
    }
    
    public boolean inserir(String nome, int quantidade, float preco, String data, String prateleira, String local) {
        Peca peca = new Peca(valorId, nome, quantidade, preco, data, prateleira, local);
        if(pecaDAO.salvarArquivo(peca)) {
            valorId++;
            return true;
        }
        else {
            return false;
        }
    }
    
    public ArrayList<Peca> getPecas() {
        return pecas;
    }
    
    public String mostrarPecas() throws ClassNotFoundException, IOException {
        pecas = pecaDAO.buscarTudoArquivo();
        if(pecas.size() > 0) {
            String retorno = "----------------Listando Peças----------------" + "\n" + "\n";

            for (Peca peca : pecas) {
                retorno = retorno + "Nome....................: " + peca.getNome() + "\n"
                        + "Quantidade em estoque...: " + peca.getQuantidade() + "\n"
                        + "Preço...................: R$" + peca.getPreco() + "\n"
                        + "Prateleira..............: " + peca.getPrateleira() + "\n"
                        + "Local...................: " + peca.getLocal() + "\n"
                        + "Data de cadastro........: " + peca.getData() + "\n"
                        + "_________________________________________" + "\n" + "\n";
            }
            
            pecas.removeAll(pecas);
            
            return retorno;
        }
        else {
            return "Não possui peças cadastradas no sistema";
        }
    }
    
    
    public String consultarPeca(String nome) throws IOException, ClassNotFoundException {
        Peca peca = pecaDAO.buscarArquivo(nome);
        if(peca != null){
            String retorno = "Nome....................: " + peca.getNome() + "\n"
                        + "Quantidade em estoque...: " + peca.getQuantidade() + "\n"
                        + "Preço...................: R$" + peca.getPreco() + "\n"
                        + "Prateleira..............: " + peca.getPrateleira() + "\n"
                        + "Local...................: " + peca.getLocal() + "\n"
                        + "Data de cadastro........: " + peca.getData() + "\n"
                    + "_________________________________________" + "\n";
            return retorno;
        }
        else{
            return null;
        }
    }
    
    public boolean removerPeca(String nome) throws ClassNotFoundException, IOException {
        pecas = pecaDAO.buscarTudoArquivo();
        boolean check = false;
        for (Peca peca: pecas) {
            if(peca.getNome().equals(nome)) {
                pecas.remove(peca);
                check = true;
                break;
            }
        }
        
        if(check) {
            pecaDAO.salvarTudoArquivo(pecas);
        }
        
        return check;
    }
    
    public boolean editarPeca(String pecaRemovida, String nome, int quantidade, float preco, String data, String prateleira, String local) throws ClassNotFoundException, IOException {
        int id = -1;
        this.removerPeca(pecaRemovida);
        Peca peca = new Peca(id, nome, quantidade, preco, data, prateleira, local);
        pecaDAO.salvarArquivo(peca);
        
        return true;
    }
}
