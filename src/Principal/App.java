package Principal;

import Controlador.Control;
import Modelo.Modelo;
import Vista.Ventana;

public class App {

	public static void main(String[] args) {
		Modelo mod = new Modelo();
		Ventana ven = new Ventana();
		Control cont = new Control(ven, mod);
		cont.Iniciar();
	}

}
