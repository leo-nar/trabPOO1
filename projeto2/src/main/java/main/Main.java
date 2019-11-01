package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Programa para edicao de textos com interface grafica, contem funcoes de adicionar e remover caracteres, desfazer e refazer alteracoes, selecionar copiar e colar
 * Tambem conta com funcao multithread, onde um mesmo arquivo pode ser editado por diversas pessoas
 * @author Julio, Leonardo
 */
public class Main {

    /**
     *Metodo main do programa inicia um prompt de texto para a entrada do nome do arquivo a ser aberto
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        
        fileprompt ini = new fileprompt();
        ArrayList <RunningThread> t= new ArrayList();
        int threadcounter = 0;
        BufferedReader br;
        BufferedWriter bw;
        ArrayList <String> files = new ArrayList();
        Thread th;
        
        while(true){
           
            if (ini.getFlag()){//se o usuario apertou o botao abrir tenta abrir o arquivo indicado, se nao existir cria um novo
                files.add(ini.getNomarq()+".txt");
                File file = new File(files.get(threadcounter));
                
                if (!file.isFile() &&!file.createNewFile()){
                    throw new IOException("Erro ao criar o arquivo");
                }
                br = new BufferedReader(new FileReader(file));
                
                t.add(new RunningThread(br));//adiciona uma nova thread ao array list
                th = new Thread(t.get(threadcounter));//inicia a thread adicionada
                th.start();
                
                threadcounter++;
                 ini.setOpenflag(false);
            }
            
            for (int i = 0; i < t.size(); i++) {//testa se alguma janela pediu para salvar o arquivo. Se sim, salva o arquivo
                if (t.get(i).isSaveflag()) {
                    bw = new BufferedWriter(new FileWriter(files.get(i)));
                    t.get(i).setWriter(bw);
                    t.get(i).setSaveflag(false);
                }
                else if (t.get(i).isCloseflag()){// testa se alguma janela pediu para desconectar. Se sim remove os objetos relevantes
                    t.remove(i);                        //dos arraylists
                    files.remove(i);
                    threadcounter--;
                }
            }
        }       
    }   
}
