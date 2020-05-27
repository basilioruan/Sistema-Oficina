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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        PecaDAO pecaDAO = new PecaDAO();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String data = dateFormat.format(date);
        Peca peca = new Peca(valorId, nome, quantidade, preco, data);
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
    
    public String mostrarPecas() {
        if(pecas.size() > 0) {
            String retorno = "----------------Listando Peças----------------" + "\n" + "\n";

            for (Peca peca : pecas) {
                retorno = retorno + "Nome: " + peca.getNome() + "\n"
                        + "Quantidade em estoque: " + peca.getQuantidade() + "\n"
                        + "Preço: " + peca.getPreco() + "\n"
                        + "Data de cadastro: " + peca.getData() + "\n"
                        + "_________________________________________" + "\n" + "\n";
            }
            return retorno;
        }
        else {
            return "Não possui peças no sistema";
        }
    }
    
    public String consultarPeca(String nome) throws IOException, ClassNotFoundException {
        PecaDAO pecaDAO = new PecaDAO();
        Peca peca = pecaDAO.buscarArquivo(nome);
        if(peca != null){
            String retorno = "Nome: " + peca.getNome() + "\n"
                    + "Quantidade em estoque: " + peca.getQuantidade() + "\n"
                    + "Preço: " + peca.getPreco() + "\n"
                    + "Data de cadastro: " + peca.getData() + "\n"
                    + "_________________________________________" + "\n";
            return retorno;
        }
        else{
            return null;
        }
    }
    
    public boolean removerPeca(String nome) {
        for (Peca peca: pecas) {
            if(peca.getNome().equals(nome)) {
                pecas.remove(peca);
                return true;
            }
        }
        return false;
    }
}
