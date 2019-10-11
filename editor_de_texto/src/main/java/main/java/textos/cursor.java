
package textos;

import java.util.Scanner;

/**
 *
 * @author julio
 */
public class cursor {
    private int posicao;

    public cursor(){
        this.posicao = 0;
    }
    
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    /**
     * Move o cursor para uma posicao digitada pelo usuario.Se a posicao nao for valida, retorna uma mensagem de erro
     * @param s Scanner de onde sera retirado o valor
     * @param t
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
