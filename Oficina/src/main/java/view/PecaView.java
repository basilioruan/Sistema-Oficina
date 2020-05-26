/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PecaController;
import helpers.Helper;
import java.util.ArrayList;
import java.util.Scanner;
import models.Peca;

/**
 *
 * @author rmb
 */
public class PecaView {
    
    Scanner ler = new Scanner(System.in);
    PecaController controller = new PecaController();
    
    public PecaView(){}
    
    public void inserir() {
    
        System.out.print("Digite o nome da peça: ");
        String nome = ler.nextLine();
        
        System.out.print("Digite a quantidade da peça: ");
        int quantidade = ler.nextInt();
        Helper.clearBuffer(ler);
        
        System.out.print("Digite o preço da peça: ");
        float preco = ler.nextFloat();
        Helper.clearBuffer(ler);
        
        if(controller.inserir(nome, quantidade, preco)){
            System.out.println("Peça cadastrada com sucesso!");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        } 
        else {
            System.out.println("Erro ao cadastrar a peça!");
            System.out.print("Pressione Enter para continuar");
            ler.nextLine();
        }
    }
    
    public void imprimir() {
        ArrayList<Peca> lista = new ArrayList<Peca>();
        lista = controller.getPecas();
        System.out.println("----------------Listando Peças----------------");
        
        for (Peca peca : lista) {
            System.out.println();
            System.out.print("Nome: ");
            System.out.println(peca.getNome());
            System.out.print("Quantidade em estoque: ");
            System.out.println(peca.getQuantidade());
            System.out.print("Preço da peça: ");
            System.out.println(peca.getPreco());
            System.out.println();
            System.out.println("_________________________________________");
        }
        
        System.out.print("Pressione Enter para continuar");
        ler.nextLine();
    }
    
    public void consultarPeca() {
        System.out.print("Digite o nome da peça que deseja buscar: ");
        String nome = ler.nextLine();
        Peca peca = controller.consultarPeca(nome);
        System.out.println("----------------Peça buscada----------------");
        System.out.println();
        System.out.print("Nome: ");
        System.out.println(peca.getNome());
        System.out.print("Quantidade em estoque: ");
        System.out.println(peca.getQuantidade());
        System.out.print("Preço da peça: ");
        System.out.println(peca.getPreco());
        System.out.println();
        System.out.println("_________________________________________");
        System.out.print("Pressione Enter para continuar");
        ler.nextLine();
    }
    
}
