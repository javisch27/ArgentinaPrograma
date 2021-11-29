package vehiculo;

public class Autobus extends Vehiculo {
	private Persona[] pasajeros;
	private int cantidadPasajeros = 0;

	public Autobus(int cantidadPasajerosMaxima) {
		this.pasajeros = new Persona[cantidadPasajerosMaxima];
	}

	private boolean autobuslleno() {
		return this.cantidadPasajeros > this.pasajeros.length - 1;
	}

	private boolean autobusVacio() {
		return this.cantidadPasajeros == 0;
	}

	public boolean agregarPasajero(Persona persona) {
		if (this.autobuslleno()) {
			return false;
		}
		pasajeros[cantidadPasajeros] = persona;
		this.cantidadPasajeros++;
		return true;
	}

	public String getPasajeros() {
		String nombresPasajeros = "";
		for (Persona persona : pasajeros) {
			nombresPasajeros += " // " + persona.getNombre();
		}
		return nombresPasajeros;
	}

	@Override
	public boolean asignarOCambiarChofer(Persona chofer) {
		if (!(this.autobusVacio())) {
			return false;
		}
		super.asignarOCambiarChofer(chofer);
		return true;
	}
}
