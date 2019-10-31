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
    private final JTextArea body;
    private final JPanel buttonpanel;
    private final UndoManager undo;
    private final Document doc;
    
    public editor() {
        body = new JTextArea(40,10);
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
        janela.add(buttonpanel,BorderLayout.PAGE_START);
        janela.add(body,BorderLayout.PAGE_END);
        janela.setVisible(true);
        
        
        //funcao do botao de desconectar
        close.addActionListener((ActionEvent e)->{
            System.exit(0);//TODO desconectar do servidor
        });
        //funcao de salvar
        save.addActionListener((ActionEvent e)->{
            System.out.println("Salvei bonitao;)");
            //TODO
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
    
   
}
