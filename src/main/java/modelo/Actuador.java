package modelo;

// Clase base para actuadores
public abstract class Actuador implements IDispositivo {

    protected String id;
    protected String nombre;
    protected String estado;

    public Actuador(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estado = "OFF";
    }

    // Acción que ejecuta el actuador
    public abstract void ejecutarAccion(String accion);

    // Acciones permitidas
    public abstract String[] getAccionesPosibles();

    @Override
    public String getID() { return id; }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public String getEstadoActual() { return estado; }
}
