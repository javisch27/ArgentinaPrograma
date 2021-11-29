package vehiculo;

public class Motocicleta extends Vehiculo {
	private Persona acompaniante = null;

	public boolean agregarAcompaniante(Persona acompaniante) {
		if (motocicletaLlena()) {
			return false;
		}
		this.acompaniante = acompaniante;
		return true;
	}

	public String getAcompaniante() {
		return this.acompaniante.getNombre();
	}

	@Override
	public boolean asignarOCambiarChofer(Persona chofer) {
		if (motocicletaLlena()) {
			return false;
		}
		super.asignarOCambiarChofer(chofer);
		return true;
	}

	private boolean motocicletaLlena() {
		return this.acompaniante != null;
	}
}