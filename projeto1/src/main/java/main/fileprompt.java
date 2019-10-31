/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julio
 */
public class fileprompt {
    private final JFrame janela = new JFrame("Abrir Arquivo");
    private final JButton open = new JButton("Abrir");
    private final JButton close = new JButton("Fechar");
    private final JLabel inst= new JLabel("Digite o nome do arquivo",JLabel.CENTER);
    private final JTextField filename = new JTextField(20);
    private final JPanel textpanel = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    
    public fileprompt(){
         //configuracao dos paineis
        textpanel.add(filename);
        buttonpanel.add(open);
        buttonpanel.add(close);
        
        //configuracao da janela principal
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setPreferredSize(new Dimension(350,150));
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setLayout(new GridLayout(3,1));
        janela.add(inst);
        janela.add(textpanel);
        janela.add(buttonpanel);
        
        
        //funcao do botao de fechar
        close.addActionListener((ActionEvent e)->{
            System.exit(0);
        });
        //funcao do botao de abrir
        open.addActionListener((ActionEvent e)->{//TODO
            filename.getText();
        });
        
    }
    
    
    
}
