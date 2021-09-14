package parqueDeAtracciones;

public abstract class Promocion implements Ofertable {
	protected String nombre;
	protected Atraccion[] atracciones;

	public Promocion(String nombre, Atraccion[] atracciones) {
		this.nombre = nombre;
		this.atracciones = atracciones;
	}

	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public double getDuracion() {
		double duracionTotal = 0;
		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}
		return duracionTotal;
	}
	
	@Override
	public TipoDeAtraccion getTipoDeAtraccion() {
		return atracciones[0].getTipoDeAtraccion();
	}

	@Override
	public boolean esPromocion() {
		return true;
	}

	public boolean cupoDisponibleEnTodasAtracciones() {
		for (int i = 0; i < atracciones.length; i++) {
			if (atracciones[i].getCupo() <= 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean puedeSerOfertada(Usuario usuario) {
		return this.cupoDisponibleEnTodasAtracciones() && usuario.getTiempoDisponible() >= this.getDuracion()
				&& usuario.getPresupuesto() >= this.getCosto();
	}

	@Override
	public void restarCupo() {
		for (Atraccion atraccion : this.atracciones) {
			atraccion.restarCupo();
		}
	}

	private String getNombreDeAtracciones() {
		String nombreDeTodasAtracciones = "";
		for (int i = 0; i < atracciones.length; i++) {
			nombreDeTodasAtracciones += atracciones[i].getNombre();
			if (i < atracciones.length - 1) {
				nombreDeTodasAtracciones += ", ";
			}
		}
		return nombreDeTodasAtracciones;
	}
	
	@Override
	public String toString() {
		return "Promoción= " + nombre + "\n" + "Atracciones= " + this.getNombreDeAtracciones() + "\n" + "Costo= "
				+ this.getCosto() + "\n" + "Duración= " + this.getDuracion() + "\n" + "Tipo= "
				+ this.getTipoDeAtraccion() + "\n";
	}
}