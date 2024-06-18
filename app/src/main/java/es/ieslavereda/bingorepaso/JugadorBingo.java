package es.ieslavereda.bingorepaso;

import java.util.List;

public class JugadorBingo extends Jugadores{
    private List<Cartones> cartones;

    public JugadorBingo(String nombre, String apellidos, int saldo, List<Cartones> cartones) {
        super(nombre, apellidos, saldo);
        this.cartones = cartones;
    }

    public List<Cartones> getCartones() {
        return cartones;
    }
}
