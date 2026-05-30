package modelo;

import java.util.List;

// Enciende la luz si hay poca iluminación
public class ReglaIluminacionAutomatica implements Regla {

    @Override
    public void aplicar(List<Sensor> sensores, List<Actuador> actuadores) {

        Sensor luz = sensores.stream()
                .filter(s -> s.getID().equals("light"))
                .findFirst().orElse(null);

        Actuador bombilla = actuadores.stream()
                .filter(a -> a.getID().equals("bulb"))
                .findFirst().orElse(null);

        if (luz == null || bombilla == null) return;

        if (luz.getValor() < 200) bombilla.ejecutarAccion("ON");
        else bombilla.ejecutarAccion("OFF");
    }

    @Override
    public String getNombre() {
        return "Iluminación Automática";
    }
}
