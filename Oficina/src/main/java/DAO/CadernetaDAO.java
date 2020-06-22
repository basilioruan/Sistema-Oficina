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
public class CadernetaDAO {
    
    public CadernetaDAO(){}
    
    public boolean salvarArquivo(ArrayList<Caderneta> cadernetas) {
        try{
            OutputStream fileStream = new FileOutputStream("cadernetas.bin");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(cadernetas);
            os.close();
            fileStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public ArrayList<Caderneta> buscarArquivo() throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("cadernetas.bin"); 
            ObjectInputStream ois = new ObjectInputStream(ios);
                        
            ArrayList<Caderneta> cadernetas = (ArrayList<Caderneta>) ois.readObject();
            
            ios.close();
            ois.close();
            
            return cadernetas;


        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
}
