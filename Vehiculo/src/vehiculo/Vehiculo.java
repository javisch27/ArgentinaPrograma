package vehiculo;

public abstract class Vehiculo {
	private Persona chofer;
	private int kilometrosRecorridos = 0;

	public boolean asignarOCambiarChofer(Persona chofer) {
		this.chofer = chofer;
		return true;
	}

	public String getChofer() {
		return this.chofer.getNombre();
	}

	public int getKilometrosRecorridos() {
		return this.kilometrosRecorridos;
	}
}
