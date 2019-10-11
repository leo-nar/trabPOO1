package main;
import textos.cursor;
import textos.texto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int escolha =1;
        Scanner s = new Scanner(System.in);
        texto text = new texto();
        //pilha desfazer = new pilha();
        //pilha refazer = new pilha();
        cursor index = new cursor();
        
        
        while (escolha <6 && escolha >0){
            
            System.out.print("Digite o comando desejado:\n"
                                     + " 1 - Inserir caracteres no cursor\n"
                                     + " 2 - Remover caracteres no cursor\n"
                                     + " 3 - Desfazer\n"
                                     + " 4 - Refazer\n"
                                     + " 5 - Mover cursor\n"
                                     + " 6 - Sair\n");
            
            if (s.hasNextInt()){
                 escolha = s.nextInt();
                 s.nextLine();
                 switch (escolha){
                     case 1:
                         System.out.println("Digite o texto a ser inserido");
                         String buffer = s.nextLine();
                         //desfazer.push(text);
                         index.setPosicao(text.insert(buffer, index.getPosicao()));//insere buffer em texto e retorna a posicao do cursor apos a insercao
                         text.print();
                         break;
                     case 2:
                         System.out.println("Digite quantos caracteres serao removidos");
                         //refazer.push(text);
                         index.setPosicao(text.remove(s.nextInt(), index.getPosicao()));//remove um numero de caracteres e retorna a posicao do cursor
                         text.print();
                         s.nextLine();
                         break;
                     case 3:
                         //desfazer.undo();
                         break;
                     case 4:
                         //refazer.redo();
                         break;
                     case 5:
                         System.out.println("Digite a posicao do cursor");
                         index.move(s,text);//move o cursor para uma posicao escolhida pelo usuario e checa se ela eh valida
                         break;
                     case 6:
                         break;
                     default:
                         System.out.println("Escoilha Invalida!");
                         break;          
                 }
            }
            else{
                System.out.println("Escoilha Invalida!");
                s.nextLine();
            }
           //System.out.println(text);
        }
    }
    
}
