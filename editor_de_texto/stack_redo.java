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

import java.util.Stack;


public class stack_redo {
    
    Stack<texto> stk;
    
    public void stack_redo()
    {
        stk = new Stack();  
    }
    
    /**
     *
     * @param entrada
     */
    public void push(texto entrada)
    {
        stk.push(entrada);
    }
    
    /**
     *
     * @return
     */
    public texto pop()
    {
        return stk.pop();
    }
}
