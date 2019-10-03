/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editor_de_texto;

/**
 *
 * @author Leonardo Rodrigues
 */

import java.util.ArrayList;
import java.lang.String;


public class stack {
    
   ArrayList<String> stack;
   
    /**
     *
     */
    public void main()
   {
   
       this.stack = new ArrayList();
       
   }
    
    /**
     *
     * @param entrada-> string a ser incerida na pilha
     */
    protected void push(String entrada)
     {
         this.stack.add(entrada);
     }
     
    /**
     *
     * @return->retorna a string no topo da pilha
     */
    protected String pop()
     {
         
         String poped;
         int index;
         index= this.stack.size();
         poped= this.stack.get(index);
         
         return poped;
         
     }
    
    
    
}
