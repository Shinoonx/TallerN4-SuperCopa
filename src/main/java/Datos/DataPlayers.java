package Datos;

import Modelo.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayers {

    public static List<Player> loadPlayersFromFile(String filePath) {
        List<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nombre = parts[0];
                    int numero = Integer.parseInt(parts[1]);
                    Player.Posicion posicion = Player.Posicion.valueOf(parts[2]);
                    Player player = new Player(nombre, numero, posicion);
                    players.add(player);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading players from file: " + filePath);
            e.printStackTrace();
        }
        return players;
    }
}
