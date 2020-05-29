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
import models.Peca;

/**
 *
 * @author rmb
 */
public class PecaDAO {
    
    public PecaDAO(){}
    
    public boolean salvarArquivo(ArrayList<Peca> pecas) {
        try{
            OutputStream fileStream = new FileOutputStream("pecas.bin");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(pecas);
            os.close();
            fileStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public ArrayList<Peca> buscarArquivo() throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("pecas.bin"); 
            ObjectInputStream ois = new ObjectInputStream(ios);
                        
            ArrayList<Peca> pecas = (ArrayList<Peca>) ois.readObject();
            
            ios.close();
            ois.close();
            
            return pecas;


        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }

}
