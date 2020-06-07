/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PecaController;
import helpers.Helper;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rmb
 */
public class PecaView {
    
    Scanner ler = new Scanner(System.in);
    PecaController controller;
    
    public PecaView() throws IOException, ClassNotFoundException{
        this.controller = new PecaController();
    }
    
    public void menu() throws IOException, ClassNotFoundException, InterruptedException {
        String opcao = "";
        while(!opcao.equals("0")){
            Helper.limparTela();
            
            System.out.println("======== MENU DE PEÇAS ========");
            System.out.println("1 - Cadastrar peça");
            System.out.println("2 - Buscar peça");
            System.out.println("3 - Exibir peças");
            System.out.println("4 - Editar peça");
            System.out.println("5 - Remover peça");
            System.out.println("6 - Adicionar estoque");
            System.out.println("7 - Exibir peças sem estoque");
            System.out.println("0 - Voltar para o menu principal");
            System.out.print("Escolha a opção desejada: ");
            opcao = ler.nextLine();
            
            Helper.limparTela();
            if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3") || opcao.equals("4") || opcao.equals("5") || opcao.equals("6") || opcao.equals("7")){
                if(opcao.equals("1")) {
                    inserir();
                }

                else if(opcao.equals("2")) {
                    consultarPeca();
                }

                else if(opcao.equals("3")){
                    imprimir();
                }

                else if(opcao.equals("4")){
                    editarPeca();
                }

                else if(opcao.equals("5")){
                    removerPeca();
                }
                
                else if(opcao.equals("6")) {
                    adicionarEstoque();
                }
                
                else if(opcao.equals("7")) {
                    exibirSemEstoque();
                }
            }
            else if(!opcao.equals("0")){
                System.out.println("Opção selecionada inválida, digite apenas um único número.");
                System.out.print("Pressione ENTER para continuar");
                ler.nextLine();
            }
        }
    }
    
    public void inserir() {
    
        System.out.print("Digite o nome da peça: ");
        String nome = ler.nextLine();
        
        System.out.print("Digite a quantidade da peça: ");
        int quantidade = ler.nextInt();
        Helper.clearBuffer(ler);
        
        System.out.print("Digite o preço da peça: ");
        float preco = ler.nextFloat();
        Helper.clearBuffer(ler);
        
        System.out.print("Digite a prateleira da peça: ");
        String prateleira = ler.nextLine();
        
        System.out.print("Digite o local da prateleira: ");
        String local = ler.nextLine();
        
        String data = Helper.gerarData();
        
        /*if(controller.inserir(nome, quantidade, preco, data, prateleira, local)){
            System.out.println("Peça cadastrada com sucesso!");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        } 
        else {
            System.out.println("Erro ao cadastrar a peça!");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        }*/
    }
    
    public void imprimir() throws IOException, ClassNotFoundException {
        System.out.println(controller.mostrarPecas());
        System.out.print("Pressione Enter para continuar");
        ler.nextLine();
    }
    
    public void consultarPeca() throws IOException, ClassNotFoundException {
        System.out.print("Digite o nome da peça que deseja buscar: ");
        String nome = ler.nextLine();
        //String peca = (controller.consultarPeca(nome));
        
        /*if(peca != null) {
            System.out.println("\n" + "--------------Peça buscada--------------" + "\n");
            System.out.println(peca);
        }
        else {
            System.out.println("A peça (" + nome + ") não foi encontrada no sistema");
        }*/
            
        System.out.print("Pressione Enter para continuar");
        ler.nextLine();
    }
    
    public void removerPeca() throws ClassNotFoundException, IOException {
        System.out.print("Digite o nome da peça que deseja remover: ");
        String nome = ler.nextLine();
        
        if(controller.removerPeca(nome)) {
            System.out.println(nome + " excluido com sucesso.");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        }
        else {
            System.out.println("A peça (" + nome + ") não foi encontrada no sistema");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        }
    }
    
    public void editarPeca() throws IOException, IOException, ClassNotFoundException {
        System.out.print("Digite o nome da peça que deseja editar: ");
        String nomeAntigo = ler.nextLine();
        /*String peca = controller.consultarPeca(nomeAntigo);
        if(peca != null) {
            System.out.println("\n" + "--------------Dados anteriores--------------" + "\n");
            System.out.println(peca);
            
            System.out.println("Digite os novos dados da peça \n");
            
            System.out.print("Digite o nome da peça: ");
            String nome = ler.nextLine();

            System.out.print("Digite a quantidade da peça: ");
            int quantidade = ler.nextInt();
            Helper.clearBuffer(ler);

            System.out.print("Digite o preço da peça: ");
            float preco = ler.nextFloat();
            Helper.clearBuffer(ler);

            System.out.print("Digite a prateleira da peça: ");
            String prateleira = ler.nextLine();

            System.out.print("Digite o local da prateleira: ");
            String local = ler.nextLine();
            
            String data = Helper.gerarData();
            
            /*if(controller.editarPeca(nomeAntigo, nome, quantidade, preco, data, prateleira, local)){
                System.out.println(nome + " editada com sucesso!");
                System.out.print("Pressione Enter para continuar");
                ler.nextLine();
            }
        }
        else {
            System.out.println("A peça (" + nomeAntigo + ") não foi encontrada no sistema");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        }*/
    }
    
    public void adicionarEstoque() throws IOException, ClassNotFoundException {
        System.out.print("Digite o nome da peça que deseja editar: ");
        String nome = ler.nextLine();
        /*String peca = controller.consultarPeca(nome);
        if(peca != null) {
            System.out.print("Digite a quantidade que chegou da peça: ");
            int quantidade = ler.nextInt();
            Helper.clearBuffer(ler);
            int estoque = controller.adicionarEstoque(quantidade, nome);
            if(estoque != -1) {
                System.out.println("Foram adicionado " + quantidade + " ao estoque de " + nome + ". Total em estoque agora: " + estoque);
                System.out.print("Pressione Enter para continuar");
                ler.nextLine();
            }
        }
        else {
            System.out.println("A peça (" + nome + ") não foi encontrada no sistema");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        }*/
    }
    
    public void exibirSemEstoque() {
        
    }
    
}
