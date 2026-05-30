package modelo;

// Enchufe ON/OFF
public class ActuadorEnchufe extends Actuador {

    public ActuadorEnchufe() {
        super("plug", "Enchufe Inteligente");
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
