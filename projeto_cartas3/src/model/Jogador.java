package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Jogador extends Deck{
  private int vida;
  private int mana;
  private Deck deck;
  private int countXp = 0;
  private Cemiterio cemiterio;
  private Set<Criatura> mao = new HashSet<>();
  private ArrayList<Criatura> cartasEmJogo = new ArrayList<>();
  private ArrayList<Criatura> ultimasCartas = new ArrayList<>();

  public Deck getDeck() {
    return deck;
  }

  public Jogador(int vida, int mana, Deck deck, Cemiterio cemiterio){
    this.vida = vida;
    this.mana = mana;
    this.deck = deck;
    this.cemiterio = cemiterio;
  }

  public int getMana() {
    return mana;
  }

  public Cemiterio getCemiterio() {
    return cemiterio;
  }

  public Set<Criatura> getMao() {
    return mao;
  }

  public int getVida() {
    return vida;
  }

  public ArrayList<Criatura> getCartasEmJogo() {
    return cartasEmJogo;
  }

  public Cemiterio getcemiterio() {
    return this.cemiterio;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }

  public ArrayList<Criatura> getUltimasCartas() {
    return ultimasCartas;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public int getCountXp() {
    return countXp;
  }

  public void setCountXp(int countXp) {
    this.countXp = countXp;
  }
}
