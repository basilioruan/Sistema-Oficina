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
import models.Peca;

/**
 *
 * @author rmb
 */
public class PecaDAO {
    
    public PecaDAO(){}
    
    public boolean salvarArquivo(Peca peca) {
        try{
            OutputStream fileStream = new FileOutputStream("pecas.bin", true);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(peca);
            os.close();
            fileStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public Peca buscarArquivo(String nome) throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("pecas.bin");
            ObjectInputStream ois = new ObjectInputStream(ios);
            
            Peca peca;
            peca = (Peca) ois.readObject();
            
            int cont = 0;
            
            while(peca != null) {
                System.out.println(cont);
                cont++;
                if(peca.getNome().equals(nome)) {
                    ios.close();
                    ois.close();
                    return peca;
                }
                ois = new ObjectInputStream(ios);
                peca = (Peca) ois.readObject();
                System.out.println(peca.getNome());
            }

            ios.close();
            ois.close();
            
            return null;

        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
}
