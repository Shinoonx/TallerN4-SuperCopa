package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombre;
    private int ranking;
    private String bandera;
    private List<Player> players;

    public Team(String nombre, int ranking, String bandera) {
        this.nombre = nombre;
        this.ranking = ranking;
        this.bandera = bandera;
        this.players = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
