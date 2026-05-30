package modelo;

import java.util.Random;

// Simula nivel de luz
public class SensorLuz extends Sensor {

    public SensorLuz() {
        super("light", "Sensor de Luz", "lx");
    }

    @Override
    public void actualizarValor() {
        valor = new Random().nextInt(1000);
    }
}
