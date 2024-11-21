package LPOO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main implements ActionListener{
	
	// Definindo os botões como variáveis de instância
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JTextField textField;
    JTextField textField2;
    JTextArea chatHistory;
    
 // JLabel para exibir o status
    JLabel statusLabel;
	  public static void main(String[] args) {
          // parte do codigo sem aparecer na interface ainda
		  new Main();
	  }
	  // construtor. Tem que tá assim para os botões funcionarem
	  public Main() {
          Deck deckTotal = new Deck();
          deckTotal.addCard(new Criatura("Pikachu", 3, 5, 3, "Rapidez"));
          deckTotal.addCard(new Criatura("Charizard", 6, 8, 5, "Força"));
          deckTotal.addCard(new Criatura("Bulbasaur", 2, 3, 4, "Provocar"));
          deckTotal.addCard(new Criatura("Squirtle", 2, 2, 5, "Rapidez"));
          deckTotal.addCard(new Criatura("Jigglypuff", 3, 4, 4, "Provocar"));
          deckTotal.addCard(new Criatura("Gengar", 5, 7, 4, "Força"));
          deckTotal.addCard(new Criatura("Mewtwo", 8, 9, 6, "Rapidez"));
          deckTotal.addCard(new Criatura("Eevee", 3, 3, 4, "Provocar"));
          deckTotal.addCard(new Criatura("Snorlax", 4, 5, 10, "Força"));
          deckTotal.addCard(new Criatura("Pidgeot", 4, 6, 3, "Rapidez"));

          deckTotal.addCard(new Criatura("Onix", 4, 6, 8, "Provocar"));
          deckTotal.addCard(new Criatura("Jolteon", 5, 6, 4, "Rapidez"));
          deckTotal.addCard(new Criatura("Flareon", 5, 7, 4, "Força"));
          deckTotal.addCard(new Criatura("Vaporeon", 5, 5, 6, "Força"));
          deckTotal.addCard(new Criatura("Machamp", 6, 8, 5, "Força"));
          deckTotal.addCard(new Criatura("Gyarados", 7, 9, 6, "Força"));
          deckTotal.addCard(new Criatura("Lapras", 6, 5, 7, "Provocar"));
          deckTotal.addCard(new Criatura("Alakazam", 5, 7, 4, "Rapidez"));
          deckTotal.addCard(new Criatura("Scyther", 4, 6, 3, "Rapidez"));
          deckTotal.addCard(new Criatura("Tyranitar", 8, 10, 8, "Força"));

          deckTotal.addCard(new Criatura("Lucario", 5, 7, 5, "Força"));
          deckTotal.addCard(new Criatura("Porygon-Z", 4, 5, 4, "Rapidez"));
          deckTotal.addCard(new Criatura("Zubat", 2, 3, 3, "Rapidez"));
          deckTotal.addCard(new Criatura("Mew", 5, 4, 5, "Provocar"));
          deckTotal.addCard(new Criatura("Gardevoir", 6, 5, 6, "Rapidez"));
          deckTotal.addCard(new Criatura("Dragonite", 7, 8, 7, "Força"));
          deckTotal.addCard(new Criatura("Regice", 6, 4, 8, "Provocar"));
          deckTotal.addCard(new Criatura("Regirock", 6, 8, 9, "Força"));
          deckTotal.addCard(new Criatura("Sandslash", 4, 6, 5, "Provocar"));
          deckTotal.addCard(new Criatura("Steelix", 7, 7, 10, "Provocar"));

          // 5 Feitiços nomes sujetos a mudanca
          Feitico feitico1 = new Feitico("Bola de Fogo", 5, "a definir");
          Feitico feitico2 = new Feitico("Relâmpago", 3, "a definir");
          Feitico feitico3 = new Feitico("Curar Feridas", 4, "a definir");
          Feitico feitico4 = new Feitico("Tempestade de Gelo", 6, "a definir");
          Feitico feitico5 = new Feitico("Barreira Arcana", 2, "a definir");

          // 5 Encantamentos nomes sujeitos a mudanca
          Encantamento encantamento1 = new Encantamento("Aura de Proteção", 4, "a definir");
          Encantamento encantamento2 = new Encantamento("Força da Natureza", 3, "a definir");
          Encantamento encantamento3 = new Encantamento("Campo de Energia", 5, "a definir");
          Encantamento encantamento4 = new Encantamento("Benção dos Deuses", 6, "a definir");
          Encantamento encantamento5 = new Encantamento("Vínculo Espiritual", 2, "a definir");

          Scanner in = new Scanner(System.in);

          // cada conjunto de cartas vai ser o inventario de cada jogador
          /*System.out.println("ESCOLHA SEU deckTotal (JOGADOR 1) ");
          deckTotal deckTotal1 = new deckTotal();
          for(int i = 0; i < 1;){
              boolean cartaEncontrada = false;
              boolean cartaRepitida = false;
              String carta = in.nextLine();

              for(int j = 0; j < deckTotal1.size(); j++) {
                  if (carta.equals(deckTotal1.getCarta(j).getNome())) {
                      cartaRepitida = true;
                      break;
                  }
              }

              for (int j = 0; j < deckTotal.size(); j++) {
                  if (carta.equals(deckTotal.getCarta(j).getNome())) {
                      deckTotal1.addCard(deckTotal.getCarta(j));
                      cartaEncontrada = true;
                      break;
                  }
              }
              if (cartaEncontrada && !cartaRepitida){
                  System.out.println("Carta adicionada com sucesso!");
                  i++;
              }
              else if(cartaRepitida){
                  System.out.println("Carta repitida!");
              }
              else{
                  System.out.println("Carta nao encontrada!");
              }
          }

          System.out.println("ESCOLHA SEU deckTotal (JOGADOR 2)");
          deckTotal deckTotal2 = new deckTotal();
          for(int i = 0; i < 1;){  // 30 são muitas cartas
              boolean cartaEncontrada = false;
              boolean cartaRepitida = false;
              String carta = in.nextLine();

              for(int j = 0; j < deckTotal2.size(); j++) {
                  if (carta.equals(deckTotal1.getCarta(j).getNome())) {
                      cartaRepitida = true;
                      break;
                  }
              }

              for (int j = 0; j < deckTotal.size(); j++) {
                  if (carta.equals(deckTotal.getCarta(j).getNome())) {
                      deckTotal2.addCard(deckTotal.getCarta(j));
                      cartaEncontrada = true;
                      break;
                  }
              }
              if (cartaEncontrada && !cartaRepitida){
                  System.out.println("Carta adicionada com sucesso!");
                  i++;
              }
              else if(cartaRepitida){
                  System.out.println("Carta repitida!");
              }
              else{
                  System.out.println("Carta nao encontrada!");
              }
          }
*/

          // COISAS DA INTERFACE ABAIXO
          // frame principal e configurações iniciais
          JFrame  frame = new JFrame();
          frame.setSize(1500, 800);
          frame.setTitle("Crônicas de Arcana");
          frame.setResizable(false);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLocationRelativeTo(null);
          frame.setLayout(null);

       // buttons
  	    button1 = new JButton();
  	    button1.setBounds(30, 50, 100, 50);
  	    button1.addActionListener(this);  // Usa "this" para passar o ActionListener
  	    button1.setText("Jogar carta1");
  	    button1.setFocusable(false);
  	    
  	    button1.setBackground(Color.gray);
  	    button1.setForeground(Color.white);
  	    button1.setBorder(BorderFactory.createEtchedBorder());
  	    
  	    button2 = new JButton();
  	    button2.setBounds(30, 300, 100, 50);
  	    button2.addActionListener(this);  // Usa "this" para passar o ActionListener
  	    button2.setText("Jogar Carta2");
  	    button2.setFocusable(false);  // retira o quadro das letras
  	    button2.setBackground(Color.white);
  	    button2.setForeground(Color.gray);
  	    button2.setBorder(BorderFactory.createEtchedBorder());
  	    
  	    // botão passar turno
  	    button3 = new JButton();
	    button3.setBounds(30, 340, 100, 50);
	    button3.addActionListener(this);  // Usa "this" para passar o ActionListener
	    button3.setText("Passar Turno");
	    button3.setFocusable(false);  // retira o quadro das letras
	    button3.setBackground(Color.gray);
	    button3.setForeground(Color.white);
	    button3.setBorder(BorderFactory.createEtchedBorder());
	    
	    // botão enviar mensagem
	    // botão passar turno
  	    button4 = new JButton();
	    button4.setBounds(30, 340, 100, 50);
	    button4.addActionListener(this);  // Usa "this" para passar o ActionListener
	    button4.setText("Send");
	    button4.setFocusable(false);  // retira o quadro das letras
	    button4.setBackground(Color.white);
	    button4.setForeground(Color.gray);
	    button4.setBorder(BorderFactory.createEtchedBorder());
	    button4.setBounds(10, 40, 50, 40);
	    
	    // botão passar turno
  	    button5 = new JButton();
	    button5.setBounds(30, 340, 100, 50);
	    button5.addActionListener(this);  // Usa "this" para passar o ActionListener
	    button5.setText("Send2");
	    button5.setFocusable(false);  // retira o quadro das letras
	    button5.setBackground(Color.white);
	    button5.setForeground(Color.gray);
	    button5.setBorder(BorderFactory.createEtchedBorder());
	    button5.setBounds(10, 100, 50, 40);
  	    
          ImageIcon imagem = new ImageIcon("icone_glico.ico");
          frame.setIconImage(imagem.getImage());

  	    	// creating panels
          JPanel panelJogador1 = new JPanel();
          panelJogador1.setBackground(Color.WHITE);
          panelJogador1.setBounds(0, 0,900, 400);
          panelJogador1.setLayout(null);

          JPanel panelJogador2 = new JPanel();
          panelJogador2.setBackground(Color.GRAY);
          panelJogador2.setBounds(0, 365, 900, 400);
          panelJogador2.setLayout(null);
          
          // panels para exibir criaturas
          JPanel criaturaJogador1 = new JPanel();
          criaturaJogador1.setBackground(Color.gray);
          criaturaJogador1.setBounds(900, 0, 285, 400); // Ajuste no tamanho e na posição
          criaturaJogador1.setLayout(new FlowLayout()); // Usar FlowLayout para organizar criaturas

          JPanel criaturaJogador2 = new JPanel();
          criaturaJogador2.setBackground(Color.white);
          criaturaJogador2.setBounds(900, 400, 285, 400); // Alterado para evitar sobreposição
          criaturaJogador2.setLayout(new FlowLayout());
          
          JPanel dialogo = new JPanel();
          dialogo.setBackground(Color.gray);
          dialogo.setBounds(1190, 0, 295, 800); // Alterado para evitar sobreposição
          dialogo.setLayout(null);
          
          // labels criaturas para colocar no panel de criaturas
       // Adicionando alguns componentes de exemplo (JLabel) para representar criaturas
          JLabel criatura1 = new JLabel("Criatura 1: Pikachu");
          criatura1.setFont(new Font("Arial", Font.PLAIN, 16));
          criatura1.setForeground(Color.white);
          
          JLabel criatura2 = new JLabel("Criatura 2: Charizard");
          criatura2.setFont(new Font("Arial", Font.PLAIN, 16));
          criatura2.setForeground(Color.white);
          
          JLabel criatura3 = new JLabel("Criatura 1: Bulbasaur");
          criatura3.setFont(new Font("Arial", Font.PLAIN, 16));
          criatura3.setForeground(Color.black);
          
          JLabel criatura4 = new JLabel("Criatura 2: Squirtle");
          criatura4.setFont(new Font("Arial", Font.PLAIN, 16));
          criatura4.setForeground(Color.black);
          
          // colocando algumas criaturas no pane de criaturas
          criaturaJogador1.add(criatura1);
          criaturaJogador1.add(criatura2);
          criaturaJogador2.add(criatura3);
          criaturaJogador2.add(criatura4);

          // creating labels
          JLabel labelJogador1 = new JLabel();
          labelJogador1.setText("Jogador 1");
          labelJogador1.setForeground(Color.gray);
          labelJogador1.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
          
          // label do diálogo
          JLabel labelDialogo = new JLabel();
          labelDialogo.setText("Diálogo");
          labelDialogo.setForeground(Color.white);
          labelDialogo.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
          labelDialogo.setBounds(120, 0, 100, 50);
          //labelDialogo.setBounds(0, 0, 50, 50);


          JLabel labelJogador2 = new JLabel();
          labelJogador2.setText("Jogador 2");
          labelJogador2.setForeground(Color.WHITE);
          labelJogador2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
          
         
       // JLabel de status
          statusLabel = new JLabel("Status: Aguardando ação...");
          statusLabel.setBounds(0, 40, 400, 30); // Posicione o label no topo
          statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
          statusLabel.setForeground(Color.white);

          labelJogador1.setBounds(450, 0, 100, 50);
          labelJogador2.setBounds(450, 350, 100, 50);
          
          // textfield
          textField = new JTextField();
          //textField.setPreferredSize(new Dimension(200, 40));
          textField.setBounds(85, 40, 200, 40);
          textField.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));
          
          textField2 = new JTextField();
          //textField.setPreferredSize(new Dimension(200, 40));
          textField2.setBounds(85, 100, 200, 40);
          textField2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));
          
          // Sistema de diálogo
          chatHistory = new JTextArea();
          chatHistory.setEditable(false); // Tornar o campo somente leitura
          chatHistory.setLineWrap(true);  // Quebra de linha automática
          chatHistory.setWrapStyleWord(true);
          chatHistory.setBackground(Color.white);
          chatHistory.setForeground(Color.BLACK);
          chatHistory.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));
          
          JScrollPane scrollPane = new JScrollPane(chatHistory); // Para adicionar barra de rolagem
          scrollPane.setBounds(0, 400, 295, 400);
          dialogo.add(scrollPane);
          
          // adding elements to the frame
          frame.add(panelJogador1);
          frame.add(panelJogador2);
          frame.add(criaturaJogador1);
          frame.add(criaturaJogador2);
          frame.add(dialogo);


          panelJogador1.add(labelJogador1);
          panelJogador2.add(labelJogador2);
          panelJogador2.add(statusLabel);
          
          // adding the buttons to the frame
  	    	panelJogador2.add(button2);
  	    	panelJogador1.add(button1);
  	    	panelJogador1.add(button3);
  	    	
  	    	dialogo.add(labelDialogo);
  	    	dialogo.add(textField);
  	    	dialogo.add(textField2);
  	    	dialogo.add(button4);
  	    	dialogo.add(button5);
          frame.setVisible(true);

      }

	  @Override
	    public void actionPerformed(ActionEvent e) {
	        // Atualizando o JLabel de status com base na ação do jogador
	        if (e.getSource() == button1) {
	            statusLabel.setText("Status: Jogador 1 jogou uma carta.");
	        } else if (e.getSource() == button2) {
	            statusLabel.setText("Status: Jogador 2 jogou uma carta.");
	        } else if (e.getSource() == button3) {
	            statusLabel.setText("Status: Jogador passou o turno.");
	        }
	        else if(e.getSource()==button4) {
	                String message = textField.getText();
	                if (!message.isEmpty()) {
	                    chatHistory.append("Você: " + message + "\n");
	                    textField.setText("");
                    
                   
                    
	        }
	        }
            else if(e.getSource()==button5) {
                String response= textField2.getText();
                if (!response.isEmpty()) {
                    chatHistory.append("Outro: " + response + "\n");
                    textField2.setText("");
	
	        }
            }
	  }
}
