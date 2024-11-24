package actions;

import model.Carta;
import model.Jogador;

public interface Jogavel {
    public void jogarCarta(Jogador jogador, Carta carta);
}
