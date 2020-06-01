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
import models.Cliente;

/**
 *
 * @author rmb
 */
public class ClienteDAO {
    
    public ClienteDAO(){}
    
    public boolean salvarArquivo(ArrayList<Cliente> clientes) {
        try{
            OutputStream fileStream = new FileOutputStream("clientes.bin");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(clientes);
            os.close();
            fileStream.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public ArrayList<Cliente> buscarArquivo() throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("clientes.bin"); 
            ObjectInputStream ois = new ObjectInputStream(ios);
                        
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) ois.readObject();
            
            ios.close();
            ois.close();
            
            return clientes;


        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
}
