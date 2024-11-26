package model;

public class Feitico extends Carta {
  private String efeito; 

  public Feitico(String nome, int custoDeMana, String efeito) {
    super(nome, custoDeMana);
    setEfeito(efeito);
  }

  public String getEfeito() {
    return efeito;
  }

  public void setEfeito(String efeito) {
    this.efeito = efeito;
  }

}