public class Gui {

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

    public class Panel {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            // JPanel = A GUI component that functions as a container to hold other components

            // initial settings
            JFrame  frame = new JFrame();
            frame.setSize(1000, 800);
            frame.setTitle("Crônicas de Arcana");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação ao fechar a janela
            frame.setLocationRelativeTo(null); // Centraliza a janela na tela
            frame.setLayout(null);  // make you add the positions manually

            // imagens
            ImageIcon imagem = new ImageIcon("icone_glico.ico"); // Carrega a imagem
            frame.setIconImage(imagem.getImage());  // Define a imagem no

            // panels = It is the frame equivalent of  tkinter in python
            // I will divide the frame into two panel. One for each player
            JPanel panelJogador1 = new JPanel();
            panelJogador1.setBackground(Color.WHITE);
            panelJogador1.setBounds(0, 0, 1000, 400);
            panelJogador1.setLayout(null); // Still do not know what it is for

            JPanel panelJogador2 = new JPanel();
            panelJogador2.setBackground(Color.GRAY);
            panelJogador2.setBounds(0, 365, 1000, 400);
            panelJogador2.setLayout(null);  // Still do not know what it is for

            // adding labels to the new panels
            JLabel labelJogador1 = new JLabel();
            labelJogador1.setText("Jogador 1");
            labelJogador1.setForeground(Color.gray);  // sets the background color / new Color(R, G, B);
            labelJogador1.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20)); // sets the font

            // changing the positions of the label
            //labelJogador1.setVerticalAlignment(JLabel.TOP);
            //labelJogador1.setHorizontalAlignment(JLabel.CENTER);

            JLabel labelJogador2 = new JLabel();
            labelJogador2.setText("Jogador 2");
            labelJogador2.setForeground(Color.WHITE);  // sets the background color / new Color(R, G, B);
            labelJogador2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20)); // sets the font

            // changing the positions of the label
            //labelJogador2.setVerticalAlignment(JLabel.BOTTOM);
            //labelJogador2.setHorizontalAlignment(JLabel.CENTER);

            labelJogador1.setBounds(450, 0, 100, 50);
            labelJogador2.setBounds(450, 350, 100, 50); // set x, y position within frame as well as dimensions

            // adding the panels to the frame
            frame.add(panelJogador1);
            frame.add(panelJogador2);

            // adding the labels to the frame
            panelJogador1.add(labelJogador1);
            panelJogador2.add(labelJogador2);

            frame.setVisible(true);

        }

    }
}
