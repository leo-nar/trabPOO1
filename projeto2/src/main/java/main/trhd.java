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

        
        editor ed=new editor(this.buffer);
        
        
        while(!ed.isCloseflag())
        {
            if(ed.isSaveflag())
            {
                ed.setSaveflag(false);
                this.buffer=ed.getBuffer();
            }
        }
        
    }
    

    
}
