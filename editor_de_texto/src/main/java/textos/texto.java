package textos;

import java.util.LinkedList;

public class texto {
    
   private final LinkedList<Character> text;

    public texto() {
       this.text = new LinkedList();//inicializa a lisata encadeada que contera o texto
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
        return index;
    }
    
    public int remove(int n,int index){
        
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
