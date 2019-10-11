package textos;

import java.util.LinkedList;

public class texto {
    
   private final LinkedList<Character> text;
   private int tamanho;

    /**
     *Construtor do texto. Inicializa a lista e a variavel tamanho
     */
    public texto() {
       this.text = new LinkedList();//inicializa a lisata encadeada que contera o texto
       this.tamanho = this.text.size();
    }

    /**
     * Retorna o numero de caracteres no texto
     * @return quantos caracteres existem no texto
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Insere no texto uma String s na posicao index
     * @param s string que sera inserida no texto
     * @param index posicao do cursor onde sera inserida a String
     * @return a posicao do cursor apos inserir a String, que sera a posicao imediatamente depois do ultimo caractere inserido
     */
    public int insert(String s, int index){
        int i;
        for ( i=0 ;i<s.length();i++){
            this.text.add(index, s.charAt(i));//adiciona o caractere na posicao do cursos
            index++;
        }
        this.tamanho+=s.length();
        return index;
    }
    
    /**
     * Remove n caracteres a esquerda do cursor. Se nao existirem n caracteres, retorna uma mensagem de erro e a posicao do cursor nao muda
     * @param n Numero de caracteres a serem removidos
     * @param index Posicao do cursor para comecar a remocao
     * @return A posicao do cursor apos a remocao
     */
    public int remove(int n,int index){
        if (n <= this.text.size()) {
            for (int i = 0; i < n; i++) {
                this.text.remove(index - 1);
                index--;
            }
            this.tamanho-=n;
        }
        else{
            System.out.println("Nao existem caracteres suficientes, entao nada sera feito.");
        }
        return index;
    }
    
    /**
     * Imprime o texto e pula uma linha
     */
    public void print() {//imprime o texto
       char ch;
       int size = this.text.size();
       System.out.println("Texto:");
        for (int i = 0; i < size; i++) {
           ch = this.text.get(i);
           System.out.print(ch);
      }
        System.out.println();
   }

}
