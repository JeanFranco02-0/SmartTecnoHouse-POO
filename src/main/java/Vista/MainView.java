package vista;

import modelo.Actuador;
import modelo.Sensor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Ventana principal de la aplicación
public class MainView extends JFrame {

    private JTextArea areaSensores;
    private JTextArea areaActuadores;

    private JButton btnActualizar;
    private JButton btnAplicarReglas;
    private JButton btnGuardar;

    public MainView() {
        setTitle("SmartTecnoHouse");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel central con sensores y actuadores
        JPanel panelCentro = new JPanel(new GridLayout(1, 2));

        areaSensores = new JTextArea();
        areaActuadores = new JTextArea();

        panelCentro.add(new JScrollPane(areaSensores));
        panelCentro.add(new JScrollPane(areaActuadores));

        add(panelCentro, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();

        btnActualizar = new JButton("Actualizar Sensores");
        btnAplicarReglas = new JButton("Aplicar Reglas");
        btnGuardar = new JButton("Guardar Estado");

        panelBotones.add(btnActualizar);
        panelBotones.add(btnAplicarReglas);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // Muestra sensores en el área correspondiente
    public void mostrarSensores(List<Sensor> sensores) {
        areaSensores.setText("");
        for (Sensor s : sensores) {
            areaSensores.append(s.getNombre() + ": " + s.getEstadoActual() + "\n");
        }
    }

    // Muestra actuadores en el área correspondiente
    public void mostrarActuadores(List<Actuador> actuadores) {
        areaActuadores.setText("");
        for (Actuador a : actuadores) {
            areaActuadores.append(a.getNombre() + ": " + a.getEstadoActual() + "\n");
        }
    }

    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnAplicarReglas() { return btnAplicarReglas; }
    public JButton getBtnGuardar() { return btnGuardar; }
}
