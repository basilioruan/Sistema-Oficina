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
import models.Caderneta;

/**
 *
 * @author rmb
 */
public class SistemaDAO {
    
    public SistemaDAO(){}
    
    public boolean salvarArquivo(String senha) {
        try{
            OutputStream fileStream = new FileOutputStream("sistema.bin");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(senha);
            os.close();
            fileStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public String buscarArquivo() throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("sistema.bin"); 
            ObjectInputStream ois = new ObjectInputStream(ios);
                        
            String senha = (String) ois.readObject();
            
            ios.close();
            ois.close();
            
            return senha;


        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
}
