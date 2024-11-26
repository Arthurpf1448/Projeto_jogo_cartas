package view;



import controller.Jogo;
import model.Carta;
import model.Criatura;
import model.Deck;
import model.Jogador;
import controller.Jogo;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameGUI implements ActionListener {
    // Declaração de componentes
    private JButton button1, button2, button3, button4, button5, button6;
    private JTextField textField, textField2;
    private JTextArea chatHistory;
    private JLabel statusLabel;
    private boolean isPlayer1Turn = true;
    private Jogador jogador1;
    private Jogador jogador2;
    private String nomej1;
    private String nomej2;


    public static void main(String[] args) {
        //new GameGUI();

    }

    // Construtor da classe GameGUI
    public GameGUI(Jogador jogador1, Jogador jogador2, String nomej1, String nomej2) {

        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.nomej1 = nomej1;
        this.nomej2 = nomej2;


        //Jogo jogo = new Jogo();

        JFrame frame = new JFrame();
        frame.setSize(1500, 800);
        frame.setTitle("Crônicas de Arcana");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Configuração dos botões
        button1 = new JButton("Jogar carta1");
        button1.setBounds(30, 50, 100, 50);
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setBackground(Color.gray);
        button1.setForeground(Color.white);
        button1.setBorder(BorderFactory.createEtchedBorder());

        button2 = new JButton("Jogar Carta2");
        button2.setBounds(30, 300, 100, 50);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setBackground(Color.white);
        button2.setForeground(Color.gray);
        button2.setBorder(BorderFactory.createEtchedBorder());

        button6 = new JButton("Atacar");
        button6.setBounds(780, 340, 100, 50);
        button6.addActionListener(this);
        button6.setFocusable(false);
        button6.setBackground(Color.gray);
        button6.setForeground(Color.white);
        button6.setBorder(BorderFactory.createEtchedBorder());

        button3 = new JButton("Passar Turno");
        button3.setBounds(30, 340, 100, 50);
        button3.addActionListener(this);
        button3.setFocusable(false);
        button3.setBackground(Color.gray);
        button3.setForeground(Color.white);
        button3.setBorder(BorderFactory.createEtchedBorder());

        button4 = new JButton("Send");
        button4.setBounds(10, 40, 50, 40);
        button4.addActionListener(this);
        button4.setFocusable(false);
        button4.setBackground(Color.white);
        button4.setForeground(Color.gray);
        button4.setBorder(BorderFactory.createEtchedBorder());

        button5 = new JButton("Send2");
        button5.setBounds(10, 100, 50, 40);
        button5.addActionListener(this);
        button5.setFocusable(false);
        button5.setBackground(Color.white);
        button5.setForeground(Color.gray);
        button5.setBorder(BorderFactory.createEtchedBorder());

        // Definindo o ícone da janela
        ImageIcon imagem = new ImageIcon("icone_glico.ico");
        frame.setIconImage(imagem.getImage());

        // Painéis para jogadores e criaturas
        JPanel panelJogador1 = new JPanel();
        panelJogador1.setBackground(Color.WHITE);
        panelJogador1.setBounds(0, 0, 900, 400);
        panelJogador1.setLayout(null);

        JPanel panelJogador2 = new JPanel();
        panelJogador2.setBackground(Color.GRAY);
        panelJogador2.setBounds(0, 365, 900, 400);
        panelJogador2.setLayout(null);

        JPanel criaturaJogador1 = new JPanel();
        criaturaJogador1.setBackground(Color.gray);
        criaturaJogador1.setBounds(900, 0, 285, 400);
        criaturaJogador1.setLayout(new FlowLayout());

        JPanel criaturaJogador2 = new JPanel();
        criaturaJogador2.setBackground(Color.white);
        criaturaJogador2.setBounds(900, 400, 285, 400);
        criaturaJogador2.setLayout(new FlowLayout());

        // Painel de diálogo
        JPanel dialogo = new JPanel();
        dialogo.setBackground(Color.gray);
        dialogo.setBounds(1190, 0, 295, 800);
        dialogo.setLayout(null);

        // panel criaturas
        JPanel painelCriaturas = new JPanel();
        painelCriaturas.setLayout(new GridLayout(1, 5)); // Um layout de grade para exibir as cartas
        frame.add(painelCriaturas, BorderLayout.SOUTH);  // Adicione o painel na parte inferior
        // Label jogadores
        JLabel jogadorA = new JLabel("Jogador 1: " + nomej1);
        jogadorA.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
        jogadorA.setBounds(370, 5, 150, 50); // Ajuste as coordenadas e tamanho
        jogadorA.setForeground(Color.white); // Defina uma cor de texto visível
        jogadorA.setOpaque(true); // Necessário para que o background funcione
        jogadorA.setBackground(Color.lightGray); // Cor de fundo para depuração

        JLabel jogadorD = new JLabel("Jogador 2: " + nomej2);
        jogadorD.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
        jogadorD.setBounds(370, 45, 150, 50); // Ajuste as coordenadas e tamanho
        jogadorD.setForeground(Color.gray); // Defina uma cor de texto visível
        jogadorD.setOpaque(true); // Necessário para que o background funcione
        jogadorD.setBackground(Color.white); // Cor de fundo para depuração


        // Labels das criaturas
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

        // Adicionando as criaturas nos painéis correspondentes
        criaturaJogador1.add(criatura1);
        criaturaJogador1.add(criatura2);
        criaturaJogador2.add(criatura3);
        criaturaJogador2.add(criatura4);

        // Criando o JLabel de status
        statusLabel = new JLabel("Status: Aguardando ação...");
        statusLabel.setBounds(0, 40, 400, 30);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        statusLabel.setForeground(Color.white);

        // Criando o campo de texto para enviar mensagens
        textField = new JTextField();
        textField.setBounds(85, 40, 200, 40);
        textField.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));

        textField2 = new JTextField();
        textField2.setBounds(85, 100, 200, 40);
        textField2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));

        // Criando o JTextArea para o histórico de chat
        chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        chatHistory.setLineWrap(true);
        chatHistory.setWrapStyleWord(true);
        chatHistory.setBackground(Color.white);
        chatHistory.setForeground(Color.BLACK);
        chatHistory.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));

        JScrollPane scrollPane = new JScrollPane(chatHistory);
        scrollPane.setBounds(0, 400, 295, 400);
        dialogo.add(scrollPane);

        // Adicionando os componentes ao frame
        frame.add(panelJogador1);
        frame.add(panelJogador2);
        frame.add(criaturaJogador1);
        frame.add(criaturaJogador2);
        frame.add(dialogo);

        // Adicionando labels aos painéis
        panelJogador2.add(statusLabel);

        // Adicionando botões aos painéis
        panelJogador1.add(button1);
        panelJogador1.add(button3);
        panelJogador1.add(jogadorA);
        panelJogador1.add(button6);
        panelJogador2.add(button2);
        panelJogador2.add(jogadorD);
        dialogo.add(button4);
        dialogo.add(button5);
        dialogo.add(textField);
        dialogo.add(textField2);

        atualizarPainelCriaturas(jogador1, criaturaJogador1);

        // Após preencher a mão do jogador
        atualizarPainelCriaturas(jogador2, criaturaJogador2);

        frame.setVisible(true);
    }

    //Jogo jogo = new Jogo();
    // Carta selecionada ao clicar em algum botão da mãe
    Carta cartaSelecionada;
    public void atualizarPainelCriaturas(Jogador jogador, JPanel painelCriaturas) {
        painelCriaturas.removeAll(); // Limpa o painel para exibir cartas atualizadas

        for (Carta carta : jogador.getMao()) {
            JButton cartaBotao = new JButton(carta.getNome());
            cartaBotao.setFont(new Font("Arial", Font.PLAIN, 16));

            if (carta instanceof Criatura) {
                Criatura criatura = (Criatura) carta; // Faz o cast para Criatura
                cartaBotao.setToolTipText("Poder: " + criatura.getPoder() + ", Resistência: " + criatura.getResistencia());
            } else {
                cartaBotao.setToolTipText("Carta: " + carta.getNome());
            }
            cartaBotao.setPreferredSize(new Dimension(120, 50)); // Define tamanho dos botões

            // Adiciona ação ao botão para seleção de carta
            cartaBotao.addActionListener(e -> {
                chatHistory.append("Carta selecionada: " + carta.getNome()+ "\n");
                cartaSelecionada = carta; // Atualiza a carta selecionada
            });

            painelCriaturas.add(cartaBotao); // Adiciona o botão ao painel
        }

        painelCriaturas.revalidate(); // Atualiza o layout
        painelCriaturas.repaint();    // Re-renderiza o painel
    }
    // Após preencher a mão do jogador



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            if (isPlayer1Turn) {

                chatHistory.append("Jogador 1 atacou!\n");
                Jogo.jogarCarta(jogador1, (Criatura)cartaSelecionada);
            }
        } else if (e.getSource() == button2) {
            isPlayer1Turn = !isPlayer1Turn; // Alterna o turno após a jogada

                Jogo.jogarCarta(jogador2, (Criatura)cartaSelecionada);


                statusLabel.setText("Status: Jogador 2 jogou uma carta.");
                chatHistory.append("Jogador 2 atacou!\n");


        } else if (e.getSource() == button3) {
            isPlayer1Turn = !isPlayer1Turn;
            statusLabel.setText("Status: Turno de " + (isPlayer1Turn ? "Jogador 1" : "Jogador 2"));
            chatHistory.append("Turno de " + (isPlayer1Turn ? "Jogador 1" : "Jogador 2") + "!\n");
        } else if (e.getSource() == button4) {
            String message = textField.getText();
            if (!message.isEmpty()) {
                chatHistory.append("Você: " + message + "\n");
                textField.setText("");
            }
        } else if (e.getSource() == button5) {
            String response = textField2.getText();
            if (!response.isEmpty()) {
                chatHistory.append("Outro: " + response + "\n");
                textField2.setText("");
            }
            else if (e.getSource() == button6) {
                if (isPlayer1Turn) {
                    if (!jogador2.getMao().isEmpty()) {
                        Criatura criaturaDefensora = jogador2.getMao().iterator().next(); // Pega a primeira carta
                        Jogo.atacar(jogador1, jogador2, (Criatura)cartaSelecionada, criaturaDefensora);
                    } else {
                        System.out.println("Jogador2 não tem cartas para defender!");
                    }
                } else {
                    if (!jogador1.getMao().isEmpty()) {
                        Criatura criaturaDefensora = jogador1.getMao().iterator().next(); // Pega a primeira carta
                        Jogo.atacar(jogador2, jogador1, (Criatura)cartaSelecionada, criaturaDefensora);
                    } else {
                        System.out.println("Jogador1 não tem cartas para defender!");
                    }
                }
            }

        }
    }
}