/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author julio
 */
public class editor extends WindowAdapter {
    
    private final JButton save;
    private final JButton close;
    private final JFrame janela;
    private  JTextArea body=null;
    private final JPanel buttonpanel;
    private final UndoManager undo;
    private final Document doc;
    private volatile boolean closeflag;
    private volatile boolean saveflag;
    private BufferedReader br;

    
    public editor(BufferedReader br) {//rececbe o arquivo em buffered reader
            
        this.br=br;
  
        body = new JTextArea(40,10);
        try {
            body.read(this.br, null);
        } catch (IOException ex) {
            Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        body.requestFocus();
        
        closeflag =false;
        saveflag = false;
        
        undo = new UndoManager();
        doc = body.getDocument();
        
        save = new JButton("Salvar");
        close = new JButton("Desconectar");
        janela= new JFrame("Editor");
        buttonpanel = new JPanel(new GridLayout(1,2));
        buttonpanel.add(save);
        buttonpanel.add(close);
        
        body.setLineWrap(true);
        body.setWrapStyleWord(true);
        
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.setPreferredSize(new Dimension(1080,720));
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setLayout(new BorderLayout());
        janela.add(buttonpanel,BorderLayout.PAGE_END);
        janela.add(body,BorderLayout.PAGE_START);
        janela.setVisible(true);
        
        janela.addWindowListener(this);
        
        /*janela.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(//pede confirmacao antes de sair da janela
        janela,
        "Quer sair sem salvar?",
        "Confirmacao",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
        janela.dispose();
        }
        }
        });*/
        
        //funcao do botao de desconectar
        close.addActionListener((ActionEvent e)->{
            close();
        });
        
        //funcao de salvar. Seta a flag de salvar como verdadeiro
        save.addActionListener((ActionEvent e)->{
            this.saveflag = true;

        });
        
        // escuta os eventos de desfazer e refazer
        doc.addUndoableEditListener((UndoableEditEvent evt) -> {
            undo.addEdit(evt.getEdit());
        });
        
        // cria uma funcao de undo e adiciona ao objeto de texto
        body.getActionMap().put("Undo",
                new AbstractAction("Undo") {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canUndo()) {
                        undo.undo();
                    }
                } catch (CannotUndoException e) {
                }
            }
        });

        // faz com que crtl z seja a funcao undo
        body.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

        // cria uma acao de redo e adiciona ao objeto de texto
        body.getActionMap().put("Redo",
                new AbstractAction("Redo") {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canRedo()) {
                        undo.redo();
                    }
                } catch (CannotRedoException e) {
                }
            }
        });
        // faz com que ctrl y seja a funcao redo
        body.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");
    
    }

    public boolean isCloseflag() {
        return closeflag;
    }

    public void setCloseflag(boolean closeflag) {
        this.closeflag = closeflag;
    }

    public boolean isSaveflag() {
        return saveflag;
    }

    public void setSaveflag(boolean saveflag) {
        this.saveflag = saveflag;
    }
    
    public void writefile(BufferedWriter bw){
        if(!(body==null)){
            try {
                this.body.write(bw);
            } catch (IOException ex) {
            }
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e){
        this.closeflag=true;
        this.janela.dispose();
    }
    
    public void close(){
         this.closeflag=true;
        this.janela.dispose();
    }
}