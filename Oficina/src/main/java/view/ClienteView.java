/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.VendaController;
import helpers.Helper;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rmb
 */
public class ClienteView {
    
    Scanner ler = new Scanner(System.in);
    private static ClienteController controller;
    
    public ClienteView() {
        controller = new ClienteController();
    }
    
    public void menu() throws IOException, InterruptedException, ClassNotFoundException {
        String opcao = "";
        while(!opcao.equals("0")){
            Helper.limparTela();
            
            System.out.println("======== MENU DE CLIENTES ========");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Buscar cliente");
            System.out.println("3 - Exibir clientes");
            System.out.println("0 - Voltar para o menu principal");
            System.out.print("Escolha a opção desejada: ");
            opcao = ler.nextLine();
            
            Helper.limparTela();
            if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3")){
                if(opcao.equals("1")) {
                    cadastrarCliente();
                }
                
                else if(opcao.equals("2")) {
                    buscarCliente();
                }

                else if(opcao.equals("3")) {
                    exibirClientes();
                }
                
            }
            else if(!opcao.equals("0")){
                System.out.println("Opção selecionada inválida, digite apenas um único número.");
                System.out.print("Pressione ENTER para continuar");
                ler.nextLine();
            }
        }
    }
    
    public void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = ler.nextLine();
        
        System.out.print("Digite o CPF: ");
        String cpf = ler.nextLine();
        
        System.out.print("Digite o e-mail: ");
        String email = ler.nextLine();
        
        System.out.print("Digite o telefone: ");
        String telefone = ler.nextLine();
        
        System.out.print("Digite o saldo restante: ");
        double saldo = ler.nextDouble();
        Helper.clearBuffer(ler);
        
        String data = "29/06/2020";
        
        String retorno = controller.cadastrarCliente(nome, cpf, email, telefone, saldo, data);
        
        System.out.println(retorno);

        System.out.print("Pressione ENTER para continuar");
        ler.nextLine();
    }
    
    public void buscarCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = ler.nextLine();
        System.out.println(controller.buscarCliente(cpf));
        System.out.print("Pressione ENTER para continuar");
        ler.nextLine();
    }
    
    public void exibirClientes() {
        System.out.println(controller.exibirClientes());
        System.out.print("Pressione ENTER para continuar");
        ler.nextLine();
    }
    
}
