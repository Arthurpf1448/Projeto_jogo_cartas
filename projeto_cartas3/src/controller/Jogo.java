package controller;

import actions.Jogavel;
import model.*;
import actions.Atacavel;
import Exception.manaInsuficienteException;
import view.GameGUI;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class Jogo implements Atacavel, Jogavel {
    static Scanner in = new Scanner(System.in);
    static String nomej1;
    static String nomej2;
    public static void inciarJogo(){

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

        System.out.println("Nome do jogador 1: ");
        String nomej1 = in.nextLine();
        System.out.println("Nome do jogador 2: ");
        String nomej2 = in.nextLine();
        new GameGUI(jogador1, jogador2, nomej1, nomej2);
        int nRamdomico = (int)(Math.random() * 2); // 1 == 2 0 == 1 (quem vai iniciar)
        if(nRamdomico == 0){
            System.out.println(nomej1 + " vai comecar");
        }
        if(nRamdomico == 1){
            System.out.println(nomej2 + " vai comecar");
        }
        while(true){
            if(jogador1.getVida() == 0){
                System.out.println(nomej2 + " venceu");
                break;
            }
            else if(jogador2.getVida() == 0){
                System.out.println(nomej1 + " venceu");
                break;
            }
            else if(jogador1.getDeck().size() == 0){
                System.out.println(nomej2 + " venceu");
                break;
            }
            else if(jogador2.getDeck().size() == 0){
                System.out.println(nomej1 + " venceu");
                break;
            }
            System.out.println("Vida de " + nomej1 + " = " + jogador1.getVida());
            System.out.println("Vida de " + nomej2 + " = " + jogador2.getVida());
            System.out.println("Mana de " + nomej1 + " = " + jogador1.getMana());
            System.out.println("Mana de " + nomej2 + " = " + jogador2.getMana());
            System.out.println("Mao de " + nomej1);
            mostrarMao(jogador1);
            System.out.println("Mao de " + nomej2);
            mostrarMao(jogador2);
            System.out.println("Cartas em jogo de " + nomej1);
            mostrarCartasEmJogo(jogador1);
            System.out.println("Cartas em jogo de " + nomej2);
            mostrarCartasEmJogo(jogador2);
            // condicoes de parada --->
            // vida de jogador 1 ou 2 == 0
            // qnt de cartas do tipo criatura no deck == 0
            // jogadores ganharao uma carta e um ponto de mana a cada rodada
            // a cada criatura morta xp sera ganho
            if(nRamdomico == 1){
                System.out.println("Vez de " + nomej2);
                acao(jogador2, jogador1);
                if(!jogador2.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador2.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                jogador2.setMana(min(jogador2.getMana() + 1, 10));
                if(jogador2.getMao().size() < 5){
                    Carta ultimaCarta = jogador2.getDeck().getCarta(jogador2.getDeck().size() - 1);
                    jogador2.getMao().add((Criatura) ultimaCarta);
                    jogador2.getDeck().removerCarta(ultimaCarta);
                }
                System.out.println("Vez de " + nomej1);
                acao(jogador1, jogador2);
                if(!jogador1.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador1.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                if(jogador1.getMao().size() < 5){
                    Carta ultimaCarta = jogador1.getDeck().getCarta(jogador1.getDeck().size() - 1);
                    jogador1.getMao().add((Criatura) ultimaCarta);
                    jogador1.getDeck().removerCarta(ultimaCarta);
                }
                jogador1.setMana(min(jogador1.getMana() + 1, 10));
            }
            if(nRamdomico == 0){
                System.out.println("Vez de " + nomej1);
                acao(jogador1, jogador2);
                if(!jogador1.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador1.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                if(jogador1.getMao().size() < 5){
                    Carta ultimaCarta = jogador1.getDeck().getCarta(jogador1.getDeck().size() - 1);
                    jogador1.getMao().add((Criatura) ultimaCarta);
                    jogador1.getDeck().removerCarta(ultimaCarta);
                }
                jogador1.setMana(min(jogador1.getMana() + 1, 10));
                System.out.println("Vez de " + nomej2);
                acao(jogador2, jogador1);
                if(!jogador2.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador2.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                if(jogador2.getMao().size() < 5){
                    Carta ultimaCarta = jogador2.getDeck().getCarta(jogador2.getDeck().size() - 1);
                    jogador2.getMao().add((Criatura) ultimaCarta);
                    jogador2.getDeck().removerCarta(ultimaCarta);
                }
                jogador2.setMana(min(jogador2.getMana() + 1, 10));
            }
        }
        jogador1.getUltimasCartas().clear();
        jogador2.getUltimasCartas().clear();
    }

    public static void atacar(Jogador jogadorA, Jogador jogadorD, Criatura atacante, Criatura defensor) {
        int mana = jogadorA.getMana();
        try {
            if (mana < atacante.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para atacar!");
            } else {
                if (jogadorD.getCartasEmJogo().isEmpty()) {
                    System.out.println("Atacando herói adversário");
                    jogadorD.setVida(max(0, jogadorD.getVida() - atacante.getPoder()));
                    jogadorA.setMana(mana - atacante.getCustoDeMana());
                } else {
                    if (atacante.getPoder() > defensor.getResistencia()) { // atacante mata
                        jogadorD.getCartasEmJogo().remove(defensor);
                        jogadorD.getCemiterio().addCartaCemiterio(defensor);
                        progressaoDeNivel(jogadorA);
                    } else if (atacante.getPoder() < defensor.getResistencia()) { // defensor mata
                        jogadorA.getCartasEmJogo().remove(atacante);
                        jogadorA.getCemiterio().addCartaCemiterio(atacante);
                        progressaoDeNivel(jogadorD);
                    } else if (atacante.getPoder() == defensor.getResistencia()) { // ambos morrem
                        jogadorA.getCartasEmJogo().remove(atacante);
                        jogadorD.getCartasEmJogo().remove(defensor);
                        jogadorD.getCemiterio().addCartaCemiterio(defensor);
                        jogadorD.getCemiterio().addCartaCemiterio(atacante);
                        progressaoDeNivel(jogadorA);
                        progressaoDeNivel(jogadorD);
                    }
                    jogadorA.setMana(mana - atacante.getCustoDeMana());
                }
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void jogarCarta(Jogador jogador, Criatura carta) {
        jogador.getMao().remove(carta);
        if(jogador.getCartasEmJogo().size() < 5) {
            jogador.getCartasEmJogo().add(carta);
        }
    }

    public static void preencherMao(Jogador jogador){
        while(jogador.getMao().size() < 5) {
            int nRandomico = (int) (Math.random() * jogador.getDeck().size());
            Deck deckDoJogador = jogador.getDeck();
            Carta carta = deckDoJogador.getCarta(nRandomico);
            jogador.getMao().add((Criatura) carta);
            jogador.getDeck().removerCarta(carta);
        }
    }

    public static void progressaoDeNivel(Jogador jogador){
        int xp = jogador.getCountXp();
        jogador.setCountXp(xp + 1);
        if(xp == 1){
            System.out.println("Parabens! Voce subiu de nível!");
        }
        else if(xp == 5){
            System.out.println("Parabens! Voce subiu de nível!");
        }
        if(xp == 10){
            System.out.println("Parabens! Voce subiu de nível!");
        } else{
            for(int i = 2; i <= 10; i++){
                if(xp == 10 * i){
                    System.out.println("Parabens! Voce subiu de nível!");
                    break;
                }
            }
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

    public static void mostrarMao(Jogador jogador){
        for(Carta c : jogador.getMao()){
            System.out.println(c.getNome());
        }
    }

    public static void mostrarCartasEmJogo(Jogador jogador){
        for(Carta c : jogador.getCartasEmJogo()){
            System.out.println(c.getNome());
        }
    }

    public static void gerarEfeitoDaHabilidade(Criatura carta, Jogador jogador){
        // rapidez   -- atacar no mesmo round
        // forca     -- atacar duas vezes seguidas
        // provocar  -- todas as cartas do deck ganham um de dano
        if(carta.getHabilidadeEspecial().equals("Rapidez")){
            carta.setPodeAtacar(true);
        }
        else if(carta.getHabilidadeEspecial().equals("Forca")){
            carta.setAtaquesRestantes(2);
        }
        else if(carta.getHabilidadeEspecial().equals("Provocar")){
            for(Criatura c : jogador.getCartasEmJogo()){
                if(c != carta){
                    c.setDano(min(c.getPoder() + 1, 10));
                }
            }
        }
    }

    public static void acao(Jogador jogadorA, Jogador jogadorD){
        System.out.println("Selecione sua acao");
        System.out.println("A = Atacar P = Pular turno J = Jogar carta");
        char acao = toUpperCase(in.next().charAt(0));
        if(acao == 'A'){
            System.out.println("Digite carta que vai atacar");
            in.nextLine(); // consumir \n
            boolean encontradoA = false;
            boolean encontradoD = false;
            Criatura cartaA = null;
            String cartaAs = in.nextLine();
            for(Criatura c : jogadorA.getCartasEmJogo()){
                if(c.getNome().equals(cartaAs)){
                    encontradoA = true;
                    cartaA = c;
                    break;
                }
            }
            if(encontradoA && jogadorD.getCartasEmJogo().isEmpty()){
                atacar(jogadorA, jogadorD, cartaA, null);
            } else {
                System.out.println("Digite carta que vai defender");
                String cartaDs = in.nextLine();
                Criatura cartaD = null;
                for (Criatura c : jogadorD.getCartasEmJogo()) {
                    if (c.getNome().equals(cartaDs)) {
                        encontradoD = true;
                        cartaD = c;
                        break;
                    }
                }
                if (encontradoA && encontradoD) {
                    System.err.println(cartaA.getHabilidadeEspecial());
                    gerarEfeitoDaHabilidade(cartaA, jogadorA);
                    if (cartaA.getPodeAtacar()) {
                        while (cartaA.getAtaquesRestantes() != 0) {
                            atacar(jogadorA, jogadorD, cartaA, cartaD);
                            cartaA.setAtaquesRestantes(cartaA.getAtaquesRestantes() - 1);
                        }
                        System.out.println("Ataque realizado com sucesso");
                    } else {
                        System.out.println("Voce nao pode atacar com essa carta ainda");
                    }
                } else {
                    System.out.println("Algum input nao estava correto!");
                }
            }
        }
        else if(acao == 'P'){
            System.out.println("Turno pulado");
        }
        else if(acao == 'J'){
            if(!jogadorA.getMao().isEmpty()) {
                in.nextLine(); // consumir \n
                System.out.println("Escolha a carta que vai jogar");
                String cartaS = in.nextLine();
                Criatura carta = null;
                boolean encontrado = false;
                for (Criatura c : jogadorA.getMao()) {
                    if (c.getNome().equals(cartaS)) {
                        carta = c;
                        jogadorA.getUltimasCartas().add(carta);
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    System.err.println(carta.getHabilidadeEspecial());
                    jogarCarta(jogadorA, carta);
                    gerarEfeitoDaHabilidade(carta, jogadorA);
                    System.out.println("Carta Jogada com sucesso");
                } else {
                    System.out.println("Carta nao encontrada");
                }
            } else{
                System.out.println("Voce nao pode jogar nenhuma carta");
            }
        }
        else{
            System.out.println("Acao invalida");
        }
        if (acao != 'P') {
            System.out.println("Terminar turno? S/N");
            char o = toUpperCase(in.next().charAt(0));
            if (o == 'S') {
                System.out.println("Turno finalizado com sucesso");
            } else if (o == 'N') {
                acao(jogadorA, jogadorD);
            } else {
                System.out.println("Acao invalida");
            }
        }
    }
}