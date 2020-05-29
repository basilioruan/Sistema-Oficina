/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author rmb
 */
public class ClienteController {
    
    private static ArrayList<Cliente> clientes;
    
    public ClienteController() {
        clientes = new ArrayList<Cliente>();
    }
    
    public String cadastrarCliente(String nome, String cpf, String email, String telefone, double saldoDevedor, String data) {
        Cliente cliente = new Cliente(nome, cpf, email, telefone, saldoDevedor, data);
        clientes.add(cliente);
        return "Cliente cadastrado com sucesso!";
    }
    
    public String buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                String retorno = "Nome....................: " + cliente.getNome() + "\n"
                                + "CPF.....................: " + cliente.getCpf()+ "\n"
                                + "E-mail..................: " + cliente.getEmail() + "\n"
                                + "Telefone................: " + cliente.getTelefone()+ "\n"
                                + "Saldo devedor...........: " + cliente.getSaldoDevedor() + "\n"
                                + "Data de pagamento.......: " + cliente.getData() + "\n"
                                + "_________________________________________" + "\n" + "\n";
                return retorno;
            }
        }
        
        return "Cliente não encontrado";
    }
    
    public String exibirClientes(){
        String retorno = "----------------Listando Clientes----------------" + "\n" + "\n";
        for(Cliente cliente : clientes) {
            retorno = retorno + "Nome....................: " + cliente.getNome() + "\n"
                            + "CPF.....................: " + cliente.getCpf()+ "\n"
                            + "E-mail..................: " + cliente.getEmail() + "\n"
                            + "Telefone................: " + cliente.getTelefone()+ "\n"
                            + "Saldo devedor...........: " + cliente.getSaldoDevedor() + "\n"
                            + "Data de pagamento.......: " + cliente.getData() + "\n"
                            + "_________________________________________" + "\n" + "\n";
        }
        return retorno;
    }
}
