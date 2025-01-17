package Modelo;

public class Player {
    public enum Posicion {
        GK, DF, MF, FW
    }

    private String nombre;
    private int numero;
    private Posicion posicion;

    public Player(String nombre, int numero, Posicion posicion) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return nombre + " (" + numero + ")";
    }
}
