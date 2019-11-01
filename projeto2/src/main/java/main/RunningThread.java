/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import editor.editor;
import java.io.BufferedReader;
import java.io.BufferedWriter;


/**
 *Essa classe é a thread que sera rodada pelo servidor sempre que houver um novo pedido de abertura de arquivo e 
 * gerência a janela do editor aberta
 * @author julio, leonardo
 */
public class RunningThread implements Runnable{
    
    private final BufferedReader buffer;
    private BufferedWriter bw;
    private volatile boolean closeflag;
    private volatile boolean saveflag;

    /**
     *Construtor da classe. Recebe um buffered reader que sera usado para colocar o texto do arquivo na janela
     * do editor
     * @param br um buffered reader
     */
    public RunningThread(BufferedReader br){
        this.buffer = br;
        this.closeflag = false;
        this.saveflag = false;
     
    }
    
    /**
     *Método principal da thread.Inicia a janela do editor e gerencia quando for salvar ou desconectar
     */
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
            if (ed.isCloseflag()){
                this.closeflag = true;
                break;
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
     *Define o valor de saveflag
     * @param saveflag
     */
    public void setSaveflag(boolean saveflag) {
        this.saveflag = saveflag;
    }
    /**
     *getter de closeflag
     * @return valor da flag de fechamento da thread
     */
    public boolean isCloseflag() {
        return closeflag;
    }

    /**
     *getter da saveflag
     * @return valor da flag de salvamento
     */
    public boolean isSaveflag() {
        return saveflag;
    }

    /**
     *Setter do buffered writer usado para escrever o arquivo
     * @param bw buffered writer
     */
    public void setWriter(BufferedWriter bw){
       this.bw = bw;
   }
    

    
}