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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
public class editor {
    
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
        
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setPreferredSize(new Dimension(1080,720));
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setLayout(new BorderLayout());
        janela.add(buttonpanel,BorderLayout.PAGE_END);
        janela.add(body,BorderLayout.PAGE_START);
        janela.setVisible(true);
        
        
        //funcao do botao de desconectar
        close.addActionListener((ActionEvent e)->{
            this.closeflag = true;
            //System.exit(0);//TODO desconectar do servidor
        });
        
        //funcao de salvar
        save.addActionListener((ActionEvent e)->{
            this.saveflag = true;

        });
        
        // Listen for undo and redo events
        doc.addUndoableEditListener((UndoableEditEvent evt) -> {
            undo.addEdit(evt.getEdit());
        });
        
        // Create an undo action and add it to the text component
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

        // Bind the undo action to ctl-Z
        body.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

        // Create a redo action and add it to the text component
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
        // Bind the redo action to ctl-Y
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
                Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}