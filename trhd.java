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
                ed.setSaveflag(false);
                this.buffer=ed.getBuffer();
            }
        }
        
    }

    /**
     * define o buffer
     * @param buffer
     */
    public void setBuffer(BufferedReader buffer) {
        this.buffer = buffer;
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
     * retorna o buffer
     * @return buffer
     */
    public BufferedReader getBuffer() {
        return buffer;
    }

    /**
     *retorna o booleano closeflag
     * @return close flag
     */
    public boolean isCloseflag() {
        return closeflag;
    }

    /**
     *retorna o booleano saveflag
     * @return
     */
    public boolean isSaveflag() {
        return saveflag;
    }
    

    
}
