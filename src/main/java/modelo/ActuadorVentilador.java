package modelo;

// Ventilador con 3 modos
public class ActuadorVentilador extends Actuador {

    public ActuadorVentilador() {
        super("fan", "Ventilador Inteligente");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("OFF") || accion.equals("LOW") || accion.equals("HIGH")) {
            estado = accion;
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"OFF", "LOW", "HIGH"};
    }
}
