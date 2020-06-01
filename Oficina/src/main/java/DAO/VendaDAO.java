/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import models.Venda;

/**
 *
 * @author rmb
 */
public class VendaDAO {
    
    public VendaDAO(){}
    
    public boolean salvarArquivo(ArrayList<Venda> vendas) {
        try{
            OutputStream fileStream = new FileOutputStream("vendas.bin");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(vendas);
            os.close();
            fileStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public ArrayList<Venda> buscarArquivo() throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("vendas.bin"); 
            ObjectInputStream ois = new ObjectInputStream(ios);
                        
            ArrayList<Venda> vendas = (ArrayList<Venda>) ois.readObject();
            
            ios.close();
            ois.close();
            
            return vendas;


        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
}
