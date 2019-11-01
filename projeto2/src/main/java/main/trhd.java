/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import editor.editor;
import java.io.BufferedReader;

/**
 *
 * @author julio
 */
public class trhd implements Runnable{
    
    private BufferedReader buffer;
    
    public trhd(BufferedReader br){
        this.buffer = br;
    }
    
    @Override
    public void run() 
    {
        //cria o promptfile  que pergunta pelo nome do arquivo
        fileprompt fp = new fileprompt();
        
        while(fp.getFlag()){}
        
        //editor ed=new editor(fp.getNomarq());
        
        //chama o editor com o nome do arquivo
        
        //fica em loop ate o editor fechar
        
    }
    
    public void arquivo(String nomarq)
    {
        //faz todo tratamento de arquivo necessario
    }
    
    
}
