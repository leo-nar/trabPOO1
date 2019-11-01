package main;

import editor.editor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 * Programa para edicao de textos em linha de comando, contem funcoes de adicionar e remover caracteres, desfazer e refazer alteracoes e imprimir o texto
 * @author Julio, Leonardo
 */
public class Main {

    public static void main(String[] args) throws IOException{
        
        fileprompt ini = new fileprompt();
        ArrayList <Thread> t= new ArrayList();
        
        
        while(true){
            

            if (ini.getFlag()){//se o usuario apertou o botao abrir tenta abrir o arquivo indicado, se nao existir cria um novo
                File file = new File(ini.getNomarq()+".txt");
                if (!file.isFile() &&!file.createNewFile()){
                    throw new IOException("Erro ao criar o arquivo");
                }
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    t.add(new Thread(new trhd(br)));
                    ini.setOpenflag(false);
                }
            }
        }

    }
    
}
