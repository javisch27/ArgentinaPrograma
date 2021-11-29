package dao;

public class DAOFactory {

	public static AutorDAO getAutorDAO() {
		return new AutorDAOImpl();
	}
	
	public static CancionDAO getCancionDAO() {
		return new CancionDAOImpl();
	}
	
}
