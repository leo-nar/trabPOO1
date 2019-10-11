/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhas;

import textos.texto;


public class Refazer extends pilha {
    
    /**
     * Refaz uma modificacao do texto
     * @param d Pilha do tipo desfazer que recebera o estado atual do texto
     * @param t texto que sera colocado na pilha de desfazer
     * @return Retorna o elemento do topo da pilha de refazer se tiver algume.Se nao retorna o proprio t
     */
    public texto redo(Desfazer d, texto t){
        if (!this.p.empty()){
            d.push(t);
            return this.p.pop();
        }
        else{
            System.out.println("Nao ha nada para refazer");
        }
        return t;
    }
    
}
