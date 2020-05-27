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
public class main {
    
    public static void main (String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Scanner ler = new Scanner(System.in);
        PecaView pecaView = new PecaView();
        int opcao = -1;
        
        while(opcao != 0){
            Helper.limparTela();
            
            System.out.println("======== MENU ========");
            System.out.println("1 - Cadastrar peça");
            System.out.println("2 - Buscar peça");
            System.out.println("3 - Exibir peças");
            System.out.println("4 - Editar peça");
            System.out.println("5 - Remover peça");
            System.out.println("6 - Realizar venda");
            System.out.println("0 - Fechar");
            System.out.print("Escolha a opção desejada: ");
            opcao = ler.nextInt();
            Helper.clearBuffer(ler);
            
            Helper.limparTela();
            
            if(opcao == 1) {
                pecaView.inserir();
            }
            
            else if(opcao == 2) {
                pecaView.consultarPeca();
            }
            
            else if(opcao == 3){
                pecaView.imprimir();
            }
            
            else if(opcao == 4){
                pecaView.editarPeca();
            }
            
            else if(opcao == 5){
                pecaView.removerPeca();
            }
        }
    }
}
