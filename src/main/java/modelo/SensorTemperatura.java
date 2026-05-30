package modelo;

import java.util.Random;

// Simula una temperatura
public class SensorTemperatura extends Sensor {

    public SensorTemperatura() {
        super("temp", "Sensor de Temperatura", "ºC");
    }

    @Override
    public void actualizarValor() {
        valor = 18 + new Random().nextDouble() * 10;
    }
}
