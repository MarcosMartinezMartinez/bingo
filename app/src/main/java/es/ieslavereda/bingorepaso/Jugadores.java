package es.ieslavereda.bingorepaso;

import java.util.Objects;

public class Jugadores {
    private String nombre;
    public String apellidos;
    private int saldo;

    public Jugadores(String nombre, String apellidos, int saldo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugadores jugadores = (Jugadores) o;
        return saldo == jugadores.saldo && Objects.equals(nombre, jugadores.nombre) && Objects.equals(apellidos, jugadores.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, saldo);
    }
}
