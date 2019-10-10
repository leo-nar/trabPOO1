
import java.util.Scanner;

public class Main {

 
    public static void main(String[] args) {
        int escolha =1;
        Scanner s = new Scanner(System.in);
        //texto text = new texto();
        //pilha desfazer = new pilha();
        //pilha refazer = new pilha();
        //cursor c = new cursor();
        
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
                         //text.insert(buffer, c);
                         break;
                     case 2:
                         System.out.println("Digite quantos caracteres serao removidos");
                         //refazer.push(text);
                         //text.removes(s.nextInt(), c);
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
                         //cursor.move(s.nextInt(),c);
                         s.nextLine();
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
