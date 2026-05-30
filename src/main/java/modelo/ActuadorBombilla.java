package modelo;

// Bombilla ON/OFF
public class ActuadorBombilla extends Actuador {

    public ActuadorBombilla() {
        super("bulb", "Bombilla Inteligente");
    }

    @Override
    public void ejecutarAccion(String accion) {
        if (accion.equals("ON") || accion.equals("OFF")) {
            estado = accion;
        }
    }

    @Override
    public String[] getAccionesPosibles() {
        return new String[]{"ON", "OFF"};
    }
}
