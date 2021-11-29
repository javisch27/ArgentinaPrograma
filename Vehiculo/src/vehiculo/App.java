package vehiculo;

public class App {

public static void main(String[] args) {
		
		Persona persona1 = new Persona("javier");
		Persona persona2 = new Persona("amélie");
		Persona persona3 = new Persona("alain");
		Persona persona4 = new Persona("marie-agnès");
		Persona persona5 = new Persona("céline");
		Persona persona6 = new Persona("francois");
		Persona persona7 = new Persona("guillaume");
		
		Motocicleta moto1 = new Motocicleta();
		moto1.asignarOCambiarChofer(persona2);
		moto1.agregarAcompaniante(persona3);
		moto1.agregarAcompaniante(persona7);
		System.out.println(moto1.getChofer());
		System.out.println(moto1.getAcompaniante());
		System.out.println();
		
		Autobus autobus1 = new Autobus(4);
		autobus1.asignarOCambiarChofer(persona1);
		autobus1.agregarPasajero(persona2);
		autobus1.agregarPasajero(persona3);
		autobus1.agregarPasajero(persona4);
		autobus1.agregarPasajero(persona7);
		autobus1.agregarPasajero(persona6);
		autobus1.agregarPasajero(persona5);
		System.out.println(autobus1.getChofer());
		System.out.println(autobus1.getPasajeros());
	}
}
