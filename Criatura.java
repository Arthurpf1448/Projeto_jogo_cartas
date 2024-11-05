public class Criatura extends Carta {
  private int poder; 
  private int resistencia; 
  private String habilidadeEspecial; 

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

  public void ataque(Criatura criaturaAtacante, Criatura criaturaDefensora) {
    criaturaDefensora.setResistencia(criaturaDefensora.getResistencia() - criaturaAtacante.getPoder());
    criaturaAtacante.setResistencia(criaturaAtacante.getResistencia() - criaturaDefensora.getPoder());
    if (criaturaDefensora.getResistencia() <= 0) {
      System.out.println("CRIATURA DEFENSORA MORREU");
    }
    if (criaturaAtacante.getResistencia() <= 0) {
      System.out.println("CRIATURA ATACANTE MORREU");
    }
  }
}
