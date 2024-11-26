package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Jogador extends Deck{
  private int vida;
  private int mana;
  private Deck deck;
  private int countXp;
  private Cemiterio cemiterio;
  private Set<Criatura> mao = new HashSet<>();
  private ArrayList<Criatura> cartasEmJogo = new ArrayList<>();
  private ArrayList<Criatura> ultimasCartas = new ArrayList<>();

  void progressao(int countXp){
    int[] level = new int[11];
    for(int i = 1; i < level.length; i++){
      level[i] = 2*i;
    }
    // level 1 = precisa de 2 de xp
    // level 2 = precisa de 4 de xp
    // assim em diante o level i precisara de 2*i de xp
    for(int i = 0; i < level.length; i++){
      if(countXp >= level[i]){
        System.out.println("Parabens! Voce subiu de nivel!");
      }
    }
  }

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

}
