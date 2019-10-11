package main;
import textos.cursor;
import textos.texto;

import java.util.Scanner;
import pilhas.Desfazer;
import pilhas.Refazer;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        int escolha =1;
        Scanner s = new Scanner(System.in);
        texto text = new texto();
        Desfazer desfazer = new Desfazer();
        Refazer refazer = new Refazer();
        cursor index = new cursor();
        
        
        while (escolha <7 && escolha >0){
            
            System.out.print("Digite o comando desejado:\n"
                                     + " 1 - Inserir caracteres no cursor\n"
                                     + " 2 - Remover caracteres no cursor\n"
                                     + " 3 - Desfazer\n"
                                     + " 4 - Refazer\n"
                                     + " 5 - Mover cursor\n"
                                     + " 6 - Imprimir texto\n"
                                     + " 7 - Sair\n");
            
            if (s.hasNextInt()){
                 escolha = s.nextInt();
                 s.nextLine();
                 switch (escolha){
                     case 1:
                         System.out.println("Digite o texto a ser inserido");
                         String buffer = s.nextLine();
                         desfazer.push(text.clone());//coloca o texto nao alterado na pilha de desfazer
                         index.setPosicao(text.insert(buffer, index.getPosicao()));//insere buffer em texto e retorna a posicao do cursor apos a insercao
                         text.print();
                         System.out.println("Posicao do cursor: "+ index.getPosicao());
                         break;
                     case 2:
                         System.out.println("Digite quantos caracteres serao removidos");
                         desfazer.push(text.clone());//coloca o texto nao alterado na pilha de desfazer
                         if (s.hasNextInt()){//testa se a entrada eh um int
                            index.setPosicao(text.remove(s.nextInt(), index.getPosicao()));//remove um numero de caracteres e retorna a posicao do cursor
                            text.print();
                            System.out.println("Posicao do cursor: "+ index.getPosicao());
                         }
                         else{
                             System.out.println("Entrada Invalida");
                         }
                        s.nextLine();
                         break;
                     case 3:
                         text = desfazer.undo(refazer,text.clone());//desaz uma alteracaao no texto/TODO Ver se refazer esta certo
                         index.setPosicao(text.getTamanho());// apos desfazer posiciona o cursor no final do texto
                         text.print();
                         System.out.println("Posicao do cursor: "+ index.getPosicao());
                         break;
                     case 4:
                         text = refazer.redo(desfazer,text.clone());//refaz uma alteracao no texto//TODO funcionar
                         index.setPosicao(text.getTamanho());//apos refafzer posiciona o cursor no final do texto
                         text.print();
                         System.out.println("Posicao do cursor: "+ index.getPosicao());
                         break;
                     case 5:
                         System.out.println("Digite a posicao do cursor");
                         index.move(s,text);//move o cursor para uma posicao escolhida pelo usuario e checa se ela eh valida
                         System.out.println("Posicao do cursor: "+ index.getPosicao());
                         break;
                     case 6:
                         text.print();
                         System.out.println("Posicao do cursor: "+ index.getPosicao());
                         break;
                     case 7:
                         break;
                     default:
                         System.out.println("Escoilha Invalida!");
                         escolha =  1;
                         break;          
                 }
            }
            else{
                System.out.println("Escoilha Invalida!");
                s.nextLine();
            }
        }
    }
    
}
