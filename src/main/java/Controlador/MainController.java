package controlador;

import modelo.SmartTecnoHouse;
import vista.MainView;

// Controla la interacción entre la vista y el modelo
public class MainController {

    private SmartTecnoHouse sistema;
    private MainView vista;

    public MainController(SmartTecnoHouse sistema, MainView vista) {
        this.sistema = sistema;
        this.vista = vista;

        // Eventos de los botones
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnAplicarReglas().addActionListener(e -> aplicarReglas());
        vista.getBtnGuardar().addActionListener(e -> guardar());

        // Mostrar datos iniciales
        actualizar();
    }

    private void actualizar() {
        sistema.actualizarSensores();
        vista.mostrarSensores(sistema.getSensores());
        vista.mostrarActuadores(sistema.getActuadores());
    }

    private void aplicarReglas() {
        sistema.aplicarReglas();
        vista.mostrarActuadores(sistema.getActuadores());
    }

    private void guardar() {
        sistema.guardarEstado();
    }
}
