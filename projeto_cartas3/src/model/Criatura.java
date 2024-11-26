package model;

public class Criatura extends Carta {
  private int poder; 
  private int resistencia; 
  private String habilidadeEspecial;
  private boolean podeAtacar = false;
  private int ataquesRestantes = 1;

  public Criatura(String nome, int custoDeMana, int poder, int resistencia, String habilidadeEspecial) {
    super(nome, custoDeMana);
    this.poder = poder;
    this.resistencia = resistencia;
    this.habilidadeEspecial = habilidadeEspecial;
  }

  public int getPoder() {
    return poder;
  }

  public void setDano(int poder) {
    if (poder <= 10) {
      this.poder = poder;
    } else {
      System.out.println("Poder excede o limite de 10");
      System.exit(1);
    }
  }

  public int getResistencia() {
    return resistencia;
  }

  public void setResistencia(int resistencia) {
    if (resistencia <= 10) {
      this.resistencia = resistencia;
    } else {
      System.out.println("Resistencia excede o limite de 10");
      System.exit(1);
    }
  }

  public String getHabilidadeEspecial() {
    return habilidadeEspecial;
  }

  public void setHabilidadeEspecial(String habilidadeEspecial) {
    this.habilidadeEspecial = habilidadeEspecial;
  }

  public void setPodeAtacar(boolean podeAtacar) {
    this.podeAtacar = podeAtacar;
  }

  public boolean getPodeAtacar(){
    return this.podeAtacar;
  }

  public int getAtaquesRestantes() {
    return ataquesRestantes;
  }

  public void setAtaquesRestantes(int ataquesRestantes) {
    this.ataquesRestantes = ataquesRestantes;
  }

}
