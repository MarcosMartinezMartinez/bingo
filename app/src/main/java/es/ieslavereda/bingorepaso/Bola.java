package es.ieslavereda.bingorepaso;

import java.util.Comparator;
import java.util.Objects;

public class Bola implements Comparable<Bola>{
    public static final Comparator<Bola> SORT_NUMBER = Comparator.comparingInt(o -> o.numero);
    public int numero;
    private int color;

    public Bola(int numero, int color) {
        this.numero = numero;
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }

    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bola bola = (Bola) o;
        return numero == bola.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public int compareTo(Bola o) {
        return (numero-color)-(o.numero-o.color);
    }
}
