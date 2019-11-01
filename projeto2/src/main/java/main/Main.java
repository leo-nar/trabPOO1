package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 * Programa para edicao de textos com interface grafica, contem funcoes de adicionar e remover caracteres, desfazer e refazer alteracoes, selecionar copiar e colar
 * Tambem conta com funcao multithread, onde um mesmo arquivo pode ser editado por diversas pessoas
 * @author Julio, Leonardo
 */
public class Main {

    public static void main(String[] args) throws IOException{
        
        fileprompt ini = new fileprompt();
        ArrayList <trhd> t= new ArrayList();
        int threadcounter = 0;
        BufferedReader br= null;
        BufferedWriter bw=null;
        ArrayList <String> files = new ArrayList();
        Thread th = null;
        
        while(true){
           
            if (ini.getFlag()){//se o usuario apertou o botao abrir tenta abrir o arquivo indicado, se nao existir cria um novo
                files.add(ini.getNomarq()+".txt");
                File file = new File(files.get(threadcounter));
                
                if (!file.isFile() &&!file.createNewFile()){
                    throw new IOException("Erro ao criar o arquivo");
                }
                br = new BufferedReader(new FileReader(file));
                
                t.add(new trhd(br));//adiciona uma nova thread ao array list
                th = new Thread(t.get(threadcounter));//inicia a thread adicionada
                th.start();
                
                threadcounter++;
                 ini.setOpenflag(false);
            }
            
            for (int i = 0; i < t.size(); i++) {
                if (t.get(i).isSaveflag()) {
                    bw = new BufferedWriter(new FileWriter(files.get(i)));
                    t.get(i).setWriter(bw);
                    t.get(i).setSaveflag(false);
                }
            }
            
            
        }
        
        /*  if (! (br == null)){
        br.close();
        }*/
        
    }
    
}
