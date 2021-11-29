package model;

public class Cancion {
	int id;
	String nombre;
	// Autor autor;
	int fk_autor;
	int duracion;
	String genero;

	public Cancion(int id, String nombre, int fk_autor, int duracion, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.fk_autor = fk_autor;
		this.duracion = duracion;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getFk_autor() {
		return fk_autor;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", nombre=" + nombre + ", fk_autor=" + fk_autor + ", duracion=" + duracion
				+ ", genero=" + genero + "]";
	}

}
