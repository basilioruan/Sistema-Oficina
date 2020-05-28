/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
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
    
    public boolean salvarTudoArquivo(ArrayList<Peca> pecas) {
        try{
            File file = new File( "pecas.bin" ); 
            file.delete(); 
            if(pecas.size() > 0){
                OutputStream fileStream = new FileOutputStream("pecas.bin", true);
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                for(Peca peca : pecas) {
                    os.writeObject(peca);
                }
                os.close();
            }
            return true;
        }catch(IOException e){
            System.out.println("Erro ao salvar no arquivo");
            return false;
        }
    }
    
    public Peca buscarArquivo(String nome) throws IOException, ClassNotFoundException {
        try{
			
            FileInputStream ios = new FileInputStream("pecas.bin"); 
            ObjectInputStream ois;
            int bytes = ios.available();
            Peca peca;
            int restante = 4;
            while(restante < bytes) {
                ois = new ObjectInputStream(ios);
                peca = (Peca) ois.readObject();
                if(peca.getNome().equals(nome)) {
                    ios.close();
                    ois.close();
                    return peca;
                }
                restante = restante + 182;
            }

            ios.close();
            
            
            return null;

        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
    public ArrayList<Peca> buscarTudoArquivo() throws ClassNotFoundException, IOException {
        try{
			
            FileInputStream ios = new FileInputStream("pecas.bin");
            ObjectInputStream ois;
            ArrayList<Peca> pecas = new ArrayList<>();
            int bytes = ios.available();
            Peca peca;
            int restante = 4;
            while(restante < bytes) {
                ois = new ObjectInputStream(ios);
                peca = (Peca) ois.readObject();
                pecas.add(peca);
                restante = restante + 182;
                if(restante >= bytes) {
                    ois.close();
                }
            }

            ios.close();
            
            return pecas;

        }catch(FileNotFoundException e){
            System.out.println("O arquivo não existe.");
        }
        return null;
    }
    
}
