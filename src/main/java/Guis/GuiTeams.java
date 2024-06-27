package Guis;

import Modelo.Team;
import Datos.DataPlayers;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiTeams extends JFrame {
    private JList<Team> teamList;
    private DefaultListModel<Team> teamListModel;
    private JComboBox comboBox1;
    private JButton jugadoresButton;
    private JButton exitButton;
    private JTextField textField1;

    public GuiTeams() {
        setTitle("Selecciones de la Super Copa");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        teamListModel = new DefaultListModel<>();
        teamList = new JList<>(teamListModel);
        teamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(teamList);
        add(scrollPane, BorderLayout.CENTER);

        loadTeams();

        setVisible(true);
    }

    private void loadTeams() {
        List<Team> teams = DataPlayers.loadTeams();
        for (Team team : teams) {
            teamListModel.addElement(team);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuiTeams());
    }
}
