package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase principal del sistema (Singleton)
public class SmartTecnoHouse {

    private static SmartTecnoHouse instancia;

    private List<Sensor> sensores;
    private List<Actuador> actuadores;
    private List<Regla> reglas;

    private static final String ESTADO_FILE = "estado.json";
    private static final String LOG_FILE = "actuators.log";

    private SmartTecnoHouse() {
        sensores = new ArrayList<>();
        actuadores = new ArrayList<>();
        reglas = new ArrayList<>();

        inicializarDispositivos();
        inicializarReglas();
        cargarEstado();
    }

    public static SmartTecnoHouse getInstancia() {
        if (instancia == null) instancia = new SmartTecnoHouse();
        return instancia;
    }

    // Sensores y actuadores por defecto
    private void inicializarDispositivos() {
        sensores.add(new SensorTemperatura());
        sensores.add(new SensorLuz());
        sensores.add(new SensorPresencia());
        sensores.add(new SensorHumedad());

        actuadores.add(new ActuadorBombilla());
        actuadores.add(new ActuadorVentilador());
        actuadores.add(new ActuadorEnchufe());
    }

    private void inicializarReglas() {
        reglas.add(new ReglaIluminacionAutomatica());
        reglas.add(new ReglaVentilacionConfortable());
    }

    public List<Sensor> getSensores() { return sensores; }
    public List<Actuador> getActuadores() { return actuadores; }
    public List<Regla> getReglas() { return reglas; }

    // Actualiza todos los sensores
    public void actualizarSensores() {
        for (Sensor s : sensores) s.actualizarValor();
    }

    // Ejecuta reglas automáticas
    public void aplicarReglas() {
        for (Regla r : reglas) r.aplicar(sensores, actuadores);
        escribirLogActuadores();
    }

    // Guarda cambios de actuadores en un log
    private void escribirLogActuadores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            for (Actuador a : actuadores) {
                bw.write(a.getID() + ";" + a.getNombre() + ";" + a.getEstadoActual());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Guarda estado en JSON simple
    public void guardarEstado() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ESTADO_FILE))) {
            pw.println("{");
            pw.println("\"actuadores\": [");

            for (int i = 0; i < actuadores.size(); i++) {
                Actuador a = actuadores.get(i);
                pw.print("  {\"id\": \"" + a.getID() + "\", \"estado\": \"" + a.getEstadoActual() + "\"}");
                if (i < actuadores.size() - 1) pw.println(",");
            }

            pw.println("\n]");
            pw.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carga estado guardado
    private void cargarEstado() {
        File f = new File(ESTADO_FILE);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("\"id\"")) {
                    String id = linea.split("\"")[3];
                    String estado = linea.split("\"")[7];

                    for (Actuador a : actuadores) {
                        if (a.getID().equals(id)) a.ejecutarAccion(estado);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
