package Biblioteca;

import java.util.Arrays;

import bibliotecaConCollections.Genero;

public class Biblioteca implements Cloneable{
	private Libro[]libros;
	private int cantidadLibros;
	
	public Biblioteca(int tamanioBiblioteca) {
		cantidadLibros = 0;
		this.libros = new Libro[tamanioBiblioteca];
	}
	
	public Libro[] getLibros(){
		return libros;
	}
	
	public void agregarLibro(Libro libro) {
		if(cantidadLibros > libros.length - 1)
			throw new Error("Biblioteca llena");
		libros[cantidadLibros] = libro;
		this.cantidadLibros++;
	}
	
	public void ordenarLibrosPorPaginas() {
		Arrays.sort(this.libros, new OrdenadorPorPaginas());
	}

	public void ordenarLibrosPorAutor() {
		Arrays.sort(this.libros, new OrdenadorPorAutor());
	}

	public void ordenarLibrosPorTitulo() {
		Arrays.sort(this.libros, new OrdenadorPorTitulo());
	}

	public void ordenarLibrosPorTituloNormalizado() {
		Arrays.sort(this.libros, new OrdenadorPorTituloNormalizado());
	}

	public void ordenarLibrosPorAnioPublicacion() {
		Arrays.sort(this.libros, new OrdenadorPorAnioPublicacion());
	}

	public String cantidadLibrosPorGenero() {
		String liBrosPorGenero = "";
		Genero[] generos = Genero.values();
		int[] cantidadLibrosPorGenero = new int[generos.length];
		for (Libro libro : this.libros) {
			cantidadLibrosPorGenero[libro.getGenero().ordinal()] += 1;
		}
		for (Genero genero : generos) {
			liBrosPorGenero += genero.name() + " " + cantidadLibrosPorGenero[genero.ordinal()] + "\n";
		}
		return liBrosPorGenero;
	}

	public boolean libroRepetido(Libro libro) {
		boolean libroRepetido = false;
		int libroABuscar = 0;
		while (libroABuscar < this.cantidadLibros && !libroRepetido) {
			libroRepetido = libro.equals(this.libros[libroABuscar]);
			libroABuscar++;
		}
		return libroRepetido;
	}

	@Override
	public Biblioteca clone() throws CloneNotSupportedException {
		Biblioteca biblioteca = (Biblioteca) super.clone();
		for (int i = 0; i < biblioteca.cantidadLibros; i++) {
			biblioteca.libros[i] = this.libros[i].clone();
		}
		return biblioteca;
	}

}
