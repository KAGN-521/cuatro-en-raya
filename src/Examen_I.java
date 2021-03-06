
import Controlador.Control;
import Modelo.Modelo;
import Vista.Ventana;


public class Examen_I {

    public static void main(String[] args) {
        Modelo mod = new Modelo();
        Ventana ven = new Ventana();
        Control cont = new Control(ven, mod);
        cont.Iniciar();
    }
    
}
