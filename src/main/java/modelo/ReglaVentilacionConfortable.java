package modelo;

import java.util.List;

// Ajusta el ventilador según la temperatura
public class ReglaVentilacionConfortable implements Regla {

    @Override
    public void aplicar(List<Sensor> sensores, List<Actuador> actuadores) {

        Sensor temp = sensores.stream()
                .filter(s -> s.getID().equals("temp"))
                .findFirst().orElse(null);

        Actuador fan = actuadores.stream()
                .filter(a -> a.getID().equals("fan"))
                .findFirst().orElse(null);

        if (temp == null || fan == null) return;

        if (temp.getValor() > 26) fan.ejecutarAccion("HIGH");
        else if (temp.getValor() > 22) fan.ejecutarAccion("LOW");
        else fan.ejecutarAccion("OFF");
    }

    @Override
    public String getNombre() {
        return "Ventilación Confortable";
    }
}
