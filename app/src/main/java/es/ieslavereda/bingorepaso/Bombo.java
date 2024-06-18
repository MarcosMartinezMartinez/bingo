package es.ieslavereda.bingorepaso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bombo {
    Set<Bola> bolas;

    public Bombo() {
        this.bolas = new HashSet<>();
    }

    public Set<Bola> getBolas() {
        return bolas;
    }

    public void setBolas(Set<Bola> bolas) {
        this.bolas = bolas;
    }
}
