package dao;

import model.Cancion;

public interface CancionDAO extends GenericDAO<Cancion> {

	public abstract Cancion buscarPorNombre(String nombre);
	
}
