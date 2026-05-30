package modelo;

import java.util.List;

// Regla automática del sistema
public interface Regla {
    void aplicar(List<Sensor> sensores, List<Actuador> actuadores);
    String getNombre();
}
