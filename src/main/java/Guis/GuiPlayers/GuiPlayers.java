package Guis.GuiPlayers;

import Modelo.Player;
import Modelo.Team;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPlayers extends JFrame implements ActionListener {
    private JList<Player> playerList;
    private DefaultListModel<Player> playerListModel;
    private JTextField playerNameField;
    private JTextField playerNumberField;
    private JComboBox<Player.Posicion> playerPositionCombo;
    private JButton btnEditarPlayer;
    private JButton btnGuardarCambios;
    private JButton btnVolver;
    private JPanel Jugadores;
    private JTable table1;

    public GuiPlayers(Team team) {
        setTitle("Jugadores de " + team.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(Jugadores);

        playerListModel = new DefaultListModel<>();
        playerList = new JList<>(playerListModel);
        loadPlayers(team);

        btnGuardarCambios.addActionListener(this);
        btnEditarPlayer.addActionListener(this);
        btnVolver.addActionListener(this);
        setVisible(true);
    }

    private void loadPlayers(Team team) {
        playerListModel.clear();
        for (Player player : team.getPlayers()) {
            playerListModel.addElement(player);
        }
    }

    private void savePlayer() {
        Player selectedPlayer = playerList.getSelectedValue();
        if (selectedPlayer != null) {
            selectedPlayer.setNombre(playerNameField.getText());
            try {
                selectedPlayer.setNumero(Integer.parseInt(playerNumberField.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Número de jugador inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            selectedPlayer.setPosicion((Player.Posicion) playerPositionCombo.getSelectedItem());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardarCambios) {
            savePlayer();
        } else if (e.getSource() == btnEditarPlayer) {
            dispose();
        } else if (e.getSource() == btnVolver) {
            dispose();
        }
    }
}