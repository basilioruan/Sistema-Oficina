/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author rmb
 */
public class ClienteController {
    
    private static ArrayList<Cliente> clientes;
    private ClienteDAO clienteDAO;
    
    public ClienteController() throws IOException, ClassNotFoundException {
        clientes = new ArrayList<Cliente>();
        clienteDAO = new ClienteDAO();
        File arquivo = new File("clientes.bin");
        if(arquivo.exists()){
            clientes = clienteDAO.buscarArquivo();
        }
    }
    
    public boolean cadastrarCliente(String nome, String cpf, String email, String telefone, String data) {
        nome = nome.toLowerCase();
        Cliente cliente = new Cliente(nome, cpf, email, telefone, data);
        clientes.add(cliente);
        return clienteDAO.salvarArquivo(clientes);
        
    }
    
    public Cliente buscarClienteCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        
        return null;
    }
    
    public ArrayList<Cliente> buscarClienteNome(String nome) {
        nome = nome.toLowerCase();
        ArrayList<Cliente> retorno = new ArrayList<Cliente>();
        for(Cliente cliente : clientes){
            if(cliente.getNome().startsWith(nome)){
                retorno.add(cliente);
            }
        }
        return retorno;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
}
