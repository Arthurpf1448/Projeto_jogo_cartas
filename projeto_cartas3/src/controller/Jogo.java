package controller;

import actions.Jogavel;
import model.Carta;
import model.Criatura;
import model.Jogador;
import actions.Atacavel;
import Exception.manaInsuficienteException;

public class Jogo implements Atacavel, Jogavel {

    public void inciarJogo(Jogador jogador1, Jogador jogador2){

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

}