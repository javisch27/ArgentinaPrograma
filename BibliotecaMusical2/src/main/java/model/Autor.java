package model;

public class Autor {
	int id;
	String nombre;

	public Autor(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + "]";
	}
}
