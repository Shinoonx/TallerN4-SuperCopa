package Guis.GuiPlayers;

import Modelo.Player;
import Modelo.Team;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPlayers extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable playerTable;
    private JButton btnEditarPlayer;
    private JButton btnGuardarCambios;
    private JButton btnVolver;
    private JPanel Jugadores;
    private JTable table1;

    public GuiPlayers(Team team) {
        setTitle("Jugadores de " + team.getNombre());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear y configurar panel para los componentes
        Jugadores = new JPanel(new BorderLayout());
        setContentPane(Jugadores);

        // Crear modelo de tabla
        tableModel = new DefaultTableModel();
        playerTable = new JTable(tableModel);
        playerTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(playerTable);
        Jugadores.add(scrollPane, BorderLayout.CENTER);

        // Configurar botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnEditarPlayer = new JButton("Editar Jugador");
        btnGuardarCambios = new JButton("Guardar Cambios");
        btnVolver = new JButton("Volver");
        panelBotones.add(btnEditarPlayer);
        panelBotones.add(btnGuardarCambios);
        panelBotones.add(btnVolver);
        Jugadores.add(panelBotones, BorderLayout.SOUTH);

        // Cargar jugadores
        loadPlayers(team);

        // Asignar acciones a los botones
        btnEditarPlayer.addActionListener(this);
        btnGuardarCambios.addActionListener(this);
        btnVolver.addActionListener(this);

        setVisible(true);
    }

    private void loadPlayers(Team team) {
        // Limpiar tabla antes de cargar nuevos datos
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);

        // Añadir columnas al modelo de tabla
        tableModel.addColumn("Número");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Posición");

        // Cargar jugadores del equipo
        for (Player player : team.getPlayers()) {
            tableModel.addRow(new Object[]{player.getNumero(), player.getNombre(), player.getPosicion()});
        }
    }

    private void savePlayer() {
        // Implementar según sea necesario para guardar cambios en un jugador
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEditarPlayer) {
            // Lógica para editar jugador seleccionado
        } else if (e.getSource() == btnGuardarCambios) {
            savePlayer();
        } else if (e.getSource() == btnVolver) {
            dispose(); // Cerrar la ventana al volver
        }
    }
}
