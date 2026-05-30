package modelo;

// Lo básico que comparten sensores y actuadores
public interface IDispositivo {
    String getID();
    String getNombre();
    String getEstadoActual();
}
