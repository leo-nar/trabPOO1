package main;

import editor.editor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 * Programa para edicao de textos em linha de comando, contem funcoes de adicionar e remover caracteres, desfazer e refazer alteracoes e imprimir o texto
 * @author Julio, Leonardo
 */
public class Main {

    public static void main(String[] args){
        
        fileprompt ini = new fileprompt();
        Thread t;
        while(true){
            
            if (ini.getFlag()){//se o usuario apertou o botao abrir entramos aqui
                FileReader f = null;
                try {
                    f = new FileReader(ini.getNomarq() + ".txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedReader br = new BufferedReader(f);
                t = new Thread(new trhd(br));
                
            }
        }

    }
    
}
