package modelo;

import java.util.Random;

// Detecta presencia (1) o no (0)
public class SensorPresencia extends Sensor {

    public SensorPresencia() {
        super("pir", "Sensor de Presencia", "");
    }

    @Override
    public void actualizarValor() {
        valor = new Random().nextBoolean() ? 1 : 0;
    }

    @Override
    public String getEstadoActual() {
        return valor == 1 ? "PRESENCIA" : "NO PRESENCIA";
    }
}
