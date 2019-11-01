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
 *Classe que contem a janela de abertura do programa. Ela pede que o usuario entre com o titulo do arquivo a ser aberto, no caso do arquivo nao existir
 * ela cria um novo arquivo com o nome
 * @author julio, Leonardo
 */
public class fileprompt {
    private final JFrame janela = new JFrame("Abrir Arquivo");
    private final JButton open = new JButton("Abrir");
    private final JButton close = new JButton("Fechar");
    private final JLabel inst= new JLabel("Digite o nome do arquivo",JLabel.CENTER);
    private final JTextField filename = new JTextField(20);
    private final JPanel textpanel = new JPanel();
    private final JPanel buttonpanel = new JPanel();
    private String nomarq;
    private volatile Boolean openflag;
    
    /**
     *Construtor do fileprompt.Inicia todas as configuracoes da janela, da flag e das funcoes dos botoes
     */
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
        this.nomarq=new String();
        this.openflag=false;
        
        
        close.addActionListener((ActionEvent e)->{//funcao do botao de fechar. Fecha o programa
            System.exit(0);
        });
        
        open.addActionListener((ActionEvent e)->{//funcao do botao de abrir. Se o textfield estiver em branco nao faz nada, caso contrario passa a string no textfield para nomarq e seta a flag de abertura como true
            this.nomarq = filename.getText();
            if (!"".equals(this.nomarq)) {
                this.openflag = true;
            } else {
                this.filename.setText("Digite alguma coisa");
            }
        });
        
    }

    /**
     *Getter para o nome do arquivo digitado
     * @return texto digitado no JTextField da janela
     */
    public String getNomarq() {
        return nomarq;
    }
    
    /**
     *Getter para a flag de abrir o arquivo
     * @return a flag de abertura de arquivo
     */
    public Boolean getFlag() {
        return openflag;
    }

    /**
     *Setter para a flag de abertura de arquivo
     * @param openflag flag que diz se pode ser feita a abertura de um arquivo
     */
    public void setOpenflag(Boolean openflag) {
        this.openflag = openflag;
    }

    
}
