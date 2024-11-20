package model;

import java.util.HashSet;
import java.util.Set;

public class Jogador extends Deck{
  private int vida;
  private int mana;
  private Deck deck;
  private int countXp;
  private Cemiterio cemiterio;
  private Set<Carta> mao = new HashSet<>();

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

  public Set<Carta> getMao() {
    return mao;
  }

  public int getVida() {
    return vida;
  }
}
