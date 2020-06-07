/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PecaController;
import controller.VendaController;
import helpers.Helper;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rmb
 */
public class VendaView {
    
    Scanner ler = new Scanner(System.in);
    private static VendaController controller;
    
    public VendaView() throws IOException, ClassNotFoundException {
        
        controller = new VendaController();
        
    }
    
    public void menu() throws IOException, InterruptedException, ClassNotFoundException {
        String opcao = "";
        while(!opcao.equals("0")){
            Helper.limparTela();
            
            System.out.println("======== MENU DE VENDAS ========");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Exibir vendas");
            System.out.println("0 - Voltar para o menu principal");
            System.out.print("Escolha a opção desejada: ");
            opcao = ler.nextLine();
            
            Helper.limparTela();
            if(opcao.equals("1") || opcao.equals("2")){
                if(opcao.equals("1")) {
                    realizarVenda();
                }

                else if(opcao.equals("2")) {
                    exibirVendas();
                }
                
            }
            else if(!opcao.equals("0")){
                System.out.println("Opção selecionada inválida, digite apenas um único número.");
                System.out.print("Pressione ENTER para continuar");
                ler.nextLine();
            }
        }
    }
    
    public void realizarVenda() throws IOException, ClassNotFoundException {
        System.out.print("Digite o produto a ser vendido: ");
        String nome = ler.nextLine();
        
        System.out.print("Digite a quantidade a ser vendida do produto: ");
        int quantidade = ler.nextInt();
        Helper.clearBuffer(ler);
        
        //String retorno = controller.realizarVenda(nome, quantidade);
        
        //System.out.println(retorno);

        System.out.print("Pressione ENTER para continuar");
        ler.nextLine();
    }
    
    public void exibirVendas() {
        //System.out.println(controller.exibirVendas());
        System.out.print("Pressione ENTER para continuar");
        ler.nextLine();
    }
    
}
