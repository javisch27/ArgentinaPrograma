package dao;

import model.Autor;

public interface AutorDAO extends GenericDAO<Autor> {

	public abstract Autor buscarPorNombre(String nombre);
	
}
