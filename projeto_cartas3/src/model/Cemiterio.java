package model;

import java.util.Stack;

public class Cemiterio{
    Stack<Carta> cemiterio = new Stack<Carta>();

    public void addCartaCemiterio(Carta carta){
        cemiterio.push(carta);
    }

    public Carta acessarUltimaCarta(){
        return cemiterio.peek();
    }

    public void removerCarta(){
        cemiterio.pop();
    }
}