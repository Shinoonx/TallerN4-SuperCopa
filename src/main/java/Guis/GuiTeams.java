package Guis;

import Datos.DataPlayers;
import Guis.GuiPlayers.GuiPlayers;
import Modelo.Player;
import Modelo.Team;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiTeams extends JFrame implements ActionListener {
    private JComboBox<String> elegirPais;
    private JButton btnExit;
    private JButton btnJugadores;
    private JPanel Teams;
    private List<Team> teams;


    public GuiTeams() {
        setTitle("Selecciones de la Super Copa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(Teams);
        elegirPais.addActionListener(this);
        btnExit.addActionListener(this);
        btnJugadores.addActionListener(this);

        loadTeams();
        setVisible(true);
    }

    private void loadTeams() {

        teams = new ArrayList<>();
        teams.add(new Team("chile", 2, "src/main/resources/chi.png"));
        teams.add(new Team("alemania", 1, "src/main/resources/ger.png"));
        teams.add(new Team("camerun", 1, "src/main/resources/cmr.png"));
        teams.add(new Team("australia", 1, "src/main/resources/aus.png"));


        for (Team team : teams) {
            elegirPais.addItem(team.getNombre());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            setVisible(false);
            dispose();
        } else if (e.getSource() == btnJugadores) {
            String selectedCountry = (String) elegirPais.getSelectedItem();
            Team selectedTeam = teams.stream()
                    .filter(team -> team.getNombre().equals(selectedCountry))
                    .findFirst()
                    .orElse(null);

            if (selectedTeam != null) {
                loadPlayersForCountry(selectedCountry);
                new GuiPlayers(selectedTeam);
                setVisible(false);
            }
        }
    }

    private void loadPlayersForCountry(String country) {
        String filePath = "src/main/resources/" + country.toLowerCase() + ".txt";
        List<Player> players = DataPlayers.loadPlayersFromFile(filePath);
        if (players.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron jugadores para " + country, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            teams.stream()
                    .filter(team -> team.getNombre().equals(country))
                    .findFirst()
                    .ifPresent(team -> team.setPlayers(players));
        }
    }
}