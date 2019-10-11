
package pilhas;

import textos.texto;

/**
 *Uma stack que permite refafzer uma alteracao do texto
 * @author Julio, Leonardo
 */
public class Desfazer extends pilha {
    
    /**
     * Metodo para desfazer alteracoes no texto
     * @param r Pilha do tipo refazer, onde sera colocado o estado atual do texto
     * @param t texto que sera colocado na pilha de reazer
     * @return Retorna o texto no topo da pilha de desfafzer, se existir alguem. Caso contrario retorna o proprio t.
     */
    public texto undo(Refazer r, texto t){
        if (!this.p.empty()){
            r.push(t);   
            return this.pop();
        }
        else{
            System.out.println("Nao ha nada para desfazer");
        }
        return t;
    }
}
