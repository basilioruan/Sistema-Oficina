/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CadernetaDAO;
import helpers.Helper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Caderneta;
import models.Cliente;
import models.Venda;

/**
 *
 * @author rmb
 */
public class CadernetaController {
    
    private static ArrayList<Caderneta> cadernetas;
    private CadernetaDAO cadernetaDAO;
    
    public CadernetaController() throws IOException, ClassNotFoundException {
        cadernetas = new ArrayList<Caderneta>();
        cadernetaDAO = new CadernetaDAO();
        File arquivo = new File("cadernetas.bin");
        if(arquivo.exists()){
            cadernetas = cadernetaDAO.buscarArquivo();
        }
    }
    
    public boolean cadastrarCaderneta(Cliente cliente, Venda venda, float valorTotal, float valorPago, String dataPagamento) throws IOException, ClassNotFoundException{
        float valorDevedor = valorTotal - valorPago;
        String dataAbertura = Helper.gerarData();
        
        VendaController vendaController = new VendaController();
        vendaController.realizarVenda(venda);
        
        Caderneta caderneta = new Caderneta(cliente, venda, valorTotal, valorPago, valorDevedor, dataAbertura, dataPagamento);
        
        cadernetas.add(caderneta);
        
        return cadernetaDAO.salvarArquivo(cadernetas);
    }
    
    public ArrayList<Caderneta> getCadernetas(){
        return cadernetas;
    }
    
    public float getValorDia(String data){
        float total = 0;
        for(Caderneta caderneta : cadernetas){
            for(String s : caderneta.getTodasDataPagamentos()){
                if(s.contains(data)){
                    total = total + caderneta.getPagamentoData(data);
                    System.out.println(total);
                }
            }
        }
        return total;
    }
    
    public Caderneta buscar(String nome, String dataInicio){
        nome = nome.toLowerCase();
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getNome().equals(nome) && caderneta.getDataAbertura().equals(dataInicio)){
                return caderneta;
            }
        }
        
        return null;
    }
    
    public ArrayList<Caderneta> buscarPeloCpf(String cpf){
        ArrayList<Caderneta> retorno = new ArrayList<Caderneta>();
        
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getCpf().equals(cpf)){
                retorno.add(caderneta);
            }
        }
        
        return retorno;
    }
    
    public ArrayList<Caderneta> buscarAbertos(){
        ArrayList<Caderneta> retorno = new ArrayList<Caderneta>();
        
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getStatus().equals("Aberto")){
                retorno.add(caderneta);
            }
        }
        
        return retorno;
    }
    
    public ArrayList<Caderneta> buscarFechados(){
        ArrayList<Caderneta> retorno = new ArrayList<Caderneta>();
        
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getStatus().equals("Fechado")){
                retorno.add(caderneta);
            }
        }
        
        return retorno;
    }
    
    public boolean fecharCaderneta(String cpf, String dataInicio){
        String data = Helper.gerarData();
        
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getCpf().equals(cpf) && caderneta.getDataAbertura().equals(dataInicio)){
                caderneta.fechar(data);
                caderneta.setValorDevedor(0);
                caderneta.setValorPago(caderneta.getValorTotal());
                break;
            }
        }
        
        return cadernetaDAO.salvarArquivo(cadernetas);
    }
    
    public ArrayList<Caderneta> buscarPorNome(String nome){
        nome = nome.toLowerCase();
        ArrayList<Caderneta> cadernetasBuscadas = new ArrayList<Caderneta>();
        
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getNome().startsWith(nome)){
                cadernetasBuscadas.add(caderneta);
            }
        }
        
        return cadernetasBuscadas;
    }
    
    public ArrayList<Caderneta> buscarPorCpf(String cpf){
        ArrayList<Caderneta> cadernetasBuscadas = new ArrayList<Caderneta>();
        
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getNome().startsWith(cpf)){
                cadernetasBuscadas.add(caderneta);
            }
        }
        
        return cadernetasBuscadas;
    }
    
    public Caderneta getCadernetaCpfData(String cpf, String dataInicial){
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getCpf().equals(cpf) && caderneta.getDataAbertura().equals(dataInicial)){
                return caderneta;
            }
        }
        return null;
    }
    
    public boolean receberPagamento(String cpf, String dataInicial, float pagamento, float restante, String dataPagamento){
        String data = Helper.gerarData();
        for(Caderneta caderneta : cadernetas){
            if(caderneta.getCliente().getCpf().equals(cpf) && caderneta.getDataAbertura().equals(dataInicial)){
                float valor = pagamento + caderneta.getValorPago();

                if(valor == caderneta.getValorTotal()){
                    caderneta.adicionarPagamento(pagamento);
                    caderneta.adicionarDataPagamento(data);
                    fecharCaderneta(cpf, dataInicial);
                }
                else{
                    float pago = caderneta.getValorPago() + pagamento;
                    caderneta.setValorPago(pago);
                    caderneta.adicionarPagamento(pagamento);
                    caderneta.adicionarDataPagamento(data);
                    float total = caderneta.getValorDevedor();
                    caderneta.setValorDevedor(restante);
                    caderneta.setDataPagamento(dataPagamento);
                }
            }
        }
        return cadernetaDAO.salvarArquivo(cadernetas);
        
    }
}
