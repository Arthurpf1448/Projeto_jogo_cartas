import javax.swing.*;
import java.awt.*;

public class Main {

        public static void main(String[] args) {
            // parte do codigo sem aparecer na interface ainda
            Deck deck = new Deck();
            deck.addCard(new Criatura("Pikachu", 3, 5, 3, "Rapidez"));
            deck.addCard(new Criatura("Charizard", 6, 8, 5, "Força"));
            deck.addCard(new Criatura("Bulbasaur", 2, 3, 4, "Provocar"));
            deck.addCard(new Criatura("Squirtle", 2, 2, 5, "Rapidez"));
            deck.addCard(new Criatura("Jigglypuff", 3, 4, 4, "Provocar"));
            deck.addCard(new Criatura("Gengar", 5, 7, 4, "Força"));
            deck.addCard(new Criatura("Mewtwo", 8, 9, 6, "Rapidez"));
            deck.addCard(new Criatura("Eevee", 3, 3, 4, "Provocar"));
            deck.addCard(new Criatura("Snorlax", 4, 5, 10, "Força"));
            deck.addCard(new Criatura("Pidgeot", 4, 6, 3, "Rapidez"));

            deck.addCard(new Criatura("Onix", 4, 6, 8, "Provocar"));
            deck.addCard(new Criatura("Jolteon", 5, 6, 4, "Rapidez"));
            deck.addCard(new Criatura("Flareon", 5, 7, 4, "Força"));
            deck.addCard(new Criatura("Vaporeon", 5, 5, 6, "Força"));
            deck.addCard(new Criatura("Machamp", 6, 8, 5, "Força"));
            deck.addCard(new Criatura("Gyarados", 7, 9, 6, "Força"));
            deck.addCard(new Criatura("Lapras", 6, 5, 7, "Provocar"));
            deck.addCard(new Criatura("Alakazam", 5, 7, 4, "Rapidez"));
            deck.addCard(new Criatura("Scyther", 4, 6, 3, "Rapidez"));
            deck.addCard(new Criatura("Tyranitar", 8, 10, 8, "Força"));

            deck.addCard(new Criatura("Lucario", 5, 7, 5, "Força"));
            deck.addCard(new Criatura("Porygon-Z", 4, 5, 4, "Rapidez"));
            deck.addCard(new Criatura("Zubat", 2, 3, 3, "Rapidez"));
            deck.addCard(new Criatura("Mew", 5, 4, 5, "Provocar"));
            deck.addCard(new Criatura("Gardevoir", 6, 5, 6, "Rapidez"));
            deck.addCard(new Criatura("Dragonite", 7, 8, 7, "Força"));
            deck.addCard(new Criatura("Regice", 6, 4, 8, "Provocar"));
            deck.addCard(new Criatura("Regirock", 6, 8, 9, "Força"));
            deck.addCard(new Criatura("Sandslash", 4, 6, 5, "Provocar"));
            deck.addCard(new Criatura("Steelix", 7, 7, 10, "Provocar"));


            // fim da parte do codigo sem interface ainda
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

