package controller;

import actions.Jogavel;
import model.*;
import actions.Atacavel;
import Exception.manaInsuficienteException;
import view.GameGUI;

public class Jogo implements Atacavel, Jogavel {

    public static void inciarJogo(){
        new GameGUI();
        Cemiterio cemiterioJogador1 = new Cemiterio();
        Cemiterio cemiterioJogador2 = new Cemiterio();
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Jogador jogador1 = new Jogador(10, 10, deck1, cemiterioJogador1);
        Jogador jogador2 = new Jogador(10, 10, deck2, cemiterioJogador2);
        preencherDeck(jogador1);
        preencherDeck(jogador2);
        preencherMao(jogador1);
        preencherMao(jogador2);

        while(true){
            // condicoes de parada --->
            // vida de jogador 1 ou 2 == 0
            // qnt de cartas do tipo criatura no deck == 0
            int vida1 = jogador1.getVida();
            int vida2 = jogador2.getVida();
            int sizedeck1 = jogador1.getDeck().size();
            int sizedeck2 = jogador2.getDeck().size();

        }
    }

    @Override
    public void atacar(Jogador jogadorA, Jogador jogadorD, Criatura atacante, Criatura defensor) {
        try {
            if (jogadorA.getMana() < atacante.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para atacar!");
            } else{
                if(atacante.getPoder() >= defensor.getResistencia()){
                    jogadorD.getCemiterio().addCartaCemiterio(atacante);
                }
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void jogarCarta(Jogador jogador, Carta carta) {
        try {
            if (jogador.getMana() < carta.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para jogar esta carta!");
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void preencherMao(Jogador jogador){
        while(jogador.getMao().size() < 5) {
            int nRandomico = (int) (Math.random() * jogador.getDeck().size());
            Deck deckDoJogador = jogador.getDeck();
            Carta carta = deckDoJogador.getCarta(nRandomico);
            jogador.getMao().add(carta);
            jogador.getDeck().removerCarta(carta);
        }
    }

    public static void preencherDeck(Jogador jogador) {
        jogador.getDeck().addCard(new Criatura("Pikachu", 3, 5, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Charizard", 6, 8, 5, "Força"));
        jogador.getDeck().addCard(new Criatura("Bulbasaur", 2, 3, 4, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Squirtle", 2, 2, 5, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Jigglypuff", 3, 4, 4, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Gengar", 5, 7, 4, "Força"));
        jogador.getDeck().addCard(new Criatura("Mewtwo", 8, 9, 6, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Eevee", 3, 3, 4, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Snorlax", 4, 5, 10, "Força"));
        jogador.getDeck().addCard(new Criatura("Pidgeot", 4, 6, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Onix", 4, 6, 8, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Jolteon", 5, 6, 4, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Flareon", 5, 7, 4, "Força"));
        jogador.getDeck().addCard(new Criatura("Vaporeon", 5, 5, 6, "Força"));
        jogador.getDeck().addCard(new Criatura("Machamp", 6, 8, 5, "Força"));
        jogador.getDeck().addCard(new Criatura("Gyarados", 7, 9, 6, "Força"));
        jogador.getDeck().addCard(new Criatura("Lapras", 6, 5, 7, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Alakazam", 5, 7, 4, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Scyther", 4, 6, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Tyranitar", 8, 10, 8, "Força"));
        jogador.getDeck().addCard(new Criatura("Lucario", 5, 7, 5, "Força"));
        jogador.getDeck().addCard(new Criatura("Porygon-Z", 4, 5, 4, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Zubat", 2, 3, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Mew", 5, 4, 5, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Gardevoir", 6, 5, 6, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Dragonite", 7, 8, 7, "Força"));
        jogador.getDeck().addCard(new Criatura("Regice", 6, 4, 8, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Regirock", 6, 8, 9, "Força"));
        jogador.getDeck().addCard(new Criatura("Sandslash", 4, 6, 5, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Steelix", 7, 7, 10, "Provocar"));
    }

}