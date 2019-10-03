/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editor_de_texto;
import java.util.ArrayList;
import java.lang.String;
/**
 *
 * @author Leonardo Rodrigues
 */
public class texto {
    
    ArrayList  inserto;    

     private void main() {
        this.inserto = new ArrayList() ;
        //nao precisa de indicador de tamanho pois o ArrayList ja tem
    }
    
    /**
     *
     * @param entrada->entrada do texto
     */
    public void insert_end(String entrada)
     {
        int c;
        char ch;
        
        
        // push entrada
        c = entrada.length();
     
        for(int i=0;i<c;i++)
        {
        
           ch= entrada.charAt(i);
           this.inserto.add(ch);
        
        }
            
     }
     
    /**
     *
     * @param entrada->entrada do texto
     * @param index-> ponteiro
     */
    public void insert_middle(String entrada ,int index)
     {
     
         //push entrada
        int c;
        char ch;
        c = entrada.length();
     
        for(int i=0;i<c;i++)
        {
        
           ch= entrada.charAt(i);
           this.inserto.add(index, ch);
        
        }

     }
    
    
    
     
    /**
     *
     */
    public void print() {
        int c=this.inserto.size();
        
        
        for (int i=0;i<c;i++)
            System.out.println(this.inserto.get(i));
     }
     
    
    
}
