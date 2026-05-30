package modelo;

import java.util.Random;

// Simula humedad
public class SensorHumedad extends Sensor {

    public SensorHumedad() {
        super("hum", "Sensor de Humedad", "%");
    }

    @Override
    public void actualizarValor() {
        valor = 30 + new Random().nextDouble() * 40;
    }
}
