package modelo;

// Clase base para sensores
public abstract class Sensor implements IDispositivo {

    protected String id;
    protected String nombre;
    protected double valor;
    protected String unidad;

    public Sensor(String id, String nombre, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
    }

    // Cada sensor actualiza su valor a su manera
    public abstract void actualizarValor();

    public double getValor() {
        return valor;
    }

    @Override
    public String getID() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public String getEstadoActual() {
        return valor + " " + unidad;
    }
}
