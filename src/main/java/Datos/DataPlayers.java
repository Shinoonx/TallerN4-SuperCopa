package Datos;

import Modelo.Player;
import Modelo.Team;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataPlayers {
    private static final String TEAMS_FILE = "teams.txt";

    public static List<Team> loadTeams() {
        List<Team> teams = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(TEAMS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String teamId = parts[0].trim();
                    String teamName = parts[1].trim();
                    int ranking = Integer.parseInt(parts[2].trim());
                    String flagPath = parts[3].trim();

                    Team team = new Team();
                    team.setNombre(teamName);
                    team.setRanking(ranking);
                    team.setBandera(flagPath);
                    team.setPlayers(loadPlayers(teamId));
                    teams.add(team);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teams;
    }

    private static List<Player> loadPlayers(String teamId) {
        List<Player> players = new ArrayList<>();
        String playersFile = teamId + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(playersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int number = Integer.parseInt(parts[0].trim());
                    String playerName = parts[1].trim();
                    Player.Posicion position = Player.Posicion.valueOf(parts[2].trim());

                    Player player = new Player();
                    player.setNumero(number);
                    player.setNombre(playerName);
                    player.setPosicion(position);
                    players.add(player);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return players;
    }
}
