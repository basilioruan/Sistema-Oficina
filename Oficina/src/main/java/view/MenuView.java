/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import helpers.Helper;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rmb
 */
public class MenuView {
    
    public static void menu() throws IOException, InterruptedException, ClassNotFoundException {
        Scanner ler = new Scanner(System.in);
        PecaView pecaView = new PecaView();
        VendaView vendaView = new VendaView();
        ClienteView clienteView = new ClienteView();
        String opcao = "";
        
        Helper.limparTela();
        while(!opcao.equals("0")) {
            
            System.out.println("======== MENU ========");
            System.out.println("1 - Menu produtos");
            System.out.println("2 - Menu vendas");
            System.out.println("3 - Menu clientes");
            System.out.println("0 - Fechar");
            System.out.print("Escolha a opção desejada: ");
            opcao = ler.nextLine();
            Helper.limparTela();
            if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3")){

                if(opcao.equals("1")) {
                    pecaView.menu();
                }

                else if(opcao.equals("2")) {
                    vendaView.menu();
                }

                else if(opcao.equals("3")){
                    clienteView.menu();
                }
            }
            else if(!opcao.equals("0")){
                System.out.println("Opção selecionada inválida, digite apenas um único número.");
                System.out.print("Pressione ENTER para continuar");
                ler.nextLine();
            }
            else {
                System.out.print("Deseja realmente fechar o programa? (s/n): ");
                opcao = ler.nextLine();
                if(opcao.equals("s")) {
                    opcao = "0";
                }
                else {
                    opcao = "";
                }
            }
        }

    }
}
