/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editor_de_texto;

/**
 *boi
 * @author Leonardo Rodrigues
 */

import java.util.Stack;


public class stack_undu {
    
    Stack<texto> stack;
    /**
     *
     */
    public void texto()
   {
       this.stack = new Stack();
       
   }
    
    /**
     *
     * @param entrada-> string a ser incerida na pilha
     */
    public void push(texto entrada)
     {
         this.stack.push(entrada);
     }
     
    /**
     *
     * @return 
     * @return->retorna a string no topo da pilha
     */
    public texto pop()
     {
         
         texto poped;
         poped= this.stack.pop();
         
         return poped;
         
     }
    
    
    
}
