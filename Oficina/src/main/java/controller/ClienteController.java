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
    
    public boolean cadastrarCliente(String nome, String cpf, String email, String telefone, float saldoDevedor, float saldoPago, float total, String data) {
        Cliente cliente = new Cliente(nome, cpf, email, telefone, saldoDevedor, saldoPago, total, data);
        clientes.add(cliente);
        return clienteDAO.salvarArquivo(clientes);
        
    }
    
    public String buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                String retorno = "\n" + "Nome....................: " + cliente.getNome() + "\n"
                                + "CPF.....................: " + cliente.getCpf()+ "\n"
                                + "E-mail..................: " + cliente.getEmail() + "\n"
                                + "Telefone................: " + cliente.getTelefone()+ "\n"
                                + "Total...................: " + cliente.getTotal() + "\n"
                                + "Saldo pago..............: " + cliente.getSaldoPago() + "\n"
                                + "Saldo devedor...........: " + cliente.getSaldoDevedor() + "\n"
                                + "Data de pagamento.......: " + cliente.getData() + "\n"
                                + "_________________________________________" + "\n" + "\n";
                return retorno;
            }
        }
        
        return null;
    }
    
    public String exibirClientes(){
        String retorno;
        if(clientes.size() > 0) {
            retorno = "----------------Listando Clientes----------------" + "\n" + "\n";
            for(Cliente cliente : clientes) {
                retorno = retorno + "Nome....................: " + cliente.getNome() + "\n"
                                + "CPF.....................: " + cliente.getCpf()+ "\n"
                                + "E-mail..................: " + cliente.getEmail() + "\n"
                                + "Telefone................: " + cliente.getTelefone()+ "\n"
                                + "Saldo devedor...........: " + cliente.getSaldoDevedor() + "\n"
                                + "Data de pagamento.......: " + cliente.getData() + "\n"
                                + "_________________________________________" + "\n" + "\n";
            }
        }
        else {
            retorno = "Não possui clientes cadastrados no sistema";
        }
        return retorno;
    }
    
}
