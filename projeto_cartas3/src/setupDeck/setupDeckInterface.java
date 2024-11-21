package setupDeck;

import model.Deck;

import java.util.Scanner;

import static main.Main.preencherDeck;

public interface setupDeckInterface {
    public static void setupDeck(Deck deckDoJogador) {
        Deck deckTotal = new Deck();
        //preencherDeck(deckTotal);
        Scanner in = new Scanner(System.in);
        System.out.println("Escolha suas cartas!");

        for (int i = 0; i < 30; ) {
            int quantidadeDeCartas = deckDoJogador.size();
            System.out.printf("Escreva o nome da carta que deseja (%d de 30): ", quantidadeDeCartas);
            boolean cartaEncontrada = false;
            boolean cartaRepetida = false;
            String carta = in.nextLine();

            for (int j = 0; j < deckDoJogador.size(); j++) {
                if (carta.equals(deckDoJogador.getCarta(j).getNome())) {
                    cartaRepetida = true;
                    break;
                }
            }

            for (int j = 0; j < deckTotal.size(); j++) {
                if (carta.equals(deckTotal.getCarta(j).getNome())) {
                    deckDoJogador.addCard(deckTotal.getCarta(j));
                    cartaEncontrada = true;
                    break;
                }
            }

            if (cartaEncontrada && !cartaRepetida) {
                System.out.println("Carta adicionada com sucesso!");
                i++;
            } else if (cartaRepetida) {
                System.out.println("Carta repetida!");
            } else {
                System.out.println("Carta não encontrada!");
            }
        }
    }
}
