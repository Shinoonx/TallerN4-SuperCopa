package Guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Player;
import Modelo.Team;

public class GuiPlayers extends JFrame {
    private JList<Player> playerList;
    private DefaultListModel<Player> playerListModel;
    private JTextField playerNameField;
    private JTextField playerNumberField;
    private JComboBox<Player.Posicion> playerPositionCombo;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollBar scrollBar1;

    public GuiPlayers(Team team) {
        setTitle("Jugadores de " + team.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        playerListModel = new DefaultListModel<>();
        playerList = new JList<>(playerListModel);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(playerList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(3, 2));

        editPanel.add(new JLabel("Nombre:"));
        playerNameField = new JTextField();
        editPanel.add(playerNameField);

        editPanel.add(new JLabel("Número:"));
        playerNumberField = new JTextField();
        editPanel.add(playerNumberField);

        editPanel.add(new JLabel("Posición:"));
        playerPositionCombo = new JComboBox<>(Player.Posicion.values());
        editPanel.add(playerPositionCombo);

        add(editPanel, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePlayer();
            }
        });

        add(saveButton, BorderLayout.NORTH);

        loadPlayers(team);

        setVisible(true);
    }

    private void loadPlayers(Team team) {
        for (Player player : team.getPlayers()) {
            playerListModel.addElement(player);
        }
    }

    private void savePlayer() {
        Player selectedPlayer = playerList.getSelectedValue();
        if (selectedPlayer != null) {
            selectedPlayer.setNombre(playerNameField.getText());
            selectedPlayer.setNumero(Integer.parseInt(playerNumberField.getText()));
            selectedPlayer.setPosicion((Player.Posicion) playerPositionCombo.getSelectedItem());
        }
    }
}