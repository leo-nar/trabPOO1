/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editor_de_texto;
import java.util.LinkedList;
/**
 *
 * @author Leonardo Rodrigues
 */
public class texto {
    
    LinkedList<Character>  inserto;    

     private void texto() {
        this.inserto = new LinkedList() ;
        //nao precisa de indicador de tamanho pois o ArrayList ja tem
    }
    
    /**
     *
     * @param entrada->entrada do texto
     * @param stk
     */
    public void insert_end(String entrada, stack_undu stk)
     {
        int c;
        char ch;
        
        
        stk.push(this);
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
     * @param stk
     */
    public void insert_middle(String entrada ,int index,stack_undu stk)
     {
     
        stk.push(this);
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
        char ch;
        int c=this.inserto.size();
        
        
        for (int i=0;i<c;i++)
        {
            ch=this.inserto.get(i);
            System.out.println(ch);
        }
     }
     
    
    
}
