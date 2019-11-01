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
        editor e = new editor(this.buffer);
        
        //editor ed=new editor(fp.getNomarq());
        
        //chama o editor com o nome do arquivo
        
        //fica em loop ate o editor fechar
        
    }
    
    
    
    
}
