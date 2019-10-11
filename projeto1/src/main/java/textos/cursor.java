
package textos;

import java.util.Scanner;

/**
 *Contem um int posicao e metodos para altera-la e acessa-la. Com um metodo que testa se a posicao digitada eh valida
 * @author Julio, Leonardo
 */
public class cursor {
    private int posicao;

    /**
     *Construtor. Inicializa a posicao do cursor como 0
     */
    public cursor(){
        this.posicao = 0;
    }
    
    /**
     *  Metodo get para a posicao do cursor
     * @return A posicao do cursor
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     *  Define a posicao do cursor 
     * @param posicao posicao do cursor no texto
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    /**
     * Move o cursor para uma posicao digitada pelo usuario.Se a posicao nao for valida, retorna uma mensagem de erro
     * @param s Scanner de onde sera retirado o valor
     * @param t texto de onde sera medido o tamanho
     */
    public void move(Scanner s, texto t){
        int aux;
        if (s.hasNextInt()){
            aux = s.nextInt();
            if (aux>t.getTamanho()||aux<0){
                System.out.println("Posicao invalida!");
            }
            else{
                this.posicao=aux;
            }
        }
        else{
            System.out.println("Posicao Invalida!");
        }
        s.nextLine();
    }
}
