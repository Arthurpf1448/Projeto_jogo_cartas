package model;

public abstract class Carta {
  private String nome;
  private int custoDeMana;

  public Carta(String nome, int custodemana) {
    setNome(nome);
    setCustoDeMana(custodemana);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCustoDeMana() {
    return custoDeMana;
  }

  public void setCustoDeMana(int custoDeMana) {
    if (custoDeMana <= 10) {
      this.custoDeMana = custoDeMana;
    } else {
      System.out.println("Custo de mana excede o limite de 10");
      System.exit(1);
    }
  }
}