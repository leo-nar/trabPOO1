
package pilhas;
import java.util.Stack;
import textos.texto;

public class pilha {
    protected final Stack<texto> p;
    
    /**
     *Construtor para classe pilha. Inicializa p como um Stack.
     */
    public pilha(){
        this.p = new Stack();
    }
    
    /**
     * Insere um elemento de texto no topo da pilha
     * @param item texto a ser inserido na pilha
     */
    public void push(texto item){
        this.p.push(item);
    }
    
    /**
     *Remove um elemento de texto do topo da pilha
     * @return elemento texto no topo da pilha
     */
    public texto pop(){
        return  this.p.pop();
    }
}
