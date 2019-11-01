/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import editor.editor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio, leonardo
 */
public class trhd implements Runnable{
    
    private final BufferedReader buffer;
    private BufferedWriter bw;
    private volatile boolean closeflag;
    private volatile boolean saveflag;

    
    public trhd(BufferedReader br){
        this.buffer = br;
        this.closeflag = false;
        this.saveflag = false;
     
    }
    
    @Override
    public void run() 
    {
        editor ed=new editor(this.buffer);
        
        while(!ed.isCloseflag())
        {
            if(ed.isSaveflag())
            { 
                this.saveflag=true; 
                
                while(this.saveflag){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                }
                ed.setSaveflag(false);
                ed.writefile(this.bw); 
            }
        }
        
    }

  
    /**
     * define closeflag
     * @param closeflag
     */
    public void setCloseflag(boolean closeflag) {
        this.closeflag = closeflag;
    }

    /**
     *
     * @param saveflag
     */
    public void setSaveflag(boolean saveflag) {
        this.saveflag = saveflag;
    }
    /**
     *
     * @return
     */
    public boolean isCloseflag() {
        return closeflag;
    }

    public boolean isSaveflag() {
        return saveflag;
    }

   public void setWriter(BufferedWriter bw){
       this.bw = bw;
   }
    

    
}