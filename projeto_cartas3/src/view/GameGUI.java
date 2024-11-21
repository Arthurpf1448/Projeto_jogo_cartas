package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
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

    // Definindo os botões como variáveis de instância
    private JButton button1, button2, button3, button4, button5;
    private JTextField textField, textField2;
    private JTextArea chatHistory;
    private JLabel statusLabel;

    // Construtor da classe
    public GameGUI() {
        // Frame principal e configurações iniciais
        JFrame frame = new JFrame();
        frame.setSize(1500, 800);
        frame.setTitle("Crônicas de Arcana");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Configuração dos botões
        button1 = criarBotao("Jogar Carta 1", 30, 50, 100, 50, Color.GRAY, Color.WHITE);
        button2 = criarBotao("Jogar Carta 2", 30, 300, 100, 50, Color.WHITE, Color.GRAY);
        button3 = criarBotao("Passar Turno", 30, 340, 100, 50, Color.GRAY, Color.WHITE);
        button4 = criarBotao("Send", 10, 40, 50, 40, Color.WHITE, Color.GRAY);
        button5 = criarBotao("Send2", 10, 100, 50, 40, Color.WHITE, Color.GRAY);

        // Ícone do frame
        ImageIcon imagem = new ImageIcon("icone_glico.ico");
        frame.setIconImage(imagem.getImage());

        // Painéis
        JPanel panelJogador1 = criarPainel(Color.WHITE, 0, 0, 900, 400);
        JPanel panelJogador2 = criarPainel(Color.GRAY, 0, 365, 900, 400);
        JPanel criaturaJogador1 = criarPainel(Color.GRAY, 900, 0, 285, 400);
        criaturaJogador1.setLayout(new FlowLayout());
        JPanel criaturaJogador2 = criarPainel(Color.WHITE, 900, 400, 285, 400);
        criaturaJogador2.setLayout(new FlowLayout());
        JPanel dialogo = criarPainel(Color.GRAY, 1190, 0, 295, 800);

        // Labels
        JLabel labelJogador1 = criarLabel("Jogador 1", Color.GRAY, 450, 0, 100, 50);
        JLabel labelJogador2 = criarLabel("Jogador 2", Color.WHITE, 450, 350, 100, 50);
        JLabel labelDialogo = criarLabel("Diálogo", Color.WHITE, 120, 0, 100, 50);
        statusLabel = criarLabel("Status: Aguardando ação...", Color.WHITE, 0, 40, 400, 30);

        // Campos de texto
        textField = criarCampoTexto(85, 40, 200, 40);
        textField2 = criarCampoTexto(85, 100, 200, 40);

        // Sistema de diálogo
        chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        chatHistory.setLineWrap(true);
        chatHistory.setWrapStyleWord(true);
        chatHistory.setBackground(Color.WHITE);
        chatHistory.setForeground(Color.BLACK);
        chatHistory.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));
        JScrollPane scrollPane = new JScrollPane(chatHistory);
        scrollPane.setBounds(0, 400, 295, 400);
        dialogo.add(scrollPane);

        // Adicionando elementos ao frame
        frame.add(panelJogador1);
        frame.add(panelJogador2);
        frame.add(criaturaJogador1);
        frame.add(criaturaJogador2);
        frame.add(dialogo);

        panelJogador1.add(labelJogador1);
        panelJogador2.add(labelJogador2);
        panelJogador2.add(statusLabel);

        panelJogador1.add(button1);
        panelJogador2.add(button2);
        panelJogador2.add(button3);

        dialogo.add(labelDialogo);
        dialogo.add(textField);
        dialogo.add(textField2);
        dialogo.add(button4);
        dialogo.add(button5);

        frame.setVisible(true);
    }

    private JButton criarBotao(String texto, int x, int y, int largura, int altura, Color corFundo, Color corTexto) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, largura, altura);
        botao.addActionListener(this);
        botao.setFocusable(false);
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setBorder(BorderFactory.createEtchedBorder());
        return botao;
    }

    private JPanel criarPainel(Color cor, int x, int y, int largura, int altura) {
        JPanel painel = new JPanel();
        painel.setBackground(cor);
        painel.setBounds(x, y, largura, altura);
        painel.setLayout(null);
        return painel;
    }

    private JLabel criarLabel(String texto, Color cor, int x, int y, int largura, int altura) {
        JLabel label = new JLabel(texto);
        label.setForeground(cor);
        label.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        label.setBounds(x, y, largura, altura);
        return label;
    }

    private JTextField criarCampoTexto(int x, int y, int largura, int altura) {
        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(x, y, largura, altura);
        campoTexto.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 15));
        return campoTexto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            statusLabel.setText("Status: Jogador 1 jogou uma carta.");
        } else if (e.getSource() == button2) {
            statusLabel.setText("Status: Jogador 2 jogou uma carta.");
        } else if (e.getSource() == button3) {
            statusLabel.setText("Status: Jogador passou o turno.");
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
        }
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
