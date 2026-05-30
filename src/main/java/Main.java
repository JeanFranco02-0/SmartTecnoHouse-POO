import controlador.MainController;
import modelo.SmartTecnoHouse;
import vista.MainView;

// Punto de entrada de la aplicación
public class Main {
    public static void main(String[] args) {

        MainView vista = new MainView();
        SmartTecnoHouse sistema = SmartTecnoHouse.getInstancia();

        new MainController(sistema, vista);

        vista.setVisible(true);
    }
}
